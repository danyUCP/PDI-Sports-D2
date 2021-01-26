package data;

import java.util.Date;

public class SeanceAviron extends Seance
{
	private int distance;
	private int coupsPagaie;


	public SeanceAviron(Date date, int duree, int distance, int coupsPagaie) 
	{
		super(date, duree);
		this.distance = distance;
		this.coupsPagaie = coupsPagaie;
	}

	public int getDistance() 
	{
		return distance;
	}

	public void setDistance(int distance) 
	{
		this.distance = distance;
	}

	public int getCoupsPagaie() 
	{
		return coupsPagaie;
	}

	public void setCoupsPagaie(int coupsPagaie) 
	{
		this.coupsPagaie = coupsPagaie;
	}
	
	
	public String toString() 
	{
		return "Séance d'Aviron  --> " + super.toString() + "  -  Distance : " + distance + "m  -  Coups de pagaie : " + coupsPagaie + "  ";
	}


}
