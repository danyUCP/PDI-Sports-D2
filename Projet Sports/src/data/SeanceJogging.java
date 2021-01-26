package data;

import java.util.Date;

public class SeanceJogging extends Seance
{
	private int distance;

	
	public SeanceJogging(Date date, int duree, int distance) 
	{
		super(date, duree);
		this.distance = distance;
	}

	public int getDistance() 
	{
		return distance;
	}

	public void setDistance(int distance) 
	{
		this.distance = distance;
	}


	public String toString() 
	{
		return "Séance de Jogging  --> " + super.toString() + "  -  Distance : " + distance + "m";
	}
	
	
	

}
