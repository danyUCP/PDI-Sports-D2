package data;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class SwimmingWorkout extends Workout
{
	int breaststroke_lenghts;
	int butterfly_lenghts;
	int crowl_lenghts;
	int backstroke_lenghts;
	
	
	public SwimmingWorkout(Date date, int duration, int breaststroke_lenghts, int butterfly_lenghts, int crowl_lenghts, int backstroke_lenghts) 
	{
		super(date, duration);
		this.breaststroke_lenghts = breaststroke_lenghts;
		this.butterfly_lenghts = butterfly_lenghts;
		this.crowl_lenghts = crowl_lenghts;
		this.backstroke_lenghts = backstroke_lenghts;
	}



	public int getBreaststroke_lenghts() 
	{
		return breaststroke_lenghts;
	}

	public void setBreaststroke_lenghts(int breaststroke_lenghts) 
	{
		this.breaststroke_lenghts = breaststroke_lenghts;
	}

	public int getButterfly_lenghts() 
	{
		return butterfly_lenghts;
	}

	public void setButterfly_lenghts(int butterfly_lenghts) 
	{
		this.butterfly_lenghts = butterfly_lenghts;
	}

	public int getCrowl_lenghts() 
	{
		return crowl_lenghts;
	}

	public void setCrowl_lenghts(int crowl_lenghts) 
	{
		this.crowl_lenghts = crowl_lenghts;
	}

	public int getBackstroke_lenghts() 
	{
		return backstroke_lenghts;
	}

	public void setBackstroke_lenghts(int backstroke_lenghts) 
	{
		this.backstroke_lenghts = backstroke_lenghts;
	}
	
	
}
