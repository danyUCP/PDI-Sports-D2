package ihm;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import data.ClimbingWorkout;
import data.DBConnection;
import data.User;
import data.Workout;
import graph.ClimbingWorkoutLine;
import graph.ClimbingWorkoutPie;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


public class ClimbingTest extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField time;
	private JTextField final_date,modif_time;
	@SuppressWarnings("unused")
	private JLabel messagelabel,date_choice_label,lblNewLabel_date,lblNewLabel_date_2,lblNewLabel_difficulty,lblNewLabel_duree;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_select_modif,comboBox_difficulty,comboBox_date;
	@SuppressWarnings("rawtypes")
	
	
	String[] liste_difficulty={"White", "Yellow","Orange","Blue","Red","Grey"};
	String[] liste_choice={"Add","Alter"};
	User user;
	JButton btn_submit,choicebtn,btn_submit2;
  	

	private long time1= System.currentTimeMillis();
  	

	/**
	 * Create the panel.
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ClimbingTest() {

		setLayout(null);
		
		//Bouton valider de fin
		btn_submit = new JButton("Submit");
		btn_submit.setBounds(10, 360, 97, 40);
		
		btn_submit2 = new JButton("Submit");
		btn_submit2.setBounds(10, 360, 97, 40);
		
		//Bouton annuler pour recommencer la requête
		JButton btnAnnuler = new JButton("Cancel");
		btnAnnuler.setBounds(143, 360, 97, 40);
		add(btnAnnuler);
		
		
		//Label pour signifier la ligne de ma durée 
		lblNewLabel_duree = new JLabel("Duration (min)");
		lblNewLabel_duree.setBounds(154, 140, 86, 24);
		
		////Label pour signifier la ligne de difficulté 
		lblNewLabel_difficulty = new JLabel("Difficulty");
		lblNewLabel_difficulty.setBounds(154, 220, 86, 24);
		
		
		//Label pour signifier la ligne la date au format
		lblNewLabel_date=new JLabel("Date format :");
		lblNewLabel_date.setBounds(154,280,86,24);
		
		
		lblNewLabel_date_2=new JLabel("aa-m-j");
		lblNewLabel_date_2.setBounds(154, 300, 86, 24);
		
		//ComboBox pour choisir la difficulté
		comboBox_difficulty = new JComboBox();
		comboBox_difficulty.setBackground(Color.WHITE);
		comboBox_difficulty.setBounds(21, 220, 123, 32);
		comboBox_difficulty.setModel(new javax.swing.DefaultComboBoxModel(liste_difficulty));
		
		//Text Field pour rentrer la durée de l'exercice 
		time = new JTextField();
		time.setBackground(new Color(255, 255, 255));
		time.setBounds(21, 140, 123, 32);
		time.setColumns(10);
		
		//TextField pour rentrer la date de la séance
		final_date=new JTextField();
		final_date.setBackground(new Color(255, 255, 255));
		final_date.setBounds(21, 280, 123, 32);
		final_date.setColumns(10);
		
		
		
		//ComboBox pour choisir le choix du début
		comboBox_select_modif = new JComboBox();
		comboBox_select_modif.setBackground(Color.WHITE);
		comboBox_select_modif.setBounds(21, 70, 123, 32);
		add(comboBox_select_modif);
		comboBox_select_modif.setModel(new javax.swing.DefaultComboBoxModel(liste_choice));
		
		//ComboBox pour les dates
		comboBox_date= new JComboBox();
		comboBox_date.setBackground(Color.WHITE);
		comboBox_date.setBounds(21 , 140, 140, 32);
		
		//Affiche l'User
		JLabel user = new JLabel("User");
		user.setFont(new Font("Tahoma", Font.PLAIN, 14));
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setBounds(71, 20, 90, 24);
		add(user);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(85, 107, 47));
		lblNewLabel.setBounds(0, 0, 271, 520);
		
		messagelabel=new JLabel("");
		messagelabel.setBounds(151, 181, 100, 30);
		//lblNewLabel.add(messagelabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ClimbingPanel.class.getResource("/images/climming.jpg")));
		lblNewLabel_1.setBounds(255, 0, 626, 520); 
		add(lblNewLabel_1);
		
		//Action finale
		//btn_submit.addActionListener(new Graphes());
		
		//Action pour le choix
		comboBox_select_modif.addActionListener(new Action_Selection());
		btn_submit.addActionListener(new Actions_Add());
		comboBox_date.addActionListener(new Action_Alter());
		

	}
	
	
	public class Action_Alter implements ActionListener{

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void actionPerformed(ActionEvent e4) {
			String result_date=comboBox_date.getSelectedItem().toString();
			Session session = data.DBConnection.getSession();
			if (e4.getSource()==comboBox_date) {
				
				
				List difficulty=session.createQuery("select climbingworkout.course_difficulty from ClimbingWorkout climbingworkout where date='"+result_date+"'").list();
				List duration=session.createQuery("select climbingworkout.duration from ClimbingWorkout climbingworkout where date='"+result_date+"'").list();
				Iterator iterator = difficulty.iterator();
				Iterator iterator1=duration.iterator();
				while (iterator.hasNext()) {
					String i = (String) iterator.next();
					lblNewLabel_difficulty.setText(""+i+"");
					System.out.println(i);
					
				}
				while (iterator1.hasNext()) {
					int j = (int) iterator1.next();
					lblNewLabel_duree.setText(""+j+"");
					System.out.println(""+j+"");
					
				}
				remove(comboBox_date);
				
				}
			if (e4.getSource()==btn_submit2) {
				
				String modify_time=time.getText();
				int int_final_times=Convettexttomesure(modify_time);
				String final_difficulty=comboBox_difficulty.getSelectedItem().toString();
				Query preparedStatement = session.createQuery("	UPDATE climbingworkout set duration="+int_final_times+", course_difficulty='"+final_difficulty+"' where date=str_to_date('"+result_date+"','%Y/%m/%d');");
				   preparedStatement.executeUpdate();
			}
			
			
		
		}
	}
	
	public class Actions_Add implements ActionListener{

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void actionPerformed(ActionEvent e3) {
			if (e3.getSource()==btn_submit) {
				
				String times=time.getText(); //Récupère la durée de l'entrainement
				
				String final_dates= final_date.getText(); // Récupère la date de l'entrainement
				String final_difficulty=comboBox_difficulty.getSelectedItem().toString(); // Récupère la difficulté de l'entrainement
				Date sql_final_date=ConvertDateToSql(final_dates);
				int int_final_times=Convettexttomesure(times);
				
				Session session = DBConnection.getSession();
				Transaction persistTransaction1 = session.beginTransaction();
				User u1 = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
				session.save(u1);
				
				Workout w=new ClimbingWorkout(sql_final_date,int_final_times,final_difficulty);
				w.setUser(u1);
				session.save(w);
				
				persistTransaction1.commit();
				session.close();
		}
		}
	}
	
	public class Action_Selection implements ActionListener{

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void actionPerformed(ActionEvent e2) {
			String choix_modif=comboBox_select_modif.getSelectedItem().toString();
			if (e2.getSource()== comboBox_select_modif) {
				repaint();
			if (choix_modif == "Add") {
				//Ajout des composants
				add(lblNewLabel_duree);
				add(lblNewLabel_difficulty);
				add(lblNewLabel_date);
				add(lblNewLabel_date_2);
				add(comboBox_difficulty);
				add(time);
				add(btn_submit);
				add(final_date);
				//Commit
			}
			
			if (choix_modif == "Alter"){
				Session session = data.DBConnection.getSession();
				@SuppressWarnings("unchecked")
				List result = session.createQuery("select climbingworkout.date from ClimbingWorkout climbingworkout").list();  

				
					Iterator iterator = result.iterator();
					int j=0;
					String[] liste3=new String[100];
					while (iterator.hasNext()) {
						Date i = (Date) iterator.next();
						liste3[j]=" "+i+"";
						 
			  System.out.println(""+i+"");  
			  j++; 
			   
					
				}
					
					
					comboBox_date.setModel(new javax.swing.DefaultComboBoxModel(liste3));
					add(comboBox_date);
					add(btn_submit2);
					lblNewLabel_duree.setBounds(154, 290, 86, 24);
					add(lblNewLabel_duree);
					add(lblNewLabel_difficulty);
					add(comboBox_difficulty);
					time.setBounds(21, 280, 123, 32);
					add(time);
					
				
				
		
		
			}
	}
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
	
	public Date text_date(String date) {  
	    Date dates=Date.valueOf(date); 
	    System.out.println(date);
		return dates;  
	}
	
	public Date ConvertDateToSql(String date) {  
	    Date dates=Date.valueOf(date); 
	    System.out.println(date);
		return dates;  
	}
	
	public String ConvertDateString(Date date) {  
	    String dates=String.valueOf(date); 
	    System.out.println(date);
		return dates;  
	}
	
	}

	
