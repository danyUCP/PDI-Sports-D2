package ihm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import graph.Compare;

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
import java.util.Iterator;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class Friends extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension dim;
	private int width = 845;
	private int height = 460;
	private Image background;
	JButton btnOK, addFriend,btnSupprimer,btnComparer;
	JLabel graphLabel;
	String listElem[] = { "Ami1","Ami2","Ami3","Ami4"
            ,"Ami5","Ami6","Ami7"};
	@SuppressWarnings("rawtypes")
	JList list;

	/**
	 * Create the panel.
	 */
	
	public Friends() {
		
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(Color.ORANGE);
		setLayout(null);
		
     /**
      * the JList object with its elements
      */
    	list = new JList(listElem);
    	list.setOpaque(false);
    	list.setBackground(new Color(28, 28, 28));
       list.setForeground(Color.WHITE);
       list.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
    	JPanel friends=new JPanel();
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
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	     

	  	Session session = data.DBConnection.getSession();
	      
	      Transaction readTransaction = session.beginTransaction();
	    	//List result1 = session.createQuery("select swimmingworkout.user_id from SwimmingWorkout swimmingworkout where user_id=2 ").list();
	      List result1 = session.createQuery("select swimmingworkout.breaststroke_lenghts from SwimmingWorkout swimmingworkout").list();
	  		//List result = session.createQuery("select swimmingworkout.user_id from SwimmingWorkout swimmingworkout").list();
	  		Iterator iterator = result1.iterator();
	  		
	  		while (iterator.hasNext()) {
	  			int j = (int) iterator.next();
	  			System.out.println(" "+j+" \n");
	  		}
	  		readTransaction.commit();
        
        btnOK = new JButton("Cliquez Ici");
        btnOK .setBorder(new LineBorder(Color.CYAN, 3));
        btnOK .setBackground(Color.BLACK);
        btnOK .setForeground(Color.WHITE);
   
        friends.add(pane, BorderLayout.CENTER);
        friends.add(btnOK, BorderLayout.SOUTH);
		add(friends);
		
		graphLabel = new JLabel("ICI");
		graphLabel.setBounds(10, 53, 375, 311);
		graphLabel.setHorizontalAlignment(SwingConstants.CENTER);
		graphLabel.setForeground(Color.WHITE);
		graphLabel.setBackground(Color.WHITE);
		
		JPanel friends_1 = new JPanel();
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
		
		JLabel lblNewLabel = new JLabel("Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(60, 22, 279, 21);
		friends_1.add(lblNewLabel);
		
		//btnOK.addActionListener(new ActionFriends());
		
		addFriend.addActionListener(new ActionFriends());
		btnSupprimer.addActionListener(new ActionFriends());
		btnComparer.addActionListener(new ActionFriends());
		btnOK.addActionListener(new ActionListener()
   	 {
   public void actionPerformed(ActionEvent e)
   	{
   		if(!list.isSelectionEmpty())
   		{
   			// Display the selected element when the button is clicked
   			//graphLabel.setBackground(Color.GREEN);//setText((String) list.getSelectedValue());
   			System.out.println(list.getSelectedValue());
   			JOptionPane.showMessageDialog(null, list.getSelectedValue());
   		}
     }
});
		
		
		
		try
		{
			background = ImageIO.read(new File("resources/images/backImage.jpg"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		

	}
	
	public void changeLabel() {
		//if(!list.isSelectionEmpty())
		//{
			//graphLabel.setBackground(Color.GREEN);//setText((String) list.getSelectedValue());
			if(!list.isSelectionEmpty())
    		{
    			// Afficher l'élément sélectionné quand on clique sur le bouton
				System.out.println(list.getSelectedValue());
    			JOptionPane.showMessageDialog(null, list.getSelectedValue());
    		}
		//}
	   }
	
	private class ActionFriends implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{		
				Friends f=new Friends();
				f.changeLabel();	
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
