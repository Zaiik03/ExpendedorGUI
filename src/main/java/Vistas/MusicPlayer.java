package Vistas;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private Clip clip;

    public void play(String ruta) {
        try {
            // Obtener un AudioInputStream desde el archivo de audio
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ruta));

            // Obtener el Clip que reproduce el sonido
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start(); // Iniciar la reproducción
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Reproducir en bucle continuo
        }
    }
}
