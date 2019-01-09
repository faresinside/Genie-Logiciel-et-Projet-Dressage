package ihm;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import motor.GameMotor;
import clock.Clock;
/**
 * 
 * @author Gabriel + Roat
 *
 */
public class GUIDiary {		//Dary window
	private JPanel pan = new JPanel();;
	private String diaryLine = "..." ;
	private GUIMaps canva;
	
	
	public GUIDiary(GUIMaps canva){
		this.canva = canva;
		
		initLayout();
		
	}
	protected void initLayout(){
			
		//jlDiary = new JLabel("<HTML>"+canva.getStoryLine()+"\n"+canva.getStoryLine2()+"\n"+canva.getStoryLine3()+"\n"+canva.getStoryLine4()+"</HTML>");*/
		JFrame frame = new JFrame("Diary");
		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);
		JScrollPane pane = new JScrollPane(list);
		//list.setSelectionMode();
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		//this.setLocationRelativeTo(null);
		list.setSize(330,200);		
		frame.add(pane);
		frame.setSize(700, 700);
		frame.setVisible(true);
		
		for(int i=1;i<canva.allDiaryList.size();i++){
			
		String phrase = canva.getAllDiaryList(i);
		
		listModel.addElement(phrase+"\n");
		
		}
	}
	
	public String getDiaryLine() {
		return diaryLine;
	}
	
	public void setDiaryLine(String diaryLine) {
		this.diaryLine = diaryLine;
	}
}
