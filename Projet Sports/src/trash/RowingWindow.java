package trash;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ihm.sport_panels.RowingPanel;


public class RowingWindow  extends JFrame {
		


		/**
		 * 
		 * @author PDI_D2
		 *
		 */



			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private RowingPanel contentPane;
			private JLabel Label_inbox;
			private JLabel messagelabel;
		
			
			
			/**
			 * Launch the application.
			 */


			/**
			 * Create the frame.
			 */
			
		//	private Dashboard dashboard = new Dashboard();
			
			public RowingWindow(){
				
			
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 858, 496);
				contentPane = new RowingPanel(null);
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
				RowingWindow frame = new RowingWindow();
				frame.setVisible(true);
			}



}
