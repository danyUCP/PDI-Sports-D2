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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.User;
import manager.UserManager;

public class MainFrame extends JFrame
{
	private User user;
	private BackPanel back;
	private static JPanel global;
	private JPanel section, header, connexion;
	private JPanel log1, log2, controls;
	private HomePanel home;
	
	private SportButton connect, create;
	
	private SportLabel title;
	private SportTextField pseudo, mdp;
	
	private int width = 845;//800;
	private int height = 460;//500;
	private String id,pass;
	
	
	/**
	 * Constructeur de la classe Fenetre.
	 * 
	 * Ce constructeur gère la disposition des éléments de l'accueil
	 */
	public MainFrame()
	{
		this.setTitle("Bon... Qui a une idée ?");
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
		mdp = new SportTextField(14);		
		log2.add(mdp);
		
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
	
	public void change() {
		global.removeAll();
		global.add(new RowingPanel(), BorderLayout.CENTER);
		global.revalidate();
	}
	
	public void siwmPanel() {
		global.removeAll();
		global.add(new SwimmingPanel(), BorderLayout.CENTER);
		global.revalidate();
		
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
		public void actionPerformed(ActionEvent e) 
		{
			
			if(e.getSource() == connect)
			{
				UserManager um = new UserManager();
				user = um.findUser(pseudo.getText(), mdp.getText());
				id=pseudo.getText();
				pass=mdp.getText();
				
				if(user == null)
					JOptionPane.showMessageDialog(null, "Utilisateur inexistant");
				else
				{
					global.removeAll();
					global.add(new HomePanel(user), BorderLayout.CENTER);
				}
				
			}
			/*
			else if(e.getSource() == proteine)
				global.add(new ARNPanel(), BorderLayout.CENTER);
			else if(e.getSource() == heritage)
				global.add(new HeritagePanel(),BorderLayout.CENTER);
			*/
			global.revalidate();	
		}
	}
	
	public String getId() {
		return id;
	}
	
	public String getPass() {
		return pass;
	}
	
	private class BackPanel extends JPanel
	{
		/**
		 * 
		 */
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
	
	private class SportLabel extends JLabel
	{
		private String texte;
		
		public SportLabel(String texte)
		{
			super(texte);
			
			this.texte = texte;
			

			this.setFont(new Font("Verdana", Font.PLAIN, 16));
			this.setBackground(new Color(50, 50, 50));
			this.setForeground(Color.WHITE);
			this.setVerticalAlignment(SwingConstants.CENTER);
		    this.setHorizontalAlignment(SwingConstants.CENTER);

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
	
	private class SportButton extends JButton implements MouseListener
	{
		public SportButton(String name)
		{
			super("  " + name + "  ");
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			this.setFocusPainted(false);
			this.setFont(new Font("Verdana", Font.PLAIN, 16));
			this.setVerticalTextPosition(SwingConstants.CENTER);
		    this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setBackground(new Color(50, 50, 50));
			this.setForeground(Color.WHITE);
			
			this.addMouseListener(this);
		}

		public void mouseEntered(MouseEvent e) 
		{
			if(this.isEnabled())
				this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		}

		public void mouseExited(MouseEvent e) 
		{
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		}
		
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}

	


	

}
