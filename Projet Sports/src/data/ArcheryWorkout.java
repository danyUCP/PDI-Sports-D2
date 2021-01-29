package data;

import java.sql.Date;

public class ArcheryWorkout extends Workout
{
	private int target_distance;
	private String affected_area;
	
	
	public ArcheryWorkout(Date date, int duration,int target_distance,String affected_area) {
		super(date, duration);
		this.target_distance=target_distance;
		this.affected_area=affected_area;
		
		
	}
	public int gettarget_distance() {
		
		
		return target_distance;
	}
	
	public String getaffected_area() {
		
		return affected_area;
		
		
	}
	
	public void settarget_distance(int target_distance) {
		
		this.target_distance=target_distance;
	}

	public void setaffected_area(String affected_area) {
		
		
	this.affected_area=affected_area;	
		
		
	}

}
