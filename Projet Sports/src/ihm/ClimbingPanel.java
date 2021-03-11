package ihm;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.ui.RefineryUtilities;

import data.ClimbingWorkout;
import data.DBConnection;
import data.User;
import data.Workout;
import graph.SwimmingWorkoutBarChart;
import manager.Managers;
import manager.UserManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;


public class ClimbingPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField time;
	private JTextField final_date;
	private JLabel messagelabel;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox,comboBox_1;
	String[] liste={"White", "Yellow","Orange","Blue","Red","Grey"};
	String[] liste1={"Alter", "Add"};
	User user;
	JButton btnNewButton_1;

	/**
	 * Create the panel.
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ClimbingPanel() {
		setLayout(null);
		
		btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setBounds(10, 360, 97, 40);
		add(btnNewButton_1);
		
		JButton btnAnnuler = new JButton("Cancel");
		btnAnnuler.setBounds(143, 360, 97, 40);
		add(btnAnnuler);
		
		JLabel lblNewLabel_3 = new JLabel("Duration");
		lblNewLabel_3.setBounds(154, 140, 86, 24);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Difficulty");
		lblNewLabel_3_1.setBounds(154, 220, 86, 24);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_option = new JLabel("Option");
		lblNewLabel_option.setBounds(160, 70, 86, 24);
		add(lblNewLabel_option);
		
		JLabel lblNewLabel_date=new JLabel("Date format :");
		lblNewLabel_date.setBounds(154,280,86,24);
		add(lblNewLabel_date);
		
		JLabel lblNewLabel_date_2=new JLabel("aa-m-j");
		lblNewLabel_date_2.setBounds(154, 300, 86, 24);
		add(lblNewLabel_date_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(21, 70, 123, 32);
		add(comboBox_1);
		comboBox_1.setModel(new javax.swing.DefaultComboBoxModel(liste1));
		
		time = new JTextField();
		time.setBackground(new Color(255, 255, 255));
		time.setBounds(21, 140, 123, 32);
		add(time);
		time.setColumns(10);
		
		final_date=new JTextField();
		final_date.setBackground(new Color(255, 255, 255));
		final_date.setBounds(21, 280, 123, 32);
		add(final_date);
		final_date.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(21, 220, 123, 32);
		add(comboBox);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel(liste));
		
		
		JLabel user = new JLabel("User");
		user.setFont(new Font("Tahoma", Font.PLAIN, 14));
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setBounds(71, 20, 90, 24);
		add(user);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(85, 107, 47));
		lblNewLabel.setBounds(0, 0, 271, 520);
		add(lblNewLabel);
		
		messagelabel=new JLabel("");
		messagelabel.setBounds(151, 181, 100, 30);
		lblNewLabel.add(messagelabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ClimbingPanel.class.getResource("/images/climming.jpg")));
		lblNewLabel_1.setBounds(255, 0, 626, 520); 
		add(lblNewLabel_1);
		
		btnNewButton_1.addActionListener(new Graph());
		btnAnnuler.addActionListener(new ActionBoutton2());
		

	}
	
	/**
	 * Create ActionListener
	 *
	 */
	
	/*public class ActionBoutton1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String text1=time.getText();
			String text2=difficulte.getText();
			if(!text1.equals("") && !text2.equals("")) {
		    
				
				if ((text1.length() > 0)&&(text2.length()>0)){
					try {
		 
						
			System.out.println(" difficulté "+text2+"");
			
			if((text2.equals("Red"))||(text2.equals("Black"))||(text2.equals("Orange"))||(text2.equals("White"))) {			
			int m1 = Integer.parseInt(text1);
	       	//	int m2 = Integer.parseInt(text2);
			
			Session session = DBConnection.getSession();
			Transaction persistTransaction1 = session.beginTransaction();
			Date date=new Date(0);	
			
			User u1 = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
			session.save(u1);
	   
			Workout w=new ClimbingWorkout(date,m1,text2);
			w.setUser(u1);
			session.save(w);
			
			persistTransaction1.commit();
			session.close();
			}
					} 
			catch (NumberFormatException nfe) {
				        settext("Erreur de format");
						   					}
					
					}
				else {
				      settext("Un paramètre est requis");
					}
		
			}
			else {
			settext("Veuillez remplir tout les champs");	
				}
		}
	}
	
	*/
	public class Graph implements ActionListener {
		
	public void actionPerformed(ActionEvent e1) {
		String text1=time.getText();
		String text_date= final_date.getText();
		String text2=comboBox.getSelectedItem().toString();
		String text3=comboBox_1.getSelectedItem().toString();
		
		if(e1.getSource()== btnNewButton_1) {
				if(text3 == "Add") {
			//	Graph p=new Graph();
				
				int m1 = Integer.parseInt(text1);
				
				Session session = DBConnection.getSession();
				Transaction persistTransaction1 = session.beginTransaction();	
				
				
				Date dates=ConvertDateToSql(text_date);
				
				
				String logintest=user.getLogin();
				String mdp=user.getMdp();
				UserManager m=new UserManager();
				user=m.findUser(logintest, mdp);
				
				//User u1 = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
				//session.save(u1);
		   
				Workout w=new ClimbingWorkout(dates,m1,text2);
				w.setUser(user);
				session.save(w);
				
				persistTransaction1.commit();
				session.close();
				
				//um.addSwimming(user,new Date(0),p.ConvertIntoNumeric(papillon_2_1.getText()),p.ConvertIntoNumeric(papillon.getText()),p.ConvertIntoNumeric(crowl.getText()),p.ConvertIntoNumeric(papillon_2.getText()),p.ConvertIntoNumeric(papillon_3.getText()));
				//SwimmingWorkoutBarChart demo = new SwimmingWorkoutBarChart("SwimmingWorkoutBar Chart");
				//demo.pack();
				//RefineryUtilities.centerFrameOnScreen(demo);
				//demo.setVisible(true);
				}
				/*else {
					Ici voir pour la modification
				}*/
			}
			/*else {
				JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis");
			}*/
		}
	}
	/**
	 * Create ActionListener
	 *
	 */
	
		public class ActionBoutton2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			messagelabel.setText("choice canceled");
			
		}
		  
	}
		
		/*private int ConvertIntoNumeric(String xVal)
		{
		 try
		  { 
		     return Integer.parseInt(xVal);
		  }
		 catch(Exception ex) 
		  {
		     return 0; 
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
	
	public Date ConvertDateToSql(String date) {  
	    Date dates=Date.valueOf(date); 
	    System.out.println(date);
		return dates;  
	}
	
}

