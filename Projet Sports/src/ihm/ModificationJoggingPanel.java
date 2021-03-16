package ihm;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import data.User;

import java.sql.PreparedStatement;

import graph.LineChartJogging;
import graph.RowingWorkoutLine;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class ModificationJoggingPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTextField time;
		private JTextField distance;
		private JTextField textField;
		private JLabel messagelabel;
		PreparedStatement state2;
		private JLabel time1;
	  	private Connection  connection;
		/**
		 * Create the panel.
		 * 
		 * 
		 * 
		 */
	  	
	  	
	  




	  		/**
	  		 * 
	  		 */
	  
	  		String[] liste={"1 jour","Une semaine","1 mois"};
	  		String[] liste1={"Modifier","Ajouter"};
	  		JButton btnNewButton_1;
	  		User user;
	  		JLabel basse,Crowl,arriere,Papillon;
	  		JTextPane papillon,crowl,papillon_2,papillon_3,papillon_2_1;
	  		JComboBox comboBox,comboBox_1;
	  		

	  		/**
	  		 * Launch the application.
	  		 */
	  		/*public static void main(String[] args) {
	  			EventQueue.invokeLater(new Runnable() {
	  				public void run() {
	  					try {
	  						Swimming frame = new Swimming();
	  						frame.setVisible(true);
	  					} catch (Exception e) {
	  						e.printStackTrace();
	  					}
	  				}
	  			});
	  		}*/

	  		/**
	  		 * Create the frame.
	  		 */
	  		
	  		@SuppressWarnings({ "unchecked", "rawtypes" })
	  		public ModificationJoggingPanel() {
	  			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  			//setBounds(100, 100, 858, 496);
	  			//contentPane = new JPanel();
	  			//setBackground(Color.WHITE);
	  			//setBorder(new EmptyBorder(5, 5, 5, 5));
	  			//setContentPane(contentPane);
	  			
	  			setLayout(null);
	  			
	  			
	  			btnNewButton_1 = new JButton("Valider");
	  			btnNewButton_1.setForeground(new Color(169, 169, 169));
	  			btnNewButton_1.setBackground(new Color(192, 192, 192));
	  			btnNewButton_1.setBounds(759, 47, 85, 21);
	  			add(btnNewButton_1);
	  			
	  			JButton btnNewButton = new JButton("Retour");
	  			btnNewButton.setForeground(new Color(192, 192, 192));
	  			btnNewButton.setBounds(10, 428, 85, 21);
	  			add(btnNewButton);
	  			
	  			JLabel lblNewLabel_3 = new JLabel("Données natation");
	  			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	  			lblNewLabel_3.setForeground(new Color(255, 255, 255));
	  			lblNewLabel_3.setBounds(54, 64, 136, 30);
	  			add(lblNewLabel_3);
	  			
	  			JLabel lblNewLabel_1 = new JLabel("Lets go");
	  			lblNewLabel_1.setForeground(new Color(255, 255, 255));
	  			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	  			lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
	  			lblNewLabel_1.setBounds(10, 10, 243, 23);
	  			add(lblNewLabel_1);
	  			
	  			JLabel lblNewLabel = new JLabel("Option");
	  			lblNewLabel.setForeground(new Color(255, 255, 255));
	  			lblNewLabel.setBounds(306, 50, 126, 18);
	  			add(lblNewLabel);
	  			
	  			JLabel lblNewLabel_2 = new JLabel("Periode");
	  			lblNewLabel_2.setForeground(new Color(255, 255, 255));
	  			lblNewLabel_2.setBounds(520, 51, 66, 18);
	  			add(lblNewLabel_2);
	  			
	  			papillon = new JTextPane();
	  			papillon.setBackground(Color.LIGHT_GRAY);
	  			papillon.setBounds(130, 202, 100, 19);
	  			add(papillon);
	  			
	  			crowl = new JTextPane();
	  			crowl.setBackground(Color.LIGHT_GRAY);
	  			crowl.setBounds(130, 264, 100, 19);
	  			add(crowl);
	  			
	  			papillon_2 = new JTextPane();
	  			papillon_2.setBackground(Color.LIGHT_GRAY);
	  			papillon_2.setBounds(130, 327, 100, 19);
	  			add(papillon_2);
	  			
	  			papillon_3 = new JTextPane();
	  			papillon_3.setBackground(Color.LIGHT_GRAY);
	  			papillon_3.setBounds(130, 134, 100, 19);
	  			add(papillon_3);
	  			
	  			comboBox = new JComboBox();
	  			comboBox.setForeground(new Color(169, 169, 169));
	  			comboBox.setBackground(new Color(192, 192, 192));
	  			comboBox.setBounds(581, 46, 136, 23);
	  			add(comboBox);
	  			comboBox.setModel(new javax.swing.DefaultComboBoxModel(liste));
	  			
	  			comboBox_1 = new JComboBox();
	  			comboBox_1.setForeground(new Color(169, 169, 169));
	  			comboBox_1.setBackground(new Color(192, 192, 192));
	  			comboBox_1.setBounds(352, 49, 136, 23);
	  			add(comboBox_1);
	  			comboBox_1.setModel(new javax.swing.DefaultComboBoxModel(liste1));
	  			
	  			JLabel left_1 = new JLabel("");
	  			left_1.setOpaque(true);
	  			left_1.setBackground(new Color(0, 0, 128));
	  			left_1.setBounds(263, 0, 581, 94);
	  			add(left_1);
	  			
	  			basse = new JLabel("Distance Basse");
	  			basse.setForeground(Color.WHITE);
	  			basse.setBounds(10, 123, 149, 30);
	  			add(basse);
	  			
	  			Crowl = new JLabel("Distance Crowl");
	  			Crowl.setForeground(Color.WHITE);
	  			Crowl.setBounds(10, 191, 119, 30);
	  			add(Crowl);
	  			
	  			arriere = new JLabel("Distance arriere");
	  			arriere.setForeground(Color.WHITE);
	  			arriere.setBounds(10, 253, 119, 30);
	  			add(arriere);
	  			
	  			Papillon = new JLabel("Distance Papillon");
	  			Papillon.setForeground(Color.WHITE);
	  			Papillon.setBounds(10, 316, 119, 30);
	  			add(Papillon);
	  			
	  			papillon_2_1 = new JTextPane();
	  			papillon_2_1.setBackground(Color.LIGHT_GRAY);
	  			papillon_2_1.setBounds(130, 375, 66, 19);
	  			add(papillon_2_1);
	  			
	  			time1 = new JLabel("Durée");
	  			time1.setForeground(Color.WHITE);
	  			time1.setBounds(77, 364, 119, 30);
	  			add(time1);
	  			
	  			JLabel left = new JLabel("");
	  			left.setOpaque(true);
	  			left.setBackground(new Color(0, 0, 128));
	  			left.setBounds(0, 0, 266, 459);
	  			add(left);
	  			
	  			
	  		//	JLabel lblNewLabel_4 = new JLabel("");
	  		//	lblNewLabel_4.setIcon(new ImageIcon(SwimmingPanel.class.getResource("/images/row.png")));
	  		//	lblNewLabel_4.setBounds(266, 92, 578, 367);
	  		//	add(lblNewLabel_4);
	  			
	  			btnNewButton_1.addActionListener(new ActionBoutton1());
	  			
	  		}
	  		
	  		
			public class ActionBoutton1 implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {

					
					String text1=textField.getText();
					String text2=distance.getText();
					String text3=time.getText();
					if(!text1.equals("") && !text2.equals("")) {
				      
						
						if ((text1.length() > 0)&&(text2.length()>0)){
							try {
					
					int m1 = Integer.parseInt(text1);
					int m2 = Integer.parseInt(text2);
					int m3 = Integer.parseInt(text3);	

					Date date=new Date(0);	
					
					DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
					Session session = data.DBConnection.getSession();
					Transaction readTransaction = session.beginTransaction();
					
					@SuppressWarnings("unchecked")
					 
			 List result = session.createQuery("SELECT id FROM RowingWorkout where id =" + m3).list();
					//SELECT id FROM rowingworkout id.rowingworkout = id
			  
					
					
					
					Iterator iterator = result.iterator();
			  		int j=0;
			  		while (iterator.hasNext()) {
			  			int i = (int) iterator.next();
			           
			      System.out.println(""+i+"");  
			  
					
			  		}
			  		

				  
			  		
			  		
			  		
			  	 System.out.println("UPDATE joggingworkout set distance="+m1+", time="+m2+" where id="+m3+";"); 
			  connection	=DriverManager.getConnection("jdbc:mysql://localhost:3306/sport_d3","root","");
			  	 
			  	 PreparedStatement preparedStatement = connection.prepareStatement("	UPDATE jogginggworkout set distance='"+m1+"', time='"+m2+"' where id='"+m3+"';");
			 
			  	
			  	
			  	System.out.print("UPDATE rowingworkout set distance=rowingworkout.'"+m1+"', paddle_strokes=rowingworkout.'"+m2+"' where id='"+m3+"';");
				preparedStatement.executeUpdate();
			
					session.close();
					LineChartJogging demo = new LineChartJogging(  "Temps Vs distance" ,"Distance vs temps");
					demo.pack();
					RefineryUtilities.centerFrameOnScreen(demo);
					demo.setVisible(true);
							} catch (NumberFormatException nfe) {
						        settext("Erreur de format");
								   
							    
						    } catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							}else {
						      settext("Un paramètre est requis");
						}
				
					}else {
					
						
						settext("Veuillez remplir tout les champs");	
						
					}
				}
				  
			}
			
			
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
	  		
	  	/*	private class Graph implements ActionListener {

	  			public void actionPerformed(ActionEvent e) {
	  				if(e.getSource()==btnNewButton_1) {
	  					Managers um = new Managers();
	  					//if(!papillon_2_1.getText().isEmpty() && !papillon.getText().isEmpty() && !crowl.getText().isEmpty() && !papillon_2.getText().isEmpty() && papillon_3.getText().isEmpty()) {
	  						if(comboBox_1.getSelectedItem().toString().equals("Ajouter")) {
	  						System.out.println(comboBox_1.getSelectedItem().toString());
	  						UserManager m=new UserManager();
	  						user=m.findUser("seruche", "1311");
	  						Graph p=new Graph();
	  						
	  						//System.out.println(p.ConvertIntoNumeric(papillon_2_1.getText())+" "+p.ConvertIntoNumeric(papillon.getText())+" "+p.ConvertIntoNumeric(crowl.getText())+" "+p.ConvertIntoNumeric(papillon_2.getText())+" "+p.ConvertIntoNumeric(papillon_3.getText()));
	  						um.addSwimming(user,new Date(0),p.ConvertIntoNumeric(papillon_2_1.getText()),p.ConvertIntoNumeric(papillon.getText()),p.ConvertIntoNumeric(crowl.getText()),p.ConvertIntoNumeric(papillon_2.getText()),p.ConvertIntoNumeric(papillon_3.getText()));
	  						SwimmingWorkoutBarChart demo = new SwimmingWorkoutBarChart("SwimmingWorkoutBar Chart");
	  						demo.pack();
	  						RefineryUtilities.centerFrameOnScreen(demo);
	  						demo.setVisible(true);
	  						}
	  					}
	  					/*else {
	  						JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis");
	  					}
	  				}
	  			*/
	  			private int ConvertIntoNumeric(String xVal)
	  			{
	  			 try
	  			  { 
	  			     return Integer.parseInt(xVal);
	  			  }
	  			 catch(Exception ex) 
	  			  {
	  			     return 0; 
	  			  }
	  			}
	  				
	  			
	  			
	  			
	  			
	  		}
	/*	public ModificationJoggingPanel() {
			setLayout(null);
			
			JButton btnNewButton = new JButton("Modifier");
			btnNewButton.setBounds(10, 360, 97, 40);
			add(btnNewButton);
			
			JButton btnAnnuler = new JButton("Annuler");
			btnAnnuler.setBounds(143, 360, 97, 40);
			add(btnAnnuler);
			
			JLabel lblNewLabel_3 = new JLabel("Distance");
			lblNewLabel_3.setBounds(154, 287, 86, 24);
			add(lblNewLabel_3);
			
			JLabel lblNewLabel_3_1 = new JLabel("time");
			lblNewLabel_3_1.setBounds(154, 212, 86, 24);
			add(lblNewLabel_3_1);
			
			time = new JTextField();
			time.setBackground(new Color(255, 255, 255));
			time.setBounds(21, 128, 123, 32);
			add(time);
			time.setColumns(10);
			
			distance = new JTextField();
			distance.setColumns(10);
			distance.setBackground(Color.WHITE);
			distance.setBounds(21, 284, 123, 32);
			add(distance);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBackground(Color.WHITE);
			textField.setBounds(21, 209, 123, 32);
			add(textField);
			
			JLabel lblNewLabel_3_1_1 = new JLabel(" séance ?");
			lblNewLabel_3_1_1.setBounds(154, 131, 117, 24);
			add(lblNewLabel_3_1_1);
			
			JLabel user = new JLabel("Séance");
			user.setFont(new Font("Tahoma", Font.PLAIN, 14));
			user.setHorizontalAlignment(SwingConstants.CENTER);
			user.setBounds(75, 67, 103, 24);
			add(user);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(218, 165, 32));
			lblNewLabel.setBounds(0, 0, 271, 520);
			add(lblNewLabel);
			
			messagelabel=new JLabel("");
			messagelabel.setBounds(151, 251, 100, 30);
			lblNewLabel.add(messagelabel);
			
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(RowingPanel.class.getResource("/images/row.jpg")));
			lblNewLabel_1.setBounds(255, 0, 626, 520);
			add(lblNewLabel_1);
			
			btnNewButton.addActionListener(new ActionBoutton1());
			btnAnnuler.addActionListener(new ActionBoutton2());
			
			
		}
		
		/**
		 * Create ActionListener
		 *
		 */
		



		/**
		 * Create ActionListener
		 *
		 */
		
		
	

