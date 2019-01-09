package ihm;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import animal.Pet;
import npc.NPCMaster;
import npc.NPCThief;
import items.Items;
import positionXY.Position;
import clock.Clock;

public class GUIMaps extends JPanel {
	Pet posPet = new Pet("Pet");
    NPCMaster posMaster = new NPCMaster("");
    
    NPCThief posThief = new NPCThief("Bob");
    
   	private Position posCouch = new Position(288,432);
   	private Position posTable = new Position(624,320);
   	private Position posTable2 = new Position(624,304);
   	private Position posChair1 = new Position(608,320);
   	private Position posChair2 = new Position(640,320);
   	private Position posChair3 = new Position(608,304);
   	private Position posChair4 = new Position(640,304);
   	private Position posToybox = new Position(380,544);
   	
   	BufferedImage img = null;
    BufferedImage imgPet = null;
    BufferedImage imgChair = null;
    BufferedImage imgChair2 = null;
    BufferedImage imgChair3 = null;
    BufferedImage imgChair4 = null;
    BufferedImage imgCouch = null;
    BufferedImage imgTable = null;
    BufferedImage imgTable2 = null;
    BufferedImage imgToyBox = null;
    BufferedImage npcMaster = null;
    BufferedImage npcThief = null;
    
    private Items couch;
   	private Items table, table2;
   	private Items chair1,chair2, chair3,chair4;
   	private Items toyBox;
   	//private Items sandBox1,sandBox2,sandBox3,sandBox4,sandBox5,sandBox6;
   	//private Items flower1,flower2,flower3,flower4,flower5,flower6,flower7;
   	private JTextArea lastEvent;
     
	private String storyLine = "Aujourd'hui je m'ennuie je ne sais pas trop quoi faire."; //default
	
	private Clock clock;
	private int updatedPosPetX;
    private int updatedPosPetY;
    
    ArrayList<String> items = new ArrayList<String>();
    ArrayList<String> allDiaryList = new ArrayList<String>();
    
    private String newHours;
	private String newMinute;
	
	public GUIMaps(Clock clock) {
		this.clock = clock;
		this.clock = clock;
		items.add("chaise");
		items.add("boite");
		items.add("table");
		items.add("couch");
	}

	public void paintComponent(Graphics g){ 
		super.paintComponent(g); 
		int larg = getWidth(); 
		double dHaut = getHeight();
		int haut = (int)dHaut;
		int dim = 16; //Case Dimension
		
		JLayeredPane EverythingButPlayer;
        
		couch = new Items("couch", null);
		
		table = new Items("table", posTable);
		
		table2 = new Items("table", posTable2);
		
		chair1 = new Items("chair", posChair1);
		
		chair2 = new Items("chair", posChair2);
		
		chair3 = new Items("chair", posChair3);
		
		chair4 = new Items("chair", posChair4);
		
		toyBox = new Items("toyBox", posToybox);
        
		try {
			img = ImageIO.read(new File("src/images/map2.png"));
				
			imgPet = ImageIO.read(new File("src/images/Pet.bmp"));
			
			imgChair = ImageIO.read(new File("src/images/chaise.png"));
			
			imgChair2 = ImageIO.read(new File("src/images/chaise2.png"));
			
			imgChair3 = ImageIO.read(new File("src/images/chaise.png"));
			
			imgChair4 = ImageIO.read(new File("src/images/chaise2.png"));
			
			imgCouch = ImageIO.read(new File("src/images/couch.jpg"));
			
			imgTable = ImageIO.read(new File("src/images/table.png"));
			
			imgTable2 = ImageIO.read(new File("src/images/table.png"));
			
			imgToyBox = ImageIO.read(new File("src/images/toyBoxItem.png")); 
			
			npcMaster = ImageIO.read(new File("src/images/master.png"));
			
			npcThief = ImageIO.read(new File("src/images/voleur.jpg"));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                   //name of the image, position and size
         
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
         
		g.drawImage(imgPet, posPet.getXPerso(), posPet.getYPerso(), dim, dim, this);
    	 
		g.drawImage(imgChair ,posChair1.getPositionX(), posChair1.getPositionY(), dim, dim, this);
        
		g.drawImage(imgChair2 ,posChair2.getPositionX(), posChair2.getPositionY(), dim, dim, this);
		
		g.drawImage(imgChair3 ,posChair3.getPositionX(), posChair3.getPositionY(), dim, dim, this);
        
		g.drawImage(imgChair4 ,posChair4.getPositionX(), posChair4.getPositionY(), dim, dim, this); //non-transparent ==> a modifier
          
		g.drawImage(imgCouch, posCouch.getPositionX(), posCouch.getPositionY(), dim, dim, this);
		
		g.drawImage(imgTable, posTable.getPositionX(), posTable.getPositionY(), dim, dim, this);
		
		g.drawImage(imgTable2, posTable2.getPositionX(), posTable2.getPositionY(), dim, dim, this);
          
		g.drawImage(imgToyBox, posToybox.getPositionX(), posToybox.getPositionY(), dim, dim, this);
		
		g.drawImage(npcMaster, posMaster.getxPersoMaster(), posMaster.getyPersoMaster(), dim, dim, this);
	
		g.drawImage(npcThief, posThief.getxPersoThief(), posThief.getyPersoThief(), dim, dim, this);
	
        // La grille:
		/*for(int i = 0; i < haut; i +=dim){
			g.drawLine(0,i,larg, i); //horizontal lines of the grid
		}
		for(int i = 0; i < larg; i +=dim){
			g.drawLine(i,0,i, haut); //vertical lines of the grid
		}*/
	}
	
	/*public GUIMaps(JTextArea lastEvent) {
		this.lastEvent = lastEvent;
	}
	*/
	public void setUpdatedPosPetX(int xPosition) {
		this.updatedPosPetX = xPosition;
	}
	
	public void setUpdatedPosPetY(int yPosition) {
		this.updatedPosPetY = yPosition;
	}
	
	public int getUpdatedPosPetX() {
		return updatedPosPetX = updatedPosPetX;
	}
	
	public int getUpdatedPosPetY(){
		return updatedPosPetY = updatedPosPetY;
	}
	
	public void deplacementChien(int direction){
		int x = this.posPet.getXPerso();
		int y = this.posPet.getYPerso();
		setUpdatedPosPetX(x);
		setUpdatedPosPetY(y);
		System.out.println("Pet : "+direction+" Position : ("+x+","+y+")");
		
		switch(direction){
		case 1:
			int north = this.posPet.getYPerso()-16;
			
			if(testXYPositionPet(x,north)){
				this.posPet.setYPerso(north);
				this.repaint(); 
				break;
			}
			else {
				System.out.println("Dog ----------------> Impossible to move on ! (North)");
				break;
			}
			
		case 2:
			int east = this.posPet.getXPerso()+16;
			
			if(testXYPositionPet(east,y)) {
				this.posPet.setXPerso(east);
				this.repaint(); 
			    break;
			}
			else {
				System.out.println("Dog ----------------> Impossible to move on ! (East)");
				break;	
			}
			
		case 3:
			int south = this.posPet.getYPerso()+16;
			
			if(testXYPositionPet(x,south)){
			     this.posPet.setYPerso(south);
			     this.repaint(); 
			     break;
			}
			else {
					System.out.println("Dog ----------------> Impossible to move on ! (South)");
					break;
				}
			
		case 4:
			int west = this.posPet.getXPerso()-16;
			
			if(testXYPositionPet(west,y)) {
				this.posPet.setXPerso(west);
				this.repaint(); 
			    break;
			}
			else {
				System.out.println("Dog ----------------> Impossible to move on ! (West)");
				break;	
			}
		}
	}
	
	public void deplacementMaster(int direction){
		int x = this.posMaster.getxPersoMaster();
		int y = this.posMaster.getyPersoMaster();
		
		System.out.println("Master : "+direction+" Position : ("+x+","+y+")");
		switch(direction){
		case 1:
			int north = this.posMaster.getyPersoMaster()-16;
			if(testXYPositionNpc(x,north)) {
		        this.posMaster.setyPersoMaster(north);
		        this.repaint();
		        break;
			}
			else {
				System.out.println("Master ----------------> Impossible to move on (North)!");
				break;	
			}
		case 2:
			int east = this.posMaster.getxPersoMaster()+16;
			if(testXYPositionNpc(east,y)) {
				this.posMaster.setxPersoMaster(east);
				this.repaint(); 
		        break;
			}
			else {
				this.posMaster.setxPersoMaster(x);
				System.out.println("Master ----------------> Impossible to move on ! (East)");
				break;	
			}
		case 3:
			int south = this.posMaster.getyPersoMaster()+16;
			if(testXYPositionNpc(x,south)){
				this.posMaster.setyPersoMaster(south);;
				this.repaint(); 
		        break;
			}
			else {
				this.posMaster.setyPersoMaster(y);
				System.out.println("Master ----------------> Impossible to move on !(South)");
				break;	
			}
		case 4:
			int west = this.posMaster.getxPersoMaster()-16;
			if(testXYPositionNpc(west,y)) {
				this.posMaster.setxPersoMaster(west);
				this.repaint(); 
		        break;
			}
			else {
				this.posMaster.setxPersoMaster(x);
				System.out.println("Master ----------------> Impossible to move on ! (West)");
				break;	
			}
		}
	}
	
	
	public boolean testXYPositionPet(int xPosition, int yPosition) {
		int i,j;
		
		int flower = 1;
		int sandBox = 2;
		int masterNear = 3;
		int masterFar = 4;
		
		String newStoryLine = "...";
		
		
		if(xPosition == 0) { //mur West
			for (j=0;j<=624;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(xPosition == 736) { //mur east
			for (j=0;j<=624;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(yPosition == 0) { //mur north
			for (i=0;i<=736;i++) {
				if(xPosition == i) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(yPosition == 624) { //mur south
			for (i=0;i<=736;i++) {
				if(xPosition == i) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(yPosition == 256){
			for (i=384;i<=688;i++) {
				if(xPosition == i) {
				System.out.println("Pet can't move --------------------- > House's wall");
				return false;
				}
			}
		}
		
		else if(yPosition == 256){
			for (i=272;i<=340;i++) {
				if(xPosition == i) {
				System.out.println("Pet can't move --------------------- > House's wall");
				return false;
				}
			}
		}
		
		else if(yPosition == 560) {
			for( i=272;i<=688;i++) {
				if(xPosition == i) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(xPosition == 272){ //ok
			for( j=256;j<=560;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(xPosition == 688) { //ok
			for( j=256;j<=560;j++) {
				if( yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(xPosition == 480) { //mur salon en haut a gauche ok
			for( j=512;j<=560;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
			for( j=368;j<=432;j++) { //mur salon en haut a droit ok
				if(yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(yPosition == 368) { //mur salon a droit (north)  ok
			for (i=288;i<=304;i++) {
				if(xPosition == i) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
			for( i=384;i<=480;i++) {
				if(xPosition == i) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
			for (i=576;i<=672;i++) {
				if(xPosition == i) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(xPosition == 576) {
			for(j=368;j<=384;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
			for(j=448;j<=496;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
			for(j=528;j<=544;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(yPosition == 480) {
			for(i = 578;i<=688;i++) {
				if(xPosition == i) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(xPosition == 400) {
			for(j=256;j<=320;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(yPosition == 320) {
			for(i=400;i<=480;i++) {
				if(xPosition == i) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
			for(i=528;i<=544;i++) {
				if(xPosition == i) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(xPosition == 544) {
			for(j=256;j<=320;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(xPosition == 304 || xPosition == 320 || xPosition == 336) { //Lake open bridge
			for(j=64;j<=96;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't swim --------------------- > House's wall");
					return false;
				}
			}
			
			for(j=128;j<=160;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't swim --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(xPosition == 352 || xPosition == 368) {
			for(j=64;j<=160;j++) {
				if(yPosition == j) {
					System.out.println("Pet can't swim --------------------- > House's wall");
					return false;
				}
			}
		}
		
		else if(yPosition == 16 || yPosition == 32) { //Fleur
			for(i=560;i<=720;i++) {
				if(xPosition == i) {
					System.out.println("The pet walk on the flowers");
					randomStory(flower);
				}
			}
		}
		
		else if(yPosition == 48 || yPosition == 64) {
			for(i=576;i<=720;i++) {
				if(xPosition == i) {
					System.out.println("The pet walk on the flowers");
					randomStory(flower);
				}
			}
		}
		
		else if(yPosition == 64 || yPosition == 80) {
			for(j=608;j<=720;j++) {
				if(xPosition == j) {
					System.out.println("The pet walk on the flowers");
					randomStory(flower);
				}
			}
		}
		
		else if(yPosition == 96) {
			for(i=688;i<=720;i++) {
				if(xPosition == i) {
					System.out.println("The pet walk on the flowers");
					randomStory(flower);
				}
			}
		}
		
		else if(yPosition == 560 ) {
			for(i=128;i<=160;i++) {
				if(xPosition == i) {
					System.out.println("The pet play on the sandbox");
					randomStory(sandBox);
				}
			}
		}
		else if(yPosition == 576) {
			for(i=96;i<=192;i++) {
				if(xPosition == i) {
					System.out.println("The pet play on the sandbox");
					randomStory(sandBox);
				}
			}
		}
		
		else if(yPosition == 592) {
			for(i=64;i<=208;i++) {
				if(xPosition == i) {
					System.out.println("The pet play on the sandbox");
					randomStory(sandBox);
				}
			}
		}
		
		else if(yPosition == 608) {
			for (i=64;i<=240;i++) {
				if(xPosition == i) {
					System.out.println("The pet play on the sandbox");
					randomStory(sandBox);
				}
			}
		} 
		
		else { //other position 
			randomStory(7);
		}
		
		for(j=288;j<=368;j++){  //inside the house
			for (i=304;i<=400;i++) { 
				if(xPosition == i && yPosition == j) {
					System.out.println("The pet is in the house (enter door)");
					randomStory(8);
				}
			}
			
			for (i=592;i<=704;i++) {
				if(xPosition == i && yPosition == j) {
					System.out.println("The pet is in the house (Kitchen)");
					randomStory(8);
				}
			}
		}
		
		for (i=304;i<=480;i++) {
			for(j=400;j<=560;j++) {
				if(xPosition == i && yPosition == j) {
					System.out.println("The pet is in the house (Saloon)");
					randomStory(8);
				}
			}
		}
		
		for (i=608;i<=688;i++) {
			for(j=400;j<=480;j++) {
				if(xPosition == i && yPosition == j) {
					System.out.println("The pet is in the house (Bed room)");
					randomStory(8);
				}
			}
		}
		return true;
	}
	public boolean testXYPositionNpc(int xPosition,int yPosition){
		double dHaut = getHeight();
		int haut = (int)dHaut;
		int larg = getWidth(); 
		int i,j;
		//xPosition c'est i; yPosition c'est j
		
		if(xPosition == 0) { //mur West
			for (j=0;j<=624;j++) {
				if(yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(xPosition == 736) { //mur east
			for (j=0;j<=624;j++) {
				if(yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(yPosition == 0) { //mur north
			for (i=0;i<=736;i++) {
				if(xPosition == i) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(yPosition == 624) { //mur south
			for (i=0;i<=736;i++) {
				if(xPosition == i) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(yPosition == 256){ //ok
			for (i=272;i<=688;i++) {
				if(xPosition == i) {
				System.out.println("Master can't move --------------------- > House's wall");
				return false;
				}
			}
		}
		
		if(yPosition == 560){ //ok
			for( i=272;i<=688;i++) {
				if(xPosition == i) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(xPosition == 272){ //ok
			for( j=256;j<=560;j++) {
				if(yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(xPosition == 688) { //ok
			for( j=256;j<=560;j++) {
				if( yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(xPosition == 480) { //mur salon en haut a gauche ok
			for( j=512;j<=560;j++) {
				if(yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
			for( j=368;j<=432;j++) { //mur salon en haut a droit ok
				if(yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(yPosition == 368) { //mur salon a droit (north)  ok
			for (i=288;i<=304;i++) {
				if(xPosition == i) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
			
			for( i=384;i<=480;i++) {
				if(xPosition == i) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
			
			for (i=576;i<=672;i++) {
				if(xPosition == i) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(xPosition == 576) {
			for(j=368;j<=384;j++) {
				if(yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
			for(j=448;j<=496;j++) {
				if(yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
			for(j=528;j<=544;j++) {
				if(yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(yPosition == 480) {
			for(i = 578;i<=688;i++) {
				if(xPosition == i) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(xPosition == 400) {
			for(j=256;j<=320;j++) {
				if(yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(yPosition == 320) {
			for(i=400;i<=480;i++) {
				if(xPosition == i) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
			for(i=528;i<=544;i++) {
				if(xPosition == i) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(xPosition == 544) {
			for(j=256;j<=320;j++) {
				if(yPosition == j) {
					System.out.println("Master can't move --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(xPosition == 304 || xPosition == 320 || xPosition == 336) { //Lake open bridge
			for(j=64;j<=96;j++) {
				if(yPosition == j) {
					System.out.println("Master can't swim --------------------- > House's wall");
					return false;
				}
			}
			
			for(j=128;j<=160;j++) {
				if(yPosition == j) {
					System.out.println("Master can't swim --------------------- > House's wall");
					return false;
				}
			}
		}
		
		if(xPosition == 352 || xPosition == 368) {
			for(j=64;j<=160;j++) {
				if(yPosition == j) {
					System.out.println("Master can't swim --------------------- > House's wall");
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void randomStory(int storyPlace) {
		String newStoryLine = " ";
		
		if(storyPlace == 0) {
			newStoryLine = "...";
			this.setStoryLine(newStoryLine);
		}
		if(storyPlace == 1) { //flowers //story1
			Random rand = new Random(); 
			int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
			if(nombreAleatoire <= 25) { //20%
				Random rand2 = new Random(); 
				int nombreAleatoire2 = rand2.nextInt(100 - 0 + 1) + 0;
				if(nombreAleatoire2 <= 10) { //20%
					newStoryLine = "Wooow ! Il fait vraiment beau aujourd'hui, et les fleurs sentent si bon !!";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 10 && nombreAleatoire2 <=15) { 
					newStoryLine = "Je me demande si les fleurs sont mangeable ... oh un oiseau!! ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 20 && nombreAleatoire2 <=25) { 
					newStoryLine = "“Amour et les fleurs ne durent qu'un printemps.” de Pierre de Ronsard, je me demande si c'est vrai.";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 30 && nombreAleatoire2 <=35) { 
					newStoryLine = "Aujourd'hui j'ai trouvé une fleur bizarre ... Mimosa Pudica, Ce mouvement de repli permet de se protéger des intempéries, des prédateurs herbivores.";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 40 && nombreAleatoire2 <=45) { 
					newStoryLine = "J'ai caché mes os dans le jadin aujourd'hui ... je ne sais même pas pourquoi !! ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 50 && nombreAleatoire2 <=55) { 
					newStoryLine = "Waf !! waf !! ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 60 && nombreAleatoire2 <=65) { 
					newStoryLine = "Youpiii !! Bonjour mr.Fleur !";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				System.out.println("======================================================================= >>>> Diary updated ! Pet on flowers");
			}
		}
		
		if(storyPlace == 2) { //SandBox
			Random rand = new Random(); 
			int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
			if(nombreAleatoire <= 25) { //25%
				Random rand2 = new Random(); 
				int nombreAleatoire2 = rand2.nextInt(100 - 0 + 1) + 0;
				if(nombreAleatoire2 <= 20) { //10%
					newStoryLine = "Le bac a sable est trop génial, je me suis éclaté aujourd'hui !!";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 20 && nombreAleatoire2 <=40) { //20%
					newStoryLine = "Il fait un peu trop chaud aujourd'hui ! et j'ai un peu soif";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 40 && nombreAleatoire2 <=60) { //20%
					newStoryLine = "J'ai entendue un bruit très bizarre aujourd'hui, je pense que c'est un rat ... ou peu etre un chat? ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);				
				}
				
				System.out.println("======================================================================= >>>> Diary updated !  Pet on sandbox");
			}
		}
		
		
		if(storyPlace == 3) { //Master's near the pet //story2
			Random rand = new Random(); 
			int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
			if(nombreAleatoire <= 25) { //25%
				Random rand2 = new Random(); 
				int nombreAleatoire2 = rand2.nextInt(100 - 0 + 1) + 0;
				if(nombreAleatoire2 <= 20) { //10%
					newStoryLine = "J'aime mon maître !! C'est mon meilleur amis et il est gentil !";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 20 && nombreAleatoire2 <=40) { //20%
					newStoryLine = "I LOVE MY MASTER OMG !! ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 40 && nombreAleatoire2 <=60) { //20%
					newStoryLine = posMaster.getName()+" sent vraiment bon aujourd'hui !! ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 60 && nombreAleatoire2 <=80) { //20%
					newStoryLine = "Mon maître est just a côté de moi, je me sens plus en sécurité !";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 80 && nombreAleatoire2 <=100) { //20%
					newStoryLine = posMaster.getName()+" est just a côté !!";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				System.out.println("======================================================================= >>>> Diary updated ! Master near");
			}
		}
		
		if(storyPlace == 4) { //Master's far 
			Random rand = new Random(); 
			int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
			if(nombreAleatoire <= 15) { //25%
				Random rand2 = new Random(); 
				int nombreAleatoire2 = rand2.nextInt(100 - 0 + 1) + 0;
				if(nombreAleatoire2 <= 20) { //10%
					newStoryLine = "Mon maître me manque, il est si loin de moi ... il ressemble à quoi déja?";
					this.setStoryLine(newStoryLine);
				}
				
				if(nombreAleatoire2 > 10 && nombreAleatoire2 <=15) { //20%
					newStoryLine = "Je vais peu être aller voir mon maître "+posMaster.getName();
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 20 && nombreAleatoire2 <=25) { //20%
					newStoryLine = "J'ai besoin qu'il me caresse ... ça gratte dans le dos ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 30 && nombreAleatoire2 <=35) { //20%
					newStoryLine = "J'ai besoin de mon maître, je me sens si seul ...";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 40 && nombreAleatoire2 <=45) { //20%
					newStoryLine = "Mon maitre est si loin de moi ... je suis triste";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				System.out.println("======================================================================= >>>> Diary updated ! Master far ");
			}
		}
		
		if(storyPlace == 5) { //récompensé par le maitre
			Random rand = new Random(); 
			int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
			if(nombreAleatoire <= 100) { //25%
				Random rand2 = new Random(); 
				int nombreAleatoire2 = rand2.nextInt(100 - 0 + 1) + 0;
				if(nombreAleatoire2 <= 25) { //10%
					newStoryLine = "Youpiii un biscuit ! ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 20 && nombreAleatoire2 <=40) { //20%
					newStoryLine = "Yum yum !! c'est vraiment bon !! ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 40 && nombreAleatoire2 <=60) { //20%
					newStoryLine = "Oh mon dieu, une croquette pour chien !! Merci, j'adore !";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 60 && nombreAleatoire2 <=80) { //20%
					newStoryLine = "J'aime manger les fleurs dans le jadin mais les biscuits sont encore mieux !";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 80 && nombreAleatoire2 <=100) { //20%
					newStoryLine = "Cooooool !!! <3 ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				System.out.println("======================================================================= >>>> Diary updated ! Gift ");
			}
		}
		
		if(storyPlace == 6) { //puni par le maitre
			Random rand = new Random(); 
			int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
			if(nombreAleatoire <= 100) { //25%
				Random rand2 = new Random(); 
				int nombreAleatoire2 = rand2.nextInt(100 - 0 + 1) + 0;
				if(nombreAleatoire2 <= 20) { //10%
					newStoryLine = "Aie !! ça fait vraiment mal !! ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				if(nombreAleatoire2 > 20 && nombreAleatoire2 <=40) { //20%
					newStoryLine = "D'accord d'accord ! j'arrête, désolé !";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				if(nombreAleatoire2 > 40 && nombreAleatoire2 <=60) { //20%
					newStoryLine = "OK ça c'est mal ... noté !";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				if(nombreAleatoire2 > 60 && nombreAleatoire2 <=80) { //20%
					newStoryLine = "Arrêtez avec les coups de fouet, j'ai vraiment mal ! ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				if(nombreAleatoire2 > 80 && nombreAleatoire2 <=100) { //20%
					newStoryLine = "Je ne comprends pas pourquoi il m'a puni ... mais je pense que c'est une bonne raison";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				System.out.println("============================================================== >>>> Diary updated !! Punition ");
			}
		}
		
		if(storyPlace == 7) { //marcher dehors
			Random rand = new Random(); 
			int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
			if(nombreAleatoire <= 20) { //25%
				Random rand2 = new Random(); 
				int nombreAleatoire2 = rand2.nextInt(100 - 0 + 1) + 0;
				if(nombreAleatoire2 <= 10) { //10%
					newStoryLine = "Je suis fatigué !! j'ai faim et j'ai soif !";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 10 && nombreAleatoire2 <=15) { //10%
					newStoryLine =  posMaster.getName()+" est mon maitre et il m'a donné "+posPet.getName()+" comme nom !";;
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 20 && nombreAleatoire2 <=25) { //10%
					newStoryLine = "Ils sont ou mes jouets ? ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 30 && nombreAleatoire2 <= 35) { //10%
					newStoryLine = "Je ne trouve pas le batôn ....";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 40 && nombreAleatoire2 <=45) { //10%
					newStoryLine = "Sniiff sniiff ça sent bon par ici. Je pense que c'est mon maître";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 50 && nombreAleatoire2 <=55) { //5%
					newStoryLine = "Je suis qu'un IA créé par les étudiants en licence 2 MI pour le projet GLP !";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 > 55 && nombreAleatoire2 <= 60) { //5%
					newStoryLine = "Aujourd'hui il fait super beau ! ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 == 99) {
					newStoryLine = "Lalalala .... ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				
				if(nombreAleatoire2 == 98) {
					newStoryLine = "Message rare avec 1% de chance : “Je Suis Un Chien, Pas Un Objet” ";
					this.setStoryLine(newStoryLine);
					addToDiaryList(getTime(),newStoryLine);
				}
				System.out.println("======================================================================= >>>> Diary updated ! Walk outside");
			}
		}
		
		if(storyPlace == 8) { //marcher dans la maison
			Random rand = new Random(); 
			int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
			if(nombreAleatoire <= 15) { //25%
				Random rand2 = new Random(); 
				int nombreAleatoire2 = rand2.nextInt(100 - 0 + 1) + 0;
				if(nombreAleatoire2 <= 20) { //10%
					newStoryLine = "Je suis dans la maison !! Youpii";
					this.setStoryLine(newStoryLine);
				}
				if(nombreAleatoire2 > 20 && nombreAleatoire2 <=30) { //20%
					newStoryLine = "Je cherche toujours mes jouets ... ";
					this.setStoryLine(newStoryLine);
				}
				if(nombreAleatoire2 > 30 && nombreAleatoire2 <= 40) { //20%
					newStoryLine = "J'ai envie de jouer dehors !";
					this.setStoryLine(newStoryLine);
				}
				if(nombreAleatoire2 > 40 && nombreAleatoire2 <= 50) { //20%
					newStoryLine = "Mon maître est dans la maison ";
					this.setStoryLine(newStoryLine);
				}
				System.out.println("======================================================================= >>>> Diary updated ! Walk inside");
			}
		}
	}
	
	public String getStoryLine() {
		return storyLine;
	}
	
	public void setStoryLine(String storyLine) {
		this.storyLine = storyLine;
	}
	
	public String getTime() {
		return "["+newHours+":"+newMinute+"]  ";
	}
	
	public void setTime(String string, String string2) {
		this.newHours = string;
		this.newMinute = string2;
	}
	
	public void addToDiaryList(String time,String string) {
		String phrase = time+string;
		allDiaryList.add(phrase);
	}
	
	public String getAllDiaryList(int i) {
		String phrase = allDiaryList.get(i);
		return phrase;
	}
	
	public void setPosMastAndPet(boolean b){
		if (b) {
			this.posMaster.setxPersoMaster(672);
			this.posMaster.setyPersoMaster(432);
			this.posPet.setXPerso(364);
			this.posPet.setYPerso(544);
		}
		else{
			this.posMaster.setxPersoMaster(624);
			this.posMaster.setyPersoMaster(272);
			this.posPet.setXPerso(512);
			this.posPet.setYPerso(128);
		}
		this.repaint(); 
	}
	public void spawnThief(){
		this.posThief.setxPersoThief(348);
		this.posThief.setyPersoThief(544);
		this.repaint();
	}
	
	public void despawnThief(){
		this.posThief.setxPersoThief(15000000);
		this.posThief.setyPersoThief(15000000);
		this.repaint();
	}
	
	public void createChairs(){
		if(items.contains("chaise")){
			items.remove("chaise");
			posChair1.setPos(10000,10000);
			posChair2.setPos(10000,10000);
			posChair3.setPos(10000,10000);
			posChair4.setPos(10000,10000);
			this.repaint();
			System.out.println("chaise removed");
		}
		else{
			items.add("chaise");
			posChair1.setPos(608,320);
			posChair2.setPos(640,320);
			posChair3.setPos(608,304);
			posChair4.setPos(640,304);
			this.repaint();
			System.out.println("chaise added");
		}
	}
	
	public void createToybox(){
		if(items.contains("boite")){
			items.remove("boite");
			posToybox.setPos(10000,10000);
			this.repaint();
			System.out.println("boite removed");
		}
		else{
			items.add("boite");
			posToybox.setPos(380,544);
			this.repaint();
			System.out.println("boite added");
		}
	}
	
	public void createTable(){
		if(items.contains("table")){
			items.remove("table");
			posTable.setPos(10000,10000);
			posTable2.setPos(10000,10000);
			this.repaint();
			System.out.println("table removed");
		}
		else{
			items.add("table");
			posTable.setPos(624,320);
			posTable2.setPos(624,304);
			this.repaint();
			System.out.println("table added");
		}
	}
	
	public void createCouch(){
		if(items.contains("couch")){
			items.remove("couch");
			posCouch.setPos(10000,10000);
			this.repaint();
			System.out.println("couch removed");
		}
		else{
			items.add("couch");
			posCouch.setPos(288,432);
			this.repaint();
			System.out.println("couch added");
		}
	}
}

