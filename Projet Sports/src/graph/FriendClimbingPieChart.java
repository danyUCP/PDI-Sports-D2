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

import data.ClimbingWorkout;
import data.User;
import data.Workout;
/**
 * <code> FriendClimbingPieChart</code>Is a class that builds the pie chart of friend for the climbingWorkout.
 * <strong>NOTE:</strong>
 *This class<code> FriendClimbingPieChart</code>. implements all the components of the associated graphical ihm .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 * 
 * */
public class FriendClimbingPieChart extends JPanel {
private static final long serialVersionUID = 1L;
	
	private JFreeChart pieGraph;
	private DefaultPieDataset dataset;

	private ArrayList<Workout> workoutList;
	private ArrayList<Workout> workoutList2;
	@SuppressWarnings("unused")
	private User u1,u2;
	/**
	 *  Builders of the class FriendPieChart
	 * @param workoutListF1
	 * @param workoutListF2
	 */
	public  FriendClimbingPieChart (ArrayList<Workout> workoutListF1,ArrayList<Workout> workoutListF2) 
	{
		this.setLayout(new BorderLayout());

		this.workoutList = workoutListF1;
		this.workoutList2 = workoutListF2;
		
		initDataset();
		pieGraph = ChartFactory.createPieChart3D("Répartition des types de natation", dataset, true, true, false);

		formatGraph();
		
		this.add(new ChartPanel(pieGraph), BorderLayout.CENTER);
	}
	/**
	 * Initialization of data to build the graph.
	 */
	public void initDataset() 
	{
		int yellow = 0, blue = 0, orange= 0, white = 0, grey = 0, red=0;
		int yellow1 = 0, blue1 = 0, orange1= 0, white1 = 0, grey1 = 0, red1=0;
		dataset = new DefaultPieDataset();
		
		if(!workoutList.isEmpty())
		{
			for(int i = 0 ; i < workoutList.size() ; i++)
			{
				for(int j=0;j<workoutList2.size() ; j++) {
					
				ClimbingWorkout w = (ClimbingWorkout) workoutList.get(i);
				ClimbingWorkout w1 = (ClimbingWorkout) workoutList.get(j);
				String difficulty=w.getCourseDifficulty();
				String difficulty1=w1.getCourseDifficulty();
				
					if(difficulty.equals("Yellow")) {
						yellow=yellow+1;
					}
					if(difficulty.equals("Red")) {
						red=red+1;
					}
					if(difficulty.equals("Blue")) {
						blue=blue+1;
					}
					if(difficulty.equals("White")) {
						white=white+1;
					}
					if(difficulty.equals("Orange")) {
						orange=orange+1;
					}
					if(difficulty.equals("Blue")) {
						grey=grey+1;
					}
					
					if(difficulty1.equals("Yellow")) {
						yellow1=yellow1+1;
					}
					if(difficulty1.equals("Red")) {
						red1=red1+1;
					}
					if(difficulty.equals("Blue")) {
						blue1=blue1+1;
					}
					if(difficulty.equals("White")) {
						white1=white1+1;
					}
					if(difficulty.equals("Orange")) {
						orange1=orange1+1;
					}
					if(difficulty.equals("Blue")) {
						grey1=grey1+1;
					}
				
				
				}
			}
		}
		dataset.setValue("Difficulté Blanc Ami1",white);
		dataset.setValue("Difficulté Jaune Ami1", yellow);
		dataset.setValue("Difficulté Orange Ami1",orange);
		dataset.setValue("Difficulté Bleu Ami1",blue);
		dataset.setValue("Difficulté Rouge Ami1", red);
		dataset.setValue("Difficulté Gris Ami1", grey);
		dataset.setValue("Difficulté Blanc Ami2",white1);
		dataset.setValue("Difficulté Jaune Ami2", yellow1);
		dataset.setValue("Difficulté Orange Ami2",orange1);
		dataset.setValue("Difficulté Bleu Ami2",blue1);
		dataset.setValue("Difficulté Rouge Ami2", red1);
		dataset.setValue("Difficulté Gris Ami2", grey1);
		
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