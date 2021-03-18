package data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class MusculationWorkout extends Workout
{	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Exercise.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Exercise> exercises;
	
	
	public MusculationWorkout() {	}
	
	public MusculationWorkout(Date date, int duration) 
	{
		super(date, duration);
		this.exercises = new ArrayList<Exercise>();
	}


	public void addExercise(Exercise e)
	{
		exercises.add(e);
	}
	
	public int getTotalReps()
	{
		int total = 0;
		
		for(int i = 0 ; i < exercises.size() ; i++)
			total += exercises.get(i).getExerciseReps();
		
		return total;
	}
	
	public List<Exercise> getExercises() 
	{
		return exercises;
	}
	

	@Override
	public String toString() 
	{
		String s = "";
		
		s += "Musculation Workout -> " + super.toString() + " - Total d'exercice : " + exercises.size() + "\n";
		for(int i = 0 ; i < exercises.size() ; i++)
			s += "\tExercice " + (i+1) + " -> " + exercises.get(i) + (i < exercises.size() - 1 ? "\n" : "");
		
		return s;
	}

}
