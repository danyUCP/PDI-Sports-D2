package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.DBConnection;
import data.DataInit;
import data.User;



public class Test {

	public static void main(String[] args) 
	{
		DataInit.createTables();

		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();

		User u = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
		session.save(u);

		User u2 = new User("Seruche","1311","Seruche","Mpou","F",20,192,51);
		session.save(u2);

		User u3 = new User("Julien","1311","Julien","Veysseyre","M",20,126,138);
		session.save(u3);

		Query selectQuery = session.createQuery("from User");
		List result = selectQuery.list();

		System.out.println(result.size() + " users found");

		for(int i = 0 ; i < result.size() ; i++)
			System.out.println((User)result.get(i));

		persistTransaction1.commit();

		session.close();
		
		
		
		/*
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
		 */


	}
}

