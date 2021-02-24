package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import data.User;

public class HomePanel extends JPanel
{
	private User user;

	private JPanel section, menu, header, footer, content, profile;
	private JPanel userPanel, history;
	private MenuButton profileButton, friendsButton, deconnexionButton;
	private MenuButton joggButton, climbButton, rowButton, muscuButton, swimButton, archButton;
	private ProfileLabel uName, uAge, uSize, uWeight, dateLabel, hourLabel, lastSessionLabel;
	private Image background;

	private Dimension dim;
	private int width = 800;
	private int height = 500;
	
	
	public HomePanel(User user)
	{
		this.user = user;
		
		this.dim = new Dimension(width, height);
		this.setSize(dim);
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
		
		section = new JPanel();
		section.setBounds(100, 50, width - 200, height - 100);
		section.setBackground(new Color(28, 28, 28));
		section.setLayout(new BorderLayout());
		this.add(section);

		
		header = new JPanel();
		header.setPreferredSize(new Dimension(width, 40));
		header.setBackground(new Color(10, 10, 10));
		initHeader();
		section.add(header, BorderLayout.NORTH);
		
		content = new JPanel();
		content.setPreferredSize(new Dimension(width, height - 40));
		content.setBackground(new Color(28, 28, 28));
		content.setLayout(new GridLayout(2, 1));
		section.add(content, BorderLayout.CENTER);
		
		profile = new JPanel();
		profile.setBackground(new Color(28, 28, 28));
		profile.setLayout(new BorderLayout());
		initProfile();
		content.add(profile);
		
		menu = new JPanel();
		menu.setBackground(new Color(28, 28, 28));
		menu.setLayout(new GridLayout(2, 3, 5, 5));
		initMenu();
		content.add(menu);
		
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
	
	public void initHeader()
	{	
		header.setLayout(new GridLayout(1, 3));
		
		profileButton = new MenuButton("Profil", "");
		friendsButton = new MenuButton("Amis", "");
		deconnexionButton = new MenuButton("Deconnexion", "");
		
		header.add(profileButton);		
		header.add(friendsButton);
		header.add(deconnexionButton);
		
		//profileButton.addActionListener(new ButtonListener());
		//friendsButton.addActionListener(new ButtonListener());
		deconnexionButton.addActionListener(new ButtonListener());
	}
	
	public void initMenu()
	{	
		joggButton = new MenuButton("Jogging", "resources/images/jogging.png");
		climbButton = new MenuButton("Escalade", "resources/images/climbing.png");
		rowButton = new MenuButton("Aviron", "resources/images/rowing.png");
		muscuButton = new MenuButton("Musculation", "resources/images/muscu.png");
		swimButton = new MenuButton("Natation", "resources/images/swimming.png");
		archButton = new MenuButton("Tir à l'arc", "resources/images/archery.png");
		
		menu.add(joggButton);
		menu.add(climbButton);
		menu.add(rowButton);	
		menu.add(muscuButton);	
		menu.add(swimButton);	
		menu.add(archButton);	
		
		//joggButton.addActionListener(new MenuListener());
		//climbButton.addActionListener(new MenuListener());
		//rowButton.addActionListener(new MenuListener());
	}
	
	public void initProfile()
	{
		userPanel = new JPanel();
		userPanel.setBackground(new Color(28, 28, 28));
		userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
		uName = new ProfileLabel(user.getLastname().toUpperCase() + " " + user.getFirstname(), Font.BOLD, 24);
		uAge = new ProfileLabel(user.getAge() + " ans");
		uSize = new ProfileLabel(user.getSize() + " cm");
		uWeight = new ProfileLabel(user.getWeight() + " kg");
		
		userPanel.add(uName);
		userPanel.add(uAge);
		userPanel.add(uSize);
		userPanel.add(uWeight);
		profile.add(userPanel, BorderLayout.CENTER);
		
		history = new JPanel();
		history.setPreferredSize(new Dimension(width / 4, height / 3));
		history.setBackground(new Color(28, 28, 28));
		history.setLayout(new BoxLayout(history, BoxLayout.Y_AXIS));
		
		Date today = new Date();
		SimpleDateFormat dayFormat = new SimpleDateFormat("EEE dd MMMM yyyy");
		SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
		dateLabel = new ProfileLabel(dayFormat.format(today), Font.ITALIC, 16);
		dateLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		hourLabel = new ProfileLabel(hourFormat.format(today), Font.ITALIC, 24);
		hourLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lastSessionLabel = new ProfileLabel("Aucune dernière séance", Font.ITALIC, 14);

		history.add(dateLabel);
		history.add(hourLabel);
		history.add(lastSessionLabel);
		profile.add(history, BorderLayout.EAST);
	}
	
	public void fermer()
	{
		MainFrame frame = (MainFrame) (SwingUtilities.getRoot(MainFrame.getGlobal()));
		
		
		this.removeAll();
		frame.resetHome();
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{			
			if(e.getSource() == deconnexionButton)
				fermer();
			
			/*
			else if(e.getSource() == proteine)
				global.add(new ARNPanel(), BorderLayout.CENTER);
			else if(e.getSource() == heritage)
				global.add(new HeritagePanel(),BorderLayout.CENTER);
			*/
		}
	}
	
	private class MenuButton extends JButton implements MouseListener
	{
		public MenuButton(String nom, String iconFile)
		{
			super("  " + nom + "  ");
			
			this.setIcon(new ImageIcon(iconFile));
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			this.setFocusPainted(false);
			this.setFont(new Font("Verdana", Font.PLAIN, 15));
			this.setVerticalTextPosition(SwingConstants.CENTER);
		    this.setHorizontalTextPosition(SwingConstants.RIGHT);
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
	
	private class ProfileLabel extends JLabel
	{
		private String texte;
		
		public ProfileLabel(String texte)
		{
			super(texte);
			
			this.texte = texte;
			

			this.setFont(new Font("Verdana", Font.PLAIN, 20));
			this.setBackground(new Color(28, 28, 28));
			this.setForeground(Color.WHITE);
			this.setVerticalAlignment(SwingConstants.CENTER);
		    this.setHorizontalAlignment(SwingConstants.LEFT);
		}
		
		public ProfileLabel(String texte, int style, int size)
		{
			super(texte);
			
			this.texte = texte;
			
			this.setFont(new Font("Verdana", style, size));
			this.setBackground(new Color(28, 28, 28));
			this.setForeground(Color.WHITE);
			this.setVerticalAlignment(SwingConstants.CENTER);
		    this.setHorizontalAlignment(SwingConstants.LEFT);
		}

	}

}
