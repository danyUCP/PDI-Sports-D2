package data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class ArcheryWorkout extends Workout
{
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Target.class)
	private List<Target> targets;


	public ArcheryWorkout() {	}

	public ArcheryWorkout(Date date, int duration) 
	{
		super(date, duration);
		this.targets = new ArrayList<Target>();
	}


	public void addTarget(Target t)
	{
		targets.add(t);
	}

	public int getTotalShots()
	{
		int total = 0;

		for(int i = 0 ; i < targets.size() ; i++)
			total += targets.get(i).getShots();

		return total;
	}

	public List<Target> getTargets() 
	{
		return targets;
	}


	@Override
	public String toString() 
	{
		String s = "";

		s += "Archery Workout -> " + super.toString() + " - Tirs total : " + this.getTotalShots() + "\n";
		for(int i = 0 ; i < targets.size() ; i++)
			s += "\tCible " + (i+1) + " -> " + targets.get(i) + (i < targets.size() - 1 ? "\n" : "");

		return s;
	}
}
