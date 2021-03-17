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

import data.ArcheryWorkout;
import data.Workout;

@SuppressWarnings("serial")
public class ArcherySummaryBar  extends JPanel
{
	private JFreeChart barGraph;
	private DefaultCategoryDataset dataset;

	private ArrayList<Workout> workoutList;
	
	public ArcherySummaryBar(ArrayList<Workout> workoutList) 
	{
		this.setLayout(new BorderLayout());

		this.workoutList = workoutList;
		
		initDataset();
		barGraph = ChartFactory.createBarChart3D("Résumé de Tir à l'arc", "Séances", "Temps (min)", dataset, PlotOrientation.VERTICAL, true, true, false);

		formatGraph();
		
		this.add(new ChartPanel(barGraph), BorderLayout.CENTER);
	}
	
	public void initDataset() 
	{
		dataset = new DefaultCategoryDataset();
		
		if(!workoutList.isEmpty())
		{
			for(int i = 0 ; i < workoutList.size() ; i++)
			{
				ArcheryWorkout w = (ArcheryWorkout) workoutList.get(i);

				System.out.println(w.getDate());
				dataset.addValue(w.getDuration(), "Durée",  "Séance " + (i + 1));
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
		
		

		/*((PiePlot) barGraph.getPlot()).setSectionPaint(1, new Color(255, 85, 85));
		((PiePlot) barGraph.getPlot()).setSectionPaint(2, new Color(85, 85, 255));
		((PiePlot) barGraph.getPlot()).setSectionPaint(3, new Color(85, 85, 85));
		((PiePlot) barGraph.getPlot()).setSectionPaint(4, new Color(240, 240, 240));
		((PiePlot) barGraph.getPlot()).setSectionPaint(5, Color.LIGHT_GRAY);
		*/
	}

}
