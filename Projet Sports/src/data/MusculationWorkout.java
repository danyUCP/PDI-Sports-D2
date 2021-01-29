package data;

import java.sql.Date;

public class MusculationWorkout extends Workout
{
	private int number_repetition;
	private int number_sets;
	private String type_exercise;
	
	
	public MusculationWorkout(Date date, int duration,int number_repetition,int number_sets,String type_exercise) {
		super(date, duration);
		this.number_repetition=number_repetition;	
		this.number_sets=number_sets;
		this.type_exercise=type_exercise;
		
	}
	
	
	public int getnumber_repetition() {
		
		
		return number_repetition;
		
	}
	
	
	
	
	public void setnumber_repetition(int number_repetition) {
		
		
		this.number_repetition=number_repetition;	
		
	}
	
	public int getnumber_sets() {
		
		
		return number_sets;
	}
	
	public void setnumber_sets(int number_sets) {
		
		
	this.number_sets=number_sets;	
	}
	
	
	public String gettype_exercise() {
		
		
		return type_exercise;	
		
	}
	
	public void settype_exercise(String type_exercise) {
		
		
		this.type_exercise=type_exercise;
		
		
	}

}
