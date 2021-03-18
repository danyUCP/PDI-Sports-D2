package ihm;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import java.sql.PreparedStatement;

import data.RowingWorkout;
import data.User;
import data.Workout;
import graph.RowingWorkoutLine;
import orm.DBConnection;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class ModificationPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTextField time;
		private JTextField distance;
		private JTextField textField;
		private JLabel messagelabel;
		PreparedStatement state2;
	  	private Connection  connection;
		/**
		 * Create the panel.
		 */
		public ModificationPanel() {
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
			
			JLabel lblNewLabel_3_1 = new JLabel("Paddle Stockes");
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
				Session session = orm.DBConnection.getSession();
				Transaction readTransaction = session.beginTransaction();
				
				@SuppressWarnings("unchecked")
				 
		 List result = session.createQuery("SELECT id FROM RowingWorkout where id =" + m3).list();
				//SELECT id FROM rowingworkout id.rowingworkout = id
		  
				
				
				
				Iterator iterator = result.iterator();
		  		int j=0;
		  		while (iterator.hasNext()) {
		  			int i = (int) iterator.next();
		           
		      System.out.println(""+i+"");  
		   //   j++; 
		    //  System.out.println(""+j+"");  
				
		  		}
		  		

			  
		  		
		  		
		  		
		  	 System.out.println("UPDATE rowingworkout set distance="+m1+", paddle_strokes="+m2+" where id="+m3+";"); 
		  	 
		    connection	=DriverManager.getConnection("jdbc:mysql://localhost:3306/sport_d3","root","");
		  	 
		  	 PreparedStatement preparedStatement = connection.prepareStatement("	UPDATE rowingworkout set distance='"+m1+"', paddle_strokes='"+m2+"' where id='"+m3+"';");
		 
		  	
		  	
		  	System.out.print("UPDATE rowingworkout set distance=rowingworkout.'"+m1+"', paddle_strokes=rowingworkout.'"+m2+"' where id='"+m3+"';");
                preparedStatement.executeUpdate();
				session.close();
				RowingWorkoutLine demo = new RowingWorkoutLine(" RowingLine Chart Demo 6");
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
		
	}

