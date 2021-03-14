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
import graph.ClimbingWorkoutLine;
import graph.ClimbingWorkoutPie;
import graph.SwimmingWorkoutBarChart;
import manager.Managers;
import manager.UserManager;

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
	private static final long serialVersionUID = 1L;
	private JTextField time;
	private JTextField final_date;
	private JLabel messagelabel,date_choice_label,lblNewLabel_date;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox,comboBox_1;
	private JComboBox comboBox_3=new JComboBox();
	
	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}

	String[] liste={"White", "Yellow","Orange","Blue","Red","Grey"};
	String[] liste1={"Add","Alter"};
	User user;
	JButton btnNewButton_1,choicebtn;
  	public JButton getChoicebtn() {
		return choicebtn;
	}

	public void setChoicebtn(JButton choicebtn) {
		this.choicebtn = choicebtn;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	private Connection  connection;
 // 	private ClimbingPanelAlter climbingPanelAlter;
  	private boolean choice_panel=true;
  	
	public boolean isChoice_panel() {
		return choice_panel;
	}

	public void setChoice_panel(boolean choice_panel) {
		this.choice_panel = choice_panel;
	}

	private long time1= System.currentTimeMillis();
  	

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

		choicebtn  = new JButton("valid");
		choicebtn.setBounds(203, 70, 67, 40);
		add(choicebtn);
		
		
		
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
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(21,280, 123, 32);
		
		
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
		choicebtn.addActionListener(new ChoiceBoutton());
		

	}
	
	/**
	 * Create ActionListener
	 *
	 */
	
	public class Graph implements ActionListener {
		
	public void actionPerformed(ActionEvent e1) {
		String text1=time.getText();
		String text_date= final_date.getText();
		String text2=comboBox.getSelectedItem().toString();
		String text3=comboBox_1.getSelectedItem().toString();
	
		int m1 = Integer.parseInt(text1);
		Date date=new Date(time1);	
		if(e1.getSource()== btnNewButton_1) {
				if(text3 == "Add") {				
				
				Session session = DBConnection.getSession();
				Transaction persistTransaction1 = session.beginTransaction();	
				Date dates=ConvertDateToSql(text_date); 
				
				
				
				
				User u1 = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
				session.save(u1);
		   
				Workout w=new ClimbingWorkout(dates,m1,text2);
				w.setUser(u1);
				session.save(w);
				
				persistTransaction1.commit();
				session.close();
				
				
				ClimbingWorkoutLine Climbingworkoutline=new ClimbingWorkoutLine("climbingworkoutline");
				Climbingworkoutline.setVisible(true);
				ClimbingWorkoutPie Climbingworkoutpie=new ClimbingWorkoutPie("climbingworkoutpie");
				Climbingworkoutpie.setVisible(true);
				
				
				}else if(text3=="Alter") {
					
					Session session = data.DBConnection.getSession();
					String textmodify=comboBox_3.getSelectedItem().toString();
				try {
					connection	=DriverManager.getConnection("jdbc:mysql://localhost:3306/sport_d3","root","");
					text_date=textmodify.replace('-','/');
				    PreparedStatement preparedStatement = connection.prepareStatement("	UPDATE climbingworkout set duration="+m1+", course_difficulty='"+text2+"' where date=str_to_date('"+text_date+"','%Y/%m/%d');");
				   preparedStatement.executeUpdate();
				
				   
					ClimbingWorkoutLine Climbingworkoutline=new ClimbingWorkoutLine("climbingworkoutline");
					Climbingworkoutline.setVisible(true);
					ClimbingWorkoutPie Climbingworkoutpie=new ClimbingWorkoutPie("climbingworkoutpie");
					Climbingworkoutpie.setVisible(true);
				    
				   
				   
				   
				    
					
				
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
	
	public class ChoiceBoutton implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String text=comboBox_1.getSelectedItem().toString();
			
			
			if(text=="Add") {
				
				
				remove(comboBox_3);
				final_date=new JTextField();
				final_date.setBackground(new Color(255, 255, 255));
				final_date.setBounds(21, 280, 123, 32);
				add(final_date);
				final_date.setColumns(10);
				
				repaint();
			
		
				
				
			}else if(text=="Alter") {
				remove(final_date);
				
				
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
				
				
				comboBox_3.setBackground(Color.WHITE);
				comboBox_3.setBounds(21,280, 123, 32);
				add(comboBox_3);
				comboBox_3.setModel(new javax.swing.DefaultComboBoxModel(liste3));
				
				
				
				
				repaint();
			
				
				
			}
			
			
		}
				
	}
		
	
		public class ActionBoutton2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			messagelabel.setText("choice canceled");
			
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

