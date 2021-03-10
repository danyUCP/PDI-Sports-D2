package ihm.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class SportTextField extends JTextField
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