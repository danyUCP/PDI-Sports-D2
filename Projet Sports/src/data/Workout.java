package data;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Workout 
{
	@TableGenerator(name = "workoutGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "WORKOUT_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="workoutGen")
	private int id;
	private Date date;
	private int duration;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	private User user;
	
	public Workout(Date date, int duration) 
	{
		this.date = date;
		this.duration = duration;
	}


	public User getUser() 
	{
		return user;
	}
	
	public void setUser(User user) 
	{
		this.user = user;
	}
	
	public Date getDate() 
	{
		return date;
	}
	
	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	public int getDuration() 
	{
		return duration;
	}
	
	public void setDuration(int duration) 
	{
		this.duration = duration;
	}
	

}
