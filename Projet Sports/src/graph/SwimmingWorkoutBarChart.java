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

	@SuppressWarnings("rawtypes")
	private CategoryDataset createDataset() {

		String series1 = "meterBreaststroke";
		String series2 = "meterbutterfly";
		String series3 = "meterCrowl";
		String series4 = "meterback";
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	     

	  	Session session = orm.DBConnection.getSession();
	      
	      Transaction readTransaction = session.beginTransaction();
	  		List result = session.createQuery("select swimmingworkout.breaststroke_lenghts from SwimmingWorkout swimmingworkout").list();
	  		List result1 = session.createQuery("select swimmingworkout.butterfly_lenghts from SwimmingWorkout swimmingworkout").list();
	  		List result2 = session.createQuery("select swimmingworkout.crowl_lenghts from SwimmingWorkout swimmingworkout").list();
	  		List result3 = session.createQuery("select swimmingworkout.backstroke_lenghts from SwimmingWorkout swimmingworkout").list();

	  		Iterator iterator = result.iterator();
	  		Iterator iterator1 = result1.iterator();
	  		Iterator iterator2 = result2.iterator();
	  		Iterator iterator3 = result3.iterator();
	  		int i=0;
	  		while (iterator.hasNext()&iterator1.hasNext()&iterator2.hasNext()&iterator3.hasNext()) {
	  			int j = (int) iterator.next();
	  			int k=(int) iterator1.next();
	  			int l=(int) iterator2.next();
	  			int m=(int) iterator3.next();
	  			 
	      dataset.addValue( j , ""+series1+"" , ""+i+"" );
	      dataset.addValue( k , ""+series2+"" , ""+i+"" );
	      dataset.addValue( l , ""+series3+"" , ""+i+"" );
	      dataset.addValue( m , ""+series4+"" , ""+i+"" );
	      
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
		SwimmingWorkoutBarChart demo = new SwimmingWorkoutBarChart("SwimmingWorkoutBar Chart");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

	
	
	
	
}



