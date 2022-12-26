import java.applet.*;
import javax.swing.*;
import java.net.*;


//Class Sound
public class Sound extends JFrame{

    //deklarasi
    private AudioClip audio;
    public boolean isPlaying;

    public Sound(String SoundURL) {
        try{
            URL url = new URL(SoundURL); //deklarasi URL
            audio = Applet.newAudioClip(url); //deklarasi Applet
        }
        catch (MalformedURLException ex){ //Get message error
            Since:
            System.err.println("Terdapat masalah audio : " + ex.getMessage());
            System.exit(0); //program exit
        }
    }

    public void play(){ //fungsi sound play
        audio.play();
        isPlaying = true;
    }

    public void stop(){ //fungsi sound stop
        audio.stop();
        isPlaying = false;
    }

    public void loop(){ //fungsi sound loop
        audio.loop();
    }

    public boolean getIsPlaying(){ //fungsi boolean apakah masih berjalan suaranya
        return isPlaying;
    }

}
