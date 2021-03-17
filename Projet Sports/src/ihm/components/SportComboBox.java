package ihm.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class SportComboBox extends JComboBox<String>
{
	private String[] list;

	public SportComboBox(String[] list)
	{
		super(list);

		this.list = list;


		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		this.setFont(new Font("Verdana", Font.PLAIN, 16));
		this.setBackground(new Color(50, 50, 50));
		this.setForeground(Color.WHITE);

	}

}