package ihm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * 
 * @author PDI_D2
 *
 */

public class Inbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel_white;
	private JLabel Label_inbox, Background;
	private JButton Button1, Button2, Button3, Button4, Button5, Button6;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		Inbox frame = new Inbox();
		frame.setUndecorated(true);
		frame.setVisible(true);
	}*/

	/**
	 * Create the frame.
	 */
	public Inbox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_white = new JPanel();
		panel_white.setBounds(102, 10, 415, 425);
		panel_white.setBackground(Color.WHITE);
		contentPane.add(panel_white);
		panel_white.setLayout(null);
		
		Label_inbox = new JLabel("INBOX");
		Label_inbox.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		Label_inbox.setHorizontalAlignment(SwingConstants.CENTER);
		Label_inbox.setBounds(110, 10, 208, 37);
		panel_white.add(Label_inbox);
		
		
		Button4 = new JButton("Itineraire");
		Button4.setBackground(Color.WHITE);
		Button4.setIcon(new ImageIcon(Inbox.class.getResource("/images/placeholder-filled-point.png")));
		Button4.setBounds(227, 198, 163, 93);
		panel_white.add(Button4);
		
		Button3 = new JButton("Recherche");
		Button3.setBackground(Color.WHITE);
		Button3.setIcon(new ImageIcon(Inbox.class.getResource("/images/increase.png")));
		Button3.setBounds(21, 198, 163, 93);
		panel_white.add(Button3);
		
		Button1 = new JButton("Graphe");
		Button1.setIcon(new ImageIcon(Inbox.class.getResource("/images/three-bars-graph.png")));
		Button1.setBackground(Color.WHITE);
		Button1.setBounds(21, 95, 163, 93);
		panel_white.add(Button1);
		
		Button2 = new JButton("Amis");
		Button2.setIcon(new ImageIcon(Inbox.class.getResource("/images/users-group.png")));
		Button2.setBackground(Color.WHITE);
		Button2.setBounds(227, 95, 163, 93);
		panel_white.add(Button2);
		
		Button5 = new JButton("D\u00E9connexion");
		Button5.setIcon(new ImageIcon(Inbox.class.getResource("/images/login(1).png")));
		Button5.setBackground(Color.WHITE);
		Button5.setBounds(21, 301, 163, 93);
		panel_white.add(Button5);
		
		Button6 = new JButton("Meilleur score");
		Button6.setIcon(new ImageIcon(Inbox.class.getResource("/images/winner-runner-arriving-to-end-line.png")));
		Button6.setBackground(Color.WHITE);
		Button6.setBounds(227, 301, 163, 93);
		panel_white.add(Button6);
		
		Background = new JLabel("");
		Background.setIcon(new ImageIcon(Inbox.class.getResource("/images/SportI.jpg")));
		Background.setBounds(0, 0, 642, 455);
		contentPane.add(Background);
		
		
		/**
		 * 
		 */
		Button1.addActionListener(new ActionBoutton1());
		Button2.addActionListener(new ActionBoutton2());
		Button3.addActionListener(new ActionBoutton3());
		Button4.addActionListener(new ActionBoutton4());
		Button5.addActionListener(new ActionBoutton5());
		Button6.addActionListener(new ActionBoutton6());
		
	}
	
	
	/**
	 * Create ActionListener
	 *
	 */
	public class ActionBoutton1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Vous avez cliquer sur graphe");
			
		}
		  
	}
	
	public class ActionBoutton2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Vous avez cliquer sur Amis");
			
		}
		  
	}
	
	public class ActionBoutton3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Vous avez cliquer sur recherche");
			
		}
		  
	}
	
	public class ActionBoutton4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Vous avez cliquer sur itinéraire");
			
		}
		  
	}
	
	public class ActionBoutton5 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int retour = JOptionPane.showOptionDialog(null, 
                    "Voulez-vous vraiment vous déconnecter?", 
                    "Erreur", 
                    //JOptionPane yes no
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.ERROR_MESSAGE, 
                    null, null, null);
			if(retour==0) {
				dispose();
			}
			
			
		}
		  
	}
	
	public class ActionBoutton6 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Vous avez cliquer sur meilleur");
			
		}
		  
	}
	
	
	
}
