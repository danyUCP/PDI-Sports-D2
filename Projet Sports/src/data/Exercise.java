package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exercise 
{
	@Id
	@GeneratedValue
	private int id;
	
	private String type;
	private int sets;
	private int repetitions;
	

	public Exercise() {	}

	public Exercise(String type, int sets, int repetitions) 
	{
		this.type = type;
		this.sets = sets;
		this.repetitions = repetitions;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public int getSets() 
	{
		return sets;
	}

	public void setSets(int sets) 
	{
		this.sets = sets;
	}

	public int getRepetitions() 
	{
		return repetitions;
	}

	public void setRepetitions(int repetitions) 
	{
		this.repetitions = repetitions;
	}

	
	@Override
	public String toString() 
	{
		return type + " " + sets + "x" + repetitions;
	}

}
