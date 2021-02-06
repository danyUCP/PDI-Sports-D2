package data;

/**
 * 
 * @author PDI_D2
 * This class create User which will serve as a table in the base
 *
 */
public class User {
	/**
	 * Attributes of the class otherwise the fields of the table
	 */
	private int idUser;
	private String login;
	private String mdp;
	private String firstname;
	private String lastname;
	private String sexe;
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
	 * @param sexe
	 * @param age
	 * @param size
	 * @param weight
	 */
	public User(int idUser, String login, String mdp, String firstname, String lastname, String sexe, int age,
			float size, float weight) {
		super();
		this.idUser = idUser;
		this.login = login;
		this.mdp = mdp;
		this.firstname = firstname;
		this.lastname = lastname;
		this.sexe = sexe;
		this.age = age;
		this.size = size;
		this.weight = weight;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * This method return the character string representing the objects
	 */
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", mdp=" + mdp + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", sexe=" + sexe + ", age=" + age + ", size=" + size + ", weight=" + weight
				+ "]";
	}
	
	
	
	
}
