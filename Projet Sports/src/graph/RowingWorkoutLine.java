package graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class RowingWorkoutLine extends ApplicationFrame {
	public RowingWorkoutLine(String title) {
		super(title);
		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;


	private XYDataset createDataset() {

		XYSeries series1 = new XYSeries("distance ");
		series1.add(1.0, 50.0);
		series1.add(2.0, 100.0);
		series1.add(3.0, 150.0);
		series1.add(4.0, 200.0);
		series1.add(5.0, 250.0);
		series1.add(6.0, 300.0);
		series1.add(7.0, 350.0);
		series1.add(8.0, 400.0);

		XYSeries series2 = new XYSeries(" paggaie strokes ");
		series2.add(1.0, 60);
		series2.add(2.0, 110);
		series2.add(3.0, 140);
		series2.add(4.0, 210);
		series2.add(5.0, 240);
		series2.add(6.0, 310);
		series2.add(7.0, 360);
		series2.add(8.0, 375);

		XYSeries series3 = new XYSeries("Third meeting");
		series3.add(3.0, 4.0);
		series3.add(4.0, 3.0);
		series3.add(5.0, 2.0);
		series3.add(6.0, 3.0);
		series3.add(7.0, 6.0);
		series3.add(8.0, 3.0);
		series3.add(9.0, 4.0);
		series3.add(10.0, 3.0);

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		return dataset;

	}  

	private JFreeChart createChart(XYDataset dataset) {
		return ChartFactory.createXYLineChart("RowingLine Chart Demo 6", "session", "distance (m)", dataset, PlotOrientation.VERTICAL, true, true, false);
	}

	public static void main(String[] args) {
		RowingWorkoutLine demo = new RowingWorkoutLine(" RowingLine Chart Demo 6");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

	
	
	
}
