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
import graph.SwimmingSummaryBar;
import manager.UserManager;
import manager.WorkoutManager;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
	JButton btnOK, addFriend,btnSupprimer,btnComparer,btnReturn;
	JLabel graphLabel,lblNewLabel;
	String listElem[]= {}; 
	JPanel friends,friends_1, south;
	private WorkoutManager wm;
	User use;
	int mode;
	@SuppressWarnings("rawtypes")
	JList list;

	/**
	 * Create the panel.
	 */
	

	public FriendsPanel(User use) {
		
		this.use = use;
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(Color.ORANGE);
		setLayout(null);
		
     /**
      * the JList object with its elements
      */
					UserManager m=new UserManager();
					User[] user=m.userFriends(use);
					listElem=new String[user.length];
					for(int i=0;i<user.length;i++) {
						if(user[i]!=null&!user[i].getLogin().equals(use.getFirstname())) {
							listElem[i]=user[i].getFirstname();
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
        btnOK .setBounds(60, 374, 85, 21);
        
        btnReturn = new JButton("Retour");
        btnReturn.setSize(85, 21);
        btnReturn .setBorder(new LineBorder(Color.CYAN, 3));
        btnReturn .setBackground(Color.BLACK);
        btnReturn .setForeground(Color.WHITE);

	    south = new JPanel();
	    south.setBackground(Color.WHITE);
	    south.setBackground(new Color(28, 28, 28));
	    south.add(btnOK);
	    south.add(btnReturn);
	    friends.add(south, BorderLayout.SOUTH);
	    
        friends.add(pane, BorderLayout.CENTER);
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
		
		
		addFriend.addActionListener(new ActionFriends());
		btnSupprimer.addActionListener(new ActionFriends());
		btnComparer.addActionListener(new ActionFriends());
		btnOK.addActionListener(new ActionFriends());
		btnReturn.addActionListener(new ActionFriends());

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

	
	private class ActionFriends implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{			
				if(e.getSource() == addFriend) {
					
				}
				else if(e.getSource() == btnSupprimer) {
					
				}
				else if(e.getSource() == btnComparer) {
					//Compare demo = new Compare( "VS" );  
				     // demo.setBounds(30, 300, 375, 311);
				      //demo.setBackground(new Color(28, 28, 28));
				      //demo.setUndecorated(true);
				      //RefineryUtilities.centerFrameOnScreen( demo );    
				      //demo.setVisible( true );
					//friends_1.add(new SwimmingSummaryBar(wm.getWorkoutList(5)), BorderLayout.CENTER);
					
					MainFrame.getGlobal().add(new SwimmingGraphPanel(use));
					/*switch(mode)
					{
						case 1:
						    MainFrame.getGlobal().add(new JoggingGraphPanel(use));
							break;
						case 2:
							MainFrame.getGlobal().add(new ClimbingGraphPanel(use));
							break;
						case 3:
							MainFrame.getGlobal().add(new RowingGraphPanel(use));
							break;
						case 4:
							MainFrame.getGlobal().add(new MusculationGraphPanel(use));
							break;
						case 5:
							MainFrame.getGlobal().add(new SwimmingGraphPanel(use));
							break;
						case 6:
							MainFrame.getGlobal().add(new ArcheryGraphPanel(use));
							break;
					}*/
					
				}
				else if(e.getSource() == btnOK) {
					if(!list.isSelectionEmpty())
			   		{
						UserManager m=new UserManager();
						User[] user=m.userFriends(use);
						for(int i=0;i<user.length;i++) {
							if(user[i]!=null) {
								if(user[i].getFirstname().equals(list.getSelectedValue())) {
									String log=user[i].getLogin();
									String mdp=user[i].getMdp();
									System.out.println(log+mdp);
									UserManager um = new UserManager();
									User u1 = um.findUser(log, mdp);
									WorkoutManager wm = new WorkoutManager(u1);
									String sport=getUserWorkoutList(wm);
									graphLabel.setFont(new Font("Verdana", Font.BOLD,12));
									graphLabel.setVerticalAlignment(SwingConstants.NORTH);
									graphLabel.setHorizontalAlignment(SwingConstants.LEFT);
									graphLabel.setText("<html><body><p>Nom: "+user[i].getLastname()+ "</p>"+
									    	 "<br/> <p>Prénom:"+ user[i].getFirstname()+"</p>"+
									    	 			"<p> Sexe: "+user[i].getGender()+"</p>"+
									    	 			"<p> Age: "+user[i].getAge()+" ans </p>"+
									    	 			"<p> Taille: "+user[i].getSize()+"</p>"+
									    	 			"<p> Poids: "+user[i].getWeight()+" kg</p>"+
									    	 			"<p> Sports en commun: "+sport+"</p>"+
									    	 			"<p> Statut: Ami/non "+"</p>"+
														"</body></html>");
									
								}
							}
						}
						
			   		}
			     }
				else if(e.getSource() == btnReturn) {
					System.out.println(use);
					new HomePanel(use);
					//MainFrame.getGlobal().add(new HomePanel(use));
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
