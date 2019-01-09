package ihm;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Gabriel + Roat
 *
 */
public class GUIParameters extends JFrame{		//parameters window
	
	
	private static final Font BUTTON_FONT = new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20);
		
	JButton Confirm = new JButton("Confirm");
	JButton Reset = new JButton("Reset");

	JLabel masterName = new JLabel("Name of the Master : ");
	JLabel petName = new JLabel("Name of the Pet : ");		
		
	JTextField 	mNTxt = new JTextField(12);
	JTextField pNTxt = new JTextField(12);
	
	
	public GUIParameters(){
		super("Options");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("sav.txt", true));
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initLayout();
	}
	
	protected void initLayout(){
		this.setLayout(new GridLayout(6,2));
		
		Confirm.setFont(BUTTON_FONT);
		Reset.setFont(BUTTON_FONT);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("sav.txt"));
			String line = br.readLine();
			if (line!=""){
				String[] opt = line.split(";");
				mNTxt.setText(opt[0]);
				pNTxt.setText(opt[1]);				
			}else{
				mNTxt.setText("Pedro");
				pNTxt.setText("Waf");
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.add(masterName);
		this.add(mNTxt);
		this.add(petName);
		this.add(pNTxt);
		this.add(Confirm);
		this.add(Reset);
		
		Confirm.addActionListener(new ActionConfirm());
		Reset.addActionListener(new ActionReset());
		
		setSize(500, 350);
		
		
		
		this.add(Confirm);
		this.add(Reset);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	class ActionReset implements ActionListener { // opening the parameters window
		public void actionPerformed(ActionEvent arg0) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("sav.txt"));
				String[] opt = br.readLine().split(";");
				mNTxt.setText(opt[0]);
				pNTxt.setText(opt[1]); 
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	
	
	
	class ActionConfirm implements ActionListener { // opening the parameters window
		public void actionPerformed(ActionEvent arg0) {
			try {
				BufferedWriter br = new BufferedWriter(new FileWriter("sav.txt"));
				String options = "" + mNTxt.getText() + ";" + pNTxt.getText();
				br.write(options);
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		 new GUIParameters();

	}

	
}
