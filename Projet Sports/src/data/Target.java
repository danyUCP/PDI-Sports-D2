package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Target 
{
	@Id
	@GeneratedValue
	private int id;
	
	private int target_distance;
	
	private int yellow_area;
	private int red_area;
	private int blue_area;
	private int black_area;
	private int white_area;
	
	private int misses;

	public Target() {	}
	
	public Target(int target_distance, int yellow_area, int red_area, int blue_area, int black_area, int white_area, int misses) 
	{
		this.target_distance = target_distance;
		
		this.yellow_area = yellow_area;
		this.red_area = red_area;
		this.blue_area = blue_area;
		this.black_area = black_area;
		this.white_area = white_area;
		
		this.misses = misses;
	}

	
	public int getShots() 
	{
		return yellow_area + red_area + blue_area + black_area + white_area + misses;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getTarget_distance() 
	{
		return target_distance;
	}

	public void setTarget_distance(int target_distance) 
	{
		this.target_distance = target_distance;
	}

	public int getYellow_area() 
	{
		return yellow_area;
	}

	public void setYellow_area(int yellow_area) 
	{
		this.yellow_area = yellow_area;
	}

	public int getRed_area() 
	{
		return red_area;
	}

	public void setRed_area(int red_area) 
	{
		this.red_area = red_area;
	}

	public int getBlue_area() 
	{
		return blue_area;
	}

	public void setBlue_area(int blue_area) 
	{
		this.blue_area = blue_area;
	}

	public int getBlack_area() 
	{
		return black_area;
	}

	public void setBlack_area(int black_area) 
	{
		this.black_area = black_area;
	}

	public int getWhite_area() 
	{
		return white_area;
	}

	public void setWhite_area(int white_area) 
	{
		this.white_area = white_area;
	}

	public int getMisses() 
	{
		return misses;
	}

	public void setMisses(int misses) 
	{
		this.misses = misses;
	}
	
	
	@Override
	public String toString() 
	{
		String s = "";
		
		s += "Distance : " + target_distance + "m \n";
		s += "\t\tFlèches par zone : \n";
		s += "\t\tJaune -> " + yellow_area + " | Rouge -> " + red_area + " | Bleue -> " + blue_area + " | Noire -> " + black_area  + " | Blanche -> " + white_area + " | Ratés -> " + misses + "\n";
		s += "\t\tNombre de tirs -> " + this.getShots();
		
		return s;
	}
	
}
