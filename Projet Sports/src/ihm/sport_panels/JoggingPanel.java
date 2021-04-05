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
import data.JoggingWorkout;
import data.User;
import data.Workout;
import ihm.MainFrame;
import ihm.SportDataPanel;
import ihm.components.SportButton;
import ihm.components.SportLabel;
import ihm.components.SportTextField;
import manager.WorkoutManager;

@SuppressWarnings("serial")
public class JoggingPanel extends JPanel
{
	private User user;
	private WorkoutManager wm;
	private JoggingWorkout w;
	
	private JPanel section, content, sportData, footer;
	private IllustrationPanel imagePanel;
	private SportButton cancelButton, confirmButton, updateButton, deleteButton;// addExercise;
	private SportLabel title;
	private SportTextField dateField, durationField,distanceField;
	private JPanel date, duration, dataPanel, listPanel,distance;
	private ArrayList<ExercisePanel> exerciseList;
	private JLabel messagelabel;
	
	private Dimension dim;
	private int width = 858;
	private int height = 460;

	public JoggingPanel(User user)
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
		
		messagelabel=new JLabel();
		messagelabel.setPreferredSize(new Dimension(width, 60));
		messagelabel.setBackground(new Color(28, 28, 28));
		messagelabel.setLayout(new BorderLayout());
		initSportData();
		content.add(messagelabel);
		
		
		imagePanel = new IllustrationPanel();
		content.add(imagePanel);
		
		footer = new JPanel();
		footer.setPreferredSize(new Dimension(width, 85));
		footer.setBackground(new Color(28, 28, 28));
		initFooter();
		sportData.add(footer, BorderLayout.SOUTH);
		
		
		
	}

	public JoggingPanel(User user, Workout w)
	{
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		this.w = (JoggingWorkout) w;
		
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

	//	addExercise  = new SportButton("Ajouter exercice");
		confirmButton = new SportButton("Valider");
		cancelButton = new SportButton("Retour");
		
		JPanel f1 = new JPanel();
		f1.setBackground(new Color(28, 28, 28));
	//	f1.add(addExercise);
		
		JPanel f2 = new JPanel();
		f2.setBackground(new Color(28, 28, 28));
		f2.add(confirmButton);
		f2.add(cancelButton);
		
		footer.add(f1);
		footer.add(f2);

//	    addExercise.addActionListener(new ButtonListener());		
		confirmButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());
	}
	
	public void initFooter2()
	{	
		footer.setLayout(new BoxLayout(footer, BoxLayout.Y_AXIS));

	//	addExercise  = new SportButton("Ajouter exercice");
		updateButton = new SportButton("Modifier");
		deleteButton = new SportButton("Supprimer");
		cancelButton = new SportButton("Retour");
		
		JPanel f1 = new JPanel();
		f1.setBackground(new Color(28, 28, 28));
	//	f1.add(addExercise);
		
		JPanel f2 = new JPanel();
		f2.setBackground(new Color(28, 28, 28));
		f2.add(updateButton);
		f2.add(deleteButton);
		f2.add(cancelButton);
		
		footer.add(f1);
		footer.add(f2);

	//	addExercise.addActionListener(new ButtonListener());		
		updateButton.addActionListener(new ButtonListener());
		deleteButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());

	}
	
	
	public void initSportData()
	{	
		title = new SportLabel("Séance : Jogging");
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


		sportData.add(dataPanel, BorderLayout.CENTER);
	}
	
	public void initSportData2()
	{	
		title = new SportLabel("Séance : Jogging");
		title.setFont(new Font("Verdana", Font.BOLD, 24));
		title.setPreferredSize(new Dimension(width, 80));

		sportData.add(title, BorderLayout.NORTH);
		
		dataPanel = new JPanel();
		dataPanel.setBackground(new Color(28, 28, 28));
		dataPanel.setLayout(new BorderLayout());
		
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
		dataPanel.add(distance);
		dataPanel.add(scroll);


		sportData.add(dataPanel, BorderLayout.CENTER);
	}
	
	public void retour()
	{
		MainFrame.getGlobal().removeAll();;		
		MainFrame.getGlobal().add(new SportDataPanel(user, 1));
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
				int distance1=Integer.parseInt(distance); 
				int duration1=Integer.parseInt(duration);
				Date dates=ConvertDateToSql(text_date);
				JoggingWorkout mw = new JoggingWorkout(dates,duration1,distance1);
				mw.setDate(dates);
				mw.setDuration(Integer.parseInt(durationField.getText()));
				
				for(int i = 0 ; i < exerciseList.size() ; i++)
				//	mw.addExercise(exerciseList.get(i).getExerciseData());

				System.out.println(mw);
				
				wm.createNewWorkout(mw);
				JOptionPane.showMessageDialog(null, "Nouvelle séance de Joggging enregistrée pour " + user.getFirstname());
				retour();
			
			}
			else if(e.getSource() == updateButton)
			{
				System.out.println("Ancienne séance : " + w);
				
				
				
				//String duration_result=durationField.getText();
				String datess=dateField.toString();
				
				String distance=distanceField.getText();
				
				//Date fin=ConvertDateToSql(datess);

				//w.setDate(fin);
				w.setDuration(Integer.parseInt(durationField.getText()));
				w.setDistance(Integer.parseInt(distance));
				

				System.out.println("Nouvelle séance : " + w);
				
				wm.updateWorkout(w);
				JOptionPane.showMessageDialog(null, "Séance de Jogging modifiée pour " + user.getFirstname());
				retour();
			
			}
			else if(e.getSource() == deleteButton)
			{
				System.out.println(w);
				
				wm.deleteWorkout(w);
				JOptionPane.showMessageDialog(null, "Séance de Jogging supprimée pour " + user.getFirstname());
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

		
		public Exercise getExerciseData()
		{
			Exercise e = new Exercise();
			
			e.setType(this.typeList.getSelectedItem().toString());
			e.setSets(Integer.parseInt(this.setsField.getText()));
			e.setRepetitions(Integer.parseInt(this.repsField.getText()));
			
			return e;
		}
		
		public void setExerciseData(Exercise e)
		{
			switch(e.getType())
			{
				case "Pompes":
					this.typeList.setSelectedIndex(0);
					break;
				case "Tractions":
					this.typeList.setSelectedIndex(1);
					break;
				case "Squats":
					this.typeList.setSelectedIndex(2);
					break;
				case "Abdominaux":
					this.typeList.setSelectedIndex(3);
					break;
			}
			
			this.setsField.setText("" + e.getSets());
			this.repsField.setText("" + e.getRepetitions());
		}

			
	}
	
	public Date ConvertDateToSql(String date) {  
	    Date dates=Date.valueOf(date); 
	    System.out.println(date);
		return dates;  
	}	
	/*
	public class Action_Modify_Supp implements ActionListener {
		
		String duration_result=durationField.getText();
		String datess=dateField.toString();

		
		
		String text_date=dateField.getText();
		String distance=distanceField.getText();
		String duration=durationField.getText();

		
		public void actionPerformed(ActionEvent e2) {
			if (e2.getSource()==updateButton) {
			//	w.setCourseDifficulty(difficulty);
				Date fin=ConvertDateToSql(datess);
				int distance1=Integer.parseInt(distance);
				System.out.printf(" distance = "+distance1    +"");
				w.setDate(fin);
				int final_times=Convettexttomesure(duration_result);
			//	w.setDuration(final_times);
			//	w.setDistance(distance1);
			//	wm.updateWorkout(w);
			JOptionPane.showMessageDialog(null, "Nouvelle séance de Jogging modifiée pour " + user.getFirstname());
		//	retour();
			}
			
			
			if (e2.getSource()==deleteButton) {
				wm.deleteWorkout(w);
			JOptionPane.showMessageDialog(null, "Séance de Jogging supprimé pour " + user.getFirstname());
			retour();
			}
		}
		
		
		}*/
	
	public int Convettexttomesure(String text) {
		
		
		int nombre=0;
		if (text.length() > 0) {
		    try {
		         nombre = Integer.parseInt(text);
		        
		    } catch (NumberFormatException nfe) {
		        settext("Erreur de format");
		   
		    
		    }
		} else {
		      settext("Un paramètre est requis");
		}
	      return nombre;
		
	}
	

	public void settext(String text) {
		
		messagelabel.setText(text);	
			
	}
	
	

	private class IllustrationPanel extends JPanel
	{
		private Image background;
		
		public IllustrationPanel()
		{
			super(null);
			try
			{
				background = ImageIO.read(new File("Projet Sports/resources/images/jogging.png"));
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
