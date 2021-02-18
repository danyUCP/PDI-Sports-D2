package ihm;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.ui.RefineryUtilities;

import data.DBConnection;
import data.JoggingWorkout;
import data.RowingWorkout;
import data.User;
import data.Workout;
import graph.LineChartJogging;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;




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
			private JPanel contentPane, panel_white;
			private JLabel Label_inbox, Background;
			private JTextField mesure1text=new JTextField("");//padlle strokes
			private JTextField mesure2text=new JTextField("");//distance
			private JTextField mesure3text=new JTextField("");//duration
			private JButton  Button1=new JButton("add workout");
			private JButton Button2=new JButton("show data");
			private JLabel durationlabel;
			private JLabel distancelabel;
			private JLabel messagelabel;
			
			/**
			 * Launch the application.
			 */


			/**
			 * Create the frame.
			 */
			
			private Dashboard dashboard = new Dashboard();
			
			public RowingWindow(){
				
			
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
				
				Label_inbox = new JLabel("Alexander BUBB");
				Label_inbox.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				Label_inbox.setHorizontalAlignment(SwingConstants.CENTER);
				Label_inbox.setBounds(110, 10, 208, 37);
				panel_white.add(Label_inbox);
				
				mesure1text=new JTextField("");
				mesure1text.setBounds(51, 101, 100, 30);
				panel_white.add(mesure1text);
				
				durationlabel=new JLabel("paddle_strokes");
				durationlabel.setBounds(151, 101, 100, 30);
				panel_white.add(durationlabel);
				
				mesure2text=new JTextField("");
				mesure2text.setBounds(51, 161, 100, 30);
				panel_white.add(mesure2text);
				
				distancelabel=new JLabel("distance");
				distancelabel.setBounds(151, 161, 100, 30);
				panel_white.add(distancelabel);

				mesure3text=new JTextField("");
				mesure3text.setBounds(51, 161, 100, 30);
				panel_white.add(mesure3text);
				
				durationlabel=new JLabel("duration");
				durationlabel.setBounds(151, 201, 100, 30);
				panel_white.add(durationlabel);
				
				
				messagelabel=new JLabel("");
				messagelabel.setBounds(151, 251, 100, 30);
				panel_white.add(messagelabel);
				
				mesure3text=new JTextField("");
				mesure3text.setBounds(51, 201, 100, 30);
				panel_white.add(mesure3text);
				
				

				Button1 = new JButton("Valid");
		
				
				Button1.setBackground(Color.WHITE);
				Button1.setBounds(21, 301, 120, 50);
				Button1.addActionListener(new ActionBoutton1());
				panel_white.add(Button1);
				
				Button2 = new JButton("Cancel");

				Button2.setBackground(Color.WHITE);
				Button2.setBounds(227, 301, 120, 50);
				Button2.addActionListener(new ActionBoutton2());
				panel_white.add(Button2);
				
				Background = new JLabel("");
				Background.setIcon(new ImageIcon(Inbox.class.getResource("/images/SportI.jpg")));
				Background.setBounds(0, 0, 642, 455);
				contentPane.add(Background);
				
				
				/**
				 * 
				 */



				
				
			}
			
			/**
			 * Create ActionListener
			 *
			 */
				public class ActionBoutton1 implements ActionListener {

					@Override
					public void actionPerformed(ActionEvent e) {
						String text1=mesure1text.getText();
						String text2=mesure2text.getText();
						String text3=mesure3text.getText();
						if(!text1.equals("") && !text2.equals("")) {
					    
							
							if ((text1.length() > 0)&&(text2.length()>0)){
								try {
						int m1 = Integer.parseInt(text1);
						int m2 = Integer.parseInt(text2);
						int m3 = Integer.parseInt(text3);	
						Session session = DBConnection.getSession();
						Transaction persistTransaction1 = session.beginTransaction();
						Date date=new Date(0);	
						
						User u1 = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
						session.save(u1);
				   
					    Workout w=new RowingWorkout(date,m3,m2,m1);
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
				RowingWindow frame = new RowingWindow();
				frame.setVisible(true);
			}
			

}
