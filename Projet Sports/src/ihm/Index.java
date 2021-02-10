package ihm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.HibernateUtil;
import manager.UserManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Index extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField last_Name;
	private JLabel lblNewLabel,new_compte,id,id_name, id_name_1, lblNewLabel_1,lblNewLabel_2,present;
	private JTextField textField;
	JButton btnNewButton_1_1,btnNewButton_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Index frame = new Index();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		present = new JLabel("");
		present.setBackground(new Color(255, 255, 255));
		present.setIcon(new ImageIcon(Index.class.getResource("/images/chart-ConvertImage.jpg")));
		present.setOpaque(true);
		present.setBounds(-2, 107, 271, 435);
		contentPane.add(present);
		
		last_Name = new JTextField();
		last_Name.setColumns(10);
		last_Name.setBounds(342, 223, 212, 28);
		contentPane.add(last_Name);
		
		lblNewLabel = new JLabel("Bienvenue sur");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(322, 8, 239, 57);
		contentPane.add(lblNewLabel);
		
		id = new JLabel("S'identifier");
		id.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		id.setForeground(new Color(0, 128, 128));
		id.setBounds(397, 68, 122, 36);
		contentPane.add(id);
		
		id_name = new JLabel("Identifiant");
		id_name.setFont(new Font("Sitka Banner", Font.PLAIN, 13));
		id_name.setForeground(new Color(0, 128, 128));
		id_name.setBounds(279, 128, 58, 36);
		contentPane.add(id_name);
		
		id_name_1 = new JLabel("Mot de passe");
		id_name_1.setForeground(new Color(0, 128, 128));
		id_name_1.setFont(new Font("Sitka Banner", Font.PLAIN, 13));
		id_name_1.setBounds(272, 220, 77, 36);
		contentPane.add(id_name_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(342, 131, 212, 28);
		contentPane.add(textField);
		
		lblNewLabel_1 = new JLabel("LET'S GO");
		lblNewLabel_1.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setBounds(494, 0, 106, 71);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Index.class.getResource("/images/running.png")));
		lblNewLabel_2.setBounds(289, 0, 115, 174);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(313, 344, 91, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1_1 = new JButton("Submit");
		btnNewButton_1_1.setBackground(Color.GRAY);
		btnNewButton_1_1.setBounds(463, 344, 91, 21);
		contentPane.add(btnNewButton_1_1);
		
		new_compte = new JLabel("Cr\u00E9er un nouveau compte");
		new_compte.setHorizontalAlignment(SwingConstants.CENTER);
		new_compte.setForeground(Color.RED);
		new_compte.setBounds(359, 394, 160, 13);
		contentPane.add(new_compte);
		
		/**
		 * Assigning actions to buttons and mouseCliked
		 */
		
		btnNewButton_1_1.addActionListener(new Submit());
		btnNewButton_1.addActionListener(new Cancel());
		
		new_compte.addMouseListener(new MouseAdapter() {
           
    public void mouseClicked(MouseEvent e) {
        dispose();
        Register re = new Register();
        re.setVisible(true);
        }

        });
	}
	
	/**
	 * Create ActionListener
	 *
	 */
	public class Submit implements ActionListener {

		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e) {
			//User u=new User();
			UserManager use= new UserManager();
			if(!textField.getText().equals("") && !last_Name.getText().equals("")) {
				/*if(textField.getText()==u.getMdp() && last_Name.getText()==u.getMdp()) {
					System.out.println("Vous avez renter "+ textField.getText()+" et "+last_Name.getText());
					System.out.println("Vous avez cliquer sur Submit");
				}*/
				use.addUser("e-sn", "123", "NIL", "Sam", "M", 30, (float) 1.70, 60);
				use.addUser("e-KL", "123", "LIL", "Kai", "F", 20, (float)1.60, 40);
				use.addUser("e-xm", "123", "Mihuel", "xavier", "M", 25, (float)1.90, 80);
				String a= use.getInfoUser(1);
				HibernateUtil.sessionFactory.close();
				if(a.equals(textField.getText()+last_Name.getText())) {
					dispose();
					Inbox frame = new Inbox();
					frame.setUndecorated(true);
					frame.setVisible(true);
				}
				
				else {
					
					JOptionPane warning;
					warning = new JOptionPane();
				    warning.showMessageDialog(null, "L'identifiant ou le mot de passe est incorecte", "Erreur", JOptionPane.ERROR_MESSAGE);
				    if(a.equals(textField.getText()+last_Name.getText())) {
						dispose();
						Inbox frame = new Inbox();
						frame.setVisible(true);
					}
				}
				
				
			}
			else {
				JOptionPane info = new JOptionPane();
				info.showMessageDialog(null, "Vous devez renter un identifiant et un mot de passe", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		  
	}
	public class Cancel implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			/**
			 * This function close the panel
			 */
			dispose();
			
		}
		  
	}
}
