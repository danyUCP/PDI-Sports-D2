package data;

import java.sql.Date;

public class ClimbingWorkout extends Workout {

		private String course_difficulty;
		
		
		public ClimbingWorkout(Date date,int duration,String course_difficulty) {
			super(date,duration);
			this.course_difficulty=course_difficulty;		
	     		
		
		
		}
		
		
		public String getcourse_difficulty() {
			
			
			return course_difficulty;
			
		}
		
	
		
		
		public void setcoursedifficulty(String course_difficulty) {
			
			
			this.course_difficulty=course_difficulty;
			
			
			
		
		
		
		
	}
}
