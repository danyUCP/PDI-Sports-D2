package ihm.sport_panels;

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
import java.sql.Date;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import data.Exercise;
import data.RowingWorkout;
import data.User;
import data.Workout;
import ihm.MainFrame;
import ihm.SportDataPanel;
import ihm.components.SportButton;
import ihm.components.SportLabel;
import ihm.components.SportTextField;
import manager.WorkoutManager;

@SuppressWarnings("serial")
public class RowingPanel extends JPanel
{
	private User user;
	private WorkoutManager wm;
	private RowingWorkout w;
	
	private JPanel section, content, sportData, footer;
	private IllustrationPanel imagePanel;
	private SportButton cancelButton, confirmButton, updateButton, deleteButton;
	private SportLabel title;
	private SportTextField dateField, durationField,distanceField,paddle_strokesField;
	private JPanel date, duration, dataPanel, listPanel,distance,paddle_strokes;
	private ArrayList<ExercisePanel> exerciseList;
	private JLabel messagelabel;
	
	private Dimension dim;
	private int width = 858;
	private int height = 460;

	public RowingPanel(User user)
	{
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		
		displayElements();
		
		sportData = new JPanel();
		sportData.setPreferredSize(new Dimension(width, 60));
		sportData.setBackground(new Color(28, 28, 28));
		sportData.setLayout(new BorderLayout());
		initSportData();
		content.add(sportData);
		
		imagePanel = new IllustrationPanel();
		content.add(imagePanel);
		
		footer = new JPanel();
		footer.setPreferredSize(new Dimension(width, 85));
		footer.setBackground(new Color(28, 28, 28));
		initFooter();
		sportData.add(footer, BorderLayout.SOUTH);
	}

	public RowingPanel(User user, Workout w)
	{
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		this.w = (RowingWorkout) w;
		
		displayElements();
		
		sportData = new JPanel();
		sportData.setPreferredSize(new Dimension(width, 60));
		sportData.setBackground(new Color(28, 28, 28));
		sportData.setLayout(new BorderLayout());
		initSportData2();
		content.add(sportData);

		imagePanel = new IllustrationPanel();
		content.add(imagePanel);
		
		footer = new JPanel();
		footer.setPreferredSize(new Dimension(width, 85));
		footer.setBackground(new Color(28, 28, 28));
		initFooter2();
		sportData.add(footer, BorderLayout.SOUTH);
	}
	
	public void displayElements()
	{
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
		
		section = new JPanel();
		section.setBounds(0, 0, width, height);
		section.setBackground(new Color(28, 28, 28));
		section.setLayout(new BorderLayout());
		this.add(section);
		

		content = new JPanel();
		content.setPreferredSize(new Dimension(width, height));
		content.setBackground(Color.BLUE);
		content.setLayout(new GridLayout(1, 2));
		section.add(content, BorderLayout.CENTER);
	}
	
	
	public void initFooter()
	{	
		footer.setLayout(new BoxLayout(footer, BoxLayout.Y_AXIS));

		
		confirmButton = new SportButton("Valider");
		cancelButton = new SportButton("Retour");
		
		JPanel f1 = new JPanel();
		f1.setBackground(new Color(28, 28, 28));
	
		
		JPanel f2 = new JPanel();
		f2.setBackground(new Color(28, 28, 28));
		f2.add(confirmButton);
		f2.add(cancelButton);
		
		footer.add(f1);
		footer.add(f2);

	
		confirmButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());
	} 
	
	public void initFooter2()
	{	
		footer.setLayout(new BoxLayout(footer, BoxLayout.Y_AXIS));

		
		updateButton = new SportButton("Modifier");
		deleteButton = new SportButton("Supprimer");
		cancelButton = new SportButton("Retour");
		
		JPanel f1 = new JPanel();
		f1.setBackground(new Color(28, 28, 28));
	
		
		JPanel f2 = new JPanel();
		f2.setBackground(new Color(28, 28, 28));
		f2.add(updateButton);
		f2.add(deleteButton);
		f2.add(cancelButton);
		
		footer.add(f1);
		footer.add(f2);

			
		updateButton.addActionListener(new ButtonListener());
		deleteButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());

	}
	
	
	public void initSportData()
	{	
		title = new SportLabel("Séance : Rowing");
		title.setFont(new Font("Verdana", Font.BOLD, 24));
		title.setPreferredSize(new Dimension(width, 80));

		sportData.add(title, BorderLayout.NORTH);
		
		dataPanel = new JPanel();
		dataPanel.setBackground(new Color(28, 28, 28));
		dataPanel.setLayout(new BorderLayout());
		
		//dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
		dataPanel.setLayout(new FlowLayout());

		date = new JPanel();
		date.setBackground(new Color(28, 28, 28));
		date.add(new SportLabel("Date : "));
		dateField = new SportTextField(8);
		date.add(dateField);
		
		duration = new JPanel();
		duration.setBackground(new Color(28, 28, 28));
		duration.add(new SportLabel("   Durée : "));
		durationField = new SportTextField(3);
		duration.add(durationField);
		duration.add(new SportLabel("min"));
		
		paddle_strokes=new JPanel();
		paddle_strokes.setBackground(new Color(28, 28, 28));
		paddle_strokes.add(new SportLabel("   Paddle Strokes : "));
		paddle_strokesField = new SportTextField(3);
		paddle_strokes.add(paddle_strokesField);
		paddle_strokes.add(new SportLabel("nb"));
		
		distance=new JPanel();
		distance.setBackground(new Color(28, 28, 28));
		distance.add(new SportLabel("   Distance : "));
		distanceField = new SportTextField(3);
		distance.add(distanceField);
		distance.add(new SportLabel("m"));
		
		
		
		
		listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		listPanel.setBackground(new Color(28, 28, 28));
		
		exerciseList = new ArrayList<ExercisePanel>();
		exerciseList.add(new ExercisePanel());

		dataPanel.add(date);
		dataPanel.add(duration);
		dataPanel.add(distance);
        dataPanel.add(paddle_strokes);

		sportData.add(dataPanel, BorderLayout.CENTER);
	}
	
	public void initSportData2()
	{	
		title = new SportLabel("Séance : Aviron");
		title.setFont(new Font("Verdana", Font.BOLD, 24));
		title.setPreferredSize(new Dimension(width, 80));

		sportData.add(title, BorderLayout.NORTH);
		
		dataPanel = new JPanel();
		dataPanel.setBackground(new Color(28, 28, 28));
		dataPanel.setLayout(new BorderLayout());
		
		//dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
		dataPanel.setLayout(new FlowLayout());

		date = new JPanel();
		date.setBackground(new Color(28, 28, 28));
		date.add(new SportLabel("Date : "));
		dateField = new SportTextField(8);
		dateField.setText("" + w.getDate());
		date.add(dateField);
		
		duration = new JPanel();
		duration.setBackground(new Color(28, 28, 28));
		duration.add(new SportLabel("   Durée : "));
		durationField = new SportTextField(3);
		durationField.setText("" + w.getDuration());
		duration.add(durationField);
		duration.add(new SportLabel("min"));
		
		paddle_strokes=new JPanel();
		paddle_strokes.setBackground(new Color(28, 28, 28));
		paddle_strokes.add(new SportLabel("   Paddle Strokes : "));
		paddle_strokesField = new SportTextField(3);
		paddle_strokes.add(paddle_strokesField);
		paddle_strokes.add(new SportLabel("nb"));
		
		distance=new JPanel();
		distance.setBackground(new Color(28, 28, 28));
		distance.add(new SportLabel("   Distance : "));
		distanceField = new SportTextField(3);
		distance.add(distanceField);
		distance.add(new SportLabel("m"));
		
		listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		listPanel.setBackground(new Color(28, 28, 28));
		
		exerciseList = new ArrayList<ExercisePanel>();		
		
		JScrollPane scroll = new JScrollPane(listPanel);
		scroll.setPreferredSize(new Dimension(350, height/2));
		scroll.getVerticalScrollBar().setBackground(new Color(50, 50, 50));
		scroll.setBorder(null);

		dataPanel.add(date);
		dataPanel.add(duration);
		dataPanel.add(paddle_strokes);
		dataPanel.add(distance);
		dataPanel.add(scroll);


		sportData.add(dataPanel, BorderLayout.CENTER);
	}
	
	public void retour()
	{
		MainFrame.getGlobal().removeAll();;		
		MainFrame.getGlobal().add(new SportDataPanel(user, 3));
		MainFrame.getGlobal().revalidate();
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{			
			
			
			if(e.getSource() == confirmButton)
			{
			
				String text_date=dateField.getText();
				String distance=distanceField.getText();
				String duration=durationField.getText();
				String paddle_strokes=paddle_strokesField.getText();
				int distance1=Integer.parseInt(distance); 
				int duration1=Integer.parseInt(duration);
				int paddle_strokes1=Integer.parseInt(paddle_strokes);
				Date dates=ConvertDateToSql(text_date);
				
				System.out.println("paddle strokes ="+paddle_strokes);
				
				RowingWorkout mw = new RowingWorkout(dates,duration1,distance1,paddle_strokes1);
				mw.setDate(dates);
				mw.setDuration(Integer.parseInt(durationField.getText()));
				
				for(int i = 0 ; i < exerciseList.size() ; i++)
			

				System.out.println(mw);
				
				wm.createNewWorkout(mw);
				JOptionPane.showMessageDialog(null, "Nouvelle séance d' aviron enregistrée pour " + user.getFirstname());
				retour();
			
			}
			else if(e.getSource() == updateButton)
			{
				System.out.println("Ancienne séance : " + w);
				
				String paddle_strokes=paddle_strokesField.getText();
				int paddle_strokes1=Integer.parseInt(paddle_strokes);
				
				String distance=distanceField.getText();
				int distance1=Integer.parseInt(distance); 
				

			//	w.setDate(new Date(0));
				w.setPaddleStrokes(paddle_strokes1);
				w.setDistance(distance1);
				
				w.setDuration(Integer.parseInt(durationField.getText()));

				System.out.println("Nouvelle séance : " + w);
				
				wm.updateWorkout(w);
				JOptionPane.showMessageDialog(null, "Séance d' aviron modifiée pour " + user.getFirstname());
				retour();
			
			}
			else if(e.getSource() == deleteButton)
			{
				System.out.println(w);
				
				wm.deleteWorkout(w);
				JOptionPane.showMessageDialog(null, "Séance d' avriron supprimée pour " + user.getFirstname());
				retour();
			
			}
			else if(e.getSource() == cancelButton)
			{
				retour();
			}
			
			
		}
	}
	
	private class ExercisePanel extends JPanel
	{
		private SportTextField setsField, repsField;
		private JPanel type, sets, reps;
		private JComboBox<String> typeList;

	
		
		public void setExerciseData(Exercise e)
		{
	
			
			this.setsField.setText("" + e.getSets());
			this.repsField.setText("" + e.getRepetitions());
		}

			
	}
	
	public Date ConvertDateToSql(String date) {  
	    Date dates=Date.valueOf(date); 
	    System.out.println(date);
		return dates;  
	}


	private class IllustrationPanel extends JPanel
	{
		private Image background;
		
		public IllustrationPanel()
		{
			super(null);
			try
			{
				background = ImageIO.read(new File("Projet Sports/resources/images/rowing.png"));
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
	}

}

