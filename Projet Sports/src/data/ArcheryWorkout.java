package data;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class ArcheryWorkout extends Workout
{
	private int target_distance;
	private String affected_area;
	
	
	public ArcheryWorkout(Date date, int duration, int target_distance, String affected_area) 
	{
		super(date, duration);
		this.target_distance = target_distance;
		this.affected_area = affected_area;
	}
	
	
	public int getTargetDistance() 
	{
		return target_distance;
	}

	public void setTargetDistance(int target_distance) 
	{
		this.target_distance = target_distance;
	}

	public String getAffectedArea() 
	{
		return affected_area;
	}

	public void setAffectedArea(String affected_area) 
	{
		this.affected_area = affected_area;
	}


}
