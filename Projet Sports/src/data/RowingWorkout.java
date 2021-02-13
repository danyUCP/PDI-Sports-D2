package data;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class RowingWorkout extends Workout
{
	private int distance;
	private int paddle_strokes;


	public RowingWorkout(Date date, int duration, int distance, int paddle_strokes) 
	{
		super(date, duration);
		this.distance = distance;
		this.paddle_strokes = paddle_strokes;
	}


	public int getDistance() 
	{
		return distance;
	}

	public void setDistance(int distance) 
	{
		this.distance = distance;
	}

	public int getPaddleStrokes() 
	{
		return paddle_strokes;
	}

	public void setPaddleStrokes(int paddle_strokes) 
	{
		this.paddle_strokes = paddle_strokes;
	}

	
	


}
