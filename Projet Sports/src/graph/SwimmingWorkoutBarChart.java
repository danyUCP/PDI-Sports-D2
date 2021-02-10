package graph;

import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/*
import chart.BarChartDemo;
*/
public class SwimmingWorkoutBarChart extends ApplicationFrame  {

	private static final long serialVersionUID = 1L;

	public SwimmingWorkoutBarChart(String title) {

		super(title);

		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(chartPanel);

	}

	private CategoryDataset createDataset() {

		String series1 = "meterBreaststroke";
		String series2 = "meterbutterfly";
		String series3 = "meterCrowl";
		String series4 = "meterback";
		
		String category1 = "session 1";
		String category2 = "session 2";
		String category3 = "session 3";
		String category4 = "session 4";
		String category5 = "session 5";

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(2.0, series1, category1);
		dataset.addValue(4.0, series1, category2);
		dataset.addValue(3.0, series1, category3);
		dataset.addValue(5.0, series1, category4);
		dataset.addValue(5.0, series1, category5);

		dataset.addValue(5.0, series2, category1);
		dataset.addValue(7.0, series2, category2);
		dataset.addValue(6.0, series2, category3);
		dataset.addValue(8.0, series2, category4);
		dataset.addValue(4.0, series2, category5);

		dataset.addValue(4.0, series3, category1);
		dataset.addValue(3.0, series3, category2);
		dataset.addValue(2.0, series3, category3);
		dataset.addValue(3.0, series3, category4);
		dataset.addValue(6.0, series3, category5);
		
		dataset.addValue(5.0, series4, category1);
		dataset.addValue(7.0, series4, category2);
		dataset.addValue(6.0, series4, category3);
		dataset.addValue(8.0, series4, category4);
		dataset.addValue(4.0, series4, category5);

		return dataset;
            
	}

	private JFreeChart createChart(CategoryDataset dataset) {

		JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo", "Category", "distance", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		return chart;

	}

	public static void main(String[] args) {
		SwimmingWorkoutBarChart demo = new SwimmingWorkoutBarChart("SwimmingWorkoutBar Chart");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

	
	
	
	
}



