package ihm;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 * 
 * @author PDI_D2
 *
 */

public class Register extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JRadioButton rdbtnNon,rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		
		Register frame = new Register();
		frame.setVisible(true);
			
	}*/

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 448, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setBounds(0, 10, 434, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(138, 71, 258, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 118, 258, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(138, 170, 258, 19);
		contentPane.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(138, 266, 258, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(138, 318, 258, 19);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBackground(new Color(105, 105, 105));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(72, 380, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(SystemColor.controlDkShadow);
		btnSubmit.setBounds(292, 380, 85, 21);
		contentPane.add(btnSubmit);
		
		JLabel Name = new JLabel("Nom");
		Name.setBounds(83, 74, 45, 13);
		contentPane.add(Name);
		
		JLabel Last_name = new JLabel("Prenom");
		Last_name.setBounds(72, 121, 56, 13);
		contentPane.add(Last_name);
		
		JLabel gender = new JLabel("Sexe");
		gender.setBounds(43, 173, 85, 13);
		contentPane.add(gender);
		
		JLabel Age = new JLabel("Age");
		Age.setBounds(50, 269, 78, 13);
		contentPane.add(Age);
		
		rdbtnNewRadioButton = new JRadioButton("Oui");
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton.setBounds(151, 217, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNon = new JRadioButton("Non");
		rdbtnNon.setBounds(293, 217, 62, 21);
		contentPane.add(rdbtnNon);
		
		/**
		 * Allows you to choose just 1 single button
		 */
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNon);
		
		JLabel sport = new JLabel("Etes vous sportif?");
		sport.setBounds(27, 221, 107, 13);
		contentPane.add(sport);
		
		JLabel Passwork = new JLabel("Mot de passe");
		Passwork.setBounds(50, 321, 78, 13);
		contentPane.add(Passwork);
		
		rdbtnNon.addActionListener(new Action());
		rdbtnNewRadioButton.addActionListener(new Action());
		btnNewButton.addActionListener(new Cancel());
	}

	
	
	public class Cancel implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			/**
			 * This return to index panel
			 */
			dispose();
			Index frame = new Index();
			frame.setVisible(true);
			
		}
	}
	
	/**
	 * 
	 * this class implements the actions of the jbuttons, 
	 * which prevents the events from occurring twice
	 * Which was the case directly in the method actionPerformed
	 *
	 */
	public class Action implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==rdbtnNon) {
				System.out.println("Vous ne pratiquez pas de sport?!");
				}
				
				if(arg0.getSource()==rdbtnNewRadioButton) {
						
						ChoiseSport dialog = new ChoiseSport();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
				}	
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
