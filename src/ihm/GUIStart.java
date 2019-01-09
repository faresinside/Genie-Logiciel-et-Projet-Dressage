package ihm;

import sound.Music;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ihm.GUIMaps;
import ihm.GUIproject;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Gabriel + Fares + Roat
 *
 */
public class GUIStart extends JFrame{	
	private static final Font BUTTON_FONT = new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 75);
	
	private JLabel jeu = new JLabel(" Dressage ");
	
	protected JButton start = new JButton("Start");
	protected JButton option = new JButton("Option");
	
	protected int running = 0;
	
	public GUIStart(){
		
		super("GLP Project 6 : Dressage");
		
		initStyle();

		initLayout();

	}
	protected void initStyle() {
		Font font = new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 150);
		jeu.setFont(font);
		jeu.setForeground(Color.BLACK);
		
		start.setFont(BUTTON_FONT);
		option.setFont(BUTTON_FONT);
		
	
	}
	protected void initLayout() {
		
		try {
			Image img = ImageIO.read(new File("src/images/background_start.jpg"));
			ImagePanel imgPan = new ImagePanel(img);
			
		
			imgPan.setLayout(new GridLayout(3,1));
			jeu.setBounds(50, -300, 5000, 850);
			imgPan.add(jeu);
		
			//JPanel panel = new JPanel();
			imgPan.setLayout(null);
			//imgPan.add(panel);

			JButton start = new JButton(new ImageIcon("src/images/startPlank.jpg"));
			start.setBounds(270, 270 , 500, 78);
			imgPan.add(start);
			start.addActionListener(new ActionStart(this));
		
			JButton option = new JButton(new ImageIcon("src/images/optionPlank.jpg"));
			option.setBounds(270, 400 , 500, 78);
			imgPan.add(option);
			option.addActionListener(new ActionOption(this));
	
			this.add(imgPan);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE); //button fermer fenetre, quitter l'application
			//setSize(1000, 750);
			this.setBounds(500,100,1000,800);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 class ActionStart implements ActionListener{
		private JFrame frame;
		
		public ActionStart(JFrame frame) {
			this.frame = frame;
		}
		
	//opening the main window
		public void actionPerformed(ActionEvent arg0) {
		  frame.dispose();//close the starting window then open the game window
		// gui = new GUIproject();
		  GUIproject game = new GUIproject();
		   game.setVisible(true);
		}
		
	}
	
	class ActionOption implements ActionListener{
		private JFrame frame;
		
		public ActionOption(JFrame frame) {
			this.frame = frame;
		}
		
	//opening the option window
		public void actionPerformed(ActionEvent arg0) {
			//GUIproject gui = new GUIproject();
			
		    new GUIParameters();
		   
		}
		
	}
	
	public static void main(String[] args){
		//ThreadPool?
		GUIStart start = new GUIStart();
		//Music player = new Music("music.mp3"); //.wav .mp3 
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter("dogAction.txt"));
			br.write(0);
			br.newLine();
			br.write(0);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}