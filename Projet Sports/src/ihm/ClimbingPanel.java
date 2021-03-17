package ihm;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.ui.RefineryUtilities;

import data.ArcheryWorkout;
import data.ClimbingWorkout;
import data.DBConnection;
import data.User;
import data.Workout;
import graph.ClimbingWorkoutLine;
import graph.ClimbingWorkoutPie;
import graph.SwimmingWorkoutBarChart;
import ihm.components.SportLabel;
import manager.Managers;
import manager.UserManager;
import manager.WorkoutManager;

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


public class ClimbingPanel extends JPanel {
	/**
	 * 
	 */
	JComboBox comboBox_difficulty;
	String[] liste_difficulty={"White", "Yellow","Orange","Blue","Red","Grey"};
	
	JButton btnAnnuler,Valider;
	JTextField time,final_date;
	SportLabel title;
	
	private JLabel messagelabel;
	
	private User user;
	private WorkoutManager wm;
	private Dimension dim;
	private int width = 858;
	private int height = 460;

	
	/**
	 * Create the panel.
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ClimbingPanel(User user) {
		
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);
		
		title = new SportLabel("Climbing Workout");
		title.setFont(new Font("Verdana", Font.BOLD, 20));
		title.setBounds(12, 70, 120, 50);
		add(title);
		
		messagelabel=new JLabel("");
		messagelabel.setBounds(151, 181, 100, 30);

		JButton btnAnnuler = new JButton("Cancel");
		btnAnnuler.setBounds(143, 360, 97, 40);
		add(btnAnnuler);
		
		JButton Valider = new JButton("Valider");
		Valider.setBounds(20, 360, 97, 40);
		add(Valider);
		
		JLabel lblNewLabel_3 = new JLabel("Duration");
		lblNewLabel_3.setBounds(154, 220, 86, 24);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Difficulty");
		lblNewLabel_3_1.setBounds(154, 140, 86, 24);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_date=new JLabel("Date format :");
		lblNewLabel_date.setBounds(154,280,86,24);
		add(lblNewLabel_date);
		
		JLabel lblNewLabel_date_2=new JLabel("aa-m-j");
		lblNewLabel_date_2.setBounds(154, 300, 86, 24);
		add(lblNewLabel_date_2);
		
		
		
		time = new JTextField();
		time.setBackground(new Color(255, 255, 255));
		time.setBounds(21, 220, 123, 32);
		add(time);
		time.setColumns(10);
		
		final_date=new JTextField();
		final_date.setBackground(new Color(255, 255, 255));
		final_date.setBounds(21, 280, 123, 32);
		add(final_date);
		final_date.setColumns(10);
		
		comboBox_difficulty = new JComboBox();
		comboBox_difficulty.setBackground(Color.WHITE);
		comboBox_difficulty.setBounds(21, 140, 123, 32);
		add(comboBox_difficulty);
		comboBox_difficulty.setModel(new javax.swing.DefaultComboBoxModel(liste_difficulty));
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ClimbingPanel.class.getResource("/images/climming.jpg")));
		lblNewLabel_1.setBounds(255, 0, 626, 520); 
		add(lblNewLabel_1);
		
		Valider.addActionListener(new Action_Add());
		
		
		

	}
	
	public void retour()
	{
		MainFrame.getGlobal().removeAll();;		
		MainFrame.getGlobal().add(new SportDataPanel(user, 2));
		MainFrame.getGlobal().revalidate();
	}
	
	/**
	 * Create ActionListener
	 *
	 */
	
	public class Action_Add implements ActionListener {
		
	public void actionPerformed(ActionEvent e1) {
		String duration_result=time.getText();
		String text_date= final_date.getText();
		String difficulty=comboBox_difficulty.getSelectedItem().toString();
			if(e1.getSource()== Valider) {
				
					
				Date dates=ConvertDateToSql(text_date);
				int final_times=Convettexttomesure(duration_result);
				
				Workout w=new ClimbingWorkout(dates,final_times,difficulty);
				wm.createNewWorkout(w);
				
				JOptionPane.showMessageDialog(null, "Nouvelle séance d'Escalade enregistrée pour " + user.getFirstname());
				retour();
			}
		
			else if(e1.getSource() == btnAnnuler)
			{
				retour();
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
	
	}

