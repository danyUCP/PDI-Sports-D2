package graph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import data.SwimmingWorkout;
import data.User;
import data.Workout;

public class FriendPieChart extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFreeChart pieGraph;
	private DefaultPieDataset dataset;

	private ArrayList<Workout> workoutList;
	private ArrayList<Workout> workoutList2;
	private User u1,u2;
	
	public  FriendPieChart (ArrayList<Workout> workoutListF1,ArrayList<Workout> workoutListF2) 
	{
		this.setLayout(new BorderLayout());

		this.workoutList = workoutListF1;
		this.workoutList2 = workoutListF2;
		
		initDataset();
		pieGraph = ChartFactory.createPieChart3D("Répartition des types de natation", dataset, true, true, false);

		formatGraph();
		
		this.add(new ChartPanel(pieGraph), BorderLayout.CENTER);
	}
	
	public void initDataset() 
	{
		int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0;
		dataset = new DefaultPieDataset();
		
		if(!workoutList.isEmpty())
		{
			for(int i = 0 ; i < workoutList.size() ; i++)
			{
				for(int j=0;j<workoutList2.size() ; j++) {
					
				
					SwimmingWorkout sw = (SwimmingWorkout) workoutList.get(i);
					
					a+=sw.getBreaststroke_lenghts(); 
					b+=sw.getButterfly_lenghts(); 
					c+=sw.getCrowl_lenghts(); 
					d+=sw.getBackstroke_lenghts();
					
					SwimmingWorkout sw2 = (SwimmingWorkout) workoutList2.get(j);
					
					e+=sw2.getBreaststroke_lenghts(); 
					f+=sw2.getButterfly_lenghts(); 
					g+=sw2.getCrowl_lenghts(); 
					h+=sw2.getBackstroke_lenghts();
				
				}
			}
		}

					dataset.setValue("basse A1", a);
					dataset.setValue("papillon A1", b);
					dataset.setValue("crowl A1", c);
					dataset.setValue("arriere A1", d);
					dataset.setValue("basse A2", e);
					dataset.setValue("papillon A2", f);
					dataset.setValue("crowl A2", g);
					dataset.setValue("arriere A2", h);
				
	}
	
	public void formatGraph()
	{
		pieGraph.setBackgroundPaint(new Color(28, 28, 28));
		pieGraph.getTitle().setFont(new Font("Verdana", Font.PLAIN, 16));
		pieGraph.getTitle().setPaint(Color.WHITE);
		pieGraph.getPlot().setBackgroundPaint(new Color(50, 50, 50));
		pieGraph.getLegend().setBackgroundPaint(new Color(50, 50, 50));
		pieGraph.getLegend().setItemPaint(Color.WHITE);
		
		((PiePlot) pieGraph.getPlot()).setSectionPaint(0, new Color(255, 255, 85));
		((PiePlot) pieGraph.getPlot()).setSectionPaint(1, new Color(255, 85, 85));
		((PiePlot) pieGraph.getPlot()).setSectionPaint(2, new Color(85, 85, 255));
		((PiePlot) pieGraph.getPlot()).setSectionPaint(3, new Color(85, 255, 85));
		
		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
	            "{0} : {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.0%"));
	    ((PiePlot) pieGraph.getPlot()).setLabelGenerator(gen);
	}
	
	

}
