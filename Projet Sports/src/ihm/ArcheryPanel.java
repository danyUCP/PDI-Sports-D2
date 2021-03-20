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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import data.ArcheryWorkout;
import data.Target;
import data.User;
import data.Workout;
import ihm.components.SportButton;
import ihm.components.SportDateBox;
import ihm.components.SportLabel;
import ihm.components.SportTextField;
import manager.WorkoutManager;

public class ArcheryPanel extends JPanel
{
	private User user;
	private WorkoutManager wm;
	private ArcheryWorkout w;

	private JPanel section, content, sportData, footer;
	private IllustrationPanel imagePanel;
	private SportButton cancelButton, confirmButton, updateButton, deleteButton, addTarget;
	private SportLabel title;
	private SportTextField durationField;
	private SportDateBox dateBox;
	private JPanel date, duration, dataPanel, listPanel;
	private ArrayList<TargetPanel> targetList;
	
	private Dimension dim;
	private int width = 858;
	private int height = 460;

	public ArcheryPanel(User user)
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
	
	public ArcheryPanel(User user, Workout w)
	{
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		this.w = (ArcheryWorkout) w;
		
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

		addTarget  = new SportButton("Ajouter cible");
		confirmButton = new SportButton("Valider");
		cancelButton = new SportButton("Retour");
		
		JPanel f1 = new JPanel();
		f1.setBackground(new Color(28, 28, 28));
		f1.add(addTarget);
		
		JPanel f2 = new JPanel();
		f2.setBackground(new Color(28, 28, 28));
		f2.add(confirmButton);
		f2.add(cancelButton);
		
		footer.add(f1);
		footer.add(f2);

		addTarget.addActionListener(new ButtonListener());		
		confirmButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());
	}
	
	public void initFooter2()
	{	
		footer.setLayout(new BoxLayout(footer, BoxLayout.Y_AXIS));

		addTarget  = new SportButton("Ajouter cible");
		updateButton = new SportButton("Modifier");
		deleteButton = new SportButton("Supprimer");
		cancelButton = new SportButton("Retour");
		
		JPanel f1 = new JPanel();
		f1.setBackground(new Color(28, 28, 28));
		f1.add(addTarget);
		
		JPanel f2 = new JPanel();
		f2.setBackground(new Color(28, 28, 28));
		f2.add(updateButton);
		f2.add(deleteButton);
		f2.add(cancelButton);
		
		footer.add(f1);
		footer.add(f2);

		addTarget.addActionListener(new ButtonListener());		
		updateButton.addActionListener(new ButtonListener());
		deleteButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());
	}
	
	
	public void initSportData()
	{	
		title = new SportLabel("Séance : Tir à l'arc");
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
		date.add(new SportLabel("Date:"));
		dateBox = new SportDateBox();
		date.add(dateBox);
		
		duration = new JPanel();
		duration.setBackground(new Color(28, 28, 28));
		duration.add(new SportLabel("Durée:"));
		durationField = new SportTextField(3);
		duration.add(durationField);
		duration.add(new SportLabel("min"));
		
		listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		listPanel.setBackground(new Color(28, 28, 28));
		
		targetList = new ArrayList<TargetPanel>();
		targetList.add(new TargetPanel());
		
		for(int i = 0 ; i < targetList.size() ; i++)
			listPanel.add(targetList.get(i));
		
		
		JScrollPane scroll = new JScrollPane(listPanel);
		scroll.setPreferredSize(new Dimension(420, height/2));
		scroll.getVerticalScrollBar().setBackground(new Color(50, 50, 50));
		scroll.setBorder(null);

		dataPanel.add(date);
		dataPanel.add(duration);
		dataPanel.add(scroll);


		sportData.add(dataPanel, BorderLayout.CENTER);
	}
	
	public void initSportData2()
	{	
		title = new SportLabel("Séance : Tir à l'arc");
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
		date.add(new SportLabel("Date:"));
		dateBox = new SportDateBox(w.getDate());
		date.add(dateBox);
		
		duration = new JPanel();
		duration.setBackground(new Color(28, 28, 28));
		duration.add(new SportLabel("Durée:"));
		durationField = new SportTextField(3);
		durationField.setText("" + w.getDuration());
		duration.add(durationField);
		duration.add(new SportLabel("min"));
		
		listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		listPanel.setBackground(new Color(28, 28, 28));
		
		targetList = new ArrayList<TargetPanel>();
		
		for(int i = 0 ; i < w.getTargets().size() ; i++)
		{
			TargetPanel tp = new TargetPanel();
			Target targ = w.getTargets().get(i);

			tp.setTargetData(targ);
			
			targetList.add(tp);		
			listPanel.add(targetList.get(i));
		}
		
		JScrollPane scroll = new JScrollPane(listPanel);
		scroll.setPreferredSize(new Dimension(420, height/2));
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
		MainFrame.getGlobal().add(new SportDataPanel(user, 6));
		MainFrame.getGlobal().revalidate();
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{			
			
			if(e.getSource() == addTarget)
			{
				if(targetList.size() < 3)
				{
					TargetPanel tgt = new TargetPanel();
					targetList.add(tgt);
					listPanel.add(tgt);
					revalidate();
				}

			}
			else if(e.getSource() == confirmButton)
			{
				ArcheryWorkout aw = new ArcheryWorkout(new Date(0), 0);
				aw.setDate(new Date(0));
				aw.setDuration(Integer.parseInt(durationField.getText()));
				
				for(int i = 0 ; i < targetList.size() ; i++)
					aw.addTarget(targetList.get(i).getTargetData());

				System.out.println(aw);

				wm.createNewWorkout(aw);
				JOptionPane.showMessageDialog(null, "Nouvelle séance de Tir à l'arc enregistrée pour " + user.getFirstname());
				retour();
			}
			else if(e.getSource() == updateButton)
			{
				System.out.println("Ancienne séance : " + w);

				w.setDate(new Date(0));
				w.setDuration(Integer.parseInt(durationField.getText()));
				
				for(int i = 0 ; i < targetList.size() ; i++)
				{
					if(i < w.getTargets().size())
					{
						Target targ = w.getTargets().get(i);
						targ.setTarget_distance(targetList.get(i).getTargetData().getTarget_distance());
						targ.setYellow_area(targetList.get(i).getTargetData().getYellow_area());
						targ.setRed_area(targetList.get(i).getTargetData().getRed_area());
						targ.setBlue_area(targetList.get(i).getTargetData().getBlue_area());
						targ.setBlack_area(targetList.get(i).getTargetData().getBlack_area());
						targ.setWhite_area(targetList.get(i).getTargetData().getWhite_area());
						targ.setMisses(targetList.get(i).getTargetData().getMisses());

					}
					else
						w.addTarget(targetList.get(i).getTargetData());

				}

				System.out.println("Nouvelle séance : " + w);
				
				wm.updateWorkout(w);
				JOptionPane.showMessageDialog(null, "Séance de Tir à l'arc modifiée pour " + user.getFirstname());
				retour();
			
			}
			else if(e.getSource() == deleteButton)
			{
				System.out.println(w);
				
				wm.deleteWorkout(w);
				JOptionPane.showMessageDialog(null, "Séance de Tir à l'arc supprimée pour " + user.getFirstname());
				retour();
			
			}
			else if(e.getSource() == cancelButton)
			{
				retour();
			}
			
			
		}
	}
	
	@SuppressWarnings("serial")
	private class TargetPanel extends JPanel
	{
		private SportTextField distanceField, yellowField, redField, blueField, blackField, whiteField, missesField;
		private JPanel distance, targets1, targets2;
		
		public TargetPanel()
		{
			this.setMaximumSize(new Dimension(420, 180));
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.setBackground(new Color(28, 28, 28));
			
			
			distance = new JPanel();
			distance.setBackground(new Color(28, 28, 28));
			distance.add(new SportLabel("Distance : "));
			distanceField = new SportTextField(3);
			distance.add(distanceField);
			distance.add(new SportLabel("mètres"));
			
			targets1 = new JPanel();
			targets1.setBackground(new Color(28, 28, 28));
			targets1.add(new SportLabel("Jaune : "));
			yellowField = new SportTextField(3);
			targets1.add(yellowField);
			targets1.add(new SportLabel("Rouge : "));
			redField = new SportTextField(3);
			targets1.add(redField);
			targets1.add(new SportLabel("Bleue : "));
			blueField = new SportTextField(3);
			targets1.add(blueField);
			
			targets2 = new JPanel();
			targets2.setBackground(new Color(28, 28, 28));
			targets2.add(new SportLabel("Noire : "));
			blackField = new SportTextField(3);
			targets2.add(blackField);
			targets2.add(new SportLabel("Blanche : "));
			whiteField = new SportTextField(3);
			targets2.add(whiteField);
			targets2.add(new SportLabel("Ratées : "));
			missesField = new SportTextField(3);
			targets2.add(missesField);

			this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

			this.add(new SportLabel("Nouvelle cible "));
			this.add(distance);
			this.add(new SportLabel(" "));
			this.add(new SportLabel("Flèches par zone           "));
			this.add(targets1);
			this.add(targets2);
		}
		

		public Target getTargetData()
		{
			Target t = new Target();

			t.setTarget_distance(Integer.parseInt(this.distanceField.getText()));
			t.setYellow_area(Integer.parseInt(this.yellowField.getText()));
			t.setRed_area(Integer.parseInt(this.redField.getText()));
			t.setBlue_area(Integer.parseInt(this.blueField.getText()));
			t.setBlack_area(Integer.parseInt(this.blackField.getText()));
			t.setWhite_area(Integer.parseInt(this.whiteField.getText()));
			t.setMisses(Integer.parseInt(this.missesField.getText()));

			return t;
		}
		
		public void setTargetData(Target t) 
		{
			this.distanceField.setText("" + t.getTarget_distance());
			this.yellowField.setText("" + t.getYellow_area());
			this.redField.setText("" + t.getRed_area());
			this.blueField.setText("" + t.getBlue_area());
			this.blackField.setText("" + t.getBlack_area());
			this.whiteField.setText("" + t.getWhite_area());
			this.missesField.setText("" + t.getMisses());
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
				background = ImageIO.read(new File("resources/images/arch.jpg"));
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
