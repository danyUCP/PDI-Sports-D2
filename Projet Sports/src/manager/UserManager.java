package manager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import data.DBConnection;
import data.User;
import data.Workout;
import manager.UserManager;


public class UserManager 
{
	private Session session;
	private Transaction transaction;
	
	public UserManager() {	}
	
	
	public void addUser(String login, String mdp, String firstname, String lastname, String gender, int age, float size, float weight) 
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();

		User u = new User(login, mdp, firstname, lastname, gender, age, size, weight);
		
		session.save(u);
		transaction.commit();
	}
	
	/**
	 * This method removes the user by his id in the base
	 * @param idUser
	 */
	public void deletteUser(int idUser) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		User u=(User) session.load(User.class,idUser);
		session.delete(u);
		session.getTransaction().commit();
		
	}
	
	public void getInfoUser() {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object ob=session.load(User.class,new Integer(1));
		User u=(User) ob;
		//session.select();
		System.out.println("Nom: "+u.getFirstname());
		
	}
	
	public String getInfoUser(int id) {
		//SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		//Session session=sessionFactory.openSession();
		session.beginTransaction();
		User u=(User) session.get(User.class, id);
		//User u=(User) session.createQuery("SELECT * FROM `user` WHERE `idUser`=1;");
		/*if(u.getFirstname().equals(user)&&u.getLastname().equals(name)) {
			//String name=u.getFirstname()
			System.out.println("Nom: "+u.getLogin()+" Prenom: "+u.getMdp());
			session.getTransaction().commit();
		}
		else {
			System.out.println("quelque chose ne va pas");
		}*/
		String ide=u.getLogin();
		String mpd=u.getMdp();
		session.getTransaction().commit();
			
		return ide+mpd;
		}
	
	public User findUser(String login, String mdp)
	{
		session = DBConnection.getSession();
		
		Query query = session.createQuery("from User where login = :login and mdp = :mdp");
		query.setString("login", login);
		query.setString("mdp", mdp);
		User u = null;

		List result = query.list();

		if(result.size() == 1)
		{
			System.out.println(result.size() + " user found");
			u = (User) result.get(0);
			System.out.println(u);
		}
		else
			System.out.println("User not found");

			
		
		session.close();
		return u;		
	}
	
	public int findID(String login, String mdp) {
		
		Query query = session.createQuery("from User where login = :login and mdp = :mdp");
		query.setString("login", login);
		query.setString("mdp", mdp);
		User u = null;
		int id=0;

		List result = query.list();

		if(result.size() == 1)
		{
			System.out.println(result.size() + " user found");
			u = (User) result.get(0);
			id=u.getId();
			System.out.println(u);
		}
		else
			System.out.println("User not found");

			
		
		session.close();
		
		return id;
	}
		
		
		
		


}
