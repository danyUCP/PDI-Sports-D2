package data;

public class Jogging extends Sport
{
	private int duree;
	private int distance;
	
	public Jogging(int duree,int distance) {
		
		this.duree=duree; 
		this.distance=distance;
		
			
	}
	
    public	int getduree() {
		
		
		
	return duree;	
		
	}
	 public void setduree(int duree) {
		
		
	this.duree=duree;	
		
	}
	public int getdistance() {
		
		
	return distance;	
		
	}
	 
	public void setdistance(int distance) {
		
		
	this.distance=distance;	
		
	}
    


}
    