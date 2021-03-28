package graph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import data.SwimmingWorkout;
import data.Workout;

public class SwimmingWorkoutPie extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFreeChart pieGraph;
	private DefaultPieDataset dataset;

	private ArrayList<Workout> workoutList;
	
	public SwimmingWorkoutPie(ArrayList<Workout> workoutList) {
		this.setLayout(new BorderLayout());

		this.workoutList = workoutList;
		
		initDataset();
		pieGraph = ChartFactory.createPieChart3D("Type de natation effectué", dataset, true, true, false);

		formatGraph();
		
		this.add(new ChartPanel(pieGraph), BorderLayout.CENTER);
	}

	public void initDataset() 
	{
		int basse = 0, crowl = 0, arriere= 0, papillon = 0;
		dataset = new DefaultPieDataset();
		
		if(!workoutList.isEmpty())
		{
			for(int i = 0 ; i < workoutList.size() ; i++)
			{
				
				SwimmingWorkout w = (SwimmingWorkout) workoutList.get(i);
				
				int pap=w.getButterfly_lenghts();
				int cro=w.getCrowl_lenghts();
				int ba=w.getBreaststroke_lenghts();
				int ar=w.getBackstroke_lenghts() ;
				
				
					if(ba==basse) {
						basse=basse+1;
					}
					if(cro==crowl) {
						crowl=crowl+1;
					}
					if(ar==arriere) {
						arriere=arriere+1;
					}
					if(pap==papillon) {
						papillon=papillon+1;
					}
			}
		}
		System.out.println(""+basse+"");
		dataset.setValue("crowl_lenghts",crowl);
		dataset.setValue("breaststroke_lenghts", basse);
		dataset.setValue("backstroke_lenghts",arriere);
		dataset.setValue("butterfly_lenghts", papillon);
		
	}
	
	public void formatGraph()
	{
	pieGraph.setBackgroundPaint(new Color(28, 28, 28));
	pieGraph.getTitle().setFont(new Font("Verdana", Font.PLAIN, 16));
	pieGraph.getTitle().setPaint(Color.WHITE);
	pieGraph.getPlot().setBackgroundPaint(new Color(50, 50, 50));
	pieGraph.getLegend().setBackgroundPaint(new Color(50, 50, 50));
	pieGraph.getLegend().setItemPaint(Color.WHITE);
	
	((PiePlot) pieGraph.getPlot()).setSectionPaint(0, new Color(255, 255, 85));
	((PiePlot) pieGraph.getPlot()).setSectionPaint(1, new Color(255, 85, 85));
	((PiePlot) pieGraph.getPlot()).setSectionPaint(2, new Color(85, 85, 255));
	((PiePlot) pieGraph.getPlot()).setSectionPaint(3, new Color(85, 85, 85));
	
	PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
            "{0} : {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.0%"));
    ((PiePlot) pieGraph.getPlot()).setLabelGenerator(gen);
	}

}
