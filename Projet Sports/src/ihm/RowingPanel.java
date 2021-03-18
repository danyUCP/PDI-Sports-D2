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
import org.jfree.ui.RefineryUtilities;

import data.JoggingWorkout;
import data.RowingWorkout;
import data.User;
import data.Workout;
import graph.RowingWorkoutLine;
import ihm.JoggingPanel.ActionBoutton2;
import orm.DBConnection;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RowingPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel messagelabel;
	private	JTextPane paddleText,timeText,distanceText;
	private long time1= System.currentTimeMillis();
  	private Connection  connection;
	private JComboBox comboBox,comboBox_1;
  	private JButton ValidButton;
  	
  	/**
	 * Create the panel.
	 */  
	
	
	
	
	
	
	public RowingPanel() {
		
		
		
		/**
		 * Create the panel.
		 * 
		 * 
		 * 
		 */

	  		/**
	  		 * 
	  		 */
  		@SuppressWarnings({ "unchecked", "rawtypes" })
	  
	  		String[] liste={"1 jour","Une semaine","1 mois"};
	  		String[] liste1={"Modifier","Ajouter"};
	  		JButton AddButton_1;
	  		
	  		

	  		/**
	  		 * Launch the application.
	  		 */

	  		/**
	  		 * Create the frame.
	  		 */
	  			setLayout(null);
	  			
	  			
	  			ValidButton = new JButton("Valider");
	  			ValidButton.setForeground(new Color(169, 169, 169));
	  			ValidButton.setBackground(new Color(192, 192, 192));
	  			ValidButton.setBounds(759, 47, 85, 21);
	  			add(ValidButton);
	  			
	  			JButton btnNewButton = new JButton("Retour");
	  			btnNewButton.setForeground(new Color(192, 192, 192));
	  			btnNewButton.setBounds(10, 428, 85, 21);
	  			add(btnNewButton);
	  			
	  			JLabel lblNewLabel_3 = new JLabel("Donn�es jogging");
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
	  			
	  			
	  			JLabel paddlelabel  = new JLabel("paddletext");
	  			paddlelabel.setForeground(new Color(255, 255, 255));
	  			paddlelabel.setBounds(40, 132, 100, 19);
	  			add(paddlelabel);
	  			
	  			paddleText = new JTextPane();
	  			paddleText.setBackground(Color.LIGHT_GRAY);
	  			paddleText.setBounds(100, 132, 100, 19);
	  			add(paddleText);
                
	  			JLabel distancelabel  = new JLabel("distance");
	  			distancelabel.setForeground(new Color(255, 255, 255));
	  			distancelabel.setBounds(40, 172, 100, 19);
	  			add(distancelabel);
	  			
	  			distanceText = new JTextPane();
	  			distanceText.setBackground(Color.LIGHT_GRAY);
	  			distanceText.setBounds(100, 172, 100, 19);
	  			add(distanceText);
	  			
	  			JLabel dureelabel  = new JLabel("dureetext");
	  			dureelabel.setForeground(new Color(255, 255, 255));
	  			dureelabel.setBounds(40, 202, 100, 19);
	  			add(dureelabel);
	  			
	  			timeText = new JTextPane();
	  			timeText.setBackground(Color.LIGHT_GRAY);
	  			timeText.setBounds(100, 202, 100, 19);
	  			add(timeText);

	  			
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
	  			
	  			lblNewLabel_3 = new JLabel("Dur�e");
	  			lblNewLabel_3.setForeground(Color.WHITE);
	  			lblNewLabel_3.setBounds(77, 364, 119, 30);
	  			add(lblNewLabel_3);
	  			
	  			JLabel left = new JLabel("");
	  			left.setOpaque(true);
	  			left.setBackground(new Color(0, 0, 128));
	  			left.setBounds(0, 0, 266, 459);
	  			add(left);
	  			
	  			
	   
	  			
		setLayout(null);

		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(143, 360, 97, 40);
		add(btnAnnuler);
		
		
		JLabel lblNewLabel_3_1 = new JLabel("Distance");
		lblNewLabel_3_1.setBounds(154, 261, 86, 24);
		add(lblNewLabel_3_1);
		
		
		messagelabel=new JLabel("");
		messagelabel.setBounds(151, 181, 100, 30);
		lblNewLabel.add(messagelabel);
		
		JLabel imageLabel_1 = new JLabel("");
		imageLabel_1.setIcon(new ImageIcon("C:\\Users\\alexa\\eclipse-workspace\\PDI-Sports-D2\\Projet Sports\\src\\images\\row.jpg"));//"C:\\Users\\alexa\\OneDrive\\Images\\free-running-track-vector.jpg")); //C:\\Users\\Hp\\Documents\\projet d'integration\\Images\\free-running-track-vector.jpg"));
		imageLabel_1.setBounds(255, 0, 626, 520); 
		add(imageLabel_1);
		
	   ValidButton.addActionListener(new Graph());	 
	   btnAnnuler.addActionListener(new ActionBoutton2());
		

	}
	
	
	/**
	 * Create ActionListener
	 *
	 */
	public class Graph implements ActionListener {
		
		public void actionPerformed(ActionEvent e1) {
		
			
			String text1=timeText.getText();
			String text2=distanceText.getText();
			String text3=paddleText.getText();

			String text4=comboBox_1.getSelectedItem().toString();
			int m1 = Integer.parseInt(text1);
	        int m2 = Integer.parseInt(text2);
	        int m3=  Integer.parseInt(text3);

			
			System.out.println(" "+text3+"  graph  ");
			
			Date date=new Date(time1);	
			if(e1.getSource()== ValidButton) {
					
				
				if(text4 == "Ajouter") {  
	
					
						System.out.println(" ajouter ");		
					
					Session session = DBConnection.getSession();
					Transaction persistTransaction1 = session.beginTransaction();	
					
					
					
					
					
					User u1 = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
					session.save(u1);
			   
					Workout w=new RowingWorkout(date,m1,m2,m3);
					w.setUser(u1);
					session.save(w);
					
					persistTransaction1.commit();
					session.close();
					
					}else if(text4=="Modifier") {
						
						
						
						System.out.println(" modifier ");	
						
						Session session = orm.DBConnection.getSession();
						
					System.out.println("UPDATE climbingworkout set distance="+m1+", time='"+text2+"' where date="+date+";"); 
					try {
						connection	=DriverManager.getConnection("jdbc:mysql://localhost:3306/sport_d3","root","");
					    PreparedStatement preparedStatement = connection.prepareStatement("	UPDATE climbingworkout set duration="+m1+", course_difficulty='"+text2+"' where date="+date+";");
					   preparedStatement.executeUpdate();
					
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						  	 

					session.close();
						
						
						
					}
			
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
		      settext("Un param�tre est requis");
		}
	      return nombre;
		
	}
	public void settext(String text) {
		
	messagelabel.setText(text);	
		
	}
	
}
