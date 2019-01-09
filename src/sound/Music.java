package sound;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;



public class Music implements Runnable{
	static String fileName;
	private Clip clip;
	private AudioInputStream ais;
	
	public Music(String fileName){
		this.fileName=fileName;
		try { 
	 		File file = new File(fileName);
	 		ais = AudioSystem.getAudioInputStream(file);
	 		clip = AudioSystem.getClip();
	 		clip.open(ais);
	 	}
	 	catch (Exception e) { 
	 		System.err.println(e.getMessage()); 
	 	}
	}
	 
	
	public void run() {
	 	try {
	 		clip.start();
	 		Thread.sleep(clip.getMicrosecondLength());
	 	}
	 	catch (Exception e) { 
	 		System.err.println(e.getMessage()); 
	 	}
	 }
}	
