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
import data.Workout;

@SuppressWarnings("serial")
public class ClimbingWorkoutPie extends JPanel  {
	
	private JFreeChart pieGraph;
	private DefaultPieDataset dataset;

	private ArrayList<Workout> workoutList;
	
	public ClimbingWorkoutPie(ArrayList<Workout> workoutList) {
		this.setLayout(new BorderLayout());

		this.workoutList = workoutList;
		
		initDataset();
		pieGraph = ChartFactory.createPieChart3D("Difficulté éffectué", dataset, true, true, false);

		formatGraph();
		
		this.add(new ChartPanel(pieGraph), BorderLayout.CENTER);
	}

	public void initDataset() 
	{
		int yellow = 0, blue = 0, orange= 0, white = 0, grey = 0, red=0;
		dataset = new DefaultPieDataset();
		
		if(!workoutList.isEmpty())
		{
			for(int i = 0 ; i < workoutList.size() ; i++)
			{
				
				ClimbingWorkout w = (ClimbingWorkout) workoutList.get(i);
				
				String difficulty=w.getCourseDifficulty();
				
				
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
				
				
				
			}
		}
		System.out.println(""+yellow+"");
		dataset.setValue("Difficulté White",white);
		dataset.setValue("Difficulté Yellow", yellow);
		dataset.setValue("Difficulté Orange",orange);
		dataset.setValue("Difficulté Blue",blue);
		dataset.setValue("Difficulté Red", red);
		dataset.setValue("Difficulté Grey", grey);
		
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
	((PiePlot) pieGraph.getPlot()).setSectionPaint(3, new Color(85, 85, 85));
	((PiePlot) pieGraph.getPlot()).setSectionPaint(4, new Color(240, 240, 240));
	((PiePlot) pieGraph.getPlot()).setSectionPaint(5, Color.LIGHT_GRAY);
	
	PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
            "{0} : {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.0%"));
    ((PiePlot) pieGraph.getPlot()).setLabelGenerator(gen);
}

	
	
	
	
}
