package npc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import positionXY.Position;
import clock.Clock;
/**
 * 
 * @author Roat + Gab
 *
 */

public class NPCMaster extends Npc{
	private String name;
	private int xPersoMaster = 624; 
	private int yPersoMaster = 272;
	
	
	public NPCMaster(String name) {
		super(name);
	}
	
	public String getName() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("sav.txt, true"));
			bw.close();
			BufferedReader br = new BufferedReader(new FileReader("sav.txt"));
			String line = br.readLine();
			if(line!=""){
				String[] opt = line.split(";");
				this.name = opt[0];
			}else{
				this.name = "Pedro";
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

	public void caress() { //Method when the master play with the dog
		
	}
	

	public void spawn(Clock clock,Position thiefPosition) { //spawn time
		
	}
	
	public void despawn(Clock clock,Position thiefPosition) { //despawn time if nothing happen
		
	}
	public int getxPersoMaster() {
		return xPersoMaster;
	}
	
	public void setxPersoMaster(int xPersoMaster) {
		this.xPersoMaster = xPersoMaster;
	}
	
	public int getyPersoMaster() {
		return yPersoMaster;
	}
	
	public void setyPersoMaster(int yPersoMaster) {
		this.yPersoMaster = yPersoMaster;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
