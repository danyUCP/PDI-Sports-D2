package ihm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;



import org.jfree.ui.RefineryUtilities;

import data.User;
import graph.Compare;
import manager.UserManager;
import manager.WorkoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JList;


/**
 * 
 * @author PD2_Sport
 *
 */
public class FriendsPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension dim;
	private int width = 845;
	private int height = 460;
	private Image background;
	JButton btnOK, addFriend,btnSupprimer,btnComparer;
	JLabel graphLabel,lblNewLabel;
	String listElem[]= {}; 
	JPanel friends,friends_1;
	@SuppressWarnings("rawtypes")
	JList list;

	/**
	 * Create the panel.
	 */
	
	public FriendsPanel() {
		
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(Color.ORANGE);
		setLayout(null);
		
     /**
      * the JList object with its elements
      */
					UserManager m=new UserManager();
					User[] use=m.userFriends();
					listElem=new String[use.length];
					for(int i=0;i<use.length;i++) {
						if(use[i]!=null) {
							listElem[i]=use[i].getFirstname();
						}
					}
	
    	list = new JList(listElem);
    	list.setOpaque(false);
    	list.setBackground(new Color(28, 28, 28));
       list.setForeground(Color.WHITE);
       list.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
    	friends=new JPanel();
    	friends.setLayout(new BorderLayout( ));
    	friends.setBounds(75, 34, 317, 405);
    	friends.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    	friends.setBackground(new Color(28, 28, 28));
    	
		/**
		 * Adding the JList in a JScrollPane
		 */
        JScrollPane pane = new JScrollPane(list);
        pane.setOpaque(false);
        pane.getViewport().setOpaque(false);
        
        
        btnOK = new JButton("Cliquez Ici");
        btnOK .setBorder(new LineBorder(Color.CYAN, 3));
        btnOK .setBackground(Color.BLACK);
        btnOK .setForeground(Color.WHITE);
        
   
        friends.add(pane, BorderLayout.CENTER);
        friends.add(btnOK, BorderLayout.SOUTH);
		add(friends);
		
		graphLabel = new JLabel("Cliquer sur un nom pour voir les détails");
		graphLabel.setBounds(10, 53, 375, 311);
		graphLabel.setHorizontalAlignment(SwingConstants.CENTER);
		graphLabel.setForeground(Color.WHITE);
		graphLabel.setBackground(Color.WHITE);
		
		friends_1 = new JPanel();
		friends_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		friends_1.setBackground(new Color(28, 28, 28));
		friends_1.setBounds(397, 34, 395, 405);
		add(friends_1);
		friends_1.add(graphLabel);
		friends_1.setLayout(null);
		
		addFriend = new JButton("Ajouter");
		addFriend.setBorder(new LineBorder(Color.CYAN, 3));
		addFriend.setBackground(Color.BLACK);
		addFriend.setForeground(Color.WHITE);
		addFriend.setBounds(60, 374, 85, 21);
		friends_1.add(addFriend);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBorder(new LineBorder(Color.CYAN, 3));
		btnSupprimer.setBackground(Color.BLACK);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBounds(163, 374, 85, 21);
		friends_1.add(btnSupprimer);
		
		btnComparer = new JButton("Comparer");
		btnComparer.setBorder(new LineBorder(Color.CYAN, 3));
		btnComparer.setBackground(Color.BLACK);
		btnComparer.setForeground(Color.WHITE);
		btnComparer.setBounds(273, 374, 85, 21);
		friends_1.add(btnComparer);
		
		lblNewLabel = new JLabel("Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(60, 22, 279, 21);
		friends_1.add(lblNewLabel);
		
		JLabel regi = new JLabel("");
		regi.setIcon(new ImageIcon("resources/images/backImage.jpg"));
		regi.setBounds(176, 0, 658, 459);
		this.add(regi);
	
		
		addFriend.addActionListener(new ActionFriends());
		btnSupprimer.addActionListener(new ActionFriends());
		btnComparer.addActionListener(new ActionFriends());
		btnOK.addActionListener(new ActionFriends());

		

	}

	
	private class ActionFriends implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{			
				if(e.getSource() == addFriend) {
					
				}
				else if(e.getSource() == btnSupprimer) {
					
				}
				else if(e.getSource() == btnComparer) {
					Compare demo = new Compare( "VS" );  
				      demo.setBounds(30, 300, 375, 311);
				      demo.setBackground(new Color(28, 28, 28));
				      //demo.setUndecorated(true);
				      RefineryUtilities.centerFrameOnScreen( demo );    
				      demo.setVisible( true );
					
				}
				else if(e.getSource() == btnOK) {
					if(!list.isSelectionEmpty())
			   		{
						UserManager m=new UserManager();
						User[] use=m.userFriends();
						for(int i=0;i<use.length;i++) {
							if(use[i]!=null) {
								if(use[i].getFirstname().equals(list.getSelectedValue())) {
									String log=use[i].getLogin();
									String mdp=use[i].getMdp();
									System.out.println(log+mdp);
									UserManager um = new UserManager();
									User u1 = um.findUser(log, mdp);
									WorkoutManager wm = new WorkoutManager(u1);
									String sport=getUserWorkoutList(wm);
									graphLabel.setFont(new Font("Verdana", Font.BOLD,12));
									graphLabel.setVerticalAlignment(SwingConstants.NORTH);
									graphLabel.setHorizontalAlignment(SwingConstants.LEFT);
									graphLabel.setText("<html><body><p>Nom: "+use[i].getLastname()+ "</p>"+
									    	 "<br/> <p>Prénom:"+ use[i].getFirstname()+"</p>"+
									    	 			"<p> Sexe: "+use[i].getGender()+"</p>"+
									    	 			"<p> Age: "+use[i].getAge()+" ans </p>"+
									    	 			"<p> Taille: "+use[i].getSize()+"</p>"+
									    	 			"<p> Poids: "+use[i].getWeight()+" kg</p>"+
									    	 			"<p> Sports en commun: "+sport+"</p>"+
									    	 			"<p> Statut: Ami/non "+"</p>"+
														"</body></html>");
									
								}
							}
						}
						
			   		}
			     }
				}

		private String getUserWorkoutList(WorkoutManager wm) {
			String name=" ";
			
			if(!wm.getWorkoutList(1).isEmpty()) {
				name+="JoggingWorkout"+" | ";
			}
			if(!wm.getWorkoutList(2).isEmpty()) {
				name+="ClimbingWorkout"+" | ";
			}
			if(!wm.getWorkoutList(3).isEmpty()) {
				name+="RowingWorkout"+" | ";
			}
			if(!wm.getWorkoutList(4).isEmpty()) {
				name+="MusculationWorkout"+" | ";
			}
			if(!wm.getWorkoutList(5).isEmpty()) {
				name+="SwimmingWorkout"+" | ";
			}
			if(!wm.getWorkoutList(6).isEmpty()) {
				name+="ArcheryWorkout"+" | ";
			}
					
					return name;
				}
		}
	

}
