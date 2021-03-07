package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ihm.Index.Cancel;
import manager.Managers;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Inbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Managers man=new Managers();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Inbox frame = new Inbox();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Inbox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(man.getUser());
		lblNewLabel_1.setBounds(138, 25, 128, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Inbox.class.getResource("/images/running_oo.png")));
		btnNewButton.setBounds(160, 133, 142, 144);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(Inbox.class.getResource("/images/muscu.png")));
		btnNewButton_1.setBounds(365, 133, 142, 140);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon(Inbox.class.getResource("/images/swimming.png")));
		btnNewButton_3.setBounds(552, 272, 136, 140);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(Inbox.class.getResource("/images/canoe.png")));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(365, 272, 142, 140);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(Inbox.class.getResource("/images/climbing.png")));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(160, 272, 142, 140);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setIcon(new ImageIcon(Inbox.class.getResource("/images/archery.png")));
		btnNewButton_3_1.setBounds(552, 133, 136, 140);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon(Inbox.class.getResource("/images/power-off.png")));
		btnNewButton_2.setBounds(625, 29, 63, 59);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setIcon(new ImageIcon(Inbox.class.getResource("/images/friends.png")));
		btnNewButton_6.setBounds(524, 29, 74, 59);
		contentPane.add(btnNewButton_6);
		
		JLabel fond = new JLabel("");
		fond.setOpaque(true);
		fond.setBackground(Color.WHITE);
		fond.setBounds(127, 10, 589, 420);
		contentPane.add(fond);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inbox.class.getResource("/images/fitnessPark.jpg")));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 844, 459);
		contentPane.add(lblNewLabel);
		//Cancel cancel=new Cancel();
		btnNewButton_3.addActionListener(new Action());
		//btnNewButton_2.addActionListener(new Cancel());
		
	}
	
	public class Action implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			SwimmingPanel frame = new SwimmingPanel();
			frame.setVisible(true);
		}
	}
}
