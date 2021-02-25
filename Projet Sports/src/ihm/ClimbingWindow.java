package ihm;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.ClimbingWorkout;
import data.DBConnection;

import data.User;
import data.Workout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;



public class ClimbingWindow  extends JFrame {
		


		/**
		 * 
		 * @author PDI_D2
		 *
		 */



			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private ClimbingPanel contentPane;
			private JLabel Label_inbox;
			private JTextField mesure1text=new JTextField("");
			private JTextField mesure2text=new JTextField("");
			private JLabel messagelabel;
		
			/**
			 * Launch the application.
			 */


			/**
			 * Create the frame.
			 */
			
			public ClimbingWindow(){
				
			
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 646, 482);
				contentPane = new ClimbingPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				Label_inbox = new JLabel("Alexander BUBB");
				Label_inbox.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				Label_inbox.setHorizontalAlignment(SwingConstants.CENTER);
				Label_inbox.setBounds(110, 10, 208, 37);



				
				
			}
			
			
			/**
			 * Create ActionListener
			 *
			 */
			/*
			public class ActionBoutton1 implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					String text1=mesure1text.getText();
					String text2=mesure2text.getText();
					if(!text1.equals("") && !text2.equals("")) {
				    
						
						if ((text1.length() > 0)&&(text2.length()>0)){
							try {
					int m2 = Integer.parseInt(text1);
				
					
					Session session = DBConnection.getSession();
					Transaction persistTransaction1 = session.beginTransaction();
					Date date=new Date(0);	
					
					User u1 = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
					session.save(u1);
			   
					Workout w=new ClimbingWorkout(date,m2,text1);
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
				

			
			public static void main(String[] args) {
				ClimbingWindow frame = new ClimbingWindow();
				frame.setVisible(true);
			}
			

}