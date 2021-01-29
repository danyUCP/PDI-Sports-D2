package data;

import java.sql.Date;

public class RowingWorkout extends Workout
{
	private int distance;
	private int paddleStrokes;


	

	public RowingWorkout(Date date, int duration, int distance, int paddleStrokes) {
		super(date, duration);
		this.distance = distance;
		this.setPaddleStrokes(paddleStrokes);
	}

	public int getDistance() 
	{
		return distance;
	}

	public void setDistance(int distance) 
	{
		this.distance = distance;
	}

	public int getPaddleStrokes() {
		return paddleStrokes;
	}

	public void setPaddleStrokes(int paddleStrokes) {
		this.paddleStrokes = paddleStrokes;
	}

	
	


}
