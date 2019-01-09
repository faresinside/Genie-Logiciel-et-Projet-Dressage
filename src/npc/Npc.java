package npc;
import positionXY.Position;
/**
 * 
 * @author Roat 
 *
 */
public class Npc {
	private String name;
	private Position npcPosition;
	
	public Npc(String name) {
		super();
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getNpcPosition() {
		return npcPosition;
	}

	public void setNpcPosition(Position npcPosition) {
		this.npcPosition = npcPosition;
	}

	public String toString() {
		return "Npc [name=" + name + ", npcPosition=" + npcPosition + "]";
	}
	
}
