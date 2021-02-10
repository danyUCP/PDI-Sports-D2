package graph;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ClimbingWorkoutPie extends ApplicationFrame  {
	
	public ClimbingWorkoutPie(String title) {
		super(title);
		setContentPane(createDemoPanel());
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	private PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("black wall", new Double(25.0));
		dataset.setValue("red wall", new Double(20.0));
		dataset.setValue("green wall", new Double(5.0));
		dataset.setValue("brown wall", new Double(23));
	
		return dataset;
	}
        
	private JFreeChart createChart(PieDataset dataset) {
		return ChartFactory.createPieChart("Climbing Workout Pie Chart", dataset, true, true, false);
	}

	public JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}

	public static void main(String[] args) {
		ClimbingWorkoutPie demo = new ClimbingWorkoutPie("ClimbingWorkoutPie Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
	
	
	
	
}
