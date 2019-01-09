package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * 
 * @author Gabriel + Roat
 *
 */
public class GUIPersonalize extends JFrame{	//personalization window
//	protected int objetCouchOn, objetBedOn, objetTableOn, objetToyBoxOn, objetChairOn = 1; //init furniture on the map
	protected JButton couch = new JButton(); //canap�
	protected JButton bed = new JButton(); //lit
	protected JButton table = new JButton(); //table
	protected JButton toyBox = new JButton(); //boite a jouer
	protected JButton chair = new JButton(); //chaise	
	private GUIMaps canva;
	Image img;
	public GUIPersonalize(GUIMaps canva){
		super("Personalize");
		this.canva = canva;
		initLayout();
	}
	protected void initLayout() {
		
	
		try {
			
		img = ImageIO.read(new File("src/images/insideHouse.jpg"));
		ImagePanel imgPan = new ImagePanel(img);
			
		
		//this.setLayout(new GridLayout(3,6));
		//this.setLayout(null);
		JButton couch = new JButton(new ImageIcon("src/images/couch.jpg"));
		couch.setBounds(5, 10 , 200, 100); //espace = +265 
		this.add(couch);
		couch.addActionListener(new ActionRemoveCouch());
		
		JButton toyBox = new JButton(new ImageIcon("src/images/toybox.png"));
		toyBox.setBounds(270, 10 , 200, 100);
		toyBox.setBackground(Color.white);
		this.add(toyBox);
		toyBox.addActionListener(new ActionRemoveToybox());
		
		JButton table = new JButton(new ImageIcon("src/images/table.jpg"));
		table.setBounds(530, 10 , 200, 100);
		table.setBackground(Color.white);
		this.add(table);
		table.addActionListener(new ActionRemoveTable());
		
		JButton chair = new JButton(new ImageIcon("src/images/chair.jpg"));
		chair.setBounds(795, 10 , 200, 100);
		chair.setBackground(Color.white);
		this.add(chair);
		chair.addActionListener(new ActionRemoveChair());
		
		imgPan.setLayout(null);
		this.add(imgPan);
		
		setBounds(400,100,1010,500);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	class ActionRemoveCouch implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			canva.createCouch();
		}	
	}
	class ActionRemoveToybox implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
				canva.createToybox();
		}	
	}
	class ActionRemoveTable implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
				canva.createTable();
		}	
	}
	class ActionRemoveChair implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
				canva.createChairs();
		}	
	}
}
