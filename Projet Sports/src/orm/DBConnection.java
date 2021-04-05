package orm;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import data.ArcheryWorkout;
import data.ClimbingWorkout;
import data.Exercise;
import data.JoggingWorkout;
import data.MusculationWorkout;
import data.RowingWorkout;
import data.SwimmingWorkout;
import data.Target;
import data.User;
import data.Workout;

/**
 * <code>DBConnection </code>Used to link java to the database.
 * <strong>NOTE:</strong>
 *This class<code>DBConnection  </code> is a motor class .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 */
public class DBConnection 
{
	private static SessionFactory sessionFactory;
	private static AnnotationConfiguration config;
	private static File configFile; 


	/**
	 * creation of tables in the database
	 * @return static AnnotationConfiguration
	 */
	public static AnnotationConfiguration getConfig() 
	{
		if (config == null) 
		{
			config = new AnnotationConfiguration();

			config.addAnnotatedClass(User.class);
			config.addAnnotatedClass(Workout.class);
			config.addAnnotatedClass(ArcheryWorkout.class);
			config.addAnnotatedClass(ClimbingWorkout.class);
			config.addAnnotatedClass(JoggingWorkout.class);
			config.addAnnotatedClass(RowingWorkout.class);
			config.addAnnotatedClass(SwimmingWorkout.class);
			config.addAnnotatedClass(MusculationWorkout.class);
			config.addAnnotatedClass(Target.class);
			config.addAnnotatedClass(Exercise.class);

			configFile = new File("resources/connection.cfg.xml");
			System.out.println(configFile.getAbsolutePath());
			config.configure(configFile);
		}
		
		return config;
	}

	/**
	 * Recovery of the SessionFactory .
	 * @return static SessionFactory
	 */
	public static SessionFactory getSessionFactory() 
	{
		if (sessionFactory == null) 
		{
			try {
				AnnotationConfiguration config = getConfig();
				sessionFactory = config.buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		return sessionFactory;
	}

	/**
	 * Recovery of the Session.
	 * @return static Session
	 */
	public static Session getSession() 
	{
		return getSessionFactory().openSession();
	}
}
