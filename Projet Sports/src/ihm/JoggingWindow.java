package ihm;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.JoggingWorkout;
import data.User;
import data.Workout;
import orm.DBConnection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;




public class JoggingWindow  extends JFrame {
		


		/**
		 * 
		 * @author PDI_D2
		 *
		 */



			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JoggingPanel contentPane, panel_white;
			private JLabel Label_inbox, Background;
			private JTextField mesure1text=new JTextField("");
			private JTextField mesure2text=new JTextField("");
		/*	private JButton  Button1;
			private JButton Button2;
			private JLabel durationlabel;
			private JLabel distancelabel;
			private JLabel messagelabel;
			*/
		/*	private RowingPanel control = new RowingPanel();
			private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
			private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(900, 650);
		*/
			/**
			 * Launch the application.
			 */


			/**
			 * Create the frame.
			 */
			
			//private Dashboard dashboard = new Dashboard();
			
			public JoggingWindow(){
				
			
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 646, 482);
				contentPane = new JoggingPanel(null);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);

				Label_inbox = new JLabel("Alexander BUBB");
				Label_inbox.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				Label_inbox.setHorizontalAlignment(SwingConstants.CENTER);
				Label_inbox.setBounds(110, 10, 208, 37);
		
				
			
				/**
				 * 
				 */



				
				
			}
			
	     
			/**
			 * Create ActionListener
			 *
			 */
			
		/*	public class ActionBoutton1 implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					String text1=mesure1text.getText();
					String text2=mesure2text.getText();
					if(!text1.equals("") && !text2.equals("")) {
				    
						
						if ((text1.length() > 0)&&(text2.length()>0)){
							try {
					int m2 = Integer.parseInt(text1);
					int m1 = Integer.parseInt(text2);
					
					Session session = DBConnection.getSession();
					Transaction persistTransaction1 = session.beginTransaction();
					Date date=new Date(0);	
					
					User u1 = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
					session.save(u1);
			   
					Workout w=new JoggingWorkout(date,m2,m1);
					w.setUser(u1);
					session.save(w);
					
					persistTransaction1.commit();
					session.close();
							} catch (NumberFormatException nfe) {
						        settext("Erreur de format");
								   
							    
						    }
							
							}else {
						      settext("Un paramètre est requis");
						}
				
					}else {
					
						
						settext("Veuillez remplir tout les champs");	
						
					}
				}
				  
			}
			
			*/
			/**
			 * Create ActionListener
			 *
			 */
		/*	
	 		public class ActionBoutton2 implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
				
					messagelabel.setText("choice canceled");
					
				}
				  
			}
			
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
				

			*/
			public static void main(String[] args) {
				JoggingWindow frame = new JoggingWindow();
				frame.setVisible(true);
			}
			

}
