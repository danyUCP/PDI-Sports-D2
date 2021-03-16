package graph;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
public class ClimbingWorkoutBarChart extends ApplicationFrame  {

	public ClimbingWorkoutBarChart(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(chartPanel);
	}

	private static final long serialVersionUID = 1L;



		

	

	@SuppressWarnings("rawtypes")
	private CategoryDataset createDataset() {

		String series1 = "White";
		String series2 = "Yellow";
		String series3 = "Orange";
		String series4 = "Blue";
		String series5 = "Red";
		String series6 = "Grey";		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	     

	  	Session session = data.DBConnection.getSession();
	      
	      Transaction readTransaction = session.beginTransaction();
	     
	  		List result = session.createQuery("select count(climbingworkout.course_difficulty) from ClimbingWorkout climbingworkout where climbingworkout.course_difficulty = 'White'").list();
	 		List result1 = session.createQuery("select count(climbingworkout.course_difficulty) from ClimbingWorkout climbingworkout where climbingworkout.course_difficulty = 'Red'").list();
	 		  
	  		//	List result1 = session.createQuery("select swimmingworkout.butterfly_lenghts from SwimmingWorkout swimmingworkout").list();
	  	//	List result2 = session.createQuery("select swimmingworkout.crowl_lenghts from SwimmingWorkout swimmingworkout").list();
	  	//	List result3 = session.createQuery("select swimmingworkout.backstroke_lenghts from SwimmingWorkout swimmingworkout").list();

	  		Iterator iterator = result.iterator();
	  	//	Iterator iterator1 = result1.iterator();
	  	//	Iterator iterator2 = result2.iterator();
	  	//	Iterator iterator3 = result3.iterator();
	  		int i=0;
	  		while (iterator.hasNext()/*&iterator1.hasNext()&iterator2.hasNext()&iterator3.hasNext()*/) {
	  			long j = (long) iterator.next();
	  		//	int k=(int) iterator1.next();
	  		//	int l=(int) iterator2.next();
	  		//	int m=(int) iterator3.next();
	  			 
	      dataset.addValue( j , ""+series1+"" , ""+i+"" );
	 //     dataset.addValue( k , ""+series2+"" , ""+i+"" );
	  //    dataset.addValue( l , ""+series3+"" , ""+i+"" );
	   //   dataset.addValue( m , ""+series4+"" , ""+i+"" );
	      
	      System.out.println(""+j+"");  
	      i++; 
	  		}
	  		readTransaction.commit();


		return dataset;
            
	}
	
	
	private JFreeChart createChart(CategoryDataset dataset) {

		JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo", "Category", "distance", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		return chart;

	}

	public static void main(String[] args) {
		ClimbingWorkoutBarChart demo = new ClimbingWorkoutBarChart("ClimbingWorkoutBar Chart");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

	
	
	
	
}

