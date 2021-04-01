package ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.User;
import ihm.components.SportButton;
import ihm.components.SportTextField;
import orm.DBConnection;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;

public class RegisterPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static JPanel global;
	private JPanel panel, panel_1;
	private Dimension dim;
	private int width = 845;//800;
	private int height = 460;//500;
	private SportTextField textFieldLogin,textField_2,textField_3, textField_4,textField_5,textField_6,textField_7;
	private JPasswordField textField_1;
	private JLabel lblNewLabel,lblMdp,lblFirstname,lblLastname, lblGender,lblAge,lblSize,lblWeight,title;
	private SportButton btnSubmit,cancel;
	private Image background;
	private JRadioButton R1,R2, R3, R4, R5, R6;
	private JLabel messagelabel;
	/**
	 * Create the panel.
	 */
	public RegisterPanel() {
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(Color.ORANGE);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(28, 28, 28));
		panel.setBounds(412, 0, 354, 377);
		add(panel);
		panel.setLayout(null);
		
		title = new JLabel("Register");
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(100, 10, 164, 20);
		title.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		panel.add(title);
		
		textFieldLogin =new SportTextField(17);
		textFieldLogin.setBounds(148, 56, 181, 26);
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textField_1 =new JPasswordField(17);
		textField_1.setColumns(10);
		textField_1.setBounds(148, 92, 181, 26);
		panel.add(textField_1);
		
		textField_2 = new SportTextField(17);
		textField_2.setColumns(10);
		textField_2.setBounds(148, 135, 181, 26);
		panel.add(textField_2);
		
		textField_3 =new SportTextField(17);
		textField_3.setColumns(10);
		textField_3.setBounds(148, 177, 181, 26);
		panel.add(textField_3);
		
		textField_4 = new SportTextField(17);
		textField_4.setColumns(10);
		textField_4.setBounds(148, 219, 181, 26);
		panel.add(textField_4);
		
		textField_5 = new SportTextField(17);
		textField_5.setColumns(10);
		textField_5.setBounds(148, 265, 181, 26);
		panel.add(textField_5);
		
		textField_6 = new SportTextField(17);
		textField_6.setColumns(10);
		textField_6.setBounds(148, 308, 181, 26);
		panel.add(textField_6);
		
		textField_7 = new SportTextField(17);
		textField_7.setColumns(10);
		textField_7.setBounds(148, 345, 181, 26);
		panel.add(textField_7);
		
		lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Source Serif Pro Semibold", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(47, 62, 74, 20);
		panel.add(lblNewLabel);
		
		lblMdp = new JLabel("Mdp");
		lblMdp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdp.setForeground(Color.WHITE);
		lblMdp.setFont(new Font("Source Serif Pro Semibold", Font.PLAIN, 14));
		lblMdp.setBounds(47, 98, 74, 20);
		panel.add(lblMdp);
		
		lblFirstname = new JLabel("FirstName");
		lblFirstname.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstname.setForeground(Color.WHITE);
		lblFirstname.setFont(new Font("Source Serif Pro Semibold", Font.PLAIN, 14));
		lblFirstname.setBounds(47, 141, 74, 20);
		panel.add(lblFirstname);
		
		lblLastname = new JLabel("Lastname");
		lblLastname.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastname.setForeground(Color.WHITE);
		lblLastname.setFont(new Font("Source Serif Pro Semibold", Font.PLAIN, 14));
		lblLastname.setBounds(47, 183, 74, 20);
		panel.add(lblLastname);
		
		lblGender = new JLabel("Gender : M/F");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Source Serif Pro Semibold", Font.PLAIN, 14));
		lblGender.setBounds(17, 225, 120, 20);
		panel.add(lblGender);
		
		lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Source Serif Pro Semibold", Font.PLAIN, 14));
		lblAge.setBounds(47, 271, 74, 20);
		panel.add(lblAge);
		
		lblSize = new JLabel("Size");
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setForeground(Color.WHITE);
		lblSize.setFont(new Font("Source Serif Pro Semibold", Font.PLAIN, 14));
		lblSize.setBounds(47, 314, 74, 20);
		panel.add(lblSize);
		
		lblWeight = new JLabel("Weight");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setFont(new Font("Source Serif Pro Semibold", Font.PLAIN, 14));
		lblWeight.setBounds(47, 351, 74, 20);
		panel.add(lblWeight);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(28, 28, 28));
		panel_1.setBounds(412, 376, 354, 38);
		add(panel_1);
		panel_1.setLayout(null);
		
		messagelabel=new JLabel("");
		messagelabel.setBounds(151, 181, 100, 30);
		
		btnSubmit = new SportButton("Submit");
		btnSubmit.setBounds(50, 10, 124, 21);
		panel_1.add(btnSubmit);
		
		cancel = new SportButton("Cancel");
		cancel.setBounds(184, 10, 85, 21);
		panel_1.add(cancel);
		
		btnSubmit.addActionListener(new Add_Workout());
		
		try
		{
			background = ImageIO.read(new File("resources/images/background.jpg"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	


public void paintComponent(Graphics g)
{
	Graphics2D g2d = (Graphics2D)g;
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

	super.paintComponent(g2d);

	g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
}
	
	public void addComposent() {
		
		title = new JLabel("Register");
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(100, 10, 164, 20);
		title.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		panel.add(title);
		
		R2 = new JRadioButton("Musculation");
		R2.setBounds(224, 121, 103, 21);
		R2.setBackground(new Color(50, 50, 50));
		R2.setForeground(Color.WHITE);
		R2.setFocusPainted(false);
		panel.add(R2);
		
		R1 = new JRadioButton("Jogging");
		R1.setBounds(23, 121, 103, 21);
		R1.setBackground(new Color(50, 50, 50));
		R1.setForeground(Color.WHITE);
		R1.setFocusPainted(false);
		panel.add(R1);
		
		R4 = new JRadioButton("Escalade");
		R4.setBounds(23, 180, 103, 21);
		R4.setBackground(new Color(50, 50, 50));
		R4.setForeground(Color.WHITE);
		R4.setFocusPainted(false);
		panel.add(R4);
		
		R3 = new JRadioButton("Tir à l'arc");
		R3.setBounds(23, 260, 103, 21);
		R3.setBackground(new Color(50, 50, 50));
		R3.setForeground(Color.WHITE);
		R3.setFocusPainted(false);
		panel.add(R3);
		
		R5 = new JRadioButton("Aviron");
		R5.setBounds(224, 180, 103, 21);
		R5.setBackground(new Color(50, 50, 50));
		R5.setForeground(Color.WHITE);
		R5.setFocusPainted(false);
		panel.add(R5);
		
		R6 = new JRadioButton("Natation");
		R6.setBounds(224, 260, 103, 21);
		R6.setBackground(new Color(50, 50, 50));
		R6.setForeground(Color.WHITE);
		R6.setFocusPainted(false);
		panel.add(R6);
		
	}
	
	void radioButtons_itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == R1) System.out.println("Vous pratiquez du jogging");
        if (source == R2) System.out.println("Vous pratiquez de la musculation");
        if (source == R3) System.out.println("Vous pratiquez du tir à l'arc");
        if (source == R4) System.out.println("Vous pratiquez de l'escalade");
        if (source == R5) System.out.println("Vous pratiquez de l'aviron");
        if (source == R6) System.out.println("Vous pratiquez de la natation");
    }
	
	public class Add_Workout implements ActionListener {
		
		public void actionPerformed(ActionEvent e1) {
			String weight=textField_7.getText();
			String size=textField_6.getText();
			String age=textField_5.getText();
			String gender=textField_4.getText();
			String lastName=textField_3.getText();
			String firstname=textField_2.getText();
			@SuppressWarnings("deprecation")
			String mdp=textField_1.getText();
			String login=textFieldLogin.getText();
			int weight1=Convettexttomesure(weight);
			int size1=Convettexttomesure(size);
			int age1=Convettexttomesure(age);
			
				if(e1.getSource()== btnSubmit) {
					Session session = DBConnection.getSession();
					Transaction persistTransaction1 = session.beginTransaction();
					User u1 = new User(login,mdp,firstname,lastName,gender,age1,size1,weight1);
					session.save(u1);
					btnSubmit.setText("AddWorkout");
					btnSubmit.setActionCommand("AddWorkout");
					panel.removeAll();
					panel.repaint();
					addComposent();
				
				}
				if(e1.getSource()== btnSubmit) {
					String newAction = e1.getActionCommand();
					if(newAction.equals("AddWorkout")) {
						System.out.println("Ajouter");
					}
				}
				if(e1.getSource()== cancel) {
					MainFrame frame = (MainFrame) (SwingUtilities.getRoot(MainFrame.getGlobal()));
					MainFrame.getGlobal().removeAll();
					frame.resetHome();
					MainFrame.getGlobal().revalidate();
					MainFrame.getGlobal().repaint();
					
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
}
