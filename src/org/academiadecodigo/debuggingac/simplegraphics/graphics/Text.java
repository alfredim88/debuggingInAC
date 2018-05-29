package org.academiadecodigo.debuggingac.simplegraphics.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Text implements Shape, Colorable, Movable {
    private Color color = Color.BLACK;
    private JLabel label = new JLabel();
    private static Font font;
    private double x;
    private double y;
    private double xGrow;
    private double yGrow;

    static {

        File file = new File("resources/SuperMario.ttf");

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, file);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(font);
        font = font.deriveFont(60f);
    }

    /**
     * Constructs a text at a given location.
     *
     * @param x       the leftmost x-position of the shape
     * @param y       the topmost y-position of the shape
     * @param message the text string
     */
    public Text(double x, double y, String message){

// makesure to derive the size
        this.x = x;
        this.y = y;
        label.setText(message);
        label.setFont(font);
    }


    /**
     * Gets the leftmost x-position of the bounding box.
     *
     * @return the leftmost x-position
     */
    public int getX() {
        return (int) Math.round(x - xGrow);
    }

    /**
     * Gets the topmost y-position of the bounding box.
     *
     * @return the topmost y-position
     */
    public int getY() {
        return (int) Math.round(y - yGrow);
    }


    /**
     * Gets the width of the bounding box.
     *
     * @return the width
     */
    public int getWidth() {
        return (int) Math.round(label.getPreferredSize().getWidth() + 2 * xGrow);
    }

    /**
     * Gets the height of the bounding box.
     *
     * @return the height
     */
    public int getHeight() {
        return (int) Math.round(label.getPreferredSize().getHeight() + 2 * yGrow);
    }

    /**
     * Moves this text by a given amount.
     *
     * @param dx the amount by which to move in x-direction
     * @param dy the amount by which to move in y-direction
     */
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
        Canvas.getInstance().repaint();
    }

    /**
     * Resizes this text both horizontally and vertically.
     *
     * @param dw the amount by which to resize the width on each side
     * @param dw the amount by which to resize the height on each side
     */
    public void grow(double dw, double dh) {
        xGrow += dw;
        yGrow += dh;
        Canvas.getInstance().repaint();
    }

    /**
     * Sets the color for drawing this text.
     *
     * @param newColor the new color
     */
    public void setColor(Color newColor) {
        color = newColor;
        Canvas.getInstance().repaint();
    }

    /**
     * Sets the text message
     * @param message the new text message
     */
    public void setText(String message) {
        label.setText(message);
        Canvas.getInstance().repaint();
    }

    /**
     * Shows this text on the canvas.
     */
    public void draw() {
        Canvas.getInstance().show(this);
    }

    /**
     * Deletes this text from the canvas
     */
    public void delete() {
        Canvas.getInstance().hide(this);
    }

    public String toString() {
        return "Text[x=" + getX() + ",y=" + getY() + ",message=" + label.getText() + "]";
    }

    public void paintShape(Graphics2D g2) {
        if (color != null) {
            label.setForeground(new java.awt.Color((int) color.getRed(), (int) color.getGreen(), (int) color.getBlue()));
            Dimension dim = label.getPreferredSize();
            if (dim.width > 0 && dim.height > 0) {
                label.setBounds(0, 0, dim.width, dim.height);
                g2.translate(getX(), getY());
                g2.scale(getWidth() / dim.width, getHeight() / dim.height);
                label.paint(g2);
            }
        }
    }

    @Override
    public Color getColor() {
        return color;
    }

}
