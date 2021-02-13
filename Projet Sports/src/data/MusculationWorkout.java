package data;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class MusculationWorkout extends Workout
{
	private int number_repetition;
	private int number_sets;
	private String type_exercise;
	
	
	public MusculationWorkout(Date date, int duration, int number_repetition, int number_sets, String type_exercise) 
	{
		super(date, duration);
		this.number_repetition = number_repetition;
		this.number_sets = number_sets;
		this.type_exercise = type_exercise;
	}


	public int getNumberRepetition() 
	{
		return number_repetition;
	}

	public void setNumberRepetition(int number_repetition) 
	{
		this.number_repetition = number_repetition;
	}

	public int getNumberSets() 
	{
		return number_sets;
	}

	public void setNumberSets(int number_sets) 
	{
		this.number_sets = number_sets;
	}

	public String getTypeExercise() 
	{
		return type_exercise;
	}

	public void setTypeExercise(String type_exercise) 
	{
		this.type_exercise = type_exercise;
	}
	

}
