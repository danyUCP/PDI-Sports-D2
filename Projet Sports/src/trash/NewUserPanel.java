package trash;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import data.User;
import ihm.HomePanel;
import ihm.MainFrame;
import ihm.components.SportButton;
import ihm.components.SportLabel;
import ihm.components.SportTextField;
import manager.UserManager;

public class NewUserPanel extends JPanel
{
	private User user;

	private JPanel section, header, connexion;
	private JPanel log1, log2, controls;
	private HomePanel home;
	
	private SportButton connect, create;
	
	private SportLabel title;
	private SportTextField pseudo, mdp;
	private Image background;

	private Dimension dim;
	private int width = 858;
	private int height = 496;
	


	public NewUserPanel()
	{
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setLayout(new FlowLayout());
		
		//-------------- CONTENT PANE ------------------//
		section = new JPanel();
		section.setBounds(350, 50, width - 450, height - 100);
		section.setBackground(new Color(28, 28, 28));
		section.setLayout(new GridLayout(3, 1));
		this.add(section);

		header = new JPanel();
		header.setBackground(new Color(28, 28, 28));
		header.setLayout(new BorderLayout());
		header.add(new SportLabel("Bienvenue sur"), BorderLayout.NORTH);
		title = new SportLabel("Tous Sports");
		title.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 36));
		header.add(title, BorderLayout.CENTER);
		section.add(header);
		
		//-------------- CONNECT PAGE ------------------//		
		//displayElements();
		

		try
		{
			background = ImageIO.read(new File("resources/images/backImage.jpg"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	

	private void displayElements()
	{
		
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
	


	public void close()
	{
		MainFrame frame = (MainFrame) (SwingUtilities.getRoot(MainFrame.getGlobal()));
		
		this.removeAll();
		frame.resetHome();
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
				
				if(user == null)
					JOptionPane.showMessageDialog(null, "Utilisateur inexistant");
				else
				{
					//global.removeAll();
					//global.add(new HomePanel(user), BorderLayout.CENTER);
				}
				
			}
			else if(e.getSource() == create)
			{
				//Actions pour le bouton create
			}

			//global.revalidate();	
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
