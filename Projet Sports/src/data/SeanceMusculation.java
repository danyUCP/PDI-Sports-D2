package data;

public class SeanceMusculation extends Seance
{
    public SeanceMusculation(int date,int duree) {
	
	 super(date,duree);
	
	
	
 }
    public int getduree() {
    	
    	
    	return duree;
    	
    }
    
    public void setduree(int duree) {
    	
    	this.duree=duree;
    	
    	
    }
   public int getdate() {
	   
	   
	   
	  return date; 
	   
   }
   
   public void setdate(int date) {
	   this.date=date;
	   
   }

}
