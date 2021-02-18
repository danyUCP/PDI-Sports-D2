package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import graph.SwimmingWorkoutBarChart;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JRadioButtonMenuItem;

public class Swimming extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[] liste={"1 jour","Une semaine","1 mois"};

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swimming frame = new Swimming();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Swimming() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Mettre basse");
		rdbtnmntmNewRadioItem.setBackground(new Color(192, 192, 192));
		rdbtnmntmNewRadioItem.setBounds(59, 129, 131, 24);
		contentPane.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmMettrePapillon = new JRadioButtonMenuItem("Mettre papillon");
		rdbtnmntmMettrePapillon.setBackground(new Color(192, 192, 192));
		rdbtnmntmMettrePapillon.setBounds(54, 194, 131, 24);
		contentPane.add(rdbtnmntmMettrePapillon);
		
		JRadioButtonMenuItem rdbtnmntmMettreCrowl = new JRadioButtonMenuItem("Mettre Crowl");
		rdbtnmntmMettreCrowl.setBackground(new Color(192, 192, 192));
		rdbtnmntmMettreCrowl.setBounds(59, 259, 131, 24);
		contentPane.add(rdbtnmntmMettreCrowl);
		
		JRadioButtonMenuItem rdbtnmntmMettreArrire = new JRadioButtonMenuItem("Mettre arri\u00E8re");
		rdbtnmntmMettreArrire.setBackground(new Color(192, 192, 192));
		rdbtnmntmMettreArrire.setBounds(59, 322, 131, 24);
		contentPane.add(rdbtnmntmMettreArrire);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnmntmNewRadioItem);
		bg.add(rdbtnmntmMettrePapillon);
		bg.add(rdbtnmntmMettreCrowl);
		bg.add(rdbtnmntmMettreCrowl);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.setForeground(new Color(169, 169, 169));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(759, 47, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setForeground(new Color(192, 192, 192));
		btnNewButton.setBounds(10, 428, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Type de natation");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(54, 64, 136, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Lets go");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(10, 10, 243, 23);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(169, 169, 169));
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setBounds(581, 46, 136, 23);
		contentPane.add(comboBox);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel(liste));
		
		JLabel left = new JLabel("");
		left.setOpaque(true);
		left.setBackground(new Color(0, 0, 128));
		left.setBounds(0, 0, 266, 459);
		contentPane.add(left);
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(169, 169, 169));
		textPane.setBackground(new Color(192, 192, 192));
		textPane.setBounds(359, 46, 136, 23);
		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Distance en km");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(266, 48, 126, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Periode");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(520, 51, 66, 18);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel left_1 = new JLabel("");
		left_1.setOpaque(true);
		left_1.setBackground(new Color(0, 0, 128));
		left_1.setBounds(263, 0, 581, 94);
		contentPane.add(left_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Swimming.class.getResource("/images/piscine.jpg")));
		lblNewLabel_4.setBounds(266, 92, 578, 367);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton_1.addActionListener(new Graph());
		
	}
	
	public class Graph implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			SwimmingWorkoutBarChart demo = new SwimmingWorkoutBarChart("SwimmingWorkoutBar Chart");
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
			
		}
	}
}
