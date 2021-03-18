package test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.User;
import manager.Managers;
import orm.DBConnection;
import orm.DataInit;


public class Test {

	public static void main(String[] args) 
	{
		
		 //User add=new User();
		 //User add1=new User();
		 //User add2=new User();
		 //User add3=new User();
		 //UserManager add=new UserManager();
		 //add.addUser("Alex","1311","Alexander","Bubb","M",20,186,65);
		 //add.addUser("Seruche","1311","Seruche","Mpou","F",20,192,51);
		 //add.addUser("Julien","1311","Julien","Veysseyre","M",20,126,138);
		 //add.addUser("Daniel","1311","Daniel","François","M",20,186,65);
		 
		
		//DataInit.createTables();

		Session session = DBConnection.getSession();
		/*Transaction persistTransaction1 = session.beginTransaction();

		User u1 = new User("Alex","1311","Alexander","Bubb","M",20,186,65);
		session.save(u1);

		User u2 = new User("Seruche","1311","Seruche","Mpou","F",20,192,51);
		session.save(u2);

		User u3 = new User("Julien","1311","Julien","Veysseyre","M",20,126,138);
		session.save(u3);

		Query selectQuery = session.createQuery("from User");
		List result = selectQuery.list();

		System.out.println(result.size() + " users found");

		for(int i = 0 ; i < result.size() ; i++)
			System.out.println((User)result.get(i));

		persistTransaction1.commit();*/
		
		 //Session session = DBConnection.getSession();
		 Managers add=new Managers();
		 System.out.println(add.testWhereClause(session, "seruche","1311"));

		session.close();
		


	}
}

