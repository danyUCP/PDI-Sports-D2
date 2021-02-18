package ihm;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
	private JTextField textField,textField_1, textField_2, textField_4,textField_5,textField_3,textField_6;
	private JRadioButton rdbtnNon,rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Register frame = new Register();
		frame.setVisible(true);
			
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S'inscrire");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setBounds(212, 10, 434, 28);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.GREEN);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(85, 74, 258, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(85, 138, 258, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(85, 203, 258, 19);
		contentPane.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(509, 74, 258, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(509, 203, 258, 19);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBackground(new Color(105, 105, 105));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(233, 380, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(SystemColor.controlDkShadow);
		btnSubmit.setBounds(484, 380, 85, 21);
		contentPane.add(btnSubmit);
		
		JLabel Name = new JLabel("Nom");
		Name.setBounds(30, 74, 45, 13);
		contentPane.add(Name);
		
		JLabel Last_name = new JLabel("Prenom");
		Last_name.setBounds(30, 141, 56, 13);
		contentPane.add(Last_name);
		
		JLabel gender = new JLabel("Sexe");
		gender.setBounds(30, 206, 85, 13);
		contentPane.add(gender);
		
		JLabel Age = new JLabel("Age");
		Age.setBounds(469, 77, 78, 13);
		contentPane.add(Age);
		
		rdbtnNewRadioButton = new JRadioButton("Oui");
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton.setBounds(143, 259, 78, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNon = new JRadioButton("Non");
		rdbtnNon.setBounds(256, 259, 62, 21);
		contentPane.add(rdbtnNon);
		
		/**
		 * Allows you to choose just 1 single button
		 */
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNon);
		
		JLabel sport = new JLabel("Etes vous sportif?");
		sport.setBounds(30, 263, 107, 13);
		contentPane.add(sport);
		
		JLabel Passwork = new JLabel("Mot de passe");
		Passwork.setBounds(201, 330, 78, 13);
		contentPane.add(Passwork);
		
		rdbtnNon.addActionListener(new Action());
		rdbtnNewRadioButton.addActionListener(new Action());
		btnNewButton.addActionListener(new Cancel());
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(509, 138, 258, 19);
		contentPane.add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(289, 327, 258, 19);
		contentPane.add(textField_6);
		
		JLabel lblTaille = new JLabel("Taille");
		lblTaille.setBounds(469, 141, 78, 13);
		contentPane.add(lblTaille);
		
		JLabel lblPoids = new JLabel("Poids");
		lblPoids.setBounds(456, 206, 78, 13);
		contentPane.add(lblPoids);
		
		JLabel regi = new JLabel("New label");
		regi.setIcon(new ImageIcon(Inbox.class.getResource("/images/registre.png")));
		regi.setBounds(176, 0, 658, 459);
		contentPane.add(regi);
		
		rdbtnNon.addActionListener(this);
		rdbtnNewRadioButton.addActionListener(this);
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
		
		
	}
}
