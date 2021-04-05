package test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.ArcheryWorkout;
import data.Exercise;
import data.JoggingWorkout;
import data.MusculationWorkout;
import data.SwimmingWorkout;
import data.Target;
import data.User;
import data.Workout;
import ihm.MainFrame;
import orm.DBConnection;
import orm.DataInit;

public class TestDataSample 
{
	public static void main(String[] args) 
	{
		DataInit.createTables();

		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();

		User u1 = new User("Alexander","1311","Alexander","Bubb","M",20,186,65);
		session.save(u1);
		
		User u2 = new User("Seruche","1311","Seruche","Mpou","F",20,192,51);
		session.save(u2);

		User u3 = new User("Julien","1311","Julien","Veysseyre","M",20,126,138);
		session.save(u3);
		
		Workout w1 = new JoggingWorkout(new Date(0), 50, 10);
		w1.setUser(u1);
		session.save(w1);
		
		Workout w2 = new SwimmingWorkout(new Date(0), 120, 10, 15, 5, 20);
		w2.setUser(u1);
		session.save(w2);
		
		Workout w6 = new SwimmingWorkout(new Date(0), 345, 24, 34, 7, 80);
		w6.setUser(u2);
		session.save(w6);
		
		Workout w7 = new SwimmingWorkout(new Date(0), 786, 16, 20, 10, 70);
		w7.setUser(u3);
		session.save(w7);
		
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
		Exercise e2 = new Exercise("Tractions", 4, 8);
		Exercise e3 = new Exercise("Abdominaux", 3, 20);
		((MusculationWorkout) w5).addExercise(e1);
		((MusculationWorkout) w5).addExercise(e2);
		((MusculationWorkout) w5).addExercise(e3);
		w5.setUser(u1);
		session.save(w5);
		
		persistTransaction1.commit();		
		
		Query selectQuery = session.createQuery("from MusculationWorkout");
		@SuppressWarnings("rawtypes")
		List result = selectQuery.list();

		System.out.println(result.size() + " workout found");

		for(int i = 0 ; i < result.size() ; i++)
		{
			Workout w = (Workout)result.get(i);
			System.out.print(w.getUser().getFirstname() + " : ");
			System.out.println(w);
		}
		
		session.close();
		
		@SuppressWarnings("unused")
		MainFrame frame = new MainFrame();
	
	}

}
