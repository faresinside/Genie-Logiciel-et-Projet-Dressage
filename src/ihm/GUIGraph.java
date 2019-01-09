package ihm;

import java.util.ArrayList;
import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import motor.GameMotor;

public class GUIGraph extends ApplicationFrame {
	private static final long serialVersionUID = 1L;
	private HashMap<Character, Integer> nodeTypeCount = new HashMap<Character, Integer>();
   // private GameMotor motor;
    public float mo=80;
    public float jo=80;
    public float as=80;
    public float dor=80;
    public float ab=80;
    





	public GUIGraph() {
		super("title");
	}

	

	public void setStatPunish(Integer action) { 
		
    	if (action == 1) {   
    						dor=dor-4;
    	                    jo=jo+1;
    	                     mo=mo+1;
    	                     ab=ab+1;
    	                     as=as+1;     }
    	if (action == 2) {   dor=dor+1;
        					 jo=jo-4;
        					 mo=mo+1;
        					 ab=ab+1;
        					 as=as+1;     }
    	if (action == 3) {  dor=dor+1;
    						jo=jo+1;
    						mo=mo-4;
    						ab=ab+1;
    						as=as+1;     }
    	if (action == 4) {   dor=dor+1;
        					jo=jo+1;
        					mo=mo+1;
        					ab=ab-4;
        					as=as+1;    }
    	if (action == 5) {   dor=dor+1;
        					jo=jo+1;
        					mo=mo+1;
        					ab=ab+1;
        					as=as-4;     }
	
    }
    
    public void setStatReward(Integer action) { 
    	
    	if (action == 1) {   dor=dor+4;
        					 jo=jo-1;
        					 mo=mo-1;
        					 ab=ab-1;
        					 as=as-1;     }
    	if (action == 2) {  	    dor=dor-1;
		 					jo=jo+4;
		 					mo=mo-1;
		 					ab=ab-1;
		 					as=as-1;     }
    	if (action == 3) {  		dor=dor-1;
							jo=jo-1;
							mo=mo+4;
							ab=ab-1;
							as=as-1;     }
    	if (action == 4) {   		dor=dor-1;
					 		jo=jo-1;
					 		mo=mo-1;
					 		ab=ab+4;
					 		as=as-1;    }
    	if (action == 5) {   		dor=dor-1;
							jo=jo-1;
							mo=mo-1;
							ab=ab-1;
							as=as+4;     }

}



	//HashMap<Integer, ArrayList<Integer> > hm = motor.getHm();
    //int x = hm.get(1).get(0);
	public JFreeChart getTypeCountPie() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Dormir",dor);
		dataset.setValue("Jouer", jo);
		dataset.setValue("Mordre", mo);
		dataset.setValue("Abboie", ab);
		dataset.setValue("Assis", as);
	
	

		return ChartFactory.createPieChart("", dataset, true, true, false);
	}
	


}
