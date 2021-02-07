package graph;
import org.jfree.chart.ChartPanel;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChartJogging extends ApplicationFrame {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public LineChartJogging( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Temps","Distance",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      dataset.addValue( 15 , "Jogging distance vs temps" , "1" );
      dataset.addValue( 30 , "Jogging distance vs temps" , "24" );
      dataset.addValue( 60 , "Jogging distance vs temps" ,  "48" );
      dataset.addValue( 120 , "Jogging distance vs temps" , "72" );
      dataset.addValue( 240 , "Jogging distance vs temps" , "96" );
      dataset.addValue( 300 , "Jogging distance vs temps" , "120" );
      dataset.addValue( 50 , "Jogging distance vs temps" , "730" );
      return dataset;
   }    
   
   public static void main( String[ ] args ) {
	   LineChartJogging chart = new LineChartJogging(
         "Temps Vs distance" ,
         "Distance vs temps");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
   }
}