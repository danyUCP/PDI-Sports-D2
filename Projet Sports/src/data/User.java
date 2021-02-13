package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author PDI_D2
 * This class create User which will serve as a table in the base
 *
 */
@Entity
public class User {
	/**
	 * Attributes of the class otherwise the fields of the table
	 */
	@Id
	@GeneratedValue
	private int id;
	
	private String login;
	private String mdp;
	private String firstname;
	private String lastname;
	private String gender;
	private int age;
	private float size;
	private float weight;
	
	public User() {
		
	}
	
	/**
	 * Constructor
	 * @param idUser
	 * @param login
	 * @param mdp
	 * @param firstname
	 * @param lastname
	 * @param gender
	 * @param age
	 * @param size
	 * @param weight
	 */
	public User(String login, String mdp, String firstname, String lastname, String gender, int age, float size, float weight) 
	{
		this.login = login;
		this.mdp = mdp;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
		this.size = size;
		this.weight = weight;
	}
	
	
	public String getLogin() 
	{
		return login;
	}
	
	public void setLogin(String login) 
	{
		this.login = login;
	}
	
	public String getMdp() 
	{
		return mdp;
	}
	
	public void setMdp(String mdp) 
	{
		this.mdp = mdp;
	}
	
	public String getFirstname() 
	{
		return firstname;
	}
	
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	
	public String getLastname() 
	{
		return lastname;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	
	public String getGender() 
	{
		return gender;
	}
	
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public float getSize() 
	{
		return size;
	}
	
	public void setSize(float size) 
	{
		this.size = size;
	}
	
	public float getWeight() 
	{
		return weight;
	}
	
	public void setWeight(float weight) 
	{
		this.weight = weight;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * This method return the character string representing the objects
	 */
	public String toString() 
	{
		String s = "";
		
		s += "User " + id + "\n";
		s += "Name : " + firstname + " " + lastname + "\n";
		s += "Gender : " + gender + "\n";
		s += "Age : " + age + "\n";
		s += "Size : " + size + " cm\n";
		s += "Weight : " + weight + " kg\n";
	
		return s;
	}
	
	
	
	
}
