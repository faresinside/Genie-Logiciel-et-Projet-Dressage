package items;
import positionXY.Position;
/**
 * 
 * @author Roat 
 *
 */
public class Items {
	
	private String itemName;
	private Position itemPosition;
	
	public Items(String itemName, Position itemPosition) {
		
		this.itemName = itemName;
		this.itemPosition = itemPosition;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Position getItemPosition() {
		return itemPosition;
	}

	public void setItemPosition(Position itemPosition) {
		this.itemPosition = itemPosition;
	}

	@Override
	public String toString() {
		return "Items [itemName=" + itemName + ", itemPosition=" + itemPosition + "]";
	}
	
	
}
