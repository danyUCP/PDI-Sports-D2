package manager;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.User;
import data.Workout;
import orm.DBConnection;


/**
 * <code>WorkoutManager </code> is a class that manages different actions of all sports
 * <strong>NOTE:</strong>
 *This class<code>WorkoutManager </code> is a purely motor .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 */
public class WorkoutManager 
{

	private Session session;
	private Transaction transaction;
	private User user;
	
	
	/**
	 * Constructor with a user as parameter
	 * @param user
	 */
	public WorkoutManager(User user)
	{
		this.user = user;
	}
	
	/**
	 * This method returns the list of all sports in the database.
	 * @param type
	 * @return ArrayList<Workout> 
	 */
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

		session.close();

		return result;
	}
	
	/**
	 * This method retrieves information about the last session of a given sport for a user.
	 * @return Workout
	 */
	public Workout getLastWorkout()
	{
		session = DBConnection.getSession();
		
		Query query = session.createQuery("from Workout where user_id = :id order by date DESC, id DESC limit 1");
		query.setInteger("id", user.getId());


		Workout result = (Workout) query.list().get(0);
		
		session.close();

		return result;
	}
	
	/**
	 * This method creates a new Workout in the database.
	 * @param w
	 */
	public void createNewWorkout(Workout w)
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();

		w.setUser(user);
		
		session.save(w);
		transaction.commit();
		
		session.close();
	}
	
	/**
	 * This method allows you to modify the Workout table in the database.
	 * @param w
	 */
	public void updateWorkout(Workout w)
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		
		session.update(w);
		transaction.commit();
		
		session.close();
	}
	
	/**
	 * This method allows you to delete a sport from the database
	 * @param w
	 */
	public void deleteWorkout(Workout w)
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
				
		session.delete(w);
		transaction.commit();
		
		session.close();
	}

}
