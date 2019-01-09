package animal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import positionXY.Position;
import npc.NPCMaster;
import npc.NPCThief;
/**
 * 
 * @author Roat + Gab
 *
 */

public class Pet {				//manage of the pet
	private String name;
	private Position position; //Pet spawn point
	private int xPerso = 704; //spawn oon playground
	private int yPerso = 32;
	
	public Pet(String name){
		this.name = name;
	}
	
	public String getName() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("sav.txt, true"));
			bw.close();
			BufferedReader br = new BufferedReader(new FileReader("sav.txt"));
			String line = br.readLine();
			if(line!=""){				
				String[] opt = line.split(";");
				this.name = opt[1];
			}else{
				this.name = "Waf";
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) { //can change the position if bug
		this.position = position;
	}
	
	public int getXPerso() {
        
		return this.xPerso;
	}
		     
	public int getYPerso() {
		         
		return this.yPerso;
	}
		
	public void setXPerso(int newX) {
	         
		 this.xPerso = newX;
	}
		     
	public void setYPerso(int newY) {
		         
		 this.yPerso = newY;
	}
		
	public String lastAction(){
		return "TODO";
	}
	public boolean isNearMaster() {
		NPCMaster posMaster = new NPCMaster("");
		
		if(xPerso<posMaster.getxPersoMaster()-16) { //left
			return false;
		}
		if(xPerso>posMaster.getxPersoMaster()+16) { //right
			return false;
		}
		if(yPerso<posMaster.getyPersoMaster()-16) { //top
			return false;
		}
		if(yPerso>posMaster.getxPersoMaster()+16) { //bottom
			return false;
		}
		if (xPerso<=posMaster.getxPersoMaster()+16 && yPerso<=posMaster.getxPersoMaster()-16) {
			if (yPerso<=posMaster.getxPersoMaster()+16 && yPerso>=posMaster.getyPersoMaster()-16) {
				System.out.println("************************The pet is near the master************************");
				return true;
			}
		}
		return false;
	}
	public boolean isNearTheif() {
		NPCThief posThief = new NPCThief("");
		if(xPerso<posThief.getxPersoThief()-16) { //left
			return false;
		}
		if(xPerso>posThief.getxPersoThief()+16) { //right
			return false;
		}
		if(yPerso<posThief.getyPersoThief()-16) { //top
			return false;
		}
		if(yPerso>posThief.getxPersoThief()+16) { //bottom
			return false;
		}
		if (xPerso<=posThief.getxPersoThief()+16 && yPerso<=posThief.getxPersoThief()-16) {
			if (yPerso<=posThief.getxPersoThief()+16 && yPerso>=posThief.getyPersoThief()-16) {
				System.out.println("************************The pet is near the master************************");
				return true;
			}
		}
		return false;
	}
}
