package data;

public class Rowing {

	int travelled_distance;
	int timesession;
	
  public Rowing(	int travelled_distance,int timesession) {
	
	this.travelled_distance=travelled_distance;
	this.timesession=timesession;
  }
	
	
	   
  public int gettimesessinon() {
	  
	     
	  return timesession;
  
  }
	
	
public int 	gettravelled_distance() {
	
	return travelled_distance;
	
}
	
	
	
	
	public void settravelled_distance(int travelled_distance,int timesession){
		
	this.travelled_distance=travelled_distance;	
	this.timesession=timesession;;	
		
		
	}
	
}



