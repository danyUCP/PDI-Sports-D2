package ihm;

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
import data.SwimmingWorkout;
import data.User;
import data.Workout;
import ihm.components.SportButton;
import ihm.components.SportDateBox;
import ihm.components.SportLabel;
import ihm.components.SportTextField;
import manager.Managers;
import manager.UserManager;
import manager.WorkoutManager;

public class SwimmingPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	SportLabel title;
	SportDateBox dateBox;
	SportButton Valider,btnAnnuler,Modify,Supp;
	JLabel basse,Crowl,arriere,Papillon,time;
	SportTextField papillon,crowl,papillon_2,papillon_3,papillon_2_1;
	 
	
	private JLabel messagelabel;
	
	private User user;
	private WorkoutManager wm;
	private SwimmingWorkout w;
	private Dimension dim;
	private int width = 858;
	private int height = 460;

	
	/**
	 * Create the panel.
	 */
	
	public SwimmingPanel(){
		
	}
	public SwimmingPanel(User user) {
		
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(new Color(28, 28, 28));
		this.setLayout(null);
		
		title = new SportLabel("Swimming Workout");
		title.setFont(new Font("Verdana", Font.BOLD, 24));
		title.setBounds(12, 20, 310, 40);
		add(title);
		
		messagelabel=new JLabel("");
		messagelabel.setBounds(151, 181, 100, 30);

		btnAnnuler = new SportButton("Cancel");
		btnAnnuler.setBounds(180, 428, 100, 30);
		btnAnnuler.setBackground(new Color(28, 28, 28));
		add(btnAnnuler);
		
		
		Valider = new SportButton("Submit");
		Valider.setBackground(new Color(28, 28, 28));
		Valider.setBounds(20, 428, 100, 30);
		add(Valider);
		
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
		
		time = new JLabel("Durée");
		time.setForeground(Color.WHITE);
		time.setBounds(77, 364, 119, 30);
		add(time);
		
		papillon = new SportTextField(100);
		papillon.setBounds(130, 202, 100, 30);
		add(papillon);
		
		crowl = new SportTextField(100);
		crowl.setBounds(130, 264, 100, 30);
		add(crowl);
		
		papillon_2 = new SportTextField(100);
		papillon_2.setBounds(130, 327, 100, 30);
		add(papillon_2);
		
		papillon_3 = new SportTextField(100);
		papillon_3.setBounds(130, 134, 100, 30);
		add(papillon_3);
		
		papillon_2_1 = new SportTextField(100);
		papillon_2_1.setBounds(130, 375, 100, 30);
		add(papillon_2_1);
		

		dateBox = new SportDateBox();
		dateBox.setBackground(new Color(28, 28, 28));
		dateBox.setBounds(60, 80, 200, 30);
		add(dateBox);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ClimbingPanel.class.getResource("/images/piscine.jpg")));
		lblNewLabel_1.setBounds(330, 0, 626, 520); 
		add(lblNewLabel_1);
		
		Valider.addActionListener(new Action_Add());
		btnAnnuler.addActionListener(new Action_Add() );
		}
	

	public SwimmingPanel(User user, Workout w) {
		this.user = user;
		this.wm = new WorkoutManager(this.user);
		this.w = (SwimmingWorkout) w;
		
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(new Color(28, 28, 28));
		this.setLayout(null);
		
		title = new SportLabel("Swimming Workout");
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
		
		
		dateBox = new SportDateBox(w.getDate());
		dateBox.setBackground(new Color(28, 28, 28));
		dateBox.setBounds(21, 100, 200, 50);
		
		add(dateBox);
		
		papillon = new SportTextField(100);
		papillon.setText("" + w.getDuration());
		papillon.setBounds(130, 202, 100, 30);
		add(papillon);
		
		crowl = new SportTextField(100);
		crowl.setText("" + w.getDuration());
		crowl.setBounds(130, 264, 100, 30);
		add(crowl);
		
		papillon_2 = new SportTextField(100);
		papillon_2.setText("" + w.getDuration());
		papillon_2.setBounds(130, 327, 100, 30);
		add(papillon_2);
		
		papillon_3 = new SportTextField(100);
		papillon_3.setText("" + w.getDuration());
		papillon_3.setBounds(130, 134, 100, 30);
		add(papillon_3);
		
		papillon_2_1 = new SportTextField(100);
		papillon_2_1.setText("" + w.getDuration());
		papillon_2_1.setBounds(130, 375, 100, 30);
		add(papillon_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ClimbingPanel.class.getResource("/images/piscine.jpg")));
		lblNewLabel_1.setBounds(330, 0, 626, 520); 
		add(lblNewLabel_1);
		
		//Modify.addActionListener(new Action_Modify_Supp());
		//Supp.addActionListener(new Action_Modify_Supp() );
	}
	
	public void retour()
	{
		MainFrame.getGlobal().removeAll();	
		MainFrame.getGlobal().add(new SportDataPanel(user, 5));
		MainFrame.getGlobal().revalidate();
	}
	
	/**
	 * Create ActionListener
	 *
	 */
	
	public class Action_Add implements ActionListener {
		
	public void actionPerformed(ActionEvent e1) {
	
			if(e1.getSource()== Valider) {
				Managers um = new Managers();
				//if(!papillon_2_1.getText().isEmpty() && !papillon.getText().isEmpty() && !crowl.getText().isEmpty() && !papillon_2.getText().isEmpty() && papillon_3.getText().isEmpty()) {
					
					//UserManager m=new UserManager();
					//user=m.findUser("seruche", "1311");
					Action_Add p=new Action_Add();
					
					//System.out.println(p.ConvertIntoNumeric(papillon_2_1.getText())+" "+p.ConvertIntoNumeric(papillon.getText())+" "+p.ConvertIntoNumeric(crowl.getText())+" "+p.ConvertIntoNumeric(papillon_2.getText())+" "+p.ConvertIntoNumeric(papillon_3.getText()));
					um.addSwimming(user,new Date(0),p.ConvertIntoNumeric(papillon_2_1.getText()),p.ConvertIntoNumeric(papillon.getText()),p.ConvertIntoNumeric(crowl.getText()),p.ConvertIntoNumeric(papillon_2.getText()),p.ConvertIntoNumeric(papillon_3.getText()));
				
				JOptionPane.showMessageDialog(null, "Nouvelle séance de Swimming enregistrée pour " + user.getFirstname());
				retour();
			}
			
			if(e1.getSource() == btnAnnuler)
			{
				retour();
			}
		

	}
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
	

			
	public class Action_Modify_Supp implements ActionListener {
		
		String duration_result=time.getText();
		String datess=dateBox.getDateBox().toString();
		//String difficulty=comboBox_difficulty.getSelectedItem().toString();
		public void actionPerformed(ActionEvent e2) {
			if (e2.getSource()==Modify) {
				//w.setCourseDifficulty(difficulty);
				Date fin=ConvertDateToSql(datess);
				w.setDate(fin);
				int final_times=Convettexttomesure(duration_result);
				w.setDuration(final_times);
				wm.updateWorkout(w);
			JOptionPane.showMessageDialog(null, "Nouvelle séance de Swimming modifié pour " + user.getFirstname());
			retour();
			}
			
			
			if (e2.getSource()==Supp) {
				wm.deleteWorkout(w);
			JOptionPane.showMessageDialog(null, "Séance de Swimming  supprimé pour " + user.getFirstname());
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


