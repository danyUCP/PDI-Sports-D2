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

import data.SwimmingWorkout;
import data.Workout;


/**
 * <code>SwimmingTypeBar </code>Is a class that creates TypeBar for swimming.
 * <strong>NOTE:</strong>
 *This class<code>SwimmingTypeBar</code>. implements all the components of the associated graphical ihm .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 * 
 * */
public class SwimmingTypeBar extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFreeChart barGraph;
	private DefaultCategoryDataset dataset;

	private ArrayList<Workout> workoutList;
	
	public SwimmingTypeBar(ArrayList<Workout> workoutList) 
	{
		this.setLayout(new BorderLayout());

		this.workoutList = workoutList;
		
		initDataset();
		barGraph = ChartFactory.createBarChart3D("Types de natation", "Séances", "Temps (min)", dataset, PlotOrientation.VERTICAL, true, true, false);

		formatGraph();
		
		this.add(new ChartPanel(barGraph), BorderLayout.CENTER);
	}
	
	/**
	 * Initialization of data to build the graph.
	 */
	public void initDataset() 
	{
		dataset = new DefaultCategoryDataset();
		
		if(!workoutList.isEmpty())
		{
			for(int i = 0 ; i < workoutList.size() ; i++)
			{
				SwimmingWorkout w = (SwimmingWorkout) workoutList.get(i);

				dataset.addValue(w.getBreaststroke_lenghts(), "basse", "" + (i + 1));
				dataset.addValue(w.getButterfly_lenghts(), "papillon", "" + (i + 1));
				dataset.addValue(w.getCrowl_lenghts(), "crowl", "" + (i + 1));
				dataset.addValue(w.getBackstroke_lenghts(), "arriere", "" + (i + 1));
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
