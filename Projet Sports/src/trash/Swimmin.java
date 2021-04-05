package trash;


import javax.swing.JPanel;


import org.jfree.ui.RefineryUtilities;

import data.User;
import ihm.MainFrame;
import manager.Managers;
import manager.UserManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;


public class Swimmin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JPanel contentPane;
	String[] liste={"1 jour","Une semaine","1 mois"};
	String[] liste1={"Modifier","Ajouter"};
	JButton btnNewButton_1;
	User user;
	JLabel basse,Crowl,arriere,Papillon,time;
	JTextPane papillon,crowl,papillon_2,papillon_3,papillon_2_1;
	JComboBox comboBox,comboBox_1;
	JButton btnNewButton;


	/**
	 * Create the frame.
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Swimmin() {
		
		setLayout(null);
		
		
		btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.setForeground(new Color(169, 169, 169));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(759, 47, 85, 21);
		add(btnNewButton_1);
		
		btnNewButton = new JButton("Retour");
		btnNewButton.setForeground(new Color(192, 192, 192));
		btnNewButton.setBounds(10, 428, 85, 21);
		add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Données natation");
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
		
		papillon = new JTextPane();
		papillon.setBackground(Color.LIGHT_GRAY);
		papillon.setBounds(130, 202, 100, 19);
		add(papillon);
		
		crowl = new JTextPane();
		crowl.setBackground(Color.LIGHT_GRAY);
		crowl.setBounds(130, 264, 100, 19);
		add(crowl);
		
		papillon_2 = new JTextPane();
		papillon_2.setBackground(Color.LIGHT_GRAY);
		papillon_2.setBounds(130, 327, 100, 19);
		add(papillon_2);
		
		papillon_3 = new JTextPane();
		papillon_3.setBackground(Color.LIGHT_GRAY);
		papillon_3.setBounds(130, 134, 100, 19);
		add(papillon_3);
		
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
		
		papillon_2_1 = new JTextPane();
		papillon_2_1.setBackground(Color.LIGHT_GRAY);
		papillon_2_1.setBounds(130, 375, 66, 19);
		add(papillon_2_1);
		
		time = new JLabel("Durée");
		time.setForeground(Color.WHITE);
		time.setBounds(77, 364, 119, 30);
		add(time);
		
		JLabel left = new JLabel("");
		left.setOpaque(true);
		left.setBackground(new Color(0, 0, 128));
		left.setBounds(0, 0, 266, 459);
		add(left);
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Swimmin.class.getResource("/images/piscine.jpg")));
		lblNewLabel_4.setBounds(266, 92, 578, 367);
		add(lblNewLabel_4);
		
		btnNewButton_1.addActionListener(new Graph());
		btnNewButton.addActionListener(new Cancel());
		
	}
	
	public void previous() {
		MainFrame fami = (MainFrame) (SwingUtilities.getRoot(MainFrame.getGlobal()));
		
		
		this.removeAll();
		
		//fami.changePanel();
	}
	
	private class Graph implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnNewButton_1) {
				Managers um = new Managers();
				//if(!papillon_2_1.getText().isEmpty() && !papillon.getText().isEmpty() && !crowl.getText().isEmpty() && !papillon_2.getText().isEmpty() && papillon_3.getText().isEmpty()) {
					if(comboBox_1.getSelectedItem().toString().equals("Ajouter")) {
					System.out.println(comboBox_1.getSelectedItem().toString());
					UserManager m=new UserManager();
					user=m.findUser("seruche", "1311");
					Graph p=new Graph();
					
					//System.out.println(p.ConvertIntoNumeric(papillon_2_1.getText())+" "+p.ConvertIntoNumeric(papillon.getText())+" "+p.ConvertIntoNumeric(crowl.getText())+" "+p.ConvertIntoNumeric(papillon_2.getText())+" "+p.ConvertIntoNumeric(papillon_3.getText()));
					um.addSwimming(user,new Date(0),p.ConvertIntoNumeric(papillon_2_1.getText()),p.ConvertIntoNumeric(papillon.getText()),p.ConvertIntoNumeric(crowl.getText()),p.ConvertIntoNumeric(papillon_2.getText()),p.ConvertIntoNumeric(papillon_3.getText()));
					SwimmingWorkoutBarChart demo = new SwimmingWorkoutBarChart("SwimmingWorkoutBar Chart");
					demo.pack();
					RefineryUtilities.centerFrameOnScreen(demo);
					demo.setVisible(true);
					}
				}
				/*else {
					JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis");
				}*/
			
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
		
		
		public class Cancel implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnNewButton) {
					
					previous();
					
				}
			}
			
		}
	}
		
		

