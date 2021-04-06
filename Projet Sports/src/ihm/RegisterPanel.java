package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.User;
import ihm.components.SportButton;
import ihm.components.SportTextField;
import orm.DBConnection;


/**
 * <code>RegisterPanel</code> 
 * Is the class that implements the registration of a user in order 
 * to have an account and access the all sports social network 
 * You can find further information and examples in
 * <a href="https://www.javaguides.net/2019/07/registration-form-using-java-swing-jdbc-mysql-example-tutorial.html">Registration Form using Java Swing + JDBC + MySQL Example Tutorial </a>,
 * <strong>NOTE:</strong>
 *This class<code>RegisterPanel</code>. implements all the components of the associated graphical ihm .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 */
public class RegisterPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static JPanel global;
	private JPanel panel, panel_1;
	private Dimension dim;
	private int width = 845;
	private int height = 460;
	private SportTextField textFieldLogin,textField_2,textField_3, textField_4,textField_5,textField_6,textField_7;
	private JPasswordField textField_1;
	private JLabel lblNewLabel,lblMdp,lblFirstname,lblLastname, lblGender,lblAge,lblSize,lblWeight,title;
	private SportButton btnSubmit,cancel;
	private Image background;
	@SuppressWarnings("unused")
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
		
		textField_1 =new JPasswordField(14);
		textField_1.setColumns(10);
		textField_1.setBounds(148, 92, 181, 26);
		textField_1.setBackground(new Color(50, 50, 50));
		textField_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		textField_1.setForeground(Color.WHITE);
		textField_1.setCaretColor(Color.WHITE);
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
		cancel.addActionListener(new Add_Workout());
		
		try
		{
			background = ImageIO.read(new File("resources/images/backImage.jpg"));
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
					@SuppressWarnings("unused")
					Transaction persistTransaction1 = session.beginTransaction();
					User u1 = new User(login,mdp,firstname,lastName,gender,age1,size1,weight1);
					session.save(u1);
					retour();
				
				}
			
				if(e1.getSource()== cancel) {
					retour()
;					
				}
				
		}
	}
	
	public void retour()
	{
		MainFrame frame = (MainFrame) (SwingUtilities.getRoot(MainFrame.getGlobal()));
		
		this.removeAll();
		frame.resetHome();
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
