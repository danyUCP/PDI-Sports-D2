package graph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import data.ClimbingWorkout;
import data.Workout;

public class FriendClimbingSummaryBar extends JPanel{
	/**
	 * <code>FriendClimbingSummaryBar</code>Is a class that builds the summary graph of friend for the climbing Workout.
	 * <strong>NOTE:</strong>
	 *This class<code>FriendSummaryBar</code>. implements all the components of the associated graphical ihm .
	 *
	 * @author  Alexander BUBB
	 * @author Daniel François
	 * @author Julien VEYSSEYRE
	 * @author Seruche MPOU EKOUYA
	 * 
	 * */
	private static final long serialVersionUID = 1L;
	
	private JFreeChart barGraph;
	private DefaultCategoryDataset dataset;

	private ArrayList<Workout> workoutList;
	private ArrayList<Workout> workoutList2;
	/**
	 * Builders of the class FriendSummaryBar
	 * @param workoutList
	 * @param workoutList2
	 */
	public FriendClimbingSummaryBar(ArrayList<Workout> workoutList,ArrayList<Workout> workoutList2) 
	{
		this.setLayout(new BorderLayout());

		this.workoutList = workoutList;
		this.workoutList2 = workoutList2;
		
		initDataset();
		barGraph = ChartFactory.createBarChart3D("Résumé de l'escalade", "Séances", "Temps (min)", dataset, PlotOrientation.VERTICAL, true, true, false);

		formatGraph();
		
		this.add(new ChartPanel(barGraph), BorderLayout.CENTER);
	}
	/**
	 * Initialization of data to build the graph.
	 */
	public void initDataset() 
	{
		dataset = new DefaultCategoryDataset();
		
		if(!workoutList.isEmpty()&&!workoutList2.isEmpty())
		{
			for(int i = 0 ; i < workoutList.size() ; i++)
			{
				for(int j = 0 ; j< workoutList2.size() ; j++)
				{
					ClimbingWorkout w = (ClimbingWorkout) workoutList.get(i);
					dataset.addValue(w.getDuration(), "Durée A1", "" + (i + 1));
					
					ClimbingWorkout w2 = (ClimbingWorkout) workoutList2.get(j);

					dataset.addValue(w2.getDuration(), "Durée A2", "" + (j + 1));
				}
			}
		}
		
	}
	
	public void formatGraph()
	{
		barGraph.setBackgroundPaint(new Color(28, 28, 28));
		barGraph.getTitle().setFont(new Font("Verdana", Font.PLAIN, 16));
		barGraph.getTitle().setPaint(Color.WHITE);
		barGraph.getPlot().setBackgroundPaint(new Color(50, 50, 50));
		barGraph.getCategoryPlot().getDomainAxis().setLabelPaint(Color.WHITE);
		barGraph.getCategoryPlot().getDomainAxis().setAxisLinePaint(Color.WHITE);
		barGraph.getCategoryPlot().getDomainAxis().setTickLabelPaint(Color.WHITE);
		barGraph.getCategoryPlot().getRangeAxis().setLabelPaint(Color.WHITE);
		barGraph.getCategoryPlot().getRangeAxis().setAxisLinePaint(Color.WHITE);
		barGraph.getCategoryPlot().getRangeAxis().setTickLabelPaint(Color.WHITE);
		barGraph.getLegend().setBackgroundPaint(new Color(50, 50, 50));
		barGraph.getLegend().setItemPaint(Color.WHITE);
		barGraph.getCategoryPlot().setRangeGridlinePaint(Color.WHITE);
	}

	
	

}
