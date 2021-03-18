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

public class DBConnection 
{
	private static SessionFactory sessionFactory;
	private static AnnotationConfiguration config;
	private static File configFile;


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

	public static Session getSession() 
	{
		return getSessionFactory().openSession();
	}
}
