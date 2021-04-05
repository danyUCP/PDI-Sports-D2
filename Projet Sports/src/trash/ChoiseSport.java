package trash;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ChoiseSport extends JDialog {

	/**
	 * @author PDI_D2
	 * Use dialog box in the register
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JRadioButton R1,R2, R3, R4, R5, R6;
	JButton cancelButton;

	/**
	 * Launch the application.
	 */
	 /*public static void main(String[] args) {
		ChoiseSport dialog = new ChoiseSport();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
	}*/

	/**
	 * Create the dialog.
	 */
	public ChoiseSport() {
		setBounds(100, 100, 574, 338);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Quels sports pratiquez-vous?");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(147, 10, 277, 32);
			contentPanel.add(lblNewLabel);
		}
		
		R2 = new JRadioButton("Musculation");
		R2.setBounds(224, 121, 103, 21);
		contentPanel.add(R2);
		
		R1 = new JRadioButton("Jogging");
		R1.setBounds(23, 121, 103, 21);
		contentPanel.add(R1);
		
		R4 = new JRadioButton("Escalade");
		R4.setBounds(23, 180, 103, 21);
		contentPanel.add(R4);
		
		R3 = new JRadioButton("Tir \u00E0 l\u2019arc");
		R3.setBounds(402, 121, 103, 21);
		contentPanel.add(R3);
		
		R5 = new JRadioButton("Aviron");
		R5.setBounds(224, 180, 103, 21);
		contentPanel.add(R5);
		
		R6 = new JRadioButton("Natation");
		R6.setBounds(402, 180, 103, 21);
		contentPanel.add(R6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new Action());
				buttonPane.add(cancelButton);
			}
		}
	}


	void radioButtons_itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == R1) System.out.println("Vous pratiquez du jogging");
        if (source == R2) System.out.println("Vous pratiquez dde la musculation");
        if (source == R3) System.out.println("Vous pratiquez du tir à l'arc");
    }
	
	public class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Cancel")) {
				  dispose();
			}
		}
	}
}
