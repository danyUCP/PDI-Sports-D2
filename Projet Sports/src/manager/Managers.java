package manager;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.SwimmingWorkout;
import data.User;
import data.Workout;
import orm.DBConnection;
import trash.HibernateUtil;

/**
 * <code>Managers</code> is a class that manages different actions/functions of the software
 * <strong>NOTE:</strong>
 *This class<code>Managers</code> is a purely motor .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 */
public class Managers {
	private String user="";
	
	/**
	 * default Constructor
	 */
	public Managers() {
		
	}
	
	/**
	 * This method adds a user to the database
	 * @param login
	 * @param mdp
	 * @param firstname
	 * @param lastname
	 * @param gender
	 * @param age
	 * @param size
	 * @param weight
	 */
	public void addUser(String login, String mdp, String firstname, String lastname, String gender, String age, String size, String weight) {
		Session session = DBConnection.getSession();
		@SuppressWarnings("unused")
		Transaction persistTransaction1 = session.beginTransaction();
		@SuppressWarnings("unused")
		Date date=new Date(0);	
		int resultat = Integer.parseInt(age);
		int resultat1 = Integer.parseInt(size);
		int resultat2 = Integer.parseInt(weight);
		User u1 = new User(login,mdp,firstname,lastname,gender,resultat,resultat1,resultat2);
		session.save(u1);
   
	}
	
	/**
	 * This method delete a user to the database
	 * @param idUser
	 */
	public void deletteUser(int idUser) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		User u=(User) session.load(User.class,idUser);
		session.delete(u);
		session.getTransaction().commit();
		
	}
	
	/**
	 * This method associates the sport of swimming with a user to specify that this user practices it.
	 * 
	 * @param u1
	 * @param date
	 * @param duration
	 * @param breaststroke_lenghts
	 * @param butterfly_lenghts
	 * @param crowl_lenghts
	 * @param backstroke_lenghts
	 */
	public void addSwimming(User u1,Date date, int duration, int breaststroke_lenghts, int butterfly_lenghts, int crowl_lenghts, int backstroke_lenghts) {
		Session session = DBConnection.getSession();
		@SuppressWarnings("unused")
		Transaction persistTransaction1 = session.beginTransaction();
		//UserManager u=new UserManager();
	
		
		Workout w2 = new SwimmingWorkout(date, duration, breaststroke_lenghts, butterfly_lenghts, crowl_lenghts, backstroke_lenghts);
		w2.setUser(u1);
		session.save(w2);
		persistTransaction1.commit();
		session.close();
	}
	
	@SuppressWarnings("rawtypes")
	/**
	 * This method allows you to search for the existence of a user in the database.
	 * @param session
	 * @param login
	 * @param mdp
	 * @return
	 */
	public String testWhereClause(Session session, String login,String mdp) {
		String name="",mt="",log="";
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from User p where p.login=:login and p.mdp=:mdp");
		readQuery.setString("login", login);
		readQuery.setString("mdp", mdp);
		List result = readQuery.list();

		for(int i = 0 ; i < result.size() ; i++)
		{
			User w = (User)result.get(i);
			name=w.getLogin();
			mt=w.getLogin();
			log=w.getMdp();
		
		}
		user=name;
		
		readTransaction.commit();
		return name+";"+mt+";"+log;
		
	}
	
	/**
	 * This method is used to retrieve information about a user.
	 */
	public void getInfoUser() {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Object ob=session.load(User.class,new Integer(1));
		User u=(User) ob;
		//session.select();
		System.out.println("Nom: "+u.getFirstname());
		
	}
	
	/**
	 * This method is used to retrieve information about a user.
	 * @param id
	 * @return String
	 */
	public String getInfoUser(int id) {
		
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		User u=(User) session.get(User.class, id);
		
		String ide=u.getLogin();
		String mpd=u.getMdp();
		session.getTransaction().commit();
			
		return ide+mpd;
		}
	
	/**
	 * This method retrieves a user from the database.
	 * @return String
	 */
	
	public String getUser() {
		return user;
		
	}
	


}
