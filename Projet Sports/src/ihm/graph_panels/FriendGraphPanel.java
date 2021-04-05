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
		getUnionWorkout(u,user);
		String[] types = {"Toutes séances", "1 séance", "5 séances", "10 séances"};
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
	
	@SuppressWarnings({ "null", "unlikely-arg-type" })
	public String[] getUnionWorkout(User u1,User u2) {
		UserManager m=new UserManager();
		String[] list1= {},liste2= {},liste3= {},liste4= {},liste5= {},liste6= {};
		
		ArrayList<User> result=m.findUsersFromSport(1);
		ArrayList<User> result2=m.findUsersFromSport(2);
		ArrayList<User> result3=m.findUsersFromSport(3);
		ArrayList<User> result4=m.findUsersFromSport(4);
		ArrayList<User> result5=m.findUsersFromSport(5);
		ArrayList<User> result6=m.findUsersFromSport(6);
		
		System.out.println("taille des arrayliste: "+result.size()+result2.size()+result3.size()+result4.size()+result5.size()+result6.size());
	
		for(int i=0;i<result.size();i++) {
			System.out.println("les sports"+result.get(i));
			if(result.contains(u1.getFirstname())||result.get(i)==u2) {
				System.out.println("yes");
			}
		}
		if(result.contains(u1))
			System.out.println("yes");
		if(result.contains(u1)&&result.contains(u2)) {
			list1= new String[]{"Jogging"};
			System.out.println("longeur liste1: "+list1.length );
		}
		if(result2.contains(u1)&&result2.contains(u2)) {
			liste2= new String[]{"Escalade"};
			System.out.println("longeur liste2: "+list1.length );
		}
		if(result3.contains(u1)&&result3.contains(u2)) {
			liste3= new String[]{"Aviron"};
			System.out.println("longeur liste3: "+list1.length );
		}
		if(result4.contains(u1)&&result4.contains(u2)) {
			liste4= new String[]{"Musculation"};
			System.out.println("longeur liste4: "+list1.length );
		}
		if(result5.contains(u1)&&result5.contains(u2)) {
			liste5=new String[] {"Natation"};
			System.out.println("longeur liste5: "+list1.length );
		}
		if(result6.contains(u1)&&result6.contains(u2)) {
			liste6=new String[] {"Tir à l'arc"};
			System.out.println("longeur liste6: "+list1.length );
		}
		
		int len = list1.length + liste2.length+ liste3.length+ liste4.length+liste5.length+ liste6.length;
		System.out.println("total longeur: "+len);
		String[] total=new String[len];
		
		int position = 0;
		
		if( list1!=null) {
			for (String object :  list1)
	        {
				total[position] = object;
	            position++;
	        }
		}
		
		if( liste2!=null) {
			for (String object :  liste2)
	        {
				total[position] = object;
	            position++;
	        }
		}
		
		if( liste3!=null) {
			for (String object :  liste3)
	        {
				total[position] = object;
	            position++;
	        }
		}
		
		if( liste4!=null) {
			for (String object :  liste4)
	        {
				total[position] = object;
	            position++;
	        }
		}
		
		if( liste5!=null) {
			for (String object :  liste5)
	        {
				total[position] = object;
	            position++;
	        }
		}
		
		if( liste6!=null) {
			for (String object :  liste6)
	        {
				total[position] = object;
	            position++;
	        }
		}
		
		for(int k=0;k<total.length;k++) {
			System.out.println(total[k]);
		}		
		
		return total;
	}
	
}
