package graph;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;

public class ArcheryWorkoutPieChart extends JFrame {
	private static final long serialVersionUID = 1L;

	public ArcheryWorkoutPieChart(String title) {
		super(title);
		setContentPane(createDemoPanel());
	}

	private PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("red target", new Double(25.0));
		dataset.setValue("green target", new Double(20.0));
		dataset.setValue("black target", new Double(5.0));
		dataset.setValue("off-target ", new Double(23));
	
		return dataset;
	}

	private JFreeChart createChart(PieDataset dataset) {
		return ChartFactory.createPieChart("Workout Pie Chart", dataset, true, true, false);
	}

	public JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}

	public static void main(String[] args) {
		ArcheryWorkoutPieChart demo = new ArcheryWorkoutPieChart("Pie Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}  
}
