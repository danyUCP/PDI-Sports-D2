package trash;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ModificationJoggingWindow extends JFrame {
			


			/**
			 * 
			 * @author PDI_D2
			 *
			 */



				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				private ModificationJoggingPanel contentPane;
				private JLabel Label_inbox;
				private JTextField mesure1text=new JTextField("");//padlle strokes
				private JTextField mesure2text=new JTextField("");//distance
				private JTextField mesure3text=new JTextField("");//duration
	
				private JLabel messagelabel;
				
				/**
				 * Launch the application.
				 */


				/**
				 * Create the frame.
				 */
					
				
			
				public ModificationJoggingWindow(){
					
				
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 858, 496);
					contentPane = new ModificationJoggingPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(null);
					
		
			
					Label_inbox = new JLabel("Alexander BUBB");
					Label_inbox.setFont(new Font("Times New Roman", Font.ITALIC, 14));
					Label_inbox.setHorizontalAlignment(SwingConstants.CENTER);
					Label_inbox.setBounds(110, 10, 208, 37);
					
					
					messagelabel=new JLabel("");
					messagelabel.setBounds(151, 251, 100, 30);
					contentPane.add(messagelabel);

					
					DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
					Session session = orm.DBConnection.getSession();
					Transaction readTransaction = session.beginTransaction();
					
		
					
			        
					
					
					
			  			 
					contentPane.setVisible(true);
					
					/**
					 * 
					 */



					
					
				}
				
				/**
				 * Create ActionListener
				 *
				 */
				
			
				/**
				 * Create ActionListener
				 *
				 */
				public class ActionBoutton2 implements ActionListener {

					@Override
					public void actionPerformed(ActionEvent e) {
					
						   settext("choice canceled");
						
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
				
				
				
				
				public static void main(String[] args) {
					ModificationJoggingWindow frame = new ModificationJoggingWindow();
					frame.setVisible(true);
				}
				

}