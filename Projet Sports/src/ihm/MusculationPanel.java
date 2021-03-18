package ihm;

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
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import data.Exercise;
import data.MusculationWorkout;
import data.User;
import data.Workout;
import ihm.components.SportButton;
import ihm.components.SportComboBox;
import ihm.components.SportLabel;
import ihm.components.SportTextField;
import manager.WorkoutManager;

public class MusculationPanel extends JPanel
{
	private User user;
	private WorkoutManager wm;
	private MusculationWorkout w;

	private JPanel section, content, sportData, footer;
	private IllustrationPanel imagePanel;
	private SportButton cancelButton, confirmButton, updateButton, deleteButton, addExercise;
	private SportLabel title;
	private SportTextField dateField, durationField;
	private JPanel date, duration, dataPanel, listPanel;
	private ArrayList<ExercisePanel> exerciseList;
	
	private Dimension dim;
	private int width = 858;
	private int height = 460;

	public MusculationPanel(User user)
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

	public MusculationPanel(User user, Workout w)
	{
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		this.w = (MusculationWorkout) w;
		
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

		addExercise  = new SportButton("Ajouter exercice");
		confirmButton = new SportButton("Valider");
		cancelButton = new SportButton("Retour");
		
		JPanel f1 = new JPanel();
		f1.setBackground(new Color(28, 28, 28));
		f1.add(addExercise);
		
		JPanel f2 = new JPanel();
		f2.setBackground(new Color(28, 28, 28));
		f2.add(confirmButton);
		f2.add(cancelButton);
		
		footer.add(f1);
		footer.add(f2);

		addExercise.addActionListener(new ButtonListener());		
		confirmButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());
	}
	
	public void initFooter2()
	{	
		footer.setLayout(new BoxLayout(footer, BoxLayout.Y_AXIS));

		addExercise  = new SportButton("Ajouter exercice");
		updateButton = new SportButton("Modifier");
		deleteButton = new SportButton("Supprimer");
		cancelButton = new SportButton("Retour");
		
		JPanel f1 = new JPanel();
		f1.setBackground(new Color(28, 28, 28));
		f1.add(addExercise);
		
		JPanel f2 = new JPanel();
		f2.setBackground(new Color(28, 28, 28));
		f2.add(updateButton);
		f2.add(deleteButton);
		f2.add(cancelButton);
		
		footer.add(f1);
		footer.add(f2);

		addExercise.addActionListener(new ButtonListener());		
		updateButton.addActionListener(new ButtonListener());
		deleteButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());

	}
	
	
	public void initSportData()
	{	
		title = new SportLabel("S�ance : Musculation");
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
		duration.add(new SportLabel("   Dur�e : "));
		durationField = new SportTextField(3);
		duration.add(durationField);
		duration.add(new SportLabel("min"));
		
		listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		listPanel.setBackground(new Color(28, 28, 28));
		
		exerciseList = new ArrayList<ExercisePanel>();
		exerciseList.add(new ExercisePanel());
		
		for(int i = 0 ; i < exerciseList.size() ; i++)
			listPanel.add(exerciseList.get(i));
		
		
		JScrollPane scroll = new JScrollPane(listPanel);
		scroll.setPreferredSize(new Dimension(350, height/2));
		scroll.getVerticalScrollBar().setBackground(new Color(50, 50, 50));
		scroll.setBorder(null);

		dataPanel.add(date);
		dataPanel.add(duration);
		dataPanel.add(scroll);


		sportData.add(dataPanel, BorderLayout.CENTER);
	}
	
	public void initSportData2()
	{	
		title = new SportLabel("S�ance : Musculation");
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
		duration.add(new SportLabel("   Dur�e : "));
		durationField = new SportTextField(3);
		durationField.setText("" + w.getDuration());
		duration.add(durationField);
		duration.add(new SportLabel("min"));
		
		listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		listPanel.setBackground(new Color(28, 28, 28));
		
		exerciseList = new ArrayList<ExercisePanel>();
		
		for(int i = 0 ; i < w.getExercises().size() ; i++)
		{
			ExercisePanel ep = new ExercisePanel();
			Exercise ex = w.getExercises().get(i);

			ep.setBoxSelection(ex.getType());
			ep.fillFields("" + ex.getSets(), "" + ex.getRepetitions());
			
			exerciseList.add(ep);		
			listPanel.add(exerciseList.get(i));
		}
		
		
		JScrollPane scroll = new JScrollPane(listPanel);
		scroll.setPreferredSize(new Dimension(350, height/2));
		scroll.getVerticalScrollBar().setBackground(new Color(50, 50, 50));
		scroll.setBorder(null);

		dataPanel.add(date);
		dataPanel.add(duration);
		dataPanel.add(scroll);


		sportData.add(dataPanel, BorderLayout.CENTER);
	}
	
	public void retour()
	{
		MainFrame.getGlobal().removeAll();;		
		MainFrame.getGlobal().add(new SportDataPanel(user, 4));
		MainFrame.getGlobal().revalidate();
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{			
			
			if(e.getSource() == addExercise)
			{
				if(exerciseList.size() < 4)
				{
					ExercisePanel ex = new ExercisePanel();
					exerciseList.add(ex);
					listPanel.add(ex);
					revalidate();
				}

			}
			else if(e.getSource() == confirmButton)
			{
				MusculationWorkout mw = new MusculationWorkout(new Date(0), 0);
				mw.setDate(new Date(0));
				mw.setDuration(Integer.parseInt(durationField.getText()));
				
				for(int i = 0 ; i < exerciseList.size() ; i++)
					mw.addExercise(exerciseList.get(i).getExerciseData());

				System.out.println(mw);
				
				wm.createNewWorkout(mw);
				JOptionPane.showMessageDialog(null, "Nouvelle s�ance de Musculation enregistr�e pour " + user.getFirstname());
				retour();
			
			}
			else if(e.getSource() == updateButton)
			{
				System.out.println("Ancienne s�ance : " + w);

				w.setDate(new Date(0));
				w.setDuration(Integer.parseInt(durationField.getText()));
				
				for(int i = 0 ; i < exerciseList.size() ; i++)
				{
					if(i < w.getExercises().size())
					{
						Exercise ex = w.getExercises().get(i);
						ex.setType(exerciseList.get(i).getExerciseData().getType());
						ex.setSets(exerciseList.get(i).getExerciseData().getSets());
						ex.setRepetitions(exerciseList.get(i).getExerciseData().getRepetitions());
					}
					else
						w.addExercise(exerciseList.get(i).getExerciseData());

				}

				System.out.println("Nouvelle s�ance : " + w);
				
				wm.updateWorkout(w);
				JOptionPane.showMessageDialog(null, "S�ance de Musculation modifi�e pour " + user.getFirstname());
				retour();
			
			}
			else if(e.getSource() == deleteButton)
			{
				System.out.println(w);
				
				wm.deleteWorkout(w);
				JOptionPane.showMessageDialog(null, "S�ance de Musculation supprim�e pour " + user.getFirstname());
				retour();
			
			}
			else if(e.getSource() == cancelButton)
			{
				retour();
			}
			
			
		}
	}
	
	@SuppressWarnings("serial")
	private class ExercisePanel extends JPanel
	{
		private SportTextField setsField, repsField;
		private JPanel type, sets, reps;
		private JComboBox<String> typeList;
		
		public ExercisePanel()
		{
			this.setMaximumSize(new Dimension(350, 180));
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.setBackground(new Color(28, 28, 28));
			
			JPanel p1 = new JPanel();
			p1.setBackground(new Color(28, 28, 28));
			p1.add(new SportLabel("Nouvel exercice"));
			
			type = new JPanel();
			type.setBackground(new Color(28, 28, 28));
			type.add(new SportLabel("              Type : "));
			String[] types = {"Pompes", "Tractions", "Squats", "Abdominaux"};
			typeList = new SportComboBox(types);
			type.add(typeList);
			
			JPanel p2 = new JPanel();
			p2.setBackground(new Color(28, 28, 28));
			p2.add(new SportLabel("Vos donn�es"));
			
			sets = new JPanel();
			sets.setBackground(new Color(28, 28, 28));
			sets.add(new SportLabel("       S�ries : "));
			setsField = new SportTextField(3);
			sets.add(setsField);
			
			reps = new JPanel();
			reps.setBackground(new Color(28, 28, 28));
			reps.add(new SportLabel("R�p�titions : "));
			repsField = new SportTextField(3);
			reps.add(repsField);

			this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

			
			this.add(p1);
			this.add(type);
			this.add(p2);
			this.add(sets);
			this.add(reps);
		}
		
		public Exercise getExerciseData()
		{
			Exercise e = new Exercise();
			
			e.setType(this.typeList.getSelectedItem().toString());
			e.setSets(Integer.parseInt(this.setsField.getText()));
			e.setRepetitions(Integer.parseInt(this.repsField.getText()));
			
			return e;
		}
		
		public void fillFields(String eSets, String eReps)
		{
			this.setsField.setText(eSets);
			this.repsField.setText(eReps);
		}
		
		public void setBoxSelection(String eType)
		{
			switch(eType)
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
		}
			
	}


	@SuppressWarnings("serial")
	private class IllustrationPanel extends JPanel
	{
		private Image background;
		
		public IllustrationPanel()
		{
			super(null);
			try
			{
				background = ImageIO.read(new File("resources/images/musculation.jpg"));
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
