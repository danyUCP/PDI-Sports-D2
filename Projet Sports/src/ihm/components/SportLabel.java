package ihm.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SportLabel extends JLabel
{
	private String texte;
	
	public SportLabel(String texte)
	{
		super(texte);
		
		this.texte = texte;
		

		this.setFont(new Font("Verdana", Font.PLAIN, 16));
		this.setBackground(new Color(28, 28, 28));
		this.setForeground(Color.WHITE);
		this.setVerticalAlignment(SwingConstants.CENTER);
	    this.setHorizontalAlignment(SwingConstants.CENTER);

	}
}