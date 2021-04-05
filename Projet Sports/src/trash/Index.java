package trash;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;

import data.User;
import manager.Managers;
import manager.UserManager;
import orm.DBConnection;

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
	private String user="";
	private User use;
	private SportTextField pseudo,mdp;
	private static JPanel global;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Index frame = new Index();
		//frame.setUndecorated(true);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		present = new JLabel("");
		present.setBackground(new Color(255, 255, 255));
		present.setIcon(new ImageIcon(Index.class.getResource("/images/chart-ConvertImage.jpg")));
		present.setOpaque(true);
		present.setBounds(0, 167, 363, 335);
		contentPane.add(present);
		
		last_Name = new JTextField();
		last_Name.setColumns(10);
		last_Name.setBounds(504, 223, 212, 28);
		contentPane.add(last_Name);
		
		lblNewLabel = new JLabel("Bienvenue sur");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(430, 8, 239, 57);
		contentPane.add(lblNewLabel);
		
		id = new JLabel("S'identifier");
		id.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		id.setForeground(new Color(0, 128, 128));
		id.setBounds(547, 64, 122, 36);
		contentPane.add(id);
		
		id_name = new JLabel("Identifiant");
		id_name.setFont(new Font("Sitka Banner", Font.PLAIN, 13));
		id_name.setForeground(new Color(0, 128, 128));
		id_name.setBounds(410, 128, 58, 36);
		contentPane.add(id_name);
		
		id_name_1 = new JLabel("Mot de passe");
		id_name_1.setForeground(new Color(0, 128, 128));
		id_name_1.setFont(new Font("Sitka Banner", Font.PLAIN, 13));
		id_name_1.setBounds(391, 220, 77, 36);
		contentPane.add(id_name_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(504, 131, 212, 28);
		contentPane.add(textField);
		
		lblNewLabel_1 = new JLabel("LET'S GO");
		lblNewLabel_1.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setBounds(610, 0, 106, 71);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Index.class.getResource("/images/running.png")));
		lblNewLabel_2.setBounds(353, 10, 115, 174);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(504, 344, 91, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1_1 = new JButton("Submit");
		btnNewButton_1_1.setBackground(Color.GRAY);
		btnNewButton_1_1.setBounds(625, 344, 91, 21);
		contentPane.add(btnNewButton_1_1);
		
		new_compte = new JLabel("Creer un nouveau compte");
		new_compte.setHorizontalAlignment(SwingConstants.CENTER);
		new_compte.setForeground(Color.RED);
		new_compte.setBounds(536, 394, 160, 13);
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
			final String SEPARATEUR = ";";
			Session session = DBConnection.getSession();
			Managers usei= new Managers();
			if(!textField.getText().equals("") && !last_Name.getText().equals("")) {
				String a= usei.testWhereClause(session, textField.getText(),last_Name.getText());
				System.out.println(a);
				String word[] = a.split(SEPARATEUR);
				if(!a.equals(";;")){
					if(a.equals(word[0]+";"+word[1]+";"+word[2])) {
						dispose();
						UserManager um = new UserManager();
				use = um.findUser(word[1], word[2]);
						//Inbox frame = new Inbox();
						//frame.setUndecorated(true);
						//frame.setVisible(true);
						 if(use == null)
				JOptionPane.showMessageDialog(null, "Utilisateur inexistant");
			else
			{
				//contentPane.removeAll();
				//contentPane.add(new HomePanel(use));
				//contentPane.revalidate();
				SportGui frame= new SportGui();//use
				frame.setUndecorated(true);
				frame.setVisible(true);
				//HomePanel p= new HomePanel(use);
				//contentPane.setContentPane(p);
				
			}
				}
				}
				else {
				if(a.equals(";;")) {
					
					JOptionPane warning;
					warning = new JOptionPane();
				    warning.showMessageDialog(null, "L'identifiant ou le mot de passe est incorecte", "Erreur", JOptionPane.ERROR_MESSAGE);
				
				}
				}
				
			}
			else {
				JOptionPane info = new JOptionPane();
				info.showMessageDialog(null, "Vous devez renter un identifiant et un mot de passe", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		  
	}
	
	private class SportTextField extends JTextField
	{
		private int size;
		
		public SportTextField(int size)
		{
			super(size);
			
			this.size = size;
			

			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			this.setFont(new Font("Verdana", Font.PLAIN, 16));
			this.setBackground(new Color(50, 50, 50));
			this.setForeground(Color.WHITE);
			this.setCaretColor(Color.WHITE);
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
