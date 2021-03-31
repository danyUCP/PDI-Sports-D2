package manager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.User;
import data.Workout;
import orm.DBConnection;

public class WorkoutManager 
{
	private Session session;
	private Transaction transaction;
	private User user;
	
	public WorkoutManager(User user)
	{
		this.user = user;
	}
	
	
	public ArrayList<Workout> getWorkoutList(int type)
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
		
		Query query = session.createQuery("from " + table + " where user_id = :id order by date DESC, id DESC");
		query.setInteger("id", user.getId());
		
		@SuppressWarnings("unchecked")
		ArrayList<Workout> result = (ArrayList<Workout>) query.list();

		//System.out.println(result.size() + " " + table + " found for " + user.getFirstname());
		//System.out.println(result);

		session.close();

		return result;
	}
	
	public Workout getLastWorkout()
	{
		session = DBConnection.getSession();
		
		Query query = session.createQuery("from Workout where user_id = :id order by date DESC, id DESC limit 1");
		query.setInteger("id", user.getId());


		Workout result = (Workout) query.list().get(0);
		
		session.close();

		return result;
	}
	
	public void createNewWorkout(Workout w)
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();

		w.setUser(user);
		
		session.save(w);
		transaction.commit();
		
		session.close();
	}
	
	public void updateWorkout(Workout w)
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		
		session.update(w);
		transaction.commit();
		
		session.close();
	}
	
	public void deleteWorkout(Workout w)
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
				
		session.delete(w);
		transaction.commit();
		
		session.close();
	}

}
