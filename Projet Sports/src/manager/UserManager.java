package manager;

import java.util.ArrayList;
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
	
	
	public void addUser(User u) 
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		
		session.save(u);
		transaction.commit();
	}
	
	public void deleteUser(User u) 
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		
		session.delete(u);
		transaction.commit();
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
		
	
	public ArrayList<User> findUsersFromSport(int type)
	{
		session = DBConnection.getSession();
		
		String table = "";
		switch(type)
		{
			case 1:
				table = "JoggingWorkout";
				break;
			case 2:
				table = "ClimbingWorkout";
				break;
			case 3:
				table = "RowingWorkout";
				break;
			case 4:
				table = "MusculationWorkout";
				break;
			case 5:
				table = "SwimmingWorkout";
				break;
			case 6:
				table = "ArcheryWorkout";
				break;
			default:
				table = "Workout";
				break;				
		}
		
		Query query = session.createQuery("select distinct user from " + table);
		
		@SuppressWarnings("unchecked")
		ArrayList<User> result = (ArrayList<User>) query.list();

		System.out.println(result.size() + " users found for " + table);
		System.out.println(result);


		session.close();

		return result;
	}
		
		
		


}
