package motor;

import ihm.GUIMaps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import ihm.GUIDiary;
import animal.Pet;
import npc.NPCThief;
import clock.Clock;

public class GameMotor {
	private Clock clock;
	private int b;
	private int lastAction;
	private int lastNonMouvAction;
	private JTextArea lastDogAction;
	private boolean timeToDayTP = true;
	private boolean thiefActionWaiting = true;
	private HashMap<Integer, ArrayList<Integer> > hm ;
	private Pet pet;
	private GUIMaps canva;
	private GUIDiary diary;
	//private String storyLine;


	public GameMotor(Pet pet, Clock clock2, JTextArea lastDogAction, GUIMaps canva){
		this.pet = pet;
		//this.diary = diary;
		this.clock=clock2;
		this.b=1;
		this.canva = canva;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("dogAction.txt", true));
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.lastDogAction=lastDogAction;
		
		hm = new HashMap<Integer, ArrayList<Integer> >();
		ArrayList<Integer> dort = new ArrayList<Integer>();
		dort.add(80);
		dort.add(80);
		dort.add(80);
		hm.put(1, dort);
		
		ArrayList<Integer> joue = new ArrayList<Integer>();
		joue.add(80);
		joue.add(80);
		joue.add(80);
		hm.put(2, joue);
		
		ArrayList<Integer> mord = new ArrayList<Integer>();
		mord.add(80);
		mord.add(80);
		mord.add(80);
		hm.put(3, mord);
		
		ArrayList<Integer> aboie = new ArrayList<Integer>();
		aboie.add(80);
		aboie.add(80);
		aboie.add(80);
		hm.put(4, aboie);
		
		ArrayList<Integer> assis = new ArrayList<Integer>();
		assis.add(80);
		assis.add(80);
		assis.add(80);
		hm.put(5, assis);
		
	}
	
	
	public int getLastAction() {
		return lastAction;
	}

	public void setLastAction(int lastAction) {
		this.lastAction = lastAction;
	}

	public int getLastNonMouvAction() {
		return lastNonMouvAction;
	}

	public void setLastNonMouvAction(int lastNonMouvAction) {
		this.lastNonMouvAction = lastNonMouvAction;
	}

	public HashMap<Integer, ArrayList<Integer>> getHm() {
		return hm;
	}

	public void setHm(HashMap<Integer, ArrayList<Integer>> hm) {
		this.hm = hm;
	}



	public void startMotor(){
		Random r;
		int valeur;
		while(true){
			r = new Random();
			valeur = 1 + r.nextInt(3800 - 1);
			canva.randomStory(7); //diary Story when the dog move
			if(Integer.parseInt(clock.getHour())<=23 && Integer.parseInt(clock.getHour())>=7){
				if(timeToDayTP){
					canva.setPosMastAndPet(false);
					timeToDayTP=false;
				}
				thiefActionWaiting = true;
				if(getLastAction()==6){
					try {
						Thread.sleep(700);
						identifySurroundings(valeur);
						Thread.sleep(700);
						identifySurroundings(valeur);
						Thread.sleep(700);
						identifySurroundings(valeur);
						actionBougeNpc();
						messageEvent();
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				else{
					if(lastNonMouvAction==1){
						try {
							Thread.sleep(2000);
							actionBougeNpc();
							Thread.sleep(2000);
							actionBougeNpc();
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
						}
						identifySurroundings(valeur);
					}else{
						try {
							Thread.sleep(2000);
							actionBougeNpc();
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
						}
						identifySurroundings(valeur);
					}
				}
			}else{
				if(timeToDayTP==false){
					canva.setPosMastAndPet(true);
					timeToDayTP=true;
				}
				
				if(Integer.parseInt(clock.getHour())==2){
					//r = new Random();
					//valeur = 1 + r.nextInt(5 - 1);
					valeur = 1;
					if(valeur == 1){
						canva.spawnThief();
						if(thiefActionWaiting == true){
							r = new Random();
							valeur = 1 + r.nextInt(400 - 1);
							
							doActionNearThief(valeur);
							thiefActionWaiting = false;
						}
					}
				}
				else{
					if(Integer.parseInt(clock.getHour())==4){
						canva.despawnThief();
					}
				}
				
			}
			if(Integer.parseInt(clock.getHour())==23){
				lastDogAction.setText("Le chien se rend Ã  son panier et commence \u00E0 dormir...");
			}
		}
	}
	

	/*public void startMaster() {
		while (true) {
			actionBougeNpc();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}*/


	public void identifySurroundings(int value){
		if(pet.isNearMaster()){
			doActionNearMaster(value);
			canva.randomStory(3);
		}else{
			doActionNearObject(value);
			canva.randomStory(4);
		}
	}
	
	private void doActionNearMaster(int value) {
		if(value<=400){
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("dogAction.txt", false));
				bw.write("0");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(value<=hm.get(1).get(0)){
			actionDort();
		}else{
			if(value<=hm.get(2).get(0)+hm.get(1).get(0)){
				actionJouer();
			}else{
				if(value<=hm.get(3).get(0)+hm.get(2).get(0)+hm.get(1).get(0)){
					actionMordre();
				}else{
					if(value<=hm.get(4).get(0)+hm.get(3).get(0)+hm.get(2).get(0)+hm.get(1).get(0)){
						actionAboie();
					}else{
						if(value<=hm.get(5).get(0)+hm.get(4).get(0)+hm.get(3).get(0)+hm.get(2).get(0)+hm.get(1).get(0)){
							actionAssis();
						}else{
							actionBouge();
						}
					}
				}
			}
		}
	}

	private void doActionNearThief(int value) {
		if(value<=400){
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("dogAction.txt", false));
				bw.write("1");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(value<=hm.get(1).get(1)){
			actionDort();
		}else{
			if(value<=hm.get(2).get(1)+hm.get(1).get(1)){
				actionJouer();
			}else{
				if(value<=hm.get(3).get(1)+hm.get(2).get(1)+hm.get(1).get(1)){
					actionMordre();
				}else{
					if(value<=hm.get(4).get(1)+hm.get(3).get(1)+hm.get(2).get(1)+hm.get(1).get(1)){
						actionAboie();
					}else{
						if(value<=hm.get(5).get(1)+hm.get(4).get(1)+hm.get(3).get(1)+hm.get(2).get(1)+hm.get(1).get(1)){
							actionAssis();
						}else{
							actionBouge();
						}
					}
				}
			}
		}
	}


	public void doActionNearObject(int value){
		if(value<=400){
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("dogAction.txt", false));
				bw.write("2");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(value<=hm.get(1).get(2)){
			actionDort();
		}else{
			if(value<=hm.get(2).get(2)+hm.get(1).get(2)){
				actionJouer();
			}else{
				if(value<=hm.get(3).get(2)+hm.get(2).get(2)+hm.get(1).get(2)){
					actionMordre();
				}else{
					if(value<=hm.get(4).get(2)+hm.get(3).get(2)+hm.get(2).get(2)+hm.get(1).get(2)){
						actionAboie();
					}else{
						if(value<=hm.get(5).get(2)+hm.get(4).get(2)+hm.get(3).get(2)+hm.get(2).get(2)+hm.get(1).get(2)){
							actionAssis();
						}else{
							actionBouge();
						}
					}
				}
			}
		}
	}
	
	private void actionDort() {		//1
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("dogAction.txt", true));
			bw.newLine();
			bw.write("1");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLastAction(1);
		setLastNonMouvAction(1);
		lastDogAction.setText("Le chien a commenc\u00E9 \u00E0 dormir...");
	}

	private void actionJouer() {	//2
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("dogAction.txt", true));
			bw.newLine();
			bw.write("2");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLastAction(2);
		setLastNonMouvAction(2);
		lastDogAction.setText("Le chien est en train de jouer.");
	}
	
	private void actionMordre() {	//3
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("dogAction.txt", true));
			bw.newLine();
			bw.write("3");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLastAction(3);
		setLastNonMouvAction(3);
		lastDogAction.setText("Le chien vient de mordre.");
		//changer le texte en fonction du cas (qui s'est fait mordre ? Voir avec la position)
	}
	
	private void actionAboie() {	//4
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("dogAction.txt", true));
			bw.newLine();
			bw.write("4");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLastAction(4);
		setLastNonMouvAction(4);
		lastDogAction.setText("Le chien a aboy\u00e9.");
	}
	
	private void actionAssis() {	//5
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("dogAction.txt", true));
			bw.newLine();
			bw.write("5");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLastAction(5);
		setLastNonMouvAction(5);
		lastDogAction.setText("Le chien s'est assis.");
	}


	private void actionBouge() {	//6
		setLastAction(6);
		lastDogAction.setText("Le chien bouge.");
		Random directionPet = new Random();
		int dep = 1 + directionPet.nextInt(5 - 1);
		
		
				
		canva.deplacementChien(dep);
		
	}
	private void actionBougeNpc() {
		
		Random directionMaster = new Random();
		int dep2 = 1 + directionMaster.nextInt(5 - 1);
		

		canva.deplacementMaster(dep2);
	}
	
	private void messageEvent() {
		int i,j;		
		int xPosition = canva.getUpdatedPosPetX();
		int yPosition = canva.getUpdatedPosPetY();
		String newStoryLine;
		
		if (canva.testXYPositionNpc(xPosition,yPosition)){
			if(yPosition == 16 || yPosition == 32) { //Fleur
				for(i=560;i<=720;i++) {
					if(xPosition == i) {
						lastDogAction.setText("The pet walk on the flower");
						
					}
				}
				
			}
			
			if(yPosition == 48 || yPosition == 64) {
				for(i=576;i<=720;i++) {
					if(xPosition == i) {
						lastDogAction.setText("The pet walk on the flower");
						
						
					}
				}
			}
			
			if(yPosition == 64 || yPosition == 80) {
				for(j=608;j<=720;j++) {
					if(xPosition == j) {
						lastDogAction.setText("The pet walk on the flower");
						
					}
				}
			}
			
			if(yPosition == 96) {
				for(i=688;i<=720;i++) {
					if(xPosition == i) {
						lastDogAction.setText("The pet walk on the flower");
						
						
					}
				}
			}
			
			if(yPosition == 560 ) { //box à sable
				for(i=128;i<=160;i++) {
					if(xPosition == i) {
						lastDogAction.setText("The pet play on the sandbox");
					}
				}
			}
			
			if(yPosition == 576) {
				for(i=96;i<=192;i++) {
					if(xPosition == i) {
						lastDogAction.setText("The pet play on the sandbox");
					}
				}
			}
			
			if(yPosition == 592) {
				for(i=64;i<=208;i++) {
					if(xPosition == i) {
						lastDogAction.setText("The pet play on the sandbox");
					}
				}
			}
			
			if(yPosition == 608) {
				for (i=64;i<=240;i++) {
					if(xPosition == i) {
						lastDogAction.setText("The pet play on the sandbox");
					}
				}
			}
		}
	}	
}
