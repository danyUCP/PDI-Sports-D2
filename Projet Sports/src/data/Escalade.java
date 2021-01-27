package data;

public class Escalade extends Sport
{
	private String course_difficulty;
	private int time_session;
	
	public Climbing(String course_difficulty, int time_session) {
		
		
     this.course_difficulty=course_difficulty;		
     this.time_session=time_session;		
	  
	}
	
	
	public String getcourse_difficulty() {
		
		
		return course_difficulty;
		
	}
	
	public int gettime_session() {
		
		
		return time_session;
		
		
	}
	
	
	public void setcoursedifficulty(String course_difficulty) {
		
		
		this.course_difficulty=course_difficulty;
		
		
		
	}
	
	public void settime_session(int time_session) {
		
	this.time_session=time_session;	
		
	}
	
	
	
	
}
 