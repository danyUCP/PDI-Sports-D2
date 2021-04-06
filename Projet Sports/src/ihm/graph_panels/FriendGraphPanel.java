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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import data.User;
import graph.FriendPieChart;
import graph.FriendSummaryBar;
import graph.SwimmingSummaryBar;
import ihm.FriendsPanel;
import ihm.MainFrame;
import ihm.components.SportButton;
import ihm.components.SportComboBox;
import ihm.components.SportLabel;
import manager.UserManager;
import manager.WorkoutManager;



/**
 * <code>FriendGraphPanel </code> 
 * Is the class that implements the graph comparison panel between two friends.
 * <strong>NOTE:</strong>
 *This class<code>FriendsPanel</code> implements all the components of the associated graphical ihm .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 */
public class FriendGraphPanel  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private WorkoutManager wm,wm2;
	private Dimension dim;
	private int width = 845;
	private int height = 496;
	private JPanel section, header, content, footer;
	private JPanel graphChoice, graphPanel;
	private SportButton returnButton, deconnexionButton, displayButton;
	private SportLabel title;
	private SportComboBox workoutNumberBox, choiceBox;
	private JPanel workoutNumber, choice, choicePanel;
	private SportLabel uName;
	private Image background;
	private User u;
	
	
	
	public  FriendGraphPanel() {
		
	}
	public  FriendGraphPanel(User user,User u) {
		
		this.u=u;
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		this.wm2 = new WorkoutManager(this.u);
		
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
	
	public void initGraphPanel()
	{	
		graphPanel.setLayout(new BorderLayout());

		graphPanel.add(new SwimmingSummaryBar(wm.getWorkoutList(5)), BorderLayout.CENTER);
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

	public void initGraphChoice()
	{	
		
		title = new SportLabel( user.getFirstname()+"VS"+u.getFirstname());
		title.setFont(new Font("Verdana", Font.BOLD, 14));
		title.setPreferredSize(new Dimension(200, 80));
		
		choicePanel = new JPanel();
		choicePanel.setBackground(new Color(28, 28, 28));
		choicePanel.setLayout(new FlowLayout());
		
		choice = new JPanel();
		choice.setLayout(new GridLayout(2, 1));
		choice.setBackground(new Color(28, 28, 28));
		choice.add(new SportLabel("Consulter : "));
		String[] choices = {"Résumé", "Repartition"};
		choiceBox = new SportComboBox(choices);
		choice.add(choiceBox);
		
		workoutNumber = new JPanel();
		workoutNumber.setLayout(new GridLayout(2, 1));
		workoutNumber.setBackground(new Color(28, 28, 28));
		workoutNumber.add(new SportLabel("Visualiser : "));
		
		String same[]=sameWorkout();
		System.out.println(same.length);
		String[] types =new String[same.length];
		for(int i=0;i<same.length;i++) {
			if(!same[i].isEmpty()) {
				types[i]=same[i];
			}
		}
		workoutNumberBox = new SportComboBox(types);
		workoutNumber.add(workoutNumberBox);


		choicePanel.add(choice);
		choicePanel.add(workoutNumber);
		
		footer = new JPanel();
		footer.setBackground(new Color(28, 28, 28));
		footer.setLayout(new FlowLayout());
		footer.setPreferredSize(new Dimension(200, 80));
		displayButton = new SportButton("Afficher");
		footer.add(displayButton);
		
		displayButton.addActionListener(new ButtonListener());

		graphChoice.add(title, BorderLayout.NORTH);
		graphChoice.add(choicePanel, BorderLayout.CENTER);
		graphChoice.add(footer, BorderLayout.SOUTH);

	}
	
	public String[] sameWorkout() {
		UserManager find =new UserManager();
		
		 ArrayList<User> listFriends1=find.findUsersFromSport(1);
		 ArrayList<User> listFriends2=find.findUsersFromSport(2);
		 ArrayList<User> listFriends3=find.findUsersFromSport(3);
		 ArrayList<User> listFriends4=find.findUsersFromSport(4);
		 ArrayList<User> listFriends5=find.findUsersFromSport(6);
		 ArrayList<User> listFriends6=find.findUsersFromSport(5);
		
		
		
		@SuppressWarnings("unused")
		String a1 = " ",a2=" ",a3=" ",a4=" ",a5=" ",a6=" ";
		int u1=0,u2=0,u3=0,u4=0,u5=0,u6=0,u7=0,u8=0,u9=0,u10=0,u11=0,u12=0;
		for(int i=0;i<listFriends6.size();i++) {
			
			if(!listFriends6.isEmpty()) {
					User uv= (User) listFriends6.get(i);
					if(uv.getFirstname().equals(user.getFirstname())) {
						u1=1;
					}
					
					if(uv.getFirstname().equals(u.getFirstname())) {
						u2=1;
					}
				}
				
		}
		if(u1!=0&&u2!=0) {
			a5="Natation";
			u1=0;
			u2=0;
		}
		
		if(!listFriends1.isEmpty()) {
				for(int i=0;i<listFriends1.size();i++) {
					User uv= (User) listFriends1.get(i);
					if(uv.getFirstname().equals(user.getFirstname())) {
						u3=1;
					}
					
					if(uv.getFirstname().equals(u.getFirstname())) {
						u4=1;
					}
				}
			
		}
		if(u3!=0&u4!=0) {
			a1="Jogging";
			u3=0;
			u4=0;
		}
		
		if(!listFriends2.isEmpty()) {
				for(int i=0;i<listFriends2.size();i++) {
					User uv= (User) listFriends2.get(i);
					if(uv.getFirstname().equals(user.getFirstname())) {
						u5=1;
					}
					
					if(uv.getFirstname().equals(u.getFirstname())) {
						u6=1;
					}
				}
				
		}
		if(u5!=0&u6!=0) {
			a2="Escalade";
			u5=0;
			u6=0;
		}
		
		if(!listFriends3.isEmpty()) {
				for(int i=0;i<listFriends3.size();i++) {
					User uv= (User) listFriends3.get(i);
					if(uv.getFirstname().equals(user.getFirstname())) {
						u7=1;
					}
					
					if(uv.getFirstname().equals(u.getFirstname())) {
						u8=1;
					}
					
				}
				
		}
		if(u7!=0&u8!=0) {
			a3="Aviron";
			u7=0;
			u8=0;
		}
		
		if(!listFriends4.isEmpty()) {
				for(int i=0;i<listFriends4.size();i++) {
					User uv= (User) listFriends4.get(i);
					if(uv.getFirstname().equals(user.getFirstname())) {
						u9=1;
					}
					
					if(uv.getFirstname().equals(u.getFirstname())) {
						u10=1;
					}
					
				}
		}
		if(u9!=0&u10!=0) {
			a4="musculation";
			u9=0;
			u10=0;
		}
		
		
		if(!listFriends5.isEmpty()) {
				for(int i=0;i<listFriends5.size();i++) {
					User uv= (User) listFriends5.get(i);
					if(uv.getFirstname().equals(user.getFirstname())) {
						u11=1;
					}
					
					if(uv.getFirstname().equals(u.getFirstname())) {
						u12=1;
					}
					
				}
		}
		if(u11!=0&u12!=0) {
			a6=" Tir à l'arc";
			u11=0;
			u12=0;
		}
		
		String a[]= {a1,a2,a3,a4,a5,a6};
		
		return a;
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
				graphPanel.removeAll();
				
				if(choiceBox.getSelectedIndex() == 0)
					graphPanel.add(new FriendSummaryBar(wm.getWorkoutList(5),wm2.getWorkoutList(5)),BorderLayout.CENTER);
				else if(choiceBox.getSelectedIndex() == 1)
					graphPanel.add(new  FriendPieChart (wm.getWorkoutList(5),wm2.getWorkoutList(5)), BorderLayout.CENTER);

				graphPanel.revalidate();
			}
			else if(e.getSource() == returnButton)
			{
				MainFrame.getGlobal().removeAll();
				MainFrame.getGlobal().add(new FriendsPanel(user));
				MainFrame.getGlobal().revalidate();
				MainFrame.getGlobal().repaint();
			}
			else if(e.getSource() == deconnexionButton)
				close();
		}
	}
	
	
	
}
