package data;

import java.sql.Date;

public class Workout 
{
	User user;
	//private int id_workout;
	private Date date;
	private int duration;
	
	public Workout( Date date, int duration) {
		
		this.date = date;
		this.duration = duration;
	}
	/*public Workout(User user, Date date, int duration) {
		this.user = user;
		this.date = date;
		this.duration = duration;
	}*/
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	

}
