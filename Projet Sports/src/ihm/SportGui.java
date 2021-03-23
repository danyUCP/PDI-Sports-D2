package ihm;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.User;

public class SportGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					SportGui frame = new SportGui();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public SportGui() {
		User user = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 496);
		//contentPane = new JoggingPanel();
		//contentPane=new RowingPanel();
		contentPane = new ClimbingPanel(user);
		//contentPane = new SwimmingPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
