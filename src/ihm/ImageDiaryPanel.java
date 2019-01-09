package ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JPanel;
/**
 * 
 * @author Roat
 *
 */
public class ImageDiaryPanel  extends JPanel implements Serializable {
		Image imageDiary = null;
	
	public ImageDiaryPanel(Image image) { 
		this.imageDiary = image;
	}
	
	public ImageDiaryPanel() { 
	}
	
	public void setImage(Image image){ 
		this.imageDiary = image;
	}
	
	public Image getImage(Image image){ 
		return image;
	}

	public void paintComponent(Graphics g) { 
		super.paintComponent(g); //paint background 
		if (imageDiary != null) { //there is a picture: draw it 
			int height = this.getSize().height;
			int width = this.getSize().width;
			//g.drawImage(image, 0, 0, this); //use image size            
			g.drawImage(imageDiary,0,0, width, height, this);
		} 
	} 
}
