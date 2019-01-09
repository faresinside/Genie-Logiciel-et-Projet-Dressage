package animal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import motor.GameMotor;

/**
 * 
 * @author Gabriel
 *
 */
public class ActionReward{	//manage the reward action

	private static HashMap<Integer, ArrayList<Integer> > hm ;
	private static GameMotor moteur;
	
	public ActionReward(GameMotor moteur){
		this.moteur=moteur;
		this.hm = moteur.getHm();
	}
	
	public static void main(String[] args){
		System.out.println("zerty");
		try {
			BufferedReader br = new BufferedReader(new FileReader("dogAction.txt"));
			
			int surrounding = Integer.parseInt(br.readLine());
			int action = Integer.parseInt(br.readLine());
			
			br.close();
			
			if(action!=0 && surrounding!=0){
				for (int i = 1 ; i<=5 ; i++){
					if(i==action){
						ArrayList<Integer> ar = new ArrayList<Integer>();
						ar = hm.get(action);
						ar.set(surrounding, hm.get(action).get(surrounding)+4);
					
						hm.put(action, ar);
					}else{
						ArrayList<Integer> ar = new ArrayList<Integer>();
						ar = hm.get(i);
						ar.set(surrounding, hm.get(action).get(surrounding)-1);
					
						hm.put(action, ar);
					}
				}
				System.out.println("Hm changé par récompense : "+hm.toString());
				moteur.setHm(hm);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
