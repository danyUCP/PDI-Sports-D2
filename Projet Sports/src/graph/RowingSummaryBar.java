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

import data.RowingWorkout;
import data.Workout;

/**
 * <code>Rowing SummaryBar</code>Is a class that builds the summary graph of rowing workout.
 * <strong>NOTE:</strong>
 *This class<code>RowingSummaryBar</code>. implements all the components of the associated graphical ihm .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 * 
 * */
@SuppressWarnings("serial")
public class RowingSummaryBar extends JPanel
{
	private JFreeChart barGraph;
	private DefaultCategoryDataset dataset;

	private ArrayList<Workout> workoutList;
	/**
	 * Builders of the class RowingSummaryBar
	 * @param workoutList
	 * @param choice
	 * @param choice2
	 */
	public RowingSummaryBar(ArrayList<Workout> workoutList,int choice,int choice2) 
	{
		this.setLayout(new BorderLayout());

		this.workoutList = workoutList;
		
		initDataset(choice,choice2);
		
		if(choice2==0) {
		barGraph = ChartFactory.createBarChart3D("Résumé de Rowing", "Séances", "Temps (min)", dataset, PlotOrientation.VERTICAL, true, true, false);
		}else if(choice2==1) {
			barGraph = ChartFactory.createBarChart3D("Résumé de Rowing", "Séances", "Distance (m)", dataset, PlotOrientation.VERTICAL, true, true, false);	
		}
		else if(choice2==2) {
			barGraph = ChartFactory.createBarChart3D("Résumé de Rowing", "Séances", "nb Coups de Paggaies", dataset, PlotOrientation.VERTICAL, true, true, false);	
		}
		formatGraph();
		
		this.add(new ChartPanel(barGraph), BorderLayout.CENTER);
	}
	
	public void initDataset(int choice,int choice2) 
	{
		dataset = new DefaultCategoryDataset();
		
		if(!workoutList.isEmpty())
		{
			
			for(int i = 0 ; i < choice/*workoutList.size()*/ ; i++)
			{
				RowingWorkout w = (RowingWorkout) workoutList.get(i);
				System.out.println(""+workoutList.get(i)+"");

				if(choice2==0) {
				dataset.addValue(w.getDuration(), "Durée", "" + (i + 1));
				}
				else if(choice2==1) {
				dataset.addValue(w.getDistance(), "Distance", "" + (i + 1));	
					
				}else if(choice2==2) {
					dataset.addValue(w.getPaddleStrokes(), "Coups de Paggaies", "" + (i + 1));	
					
					}
			}
			
		
			
		}
	
	}
	/**
	 * Initialization of data to build the graph.
	 */
	public void formatGraph()
	{
		barGraph.setBackgroundPaint(new Color(20, 20, 20));
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
