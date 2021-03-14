package ihm;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;




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
			private ClimbingPanel contentPane= new ClimbingPanel();
			
			private JLabel Label_inbox;
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
			

				Label_inbox = new JLabel("Alexander BUBB");
				Label_inbox.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				Label_inbox.setHorizontalAlignment(SwingConstants.CENTER);
				Label_inbox.setBounds(110, 10, 208, 37);
		
                

				
				
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
				ClimbingWindow frame = new ClimbingWindow();
				frame.setVisible(true);
			}

}