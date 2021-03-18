package data;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class ClimbingWorkout extends Workout 
{
	private String course_difficulty;


	public ClimbingWorkout() {	}

	public ClimbingWorkout(Date date, int duration, String course_difficulty) 
	{
		super(date, duration);
		this.course_difficulty = course_difficulty;
	}


	public String getCourseDifficulty() 
	{
		return course_difficulty;
	}

	public void setCourseDifficulty(String course_difficulty) 
	{
		this.course_difficulty = course_difficulty;
	}


}
