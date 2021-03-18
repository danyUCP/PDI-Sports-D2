package test;


import org.hibernate.Session;
import org.hibernate.Transaction;

import data.User;
import manager.UserManager;
import manager.WorkoutManager;
import orm.DBConnection;


public class Test {

	public static void main(String[] args) 
	{
		Session session = DBConnection.getSession();
		//Transaction persistTransaction1 = session.beginTransaction();


		UserManager um = new UserManager();
		User u = um.findUser("Alexander", "1311");
		
		WorkoutManager wm = new WorkoutManager(u);
		
		System.out.println(wm.getWorkoutList(0));


		session.close();
		


	}
}

