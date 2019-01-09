package ihm;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import sound.Music;
import clock.Clock;
import animal.Pet;
import animal.ActionPunish;
import animal.ActionReward;
import motor.GameMotor;
import npc.NPCMaster;
import npc.NPCThief;
import npc.NpcEvents;

/**
 * 
 * @author Gabriel + Fares + Roat
 *
 */

public class GUIproject extends JFrame implements Runnable{
	private static Clock clock;
	private Pet dog;
	private NPCMaster master;
	private NPCThief thief;
	private NpcEvents events;
	private static JLabel clockLab;
	private GUIproject instance = this;
	private static JLabel mastName;
	private static JLabel dogName;
	private GameMotor moteur;
	private JTextArea lastDogAction;
	private JTextArea lastEvent;
	private int lastReactedAction;
	public GUIMaps canva = new GUIMaps(clock);
	public GUIGraph chartManagerThief= new GUIGraph();
	public GUIGraph chartManagerMaitre= new GUIGraph();
	public GUIGraph chartManagerObject= new GUIGraph();
	public GUIproject() {
	

		super("GLP Project 6 : Dressage");
		
        
		JPanel mainPanel = new JPanel(); // Panels and layouts creation ->
		JPanel pan2A = new JPanel();
		JPanel pan2B = new JPanel();
		JPanel pan3A = new JPanel();
		JPanel pan3B = new JPanel();
		//JPanel pan3BText = new JPanel();
		JPanel pan3C = new JPanel();

		mainPanel.setLayout(new BorderLayout());
		pan2A.setLayout(new FlowLayout());
		pan2B.setLayout(new BorderLayout());
		pan3A.setLayout(new GridLayout(2, 2));
		pan3B.setLayout(new GridLayout(0, 1));
		pan3C.setLayout(new GridLayout(2, 2)); 
		
		
		pan3A.setPreferredSize(new Dimension(350,100));
		pan3B.setPreferredSize(new Dimension(350,0));
		pan3C.setPreferredSize(new Dimension(350,100));
	   

		JLabel punishText = new JLabel("Punir"); // component creation ->
		JLabel rewardText = new JLabel("R\u00E9compenser");
		JLabel statisticText = new JLabel("Statistic");
		JLabel lastDogActionText = new JLabel("Derni\u00E8re action :");
		lastDogAction = new JTextArea("La chien n'as rien fait. Pour l'instant.");
		
		JLabel lastEventText = new JLabel("Dernier \u00e9v\u00e8nement :");
		lastEvent = new JTextArea("Aucun \u00e9v\u00e8nement.");
		
		
		
		
		
		clock = new Clock();
		dog = new Pet("Pet"); // null for initialize after GUI
		master = new NPCMaster("Name");
		thief = new NPCThief("Bob the thief"); // same idea
		events = new NpcEvents(); // <-

		JButton jbPunish = new JButton(new ImageIcon("src/images/stick.png")); // Buttons & ActionListeners ->
		JButton jbReward = new JButton(new ImageIcon("src/images/apple.png"));
		JButton jbStatistic = new JButton(new ImageIcon("src/images/state.png"));
		JButton jbDiary = new JButton(new ImageIcon("src/images/diary.png"));
		JButton jbPersonalize = new JButton(new ImageIcon("src/images/maison.jpg"));
		JButton jbParameters = new JButton(new ImageIcon("src/images/cog.png"));
		JButton jbQuit = new JButton(new ImageIcon("src/images/quit.png"));

		jbPunish.addActionListener(new ActionBoutonPunish());
		jbReward.addActionListener(new ActionBoutonReward());
		jbStatistic.addActionListener(new ActionStatistic());
		jbDiary.addActionListener(new ActionDiaryWin(this));
		jbPersonalize.addActionListener(new ActionPersonalizeWin());
		jbParameters.addActionListener(new ActionParmetersWin());
		jbQuit.addActionListener(new ActionQuit(this)); // <-

		clockLab = new JLabel(clock.toString()); // Panels organisation ->
		pan2A.add(clockLab);
		mastName = new JLabel("Master's name : "+master.getName());
		pan2A.add(mastName);
		dogName = new JLabel("Dog's name : "+ dog.getName());
		pan2A.add(dogName);

		pan3A.add(jbReward);
		pan3A.add(jbPunish);
		pan3A.add(jbStatistic);
		pan3A.add(rewardText);
		pan3A.add(punishText);
		pan3A.add(statisticText);
		
		//pan3BText.add(lastDogActionText);
		pan3B.add(lastDogActionText);
		pan3B.add(lastDogAction);
		
		//pan3BText.add(lastEventText);
		pan3B.add(lastEventText);
		pan3B.add(lastEvent);
		
		pan3C.add(jbDiary);
		pan3C.add(jbPersonalize);
		pan3C.add(jbParameters);
		pan3C.add(jbQuit);
		
		pan2B.add(pan3A, BorderLayout.NORTH);
		pan2B.add(pan3B, BorderLayout.CENTER);
		//pan2B.add(pan3BText, BorderLayout.EAST);
		pan2B.add(pan3C, BorderLayout.SOUTH);

		mainPanel.add(pan2A, BorderLayout.NORTH);
		mainPanel.add(pan2B, BorderLayout.EAST);
		mainPanel.add(canva, BorderLayout.CENTER ); // <-
		
		jbReward.setBackground(Color.white);
		jbPunish.setBackground(Color.white);
		jbStatistic.setBackground(Color.white);
		jbDiary.setBackground(Color.white);
		jbPersonalize.setBackground(Color.white);
		jbParameters.setBackground(Color.white);
		jbQuit.setBackground(Color.white);
		
		lastDogAction.setEditable(false);
		lastEvent.setEditable(false); 
		
		lastDogAction.setLineWrap(true);
		lastEvent.setLineWrap(true);
		
		this.getContentPane().add(mainPanel);
		
		this.setSize(1100, 700);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		Thread windowThread = new Thread(instance);
		windowThread.start();
		
		initMotor();
		
	}
	
	protected void initMotor() {
		
		moteur = new GameMotor(dog, clock, lastDogAction, canva);
		moteur.startMotor();
		
	}
	
	public class ActionBoutonPunish implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			Thread pun = new Thread(new Music("./sounds/punishment.wav"));
			canva.randomStory(6);
			pun.start();
			
			HashMap<Integer, ArrayList<Integer> > hm = moteur.getHm();
			
			try {
				BufferedReader br = new BufferedReader(new FileReader("dogAction.txt"));
				
				int surrounding = Integer.parseInt(br.readLine());
				int action = Integer.parseInt(br.readLine());
				br.close();
				
					if(action!=lastReactedAction){
				
					if(action!=0 && surrounding!=0){
						if(action==3){
							for (int i = 1 ; i<=5 ; i++){
								if(i==action){
									ArrayList<Integer> ar = new ArrayList<Integer>();
									ar = hm.get(action);
									ar.set(surrounding, ar.get(surrounding)-4);
									hm.put(action, ar);
									if (surrounding==0) {chartManagerThief.setStatPunish(action); }
									if (surrounding==1) {chartManagerMaitre.setStatPunish(action); }
									if (surrounding==2) {chartManagerObject.setStatPunish(action); }
								}else{
									ArrayList<Integer> ar = new ArrayList<Integer>();
									ar = hm.get(i);
									ar.set(surrounding, ar.get(surrounding)+1);
									hm.put(i, ar);
								}
							}
						}else{
							for (int i = 1 ; i<=5 ; i++){
								if(i==action){
									ArrayList<Integer> ar = new ArrayList<Integer>();
									ar = hm.get(action);
									ar.set(0, ar.get(0)-4);
									ar.set(1, ar.get(1)-4);
									ar.set(2, ar.get(2)-4);
									hm.put(action, ar);
									chartManagerThief.setStatPunish(action);
									chartManagerMaitre.setStatPunish(action);
									chartManagerObject.setStatPunish(action);
									
								}else{
									ArrayList<Integer> ar = new ArrayList<Integer>();
									ar = hm.get(i);
									ar.set(0, ar.get(0)+1);
									ar.set(1, ar.get(1)+1);
									ar.set(2, ar.get(2)+1);
									hm.put(i, ar);
									chartManagerThief.setStatPunish(action);
									chartManagerMaitre.setStatPunish(action);
									chartManagerObject.setStatPunish(action);
								}
							}
						}
						moteur.setHm(hm);
						lastEvent.setText("Vous avez punis le chien.");
						
					}
					lastReactedAction=action;
					
				}
			} catch (IOException err) {
				// TODO Auto-generated catch block
				err.printStackTrace();
			}	
		}	
	}
	
	
	public class ActionBoutonReward implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			Thread rew = new Thread(new Music("./sounds/reward.wav"));
			canva.randomStory(5);
			rew.start();
			
			HashMap<Integer, ArrayList<Integer> > hm = moteur.getHm();
			
			try {
				BufferedReader br = new BufferedReader(new FileReader("dogAction.txt"));
				
				int surrounding = Integer.parseInt(br.readLine());
				int action = Integer.parseInt(br.readLine());
				
				br.close();
				
				if(action!=lastReactedAction){
					if(action!=0 && surrounding!=0){
						if(action==3){
							for (int i = 1 ; i<=5 ; i++){
								if(i==action){
									ArrayList<Integer> ar = new ArrayList<Integer>();
									ar = hm.get(action);
									ar.set(surrounding, ar.get(surrounding)+4);
									hm.put(action, ar);
									if (surrounding==0) {chartManagerThief.setStatReward(action); }
									if (surrounding==1) {chartManagerMaitre.setStatReward(action); }
									if (surrounding==2) {chartManagerObject.setStatReward(action); }
								}else{
									ArrayList<Integer> ar = new ArrayList<Integer>();
									ar = hm.get(i);
									ar.set(surrounding, ar.get(surrounding)-1);
									hm.put(i, ar);
								}	
							}
						}else{
							for (int i = 1 ; i<=5 ; i++){
								if(i==action){
									ArrayList<Integer> ar = new ArrayList<Integer>();
									ar = hm.get(action);
									ar.set(0, ar.get(0)+4);
									ar.set(1, ar.get(1)+4);
									ar.set(2, ar.get(2)+4);
									hm.put(action, ar);
									chartManagerThief.setStatReward(action);
									chartManagerMaitre.setStatReward(action);
									chartManagerObject.setStatReward(action);
								}else{
									ArrayList<Integer> ar = new ArrayList<Integer>();
									ar = hm.get(i);
									ar.set(0, ar.get(0)-1);
									ar.set(1, ar.get(1)-1);
									ar.set(2, ar.get(2)-1);
									hm.put(i, ar);
									chartManagerThief.setStatReward(action);
									chartManagerMaitre.setStatReward(action);
									chartManagerObject.setStatReward(action);
								}
							}
						}
						moteur.setHm(hm);
						lastEvent.setText("Vous avez r\u00e9compens\u00e9 le chien.");
					}
					lastReactedAction=action;
				}
			} catch (IOException err) {
				// TODO Auto-generated catch block
				err.printStackTrace();
			}
			
		}	
	}

	class ActionDiaryWin implements ActionListener { // opening the diary
		private JFrame frame;
		
		public ActionDiaryWin(JFrame frame) {
			this.frame = frame;
		}
		public void actionPerformed(ActionEvent arg0) {
			lastEvent.selectAll();
			lastEvent.setText("Vous avez ouvert le journal.");
			new GUIDiary(canva);
		}

	}

	class ActionPersonalizeWin implements ActionListener { // opening the personalization window
		public void actionPerformed(ActionEvent arg0) {
			lastEvent.selectAll();
			lastEvent.setText("Vous avez ouvert le mode de personnalisation.");
			new GUIPersonalize(canva);
		}

	}

	class ActionParmetersWin implements ActionListener { // opening the parameters window
		public void actionPerformed(ActionEvent arg0) {
			new GUIParameters();
		}

	}

	class ActionQuit implements ActionListener { // quit the game
		private JFrame frame;
		
		public ActionQuit(JFrame frame) {
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			 frame.dispose();
			 GUIStart start = new GUIStart();

		}

	}

	public static void main(String[] args) {
		new GUIproject();
	}

	
	class ActionStatistic implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			new GUIStatistic(chartManagerThief,chartManagerMaitre,chartManagerObject);
		   
		}
		
	}
	
	public void run() {
		Music bgMusic = new Music("./sounds/music.wav");
		Thread mus = new Thread(bgMusic);
		mus.start();

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			clock.increment();
			clockLab.setText(clock.toString());
			canva.setTime(clock.getHour(), clock.getMinute());
			mastName.setText(master.getName());
			dogName.setText(dog.getName());
		}

	}

}
