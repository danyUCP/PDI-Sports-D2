package graph;

import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class Compare extends ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Compare(String title) {
		super( title ); 
	      setContentPane(createDemoPanel( ));
	}
	private static PieDataset createDataset( ) {
	      DefaultPieDataset dataset = new DefaultPieDataset( );
	      dataset.setValue( "Duree Ami 1" , new Double( 20 ) );  
	      dataset.setValue( "Nb seance Ami 1" , new Double( 20 ) );   
	      dataset.setValue( "Duree Ami 2" , new Double( 40 ) );    
	      dataset.setValue( "Nb seance Ami 2" , new Double( 10 ) );  
	      
	      return dataset;         
	   }
	   
	   private static JFreeChart createChart( PieDataset dataset ) {
	      JFreeChart chart = ChartFactory.createPieChart(      
	         "VS",   // chart title 
	         dataset,          // data    
	         true,             // include legend   
	         true, 
	         false);
	      //chart.setBackgroundPaint(new Color(28, 28, 28)); // transparent black

	      return chart;
	   }
	   
	   public static JPanel createDemoPanel( ) {
	      JFreeChart chart = createChart(createDataset( ) );
	      chart.setBackgroundPaint(new Color(28, 28, 28)); // transparent black
	      return new ChartPanel( chart ); 
	   }


	public static void main(String[] args) {
		Compare demo = new Compare( "VS" );  
	      demo.setSize( 375, 311 );
	      demo.setBackground(new Color(28, 28, 28));
	      //demo.setUndecorated(true);
	      RefineryUtilities.centerFrameOnScreen( demo );    
	      demo.setVisible( true );
		
	}

}
