package ihm;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.ui.RefineryUtilities;

import data.DBConnection;
import data.RowingWorkout;
import data.User;
import data.Workout;
import graph.RowingWorkoutLine;
import ihm.RowingWindow.ActionBoutton1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class RowingPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField time;
	private JTextField distance;
	private JTextField textField;
	private JLabel messagelabel;

	/**
	 * Create the panel.
	 */
	public RowingPanel() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(10, 360, 97, 40);
		add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(143, 360, 97, 40);
		add(btnAnnuler);
		
		JLabel lblNewLabel_3 = new JLabel("Durée");
		lblNewLabel_3.setBounds(154, 287, 86, 24);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Distance");
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
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Coup de pagaie");
		lblNewLabel_3_1_1.setBounds(154, 131, 117, 24);
		add(lblNewLabel_3_1_1);
		
		JLabel user = new JLabel("User");
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
				RowingWorkoutLine demo = new RowingWorkoutLine(" RowingLine Chart Demo 6");
				demo.pack();
				RefineryUtilities.centerFrameOnScreen(demo);
				demo.setVisible(true);
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
	
}
