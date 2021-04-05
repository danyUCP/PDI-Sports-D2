package trash;



import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import data.JoggingWorkout;
import orm.DBConnection;

/**
 * Main GUI class for chronometer.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class LineChartJogging extends ApplicationFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The dashboard part is managed in a separate class.
	 */


	public LineChartJogging( String applicationTitle , String chartTitle ) {
	     
		super(applicationTitle);
	   
	    JFreeChart lineChart = ChartFactory.createLineChart(
	         chartTitle,
	         "Temps","Distance",
	         createDataset(),
	         PlotOrientation.VERTICAL,
	         true,true,false);
	      

	         
	      ChartPanel chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension(  800 , 400 ) );  
	      setContentPane( chartPanel );
	   }
	   private DefaultCategoryDataset createDataset( ) {
		      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		     

		  	Session session = orm.DBConnection.getSession();
		      
		      Transaction readTransaction = session.beginTransaction();
		  		@SuppressWarnings("unchecked")
				List result = session.createQuery("select joggingworkout.distance from JoggingWorkout joggingworkout").list();  
	
		  		Iterator iterator = result.iterator();
		  		int i=0;
		  		while (iterator.hasNext()) {
		  			int j = (int) iterator.next();
		           
		  			 
		      dataset.addValue( j , "Jogging distance vs seance" , ""+i+"" );
		      System.out.println(""+j+"");  
		      i++; 
		  		}
		  		readTransaction.commit();
		      
		      
		  //    dataset.addValue( 30 , "Jogging distance vs temps" , "24" );
		  //    dataset.addValue( 60 , "Jogging distance vs temps" ,  "48" );
		  //    dataset.addValue( 120 , "Jogging distance vs temps" , "72" );
		  //    dataset.addValue( 240 , "Jogging distance vs temps" , "96" );
		  //    dataset.addValue( 300 , "Jogging distance vs temps" , "120" );
		  //    dataset.addValue( 50 , "Jogging distance vs temps" , "730" );
		      
		      	

				
		      return dataset;
		  
	   }    
	    private static void testWhereClause(Session session) {
	  		Transaction readTransaction = session.beginTransaction();
	  		@SuppressWarnings("unchecked")
			List result = session.createQuery("select joggingworkout.distance from JoggingWorkout joggingworkout").list();  
	  		//	Query readQuery = session.createQuery("select distance from joggingworkout j");
	  		//List result = readQuery.list();
	  		Iterator iterator = result.iterator();
	  		while (iterator.hasNext()) {
	  			int j = (int) iterator.next();
	  		    System.out.println(""+j+"");
	  		
	  		}
	  		readTransaction.commit();
	  	}
	   
		   public static void main( String[ ] args ) {
			  LineChartJogging chart = new LineChartJogging(
		         "Temps Vs distance" ,
		         "Distance vs temps");
			//	Session session = data.DBConnection.getSession();
			 //   testWhereClause(session);
             
		      chart.pack( );
		      RefineryUtilities.centerFrameOnScreen( chart );
		      chart.setVisible( true );
		   }






	}

