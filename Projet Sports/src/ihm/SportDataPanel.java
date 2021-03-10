package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;

import data.User;
import data.Workout;
import ihm.components.SportButton;
import ihm.components.SportLabel;
import manager.UserManager;
import manager.WorkoutManager;

public class SportDataPanel extends JPanel
{
	private User user;
	private WorkoutManager wm;
	private int mode;

	private JPanel section, header, footer, content;
	private JPanel summary, averageData, listPanel, workoutList;
	private SportButton returnButton, deconnexionButton;
	private SportButton addWorkout, seeGraph;
	private SportLabel uName;

	private Image background;

	private Dimension dim;
	private int width = 858;
	private int height = 496;
	
	
	public SportDataPanel(User user, int mode)
	{
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		this.mode = mode;
		
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
		
		section = new JPanel();
		section.setBounds(100, 50, width - 200, height - 100);
		section.setBackground(new Color(28, 28, 28));
		section.setLayout(new BorderLayout());
		this.add(section);

		
		header = new JPanel();
		header.setPreferredSize(new Dimension(width, 40));
		header.setBackground(new Color(10, 10, 10));
		initHeader();
		section.add(header, BorderLayout.NORTH);
		
		content = new JPanel();
		content.setPreferredSize(new Dimension(width, height - 40));
		content.setBackground(new Color(28, 28, 28));
		content.setLayout(new GridLayout(1, 2));
		section.add(content, BorderLayout.CENTER);
		
		summary = new JPanel();
		summary.setBackground(new Color(28, 28, 28));
		summary.setLayout(new BorderLayout());
		initSummary();
		content.add(summary);
		
		listPanel = new JPanel();
		listPanel.setBackground(new Color(28, 28, 28));
		listPanel.setLayout(new BorderLayout());
		initListPanel();
		content.add(listPanel);
		
		
		footer = new JPanel();
		footer.setPreferredSize(new Dimension(width, 60));
		footer.setBackground(new Color(28, 28, 28));
		initFooter();
		listPanel.add(footer, BorderLayout.SOUTH);
		
		try
		{
			background = ImageIO.read(new File("resources/images/backImage.jpg"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		super.paintComponent(g2d);

		g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public void initHeader()
	{	
		header.setLayout(new BorderLayout());
		

		uName = new SportLabel(user.getLastname().toUpperCase() + " " + user.getFirstname());
		returnButton = new SportButton("Retour");
		deconnexionButton = new SportButton("Deconnexion");
		
		header.add(uName, BorderLayout.CENTER);
		header.add(returnButton, BorderLayout.WEST);
		header.add(deconnexionButton, BorderLayout.EAST);
		
		returnButton.addActionListener(new ButtonListener());
		deconnexionButton.addActionListener(new ButtonListener());
	}
	
	public void initSummary()
	{	
		summary.setLayout(new GridLayout(2, 1));

		averageData = new JPanel();
		averageData.setBackground(new Color(28, 28, 28));
		averageData.setLayout(new BoxLayout(averageData, BoxLayout.Y_AXIS));
		
		averageData.add(new SportLabel(" Nombre total de séance : 0"));
		averageData.add(new SportLabel(" Séances ces 7 derniers jours : 0"));
		averageData.add(new SportLabel(" Durée moyenne par séance : 0 min"));

		//Graphe simplifié à remplacer ================================================
		JFreeChart lineGraph = ChartFactory.createLineChart("Résumé", null, null, null, PlotOrientation.VERTICAL, false, false, false);
		lineGraph.setBackgroundPaint(new Color(28, 28, 28));
		lineGraph.getTitle().setFont(new Font("Verdana", Font.PLAIN, 16));
		lineGraph.getTitle().setPaint(Color.WHITE);
		lineGraph.getCategoryPlot().getDomainAxis().setLabelPaint(Color.WHITE);
		lineGraph.getPlot().setBackgroundPaint(new Color(50, 50, 50));
		lineGraph.getCategoryPlot().getRangeAxis().setAxisLinePaint(Color.WHITE);
		lineGraph.getCategoryPlot().getRangeAxis().setTickLabelPaint(Color.WHITE);
		lineGraph.getCategoryPlot().getDomainAxis().setAxisLinePaint(Color.WHITE);
		lineGraph.getCategoryPlot().setRangeGridlinePaint(Color.WHITE);
		//=============================================================================
		
		ChartPanel graph = new ChartPanel(lineGraph);
		graph.setBackground(new Color(28, 28, 28));
		
		summary.add(graph);
		summary.add(averageData);
	}
	
	public void initListPanel()
	{	
		listPanel.add(new SportLabel("Mes dernières séances"), BorderLayout.NORTH);
		
		workoutList = new JPanel();
		workoutList.setBackground(new Color(28, 28, 28));
		workoutList.setLayout(new BoxLayout(workoutList, BoxLayout.Y_AXIS));
		
		//A supprimer et à adapter avec l'utilisateur connecté		

		ArrayList<Workout> list = wm.getWorkoutList(mode);
		
		for(int i = 0 ; i < list.size() ; i++)
			workoutList.add(new WorkoutButton(list.get(i)));
		
		JScrollPane scroll = new JScrollPane(workoutList);
		scroll.setPreferredSize(new Dimension(listPanel.getWidth(), listPanel.getHeight()));
		scroll.setBorder(null);
		listPanel.add(scroll);

	}
	
	
	public void initFooter()
	{	
		footer.setLayout(new GridLayout(1, 2, 5, 5));

		addWorkout = new SportButton("Ajouter une séance");
		addWorkout.setText("<html><p style='text-align: center;'>Ajouter une <br />séance</p></html>");
		seeGraph = new SportButton("Visualiser mes données");
		seeGraph.setText("<html><p style='text-align: center;'>Visualiser <br />mes données</p></html>");

		
		footer.add(addWorkout);
		footer.add(seeGraph);
		
		addWorkout.addActionListener(new ButtonListener());
		seeGraph.addActionListener(new ButtonListener());
	}
	
	public void close()
	{
		MainFrame frame = (MainFrame) (SwingUtilities.getRoot(MainFrame.getGlobal()));
		
		this.removeAll();
		frame.resetHome();
	}
	
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{			
			MainFrame.getGlobal().removeAll();

			if(e.getSource() == addWorkout)
			{

				switch(mode)
				{
					case 1:
						MainFrame.getGlobal().add(new JoggingPanel());
						break;
					case 2:
						MainFrame.getGlobal().add(new ClimbingPanel());
						break;
					case 3:
						MainFrame.getGlobal().add(new RowingPanel());
						break;
					case 4:
						//MainFrame.getGlobal().add(new MusculationPanel());
						break;
					case 5:
						MainFrame.getGlobal().add(new SwimmingPanel());
						break;
					case 6:
						//MainFrame.getGlobal().add(new ArcheryPanel());
						break;
				}
			}
			else if(e.getSource() == seeGraph)
			{
				//Actions pour le bouton Visualiser
			}
			else if(e.getSource() == returnButton)
			{
				MainFrame.getGlobal().add(new HomePanel(user));
			}
			else if(e.getSource() == deconnexionButton)
				close();
			
			MainFrame.getGlobal().revalidate();
		}
	}
	
	@SuppressWarnings("serial")
	private class WorkoutButton extends SportButton
	{
		private Workout w;
		
		public WorkoutButton(Workout w)
		{
			super("Séance");
			this.w = w;
			
			this.setText("<html><p style='text-align: center;'>Séance du " + w.getDate() + "<br />Durée : " + w.getDuration() + " min</p></html>");
			this.setFont(new Font("Verdana", Font.ITALIC, 13));
			this.setBorder(BorderFactory.createLineBorder(new Color(28, 28, 28), 5));
			this.setBackground(new Color(28, 28, 28));
		}

		public Workout getWorkout() 
		{
			return w;
		}	
		
		public void mouseEntered(MouseEvent e) 
		{
			if(this.isEnabled())
				this.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 40), 5));
		}
		
		public void mouseExited(MouseEvent e) 
		{
			this.setBorder(BorderFactory.createLineBorder(new Color(28, 28, 28), 5));
		}
	}
	

}
