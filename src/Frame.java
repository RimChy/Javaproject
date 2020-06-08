



import javax.swing.*;

//import sun.audio.AudioData;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Frame {
	
		public Frame() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        JFrame frame = new JFrame("WORD RUN");
                        
        frame.setSize(1000,526);  
        
        frame.add(new Board()); 
        
        frame.setResizable(false);
        
        frame.setVisible(true);
        
        frame.setLocationRelativeTo(null); 
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AudioInputStream sample;
		sample = AudioSystem.getAudioInputStream(new File("music1.wav"));
		
		Clip clip = AudioSystem.getClip();
		clip.open(sample);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	
}
		public static void main(String[] args) throws Exception{
	        
	        
	        
	        new Frame();
	        
	    }
}






