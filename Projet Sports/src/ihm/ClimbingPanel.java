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

import data.ClimbingWorkout;
import data.DBConnection;
import data.JoggingWorkout;
import data.User;
import data.Workout;

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
	private JTextField difficulte;
	private JLabel messagelabel;

	/**
	 * Create the panel.
	 */
	public ClimbingPanel() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(10, 360, 97, 40);
		add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(143, 360, 97, 40);
		add(btnAnnuler);
		
		JLabel lblNewLabel_3 = new JLabel("Dur�e");
		lblNewLabel_3.setBounds(154, 143, 86, 24);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Difficult�");
		lblNewLabel_3_1.setBounds(154, 261, 86, 24);
		add(lblNewLabel_3_1);
		
		time = new JTextField();
		time.setBackground(new Color(255, 255, 255));
		time.setBounds(21, 143, 123, 32);
		add(time);
		time.setColumns(10);
		
		
		difficulte = new JTextField();
		difficulte.setColumns(10);
		difficulte.setBackground(Color.WHITE);
		difficulte.setBounds(21, 253, 123, 32);
		add(difficulte);
		
		
		JLabel user = new JLabel("User");
		user.setFont(new Font("Tahoma", Font.PLAIN, 14));
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setBounds(71, 79, 103, 24);
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
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\alexa\\eclipse-workspace\\PDI-Sports-D2\\Projet Sports\\src\\images\\climbing.png"));//"C:\\Users\\alexa\\OneDrive\\Images\\free-running-track-vector.jpg")); //C:\\Users\\Hp\\Documents\\projet d'integration\\Images\\free-running-track-vector.jpg"));
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
			String text1=time.getText();
			String text2=difficulte.getText();
			if(!text1.equals("") && !text2.equals("")) {
		    
				
				if ((text1.length() > 0)&&(text2.length()>0)){
					try {
		 
						
			System.out.println(" difficult� "+text2+"");
			
			if((text2.equals("red"))||(text2.equals("black"))||(text2.equals("orange"))||(text2.equals("brown"))) {			
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
			}else{
				
				settext("cette difficult� n'�xiste pas");
				
		     }
					
					
					
					
					} catch (NumberFormatException nfe) {
				        settext("Erreur de format");
						   
					    
				    }
					
					}else {
				      settext("Un param�tre est requis");
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
		      settext("Un param�tre est requis");
		}
	      return nombre;
		
	}
	
	public void settext(String text) {
		
		messagelabel.setText(text);	
			
		}
}
