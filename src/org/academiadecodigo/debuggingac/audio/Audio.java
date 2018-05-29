package org.academiadecodigo.debuggingac.audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Audio {

    private Clip clip;
    private URL audioDIR;

    public Audio(String path) {

        initClip(path);
    }

    public void start(boolean fromStart) {

        if (fromStart) {
            clip.setFramePosition(0);
        }
        clip.start();
    }

    public void stop() {


        clip.stop();
    }

    public void createLoop(int times) {
        clip.loop(times);
    }

    private void initClip(String path) {

        //if loading from jar
        audioDIR = Audio.class.getResource(path);
        AudioInputStream inputStream = null;

        try {

            if (audioDIR == null) {
                path = path.substring(1);
                File file = new File(path);
                audioDIR = file.toURI().toURL();
            }

            inputStream = AudioSystem.getAudioInputStream(audioDIR);
            clip = AudioSystem.getClip();
            clip.open(inputStream);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}