package org.academiadecodigo.debuggingac;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class TesterCursor extends JFrame {

    private JPanel pane;

    public TesterCursor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(getListener());
        setSize(1280, 720);
        setTitle("Debuggin' in <AC_>");
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/game/cursor.png").getImage(), new Point(0, 0), "custom cursor"));

        pane = (JPanel) getContentPane();
        setVisible(true);
    }

    private MouseListener getListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                pane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/game/luigi_jump02.png").getImage(), new Point(100, 50), "custom cursor"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                pane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/game/luigi_jump01.png").getImage(), new Point(100, 50), "custom cursor"));


            }
        };
    }

    public static void main(String... s) {
        new TesterCursor();
    }
}
