package data;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {

	public static void main(String[] args) {
		DataInit.createTables();

		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		
		User u1 = new User(1, "Alex","1311","Alexander","Bubb","g",20,186,65);
		session.persist(u1);
		
		
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        java.sql.Date sqlDate;
		

            try {
            	
                sqlDate = new java.sql.Date(df.parse("02-04-2015").getTime());
                Workout climbing=new Workout(sqlDate,5);
                JoggingWorkout student = new JoggingWorkout(climbing.getDate(),climbing.getDuration(), 25);
        		session.persist(student);
                session.persist(climbing);


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		
		
		
		
		
		//Very useful, the save method can return an auto-generated Id.
		
		
		persistTransaction1.commit();

		session.close();

	}
}

