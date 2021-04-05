package ihm.sport_panels;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.ClimbingWorkout;
import data.User;
import data.Workout;
import ihm.MainFrame;
import ihm.SportDataPanel;
import ihm.components.SportButton;
import ihm.components.SportComboBox;
import ihm.components.SportDateBox;
import ihm.components.SportLabel;
import ihm.components.SportTextField;
import manager.WorkoutManager;



public class ClimbingPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	SportComboBox comboBox_difficulty;
	String[] liste_difficulty={"White", "Yellow","Orange","Blue","Red","Grey"};
	

	SportTextField time;
	SportLabel title;
	SportDateBox dateBox;
	SportButton Valider,btnAnnuler,Modify,Supp;
	
	private JLabel messagelabel;
	
	private User user;
	private WorkoutManager wm;
	private ClimbingWorkout w;
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
		this.setBackground(new Color(28, 28, 28));
		this.setLayout(null);
		
		title = new SportLabel("Climbing Workout");
		title.setFont(new Font("Verdana", Font.BOLD, 24));
		title.setBounds(12, 40, 310, 40);
		add(title);
		
		messagelabel=new JLabel("");
		messagelabel.setBounds(151, 181, 100, 30);

		btnAnnuler = new SportButton("Cancel");
		btnAnnuler.setBounds(180, 350, 130, 50);
		btnAnnuler.setBackground(new Color(28, 28, 28));
		add(btnAnnuler);
		
		/*Valider = new JButton("Valider");
		Valider.setBackground(new Color(28, 28, 28));
		Valider.setBounds(20, 390, 97, 40);
		add(Valider);*/
		
		Valider = new SportButton("Submit");
		Valider.setBackground(new Color(28, 28, 28));
		Valider.setBounds(20, 350, 130, 50);
		add(Valider);
		
		JLabel lblNewLabel_3 = new JLabel("Duration");
		lblNewLabel_3.setBounds(240, 280, 86, 24);
		lblNewLabel_3.setForeground(Color.white);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Difficulty");
		lblNewLabel_3_1.setBounds(240, 200, 86, 24);
		lblNewLabel_3_1.setForeground(Color.white);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Date");
		lblNewLabel_3_2.setBounds(240, 110, 86, 24);
		lblNewLabel_3_2.setForeground(Color.white);
		add(lblNewLabel_3_2);
		
		
		
		time = new SportTextField(100);
		time.setBackground(new Color(28, 28, 28));
		time.setBounds(21, 260, 200, 50);
		add(time);
		time.setColumns(10);
		
		comboBox_difficulty = new SportComboBox(liste_difficulty);
		comboBox_difficulty.setBackground(new Color(28, 28, 28));
		comboBox_difficulty.setBounds(21, 180, 200, 50);
		add(comboBox_difficulty);
		comboBox_difficulty.setModel(new javax.swing.DefaultComboBoxModel(liste_difficulty));
		
		
		dateBox = new SportDateBox();
		dateBox.setBackground(new Color(28, 28, 28));
		dateBox.setBounds(21, 100, 200, 50);
		add(dateBox);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ClimbingPanel.class.getResource("/images/climming.jpg")));
		lblNewLabel_1.setBounds(330, 0, 626, 520); 
		add(lblNewLabel_1);
		
		Valider.addActionListener(new Action_Add());
		btnAnnuler.addActionListener(new Action_Add() );
		}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ClimbingPanel(User user, Workout w) {
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		this.w = (ClimbingWorkout) w;
		
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(new Color(28, 28, 28));
		this.setLayout(null);
		
		title = new SportLabel("Climbing Workout");
		title.setFont(new Font("Verdana", Font.BOLD, 24));
		title.setBounds(12, 40, 310, 40);
		add(title);
		
		messagelabel=new JLabel("");
		messagelabel.setBounds(151, 181, 100, 30);
		
		Modify = new SportButton("Alter");
		Modify.setBounds(20, 350, 130, 50);
		Modify.setBackground(new Color(28, 28, 28));
		add(Modify);
		
		Supp = new SportButton("Delete");
		Supp.setBounds(180, 350, 130, 50);
		Supp.setBackground(new Color(28, 28, 28));
		add(Supp);
		
		JLabel lblNewLabel_3_2 = new JLabel("Date");
		lblNewLabel_3_2.setBounds(240, 110, 86, 24);
		lblNewLabel_3_2.setForeground(Color.white);
		add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3 = new JLabel("Duration");
		lblNewLabel_3.setBounds(240, 280, 86, 24);
		lblNewLabel_3.setForeground(Color.white);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Difficulty");
		lblNewLabel_3_1.setBounds(240, 200, 86, 24);
		lblNewLabel_3_1.setForeground(Color.white);
		add(lblNewLabel_3_1);
		
		time = new SportTextField(100);
		time.setText("" + w.getDuration());
		time.setBackground(new Color(28, 28, 28));
		time.setBounds(21, 260, 200, 50);
		add(time);
		time.setColumns(10);
		
		comboBox_difficulty = new SportComboBox(liste_difficulty);
		//Je n'arrive pas à récupérer la difficulté sélectionné
		//comboBox_difficulty.setSelectedItem(w);
		comboBox_difficulty.setBackground(new Color(28, 28, 28));
		comboBox_difficulty.setBounds(21, 180, 200, 50);
		add(comboBox_difficulty);
		comboBox_difficulty.setModel(new javax.swing.DefaultComboBoxModel(liste_difficulty));
		
		
		dateBox = new SportDateBox(w.getDate());
		dateBox.setBackground(new Color(28, 28, 28));
		dateBox.setBounds(21, 100, 200, 50);
		
		add(dateBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ClimbingPanel.class.getResource("/images/climming.jpg")));
		lblNewLabel_1.setBounds(330, 0, 626, 520); 
		add(lblNewLabel_1);
		
		Modify.addActionListener(new Action_Modify_Supp());
		Supp.addActionListener(new Action_Modify_Supp() );
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
	
		String datess=dateBox.getDateBox().toString();
		String difficulty=comboBox_difficulty.getSelectedItem().toString();
			if(e1.getSource()== Valider) {
				
				
				Date dates=ConvertDateToSql(datess);
				
				int final_times=Convettexttomesure(duration_result);
				
				Workout w=new ClimbingWorkout(dates,final_times,difficulty);
				wm.createNewWorkout(w);
				
				JOptionPane.showMessageDialog(null, "Nouvelle séance d'Escalade enregistrée pour " + user.getFirstname());
				retour();
			}
		
			if(e1.getSource() == btnAnnuler)
			{
				
				retour();
			}
			
				
									
				
				} 
	}
			
	public class Action_Modify_Supp implements ActionListener {
		
		String duration_result=time.getText();
		String datess=dateBox.getDateBox().toString();
		String difficulty=comboBox_difficulty.getSelectedItem().toString();
		public void actionPerformed(ActionEvent e2) {
			if (e2.getSource()==Modify) {
				w.setCourseDifficulty(difficulty);
				Date fin=ConvertDateToSql(datess);
				w.setDate(fin);
				int final_times=Convettexttomesure(duration_result);
				w.setDuration(final_times);
				wm.updateWorkout(w);
			JOptionPane.showMessageDialog(null, "Nouvelle séance d'Escalade modifié pour " + user.getFirstname());
			retour();
			}
			
			
			if (e2.getSource()==Supp) {
				wm.deleteWorkout(w);
			JOptionPane.showMessageDialog(null, "Séance d'Escalade supprimé pour " + user.getFirstname());
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
	public String ConvettextString(int text) {
		
		
		String nombre=String.valueOf(text);
		
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

