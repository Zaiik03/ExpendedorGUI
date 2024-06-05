package Vistas;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Clase MusicPlayer
 */
public class MusicPlayer {
    /**
     * Variable Clip
     */
    private Clip clip;

    /**
     * Metodo para reproducir sonido
     * @param ruta direccion del archivo
     */
    public void play(String ruta) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ruta));

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para detener la musica reproducida
     */
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    /**
     * Metodo para hacer un loop
     */
    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Reproducir en bucle continuo
        }
    }
}
