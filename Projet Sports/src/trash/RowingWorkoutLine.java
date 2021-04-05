package trash;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
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
		
	/*	DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		Session session = data.DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List result = session.createQuery("select Rowingworkout.distance from 	RowingWorkout Rowingworkout").list();  
  		//	Query readQuery = session.createQuery("select distance from joggingworkout j");
  		//List result = readQuery.list();
  		Iterator iterator = result.iterator();
  		int i=0;
  		while (iterator.hasNext()) {
  			int j = (int) iterator.next();
           
  			 
      dataset.addValue( j , "Jogging distance vs temps" , ""+i+"" );
      System.out.println(""+j+"");  
      i+=24; 
  		}
  		readTransaction.commit();
		*/
		
		XYSeries series1 = new XYSeries("distance ");
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		Session session = orm.DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List result = session.createQuery("select rowingworkout.distance from RowingWorkout rowingworkout").list();  
  		//	Query readQuery = session.createQuery("select distance from joggingworkout j");
  		//List result = readQuery.list();
  		Iterator iterator = result.iterator();
  		int j=0;
  		while (iterator.hasNext()) {
  			int i = (int) iterator.next();
           
  			 
     series1.add( j ,i );
      System.out.println(""+i+"");  
      j++; 
      System.out.println(""+j+"");  
  		
  	}
  		//readTransaction.commit();
		
		
		
	/*	DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		Session session = data.DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List result = session.createQuery("select Rowingworkout.distance from 	RowingWorkout Rowingworkout").list();  
  		//	Query readQuery = session.createQuery("select distance from joggingworkout j");
  		//List result = readQuery.list();
  		Iterator iterator = result.iterator();
  		int i=0;
  		while (iterator.hasNext()) {
  			int j = (int) iterator.next();
           
  			 
      dataset.addValue( j , "Jogging distance vs temps" , ""+i+"" );
      System.out.println(""+j+"");  
      i+=24; 
  		}
  		readTransaction.commit();
		*/
		
		
		
		
		/*
		series1.add(1.0, 50.0);
		series1.add(2.0, 100.0);
		series1.add(3.0, 150.0);
		series1.add(4.0, 200.0);
		series1.add(5.0, 250.0);
		series1.add(6.0, 300.0);
		series1.add(7.0, 350.0);
     	series1.add(8.0, 400.0);
		*/
		/*
		Transaction readTransaction = session.beginTransaction();
  		@SuppressWarnings("unchecked")
		List result = session.createQuery("select joggingworkout.distance from JoggingWorkout joggingworkout").list();  
        */
		XYSeries series2 = new XYSeries(" paggaie strokes ");
	
		@SuppressWarnings("unchecked")
		List result2 = session.createQuery("select rowingworkout.paddle_strokes from RowingWorkout rowingworkout").list();  
  		//	Query readQuery = session.createQuery("select distance from joggingworkout j");
  		//List result = readQuery.list();
  		Iterator iterator2 = result2.iterator();
  		int k=0;
  		while (iterator2.hasNext()) {
  			int i = (int) iterator2.next();
           
  			 
     series2.add( k ,i );
      System.out.println(""+i+"");  
      k++; 
      System.out.println(""+k+"");  
  		
  	}
  		readTransaction.commit();

	
		/*
		series2.add(1.0, 60);
		series2.add(2.0, 110);
		series2.add(3.0, 140);
		series2.add(4.0, 210);
		series2.add(5.0, 240);
		series2.add(6.0, 310);
		series2.add(7.0, 360);
		series2.add(8.0, 375);
        */
		XYSeries series3 = new XYSeries("Third meeting");
		series3.add(3.0, 4.0);
		series3.add(4.0, 3.0);
		series3.add(5.0, 2.0);
		series3.add(6.0, 3.0);
		series3.add(7.0, 6.0);
		series3.add(8.0, 3.0);
		series3.add(9.0, 4.0);
		series3.add(10.0, 3.0);

		XYSeriesCollection dataset2 = new XYSeriesCollection();
		dataset2.addSeries(series1);
		dataset2.addSeries(series2);
		dataset2.addSeries(series3);

		return dataset2;

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
