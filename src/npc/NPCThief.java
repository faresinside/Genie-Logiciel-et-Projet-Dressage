package npc;
import positionXY.Position;
import clock.Clock;;
/**
 * 
 * @author Roat + Gab + Fares
 *
 */

public class NPCThief extends Npc {
	private int xPersoThief = 100000; 

	private int yPersoThief = 100000;
	
	public NPCThief(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public int getxPersoThief() {
		return xPersoThief;
	}
	
	public void setxPersoThief(int xPersoThief) {
		this.xPersoThief = xPersoThief;
	}
	
	public int getyPersoThief() {
		return yPersoThief;
	}
	
	public void setyPersoThief(int yPersoThief) {
		this.yPersoThief = yPersoThief;
	}
	
	public static boolean isPresent(){
		return false;
	}
}
