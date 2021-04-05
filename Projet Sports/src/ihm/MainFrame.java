package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import data.User;
import ihm.components.SportButton;
import ihm.components.SportLabel;
import ihm.components.SportTextField;
import manager.UserManager;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	private User user;
	private BackPanel back;
	private static JPanel global;
	private JPanel section, header, connexion;
	private JPanel log1, log2, controls;
	
	private SportButton connect, create;
	
	private SportLabel title;
	private SportTextField pseudo;
	private JPasswordField mdp1;
	
	private int width = 845;//800;
	private int height = 460;//500;
	
	
	/**
	 * Constructeur de la classe Fenetre.
	 * 
	 * Ce constructeur gère la disposition des éléments de l'accueil
	 */
	public MainFrame()
	{
		this.setTitle("Sport D2");
		this.setSize(width, height);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		//-------------- CONTENT PANE ------------------//
		global = new JPanel();
	    global.setPreferredSize(new Dimension(width, height));
		global.setBackground(Color.CYAN);
		global.setLayout(new BorderLayout());
		this.setContentPane(global);
		
		
		//-------------- CONNECT PAGE ------------------//		
		displayElements();
		
		this.setVisible(true);
		pack();
	}
	

	private void displayElements()
	{
		back = new BackPanel();
		back.setSize(width, height);
		back.setBackground(Color.ORANGE);
		back.setLayout(null);
		global.add(back);		
		
		section = new JPanel();
		section.setBounds(350, 50, width - 450, height - 100);
		section.setBackground(new Color(28, 28, 28));
		section.setLayout(new GridLayout(3, 1));
		back.add(section);
		
		header = new JPanel();
		header.setBackground(new Color(28, 28, 28));
		header.setLayout(new BorderLayout());
		header.add(new SportLabel("Bienvenue sur"), BorderLayout.NORTH);
		title = new SportLabel("Tous Sports");
		title.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 36));
		header.add(title, BorderLayout.CENTER);
		section.add(header);
		
		connexion = new JPanel();
		connexion.setBackground(new Color(28, 28, 28));
		connexion.setLayout(new GridLayout(3, 1));		

		log1 = new JPanel();
		log1.setBackground(new Color(28, 28, 28));
		log1.add(new SportLabel("Pseudo : "));
		pseudo = new SportTextField(17);
		log1.add(pseudo);
		
		log2 = new JPanel();
		log2.setBackground(new Color(28, 28, 28));
		log2.add(new SportLabel("Mot de passe : "));
		mdp1 = new JPasswordField(17);
		mdp1.setBackground(new Color(50, 50, 50));
		mdp1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		mdp1.setFont(new Font("Verdana", Font.PLAIN, 16));
		mdp1.setForeground(Color.WHITE);
		mdp1.setCaretColor(Color.WHITE);
		log2.add(mdp1);
		
		controls = new JPanel();
		controls.setBackground(new Color(28, 28, 28));
		controls.setLayout(new FlowLayout());
		
		connect = new SportButton("Se connecter");
		create = new SportButton("Créer le compte");		
		controls.add(connect);
		controls.add(create);
		
		connexion.add(log1);
		connexion.add(log2);
		connexion.add(controls);
		section.add(connexion);
		
		connect.addActionListener(new ButtonListener());
		create.addActionListener(new ButtonListener());
	}
	
	/**
	 * Cette méthode permet de réinitialiser l'accueil
	 */
	public void resetHome()
	{
		global.removeAll();

		//-------------- CONNECT PAGE ------------------//		
		displayElements();

		this.revalidate();
		this.repaint();
	}
	
	
	
	public static JPanel getGlobal() 
	{
		return global;
	}

	
	
	/**
	 * Ecouteur associé aux boutons "cycle", "proteine" et "heritage" du panneau de commandes.
	 * 
	 * Chacun des boutons déclenche l'affichage du panel d'accès aux activités
	 */
	private class ButtonListener implements ActionListener
	{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) 
		{
			
			if(e.getSource() == connect)
			{
				UserManager um = new UserManager();
				user = um.findUser(pseudo.getText(), mdp1.getText());
				
				if(user == null)
					JOptionPane.showMessageDialog(null, "Utilisateur inexistant");
				else
				{
					global.removeAll();
					global.add(new HomePanel(user), BorderLayout.CENTER);
				}
				
			}
			else if(e.getSource() == create)
			{
				global.removeAll();
				global.add(new RegisterPanel(), BorderLayout.CENTER);
				global.repaint();
			}

			global.revalidate();	
		}
	}
	
	
	private class BackPanel extends JPanel
	{
	
		private static final long serialVersionUID = 1L;
		private Image background;
		
		public BackPanel()
		{
			super(null);
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
	}
		
	
	

	


	

}
