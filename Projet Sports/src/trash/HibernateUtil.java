package trash;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
 public static final SessionFactory sessionFactory;
 
 static {
	 try {
		 sessionFactory=new Configuration().configure().buildSessionFactory();//aller chercher le fichier de mapping
	 }catch (Throwable ex) {
		 System.err.println("Creation d'une session factory a échoué. "+ex);
		 throw new ExceptionInInitializerError(ex);
	 }
 }
 
 public static SessionFactory getSessionFactory() {
	 return sessionFactory;
 }
}
