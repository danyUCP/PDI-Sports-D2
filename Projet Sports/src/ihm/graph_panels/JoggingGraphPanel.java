package ihm.graph_panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import data.User;
import data.Workout;
import graph.JoggingSummaryBar;
import ihm.MainFrame;
import ihm.SportDataPanel;
import ihm.components.SportButton;
import ihm.components.SportComboBox;
import ihm.components.SportLabel;
import manager.WorkoutManager;

public class JoggingGraphPanel extends JPanel
{
	private User user;
	private WorkoutManager wm;
	private int mode;

	private JPanel section, header, content, footer;
	private JPanel graphChoice, graphPanel;
	private SportButton returnButton, deconnexionButton, displayButton;
	private SportLabel title;
	private SportComboBox workoutNumberBox,choiceBox;
	private JPanel workoutNumber, choice, choicePanel;
	private JLabel messagelabel;
	private SportLabel uName;

	private Image background;
	private String text;

	private Dimension dim;
	private int width = 845;
	private int height = 496;
	
	public JoggingGraphPanel(User user)
	{
		this.user = user;
		this.wm = new WorkoutManager(this.user);

		
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
		content.setLayout(new BorderLayout());
		section.add(content, BorderLayout.CENTER);
		
		graphChoice = new JPanel();
		graphChoice.setPreferredSize(new Dimension(200, height - 40));
		graphChoice.setBackground(new Color(28, 28, 28));
		graphChoice.setLayout(new BorderLayout());
		initGraphChoice();
		content.add(graphChoice, BorderLayout.WEST);
		
		graphPanel = new JPanel();
		graphPanel.setBackground(new Color(28, 28, 28));
		graphPanel.setLayout(new BorderLayout());
		initGraphPanel();
		content.add(graphPanel, BorderLayout.CENTER);
		
		
		
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
	
	public void initGraphPanel()
	{	
		graphPanel.setLayout(new BorderLayout());
		int choice=1;
        int choice2=0;
		graphPanel.add(new JoggingSummaryBar(wm.getWorkoutList(1),choice,choice2), BorderLayout.CENTER);
	}
	
	public void initGraphChoice()
	{	
		title = new SportLabel("Jogging");
		title.setFont(new Font("Verdana", Font.BOLD, 20));
		title.setPreferredSize(new Dimension(200, 80));
		
		choicePanel = new JPanel();
		choicePanel.setBackground(new Color(28, 28, 28));
		choicePanel.setLayout(new FlowLayout());
		
		choice = new JPanel();
		choice.setLayout(new GridLayout(2, 1));
		choice.setBackground(new Color(28, 28, 28));

		
		workoutNumber = new JPanel();
		workoutNumber.setLayout(new GridLayout(2, 1));
		workoutNumber.setBackground(new Color(28, 28, 28));
		workoutNumber.add(new SportLabel("Visualiser sur : "));
		String[] types = {"Toutes séances", "1 séance", "5 séances", "10 séances"};
		workoutNumberBox = new SportComboBox(types);
		
		workoutNumber.add(workoutNumberBox);
		
		choice = new JPanel();
		choice.setLayout(new GridLayout(2, 1));
		choice.setBackground(new Color(28, 28, 28));
		choice.add(new SportLabel("Consulter : "));
		String[] choices = {"Durée", "Distance"};
		choiceBox = new SportComboBox(choices);
		choice.add(choiceBox);
       

		choicePanel.add(choice);
		choicePanel.add(workoutNumber);
		
		footer = new JPanel();
		footer.setBackground(new Color(28, 28, 28));
		footer.setLayout(new FlowLayout());
		footer.setPreferredSize(new Dimension(200, 80));
		displayButton = new SportButton("Afficher");
		footer.add(displayButton);
		
		messagelabel = new JLabel("text");
		messagelabel.setLayout(new FlowLayout());
		//messagelabel.setBackground(Color.WHITE);
		messagelabel.setPreferredSize(new Dimension(150, 70));
		//displayButton = new SportButton("Afficher");
		choicePanel.add(messagelabel);
		
		
		displayButton.addActionListener(new ButtonListener());

		graphChoice.add(title, BorderLayout.NORTH);
		graphChoice.add(choicePanel, BorderLayout.CENTER);
		graphChoice.add(footer, BorderLayout.SOUTH);

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

			if(e.getSource() == displayButton)
			{
			
				
		
					
			     if(choiceBox.getSelectedIndex() == 0) {
					
					int choice2=0;
					
					if( workoutNumberBox.getSelectedIndex() == 0)
						
						
					{
						System.out.println(" all ");
						ArrayList<Workout>workoutList=wm.getWorkoutList(1);
						int size=workoutList.size();
						graphPanel.removeAll();
                        try {			
						graphPanel.add(new JoggingSummaryBar(wm.getWorkoutList(1),size,choice2), BorderLayout.CENTER);
                        }catch(IndexOutOfBoundsException e1) {
                        	
                        }
					}
					
					if( workoutNumberBox.getSelectedIndex() == 1)
					{
						System.out.println("choice 1");
						int choice=1;
						graphPanel.removeAll();
						 try {
						graphPanel.add(new JoggingSummaryBar(wm.getWorkoutList(1),choice,choice2), BorderLayout.CENTER);
						 }catch(IndexOutOfBoundsException e1) {
							 messagelabel.setText("séances insuffisantes");
	                        }
					}
					
					if( workoutNumberBox.getSelectedIndex() == 2)
					{
						System.out.println("choice 5");
						int choice=5;
						graphPanel.removeAll();
						 try {
						graphPanel.add(new JoggingSummaryBar(wm.getWorkoutList(1),choice,choice2), BorderLayout.CENTER);
						 }catch(IndexOutOfBoundsException e1) {
							 messagelabel.setText("séances insuffisantes");	
	                        }
					}
					if( workoutNumberBox.getSelectedIndex() == 3)
					{
						System.out.println("choice 10");
						graphPanel.removeAll();
						int choice=10;
						 try {
						graphPanel.add(new JoggingSummaryBar(wm.getWorkoutList(1),choice,choice2), BorderLayout.CENTER);
						 }catch(IndexOutOfBoundsException e1) {
							 messagelabel.setText("séances insuffisantes");
	                        }
					}
					

			     graphPanel.revalidate();
				
			     }
			     
			     
			     if(choiceBox.getSelectedIndex() == 1) {
			    	 int choice2=1;
			     if( workoutNumberBox.getSelectedIndex() == 0)
						
						
					{
						System.out.println(" all ");
						ArrayList<Workout>workoutList=wm.getWorkoutList(1);
						int size=workoutList.size();
						graphPanel.removeAll();
                     try {			
						graphPanel.add(new JoggingSummaryBar(wm.getWorkoutList(1),size,choice2), BorderLayout.CENTER);
                     }catch(IndexOutOfBoundsException e1) {
                     	
                     }
					}
					
					if( workoutNumberBox.getSelectedIndex() == 1)
					{
						System.out.println("choice 1");
						int choice=1;
						graphPanel.removeAll();
						 try {
						graphPanel.add(new JoggingSummaryBar(wm.getWorkoutList(1),choice,choice2), BorderLayout.CENTER);
						 }catch(IndexOutOfBoundsException e1) {
							 messagelabel.setText("séances insuffisantes");
	                        }
					}
					
					if( workoutNumberBox.getSelectedIndex() == 2)
					{
						System.out.println("choice 5");
						int choice=5;
						graphPanel.removeAll();
						 try {
						graphPanel.add(new JoggingSummaryBar(wm.getWorkoutList(1),choice,choice2), BorderLayout.CENTER);
						 }catch(IndexOutOfBoundsException e1) {
							 messagelabel.setText("séances insuffisantes");	
	                        }
					}
					if( workoutNumberBox.getSelectedIndex() == 3)
					{
						System.out.println("choice 10");
						graphPanel.removeAll();
						int choice=10;
						 try {
						graphPanel.add(new JoggingSummaryBar(wm.getWorkoutList(1),choice,choice2), BorderLayout.CENTER);
						 }catch(IndexOutOfBoundsException e1) {
							 messagelabel.setText("séances insuffisantes");
	                        }
					}
					

			     graphPanel.revalidate();
			    }
			}
			else if(e.getSource() == returnButton)
			{
				MainFrame.getGlobal().removeAll();
				MainFrame.getGlobal().add(new SportDataPanel(user, 1));
				MainFrame.getGlobal().revalidate();
			}
			else if(e.getSource() == workoutNumberBox)
			{
				
				
				
			}
		     
			else if(e.getSource() == deconnexionButton)
				close();
		
			//graphPanel.repaint();
			
		}
		
	
	}
	public void settext(String text) {
		
		this.text=text;
		
	}
	
	
	
}