package manager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import data.User;
import data.Workout;
import manager.UserManager;
import orm.DBConnection;


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

		//System.out.println(result.size() + " users found for " + table);
		//System.out.println(result);


		session.close();

		return result;
	}
	
	public User[] userFriends() {
		String listElem[] =null; 
		User result1[]= {},result2[]={},result3[]={},result4[]={},result5[]=null,result6[]={};
		ArrayList<User> listFriends1=null, listFriends2=null, listFriends3=null, listFriends4=null, listFriends5=null, listFriends6=null;

		
		UserManager um = new UserManager();		
		User u1 = um.findUser("Seruche", "1311");
		
		WorkoutManager wm = new WorkoutManager(u1);
		System.out.println(u1.getId());
		if(!wm.getWorkoutList(1).isEmpty()) {
			listFriends1=um.findUsersFromSport(1);
			for (int i = 0; i < listFriends1.size(); i++) {
				result1=new User[listFriends1.size()];
				result1[i] = (User) listFriends1.get(i);
			}
		}
		if(!wm.getWorkoutList(2).isEmpty()) {
			 listFriends2=um.findUsersFromSport(2);
			for (int i = 0; i < listFriends2.size(); i++) {
				result2=new User[listFriends2.size()];
				result2[i] = (User) listFriends2.get(i);
				
			}
		}
		if(!wm.getWorkoutList(3).isEmpty()) {
			listFriends3=um.findUsersFromSport(3);
			for (int i = 0; i < listFriends3.size(); i++) {
				result3=new User[listFriends3.size()];
				result3[i] = (User) listFriends3.get(i);
				
			}
		}
		if(!wm.getWorkoutList(4).isEmpty()) {
			listFriends4=um.findUsersFromSport(4);
			for (int i = 0; i < listFriends4.size(); i++) {
				result4=new User[listFriends4.size()];
				result4[i] = (User) listFriends4.get(i);
				
			}
		}
		if(!wm.getWorkoutList(5).isEmpty()) {
			listFriends5=um.findUsersFromSport(5);
			for (int i = 0; i < listFriends5.size(); i++) {
				result5=new User[listFriends5.size()];
				result5[i] = (User) listFriends5.get(i);
				System.out.println("Vide mais afficher 5"+result5[i]);
			}
			for(int i=0;i<result5.length;i++) {
				System.out.println("Affiche Table 5"+result5[i]);
			}
		}
		
		if(!wm.getWorkoutList(6).isEmpty()) {
			listFriends6=um.findUsersFromSport(6);
			for (int i = 0; i < listFriends6.size(); i++) {
				result6=new User[listFriends6.size()];
				result6[i] = (User) listFriends6.get(i);
				
			}
		}
		System.out.println("Aucun tableau afficher pour l'instant");
		
		/*for(int i=0;i<result5.length;i++) {
			System.out.println("Affiche Table 5"+result5[i]);
		}*/
		
		int len = result1.length + result2.length+ result3.length+ result4.length+ result5.length+ result6.length;
		System.out.println("total longeur: "+len);
		
		User result[]=new User[len];
		int position = 0;
		
		if(result1!=null) {
			for (User object : result1)
	        {
				result[position] = object;
	            position++;
	        }
		}
		
		if(result2!=null) {
			for (User object : result2)
	        {
				result[position] = object;
	            position++;
	        }
		}
		
		if(result3!=null) {
			for (User object : result3)
	        {
				result[position] = object;
	            position++;
	        }
		}
		
		if(result4!=null) {
			for (User object : result4)
	        {
				result[position] = object;
	            position++;
	        }
		}
		
		if(result5!=null) {
			//for (User object : result5)
	        //{
				for(int i=0;i<result5.length;i++) {
					result[position] = result5[i];
					//System.out.println("Table 5"+result5[i]);
		            position++;
				//}
				
				}
		}
		
		if(result6!=null) {
			for (User object : result6)
	        {
				result[position] = object;
	            position++;
	        }
		}
		
		for(int k=0;k<result.length;k++) {
			//if(result[k]!=null)
				System.out.println(result[k]);
		}
		
		return result;
		
	}
		
	public String getUserWorkoutList(WorkoutManager wm) {
		String name=" ";
	
		if(!wm.getWorkoutList(1).isEmpty()) {
			name+="JoggingWorkout"+" | ";
		}
		if(!wm.getWorkoutList(2).isEmpty()) {
			name+="ClimbingWorkout"+" | ";
		}
		if(!wm.getWorkoutList(3).isEmpty()) {
			name+="RowingWorkout"+" | ";
		}
		if(!wm.getWorkoutList(4).isEmpty()) {
			name+="MusculationWorkout"+" | ";
		}
		if(!wm.getWorkoutList(5).isEmpty()) {
			name+="SwimmingWorkout"+" | ";
		}
		if(!wm.getWorkoutList(6).isEmpty()) {
			name+="ArcheryWorkout"+" | ";
		}
		
		return name;
	}
		
		


}
