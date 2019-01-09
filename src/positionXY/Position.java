package positionXY;

/**
 * 
 * @author Roat + Gab + Fares
 *
 */

public class Position {
	private int x;
	private int y;
	
	
	public Position() {
		
	}
	
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getPositionX() {
		return x;
	}

	public int getPositionY() {
		return y;
	}
	

	public void setX(int x) {
		this.x = x;
	}

	
	public void setY(int y) {
		this.y = y;
	}

	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void moveUp() {
		y--;
	}

	public void moveDown() {
		y++;
	}

	public void moveLeft() {
		x--;
	}

	public void moveRight() {
		x++;
	}
	
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}

}
