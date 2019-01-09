package ihm;
import motor.GameMotor;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;


public class GUIStatistic extends JFrame{
	private GameMotor motor;
	private JPanel statsPanel = new JPanel();

	private JPanel typeCountPieThief;
	private JPanel typeCountPieMaitre;
	private JPanel typeCountPieObject;
	
	GUIGraph chartmanagerThief;
	GUIGraph chartmanagerMaitre;
	GUIGraph chartmanagerObject;

	
	
	public GUIStatistic(GUIGraph chartmanagerThief,GUIGraph chartmanagerMaitre,GUIGraph chartmanagerObject){
		super("Statistic");
	    
	   
	    this.chartmanagerThief = chartmanagerThief;
	    this.chartmanagerMaitre = chartmanagerMaitre;
	    this.chartmanagerObject = chartmanagerObject;
		//ChartManager chartManager2 ;
		//ChartManager chartManager3;
		statsPanel.setLayout(new GridLayout(3, 1));

		typeCountPieThief = new ChartPanel(chartmanagerThief.getTypeCountPie());
		typeCountPieMaitre = new ChartPanel(chartmanagerMaitre.getTypeCountPie());
		typeCountPieObject = new ChartPanel(chartmanagerObject.getTypeCountPie());
		getContentPane().setLayout(new GridLayout(1,1));
		statsPanel.add(typeCountPieThief);
		statsPanel.add(typeCountPieMaitre);
		statsPanel.add(typeCountPieObject);
	   // statsPanel.add(typeCountPie);


		
		getContentPane().add(statsPanel);

		//getContentPane().add(statsPanel2);

		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		
		
		initLayout();
		
	}
	protected void initLayout(){
		//setSize(1000, 750);
		
		setBounds(500,100,500,500);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
