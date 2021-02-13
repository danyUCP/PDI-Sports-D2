package test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.ArcheryWorkout;
import data.DBConnection;
import data.DataInit;
import data.Exercise;
import data.JoggingWorkout;
import data.MusculationWorkout;
import data.SwimmingWorkout;
import data.Target;
import data.User;
import data.Workout;

public class TestWorkout 
{
	public static void main(String[] args) 
	{
		DataInit.createTables();

		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();

		User u1 = new User("Alexander","1311","Alexander","Bubb","M",20,186,65);
		session.save(u1);
		
		Workout w1 = new JoggingWorkout(new Date(0), 50, 10);
		w1.setUser(u1);
		session.save(w1);
		
		Workout w2 = new SwimmingWorkout(new Date(0), 120, 10, 15, 5, 20);
		w2.setUser(u1);
		session.save(w2);
		
		Workout w3 = new JoggingWorkout(new Date(0), 80, 20);
		w3.setUser(u1);
		session.save(w3);
		
		Workout w4 = new ArcheryWorkout(new Date(0), 40);
		Target t1 = new Target(20, 15, 5, 0, 0, 0, 5);
		Target t2 = new Target(50, 10, 12, 8, 0, 0, 8);
		Target t3 = new Target(80, 2, 5, 0, 5, 1, 16);
		((ArcheryWorkout) w4).addTarget(t1);
		((ArcheryWorkout) w4).addTarget(t2);
		((ArcheryWorkout) w4).addTarget(t3);
		w4.setUser(u1);
		session.save(w4);
		
		Workout w5 = new MusculationWorkout(new Date(0), 40);
		Exercise e1 = new Exercise("Pompes", 4, 12);
		Exercise e2 = new Exercise("Traction", 4, 8);
		Exercise e3 = new Exercise("Abdos", 3, 20);
		((MusculationWorkout) w5).addExercise(e1);
		((MusculationWorkout) w5).addExercise(e2);
		((MusculationWorkout) w5).addExercise(e3);
		w5.setUser(u1);
		session.save(w5);
		
		persistTransaction1.commit();

		//System.out.println(w1);
		
		Query selectQuery = session.createQuery("from Workout");
		List result = selectQuery.list();

		System.out.println(result.size() + " workout found");

		for(int i = 0 ; i < result.size() ; i++)
		{
			Workout w = (Workout)result.get(i);
			System.out.println(w);
		}

		
		session.close();
		
	}

}
