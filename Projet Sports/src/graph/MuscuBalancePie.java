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

import data.Exercise;
import data.MusculationWorkout;
import data.Workout;
/**
 * <code>MuscuBalancePie</code>Is a class that builds the summary graph of musculation workout.
 * <strong>NOTE:</strong>
 *This class<code>MuscuBalancePie</code>. implements all the components of the associated graphical ihm .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 * 
 * */
@SuppressWarnings("serial")
public class MuscuBalancePie extends JPanel
{
	private JFreeChart pieGraph;
	private DefaultPieDataset dataset;

	private ArrayList<Workout> workoutList;
	/**
	 * Builders of the class MuscuBalancePie
	 * @param workoutList
	 */
	public MuscuBalancePie(ArrayList<Workout> workoutList) 
	{
		this.setLayout(new BorderLayout());

		this.workoutList = workoutList;
		
		initDataset();
		pieGraph = ChartFactory.createPieChart3D("Répartition des exercices", dataset, true, true, false);

		formatGraph();
		
		this.add(new ChartPanel(pieGraph), BorderLayout.CENTER);
	}
	/**
	 * Initialization of data to build the graph.
	 */
	public void initDataset() 
	{
		int pushUps = 0, pullUps = 0, squats = 0, abs = 0;
		dataset = new DefaultPieDataset();
		
		if(!workoutList.isEmpty())
		{
			for(int i = 0 ; i < workoutList.size() ; i++)
			{
				MusculationWorkout w = (MusculationWorkout) workoutList.get(i);

				for(int j = 0 ; j < w.getExercises().size() ; j++)
				{
					Exercise e = w.getExercises().get(j);
					
					switch(e.getType())
					{
						case "Pompes":
							pushUps += e.getExerciseReps();
							break;
						case "Tractions":
							pullUps += e.getExerciseReps();
							break;
						case "Squats":
							squats += e.getExerciseReps();
							break;
						case "Abdominaux":
							abs += e.getExerciseReps();
							break;
					}
					
				}
			}
		}

		dataset.setValue("Pompes", pushUps);
		dataset.setValue("Tractions", pullUps);
		dataset.setValue("Squats", squats);
		dataset.setValue("Abdos", abs);

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
