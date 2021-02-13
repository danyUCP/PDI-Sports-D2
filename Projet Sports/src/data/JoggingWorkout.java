package data;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class JoggingWorkout extends Workout
{
	private int distance;
	
	public JoggingWorkout() {	}
	
	public JoggingWorkout(Date date, int duration, int distance) 
	{
		super(date, duration);
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


	@Override
	public String toString() 
	{
		return "Jogging Workout -> " + super.toString() + " | Distance : " + distance + "m";
	}

	
}
