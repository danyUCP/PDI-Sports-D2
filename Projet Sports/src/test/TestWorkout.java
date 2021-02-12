package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.DBConnection;
import data.DataInit;
import data.JoggingWorkout;
import data.User;
import data.Workout;

public class TestWorkout 
{
	public static void main(String[] args) 
	{
		DataInit.createTables();

		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();

		User u1 = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
		session.save(u1);
		
		Workout w1 = new JoggingWorkout(new Date(0), 50, 10);
		w1.setUser(u1);
		session.save(w1);
		
		persistTransaction1.commit();

		session.close();
		
	}

}
