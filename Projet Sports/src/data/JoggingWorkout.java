package data;

import java.sql.Date;

public class JoggingWorkout extends Workout
{
	private int distance;
	public JoggingWorkout(Date date, int duration, int distance) {
		super(date, duration);
		this.distance=distance;
	}

	

	
	

	public int getDistance() 
	{
		return distance;
	}

	public void setDistance(int distance) 
	{
		this.distance = distance;
	}


	
	
	

}
