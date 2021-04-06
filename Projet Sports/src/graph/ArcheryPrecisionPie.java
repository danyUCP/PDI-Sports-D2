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

import data.ArcheryWorkout;
import data.Workout;
/**
 * <code>ArcheryPrecisionPie </code>Is a class that creates pie chart for archery.
 * <strong>NOTE:</strong>
 *This class<code>ArcheryPrecisionPie</code>. implements all the components of the associated graphical ihm .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 */
@SuppressWarnings("serial")
public class ArcheryPrecisionPie extends JPanel
{
	private JFreeChart pieGraph;
	private DefaultPieDataset dataset;

	private ArrayList<Workout> workoutList;
	/**
	 * Builders of the class ArcheryPrecisionPie
	 * @param workoutList
	 */
	public ArcheryPrecisionPie(ArrayList<Workout> workoutList) 
	{
		this.setLayout(new BorderLayout());

		this.workoutList = workoutList;
		
		initDataset();
		pieGraph = ChartFactory.createPieChart3D("Flèches par zone", dataset, true, true, false);

		formatGraph();
		
		this.add(new ChartPanel(pieGraph), BorderLayout.CENTER);
	}
	/**
	 * Initialization of data to build the graph.
	 */
	public void initDataset() 
	{
		int yellow = 0, red = 0, blue = 0, black = 0, white = 0, misses = 0;
		dataset = new DefaultPieDataset();
		
		if(!workoutList.isEmpty())
		{
			for(int i = 0 ; i < workoutList.size() ; i++)
			{
				ArcheryWorkout w = (ArcheryWorkout) workoutList.get(i);

				for(int j = 0 ; j < w.getTargets().size() ; j++)
				{
					yellow += w.getTargets().get(j).getYellow_area();
					red += w.getTargets().get(j).getRed_area();
					blue += w.getTargets().get(j).getBlue_area();
					black += w.getTargets().get(j).getBlack_area();
					white += w.getTargets().get(j).getWhite_area();
					misses += w.getTargets().get(j).getMisses();
				}
			}
		}

		dataset.setValue("Zone jaune",yellow);
		dataset.setValue("Zone rouge", red);
		dataset.setValue("Zone bleue",blue);
		dataset.setValue("Zone noire",black);
		dataset.setValue("Zone blanche", white);
		dataset.setValue("Ratées", misses);
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
