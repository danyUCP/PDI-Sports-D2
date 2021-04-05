package manager;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.SwimmingWorkout;
import data.User;
import data.Workout;
import orm.DBConnection;
import trash.HibernateUtil;

/**
 * 
 * cette classe créer et modifie la table manager
 *
 */
public class Managers {
	private String user="";
	public Managers() {
		
	}
	
	public void addUser(String login, String mdp, String firstname, String lastname, String gender, String age, String size, String weight) {
		Session session = DBConnection.getSession();
		@SuppressWarnings("unused")
		Transaction persistTransaction1 = session.beginTransaction();
		@SuppressWarnings("unused")
		Date date=new Date(0);	
		int resultat = Integer.parseInt(age);
		int resultat1 = Integer.parseInt(size);
		int resultat2 = Integer.parseInt(weight);
		User u1 = new User(login,mdp,firstname,lastname,gender,resultat,resultat1,resultat2);
		session.save(u1);
   
	}
	
	public void deletteUser(int idUser) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		User u=(User) session.load(User.class,idUser);
		session.delete(u);
		session.getTransaction().commit();
		
	}
	
	public void addSwimming(User u1,Date date, int duration, int breaststroke_lenghts, int butterfly_lenghts, int crowl_lenghts, int backstroke_lenghts) {
		Session session = DBConnection.getSession();
		@SuppressWarnings("unused")
		Transaction persistTransaction1 = session.beginTransaction();
		//UserManager u=new UserManager();
	
		
		Workout w2 = new SwimmingWorkout(date, duration, breaststroke_lenghts, butterfly_lenghts, crowl_lenghts, backstroke_lenghts);
		w2.setUser(u1);
		session.save(w2);
		persistTransaction1.commit();
		session.close();
	}
	
	@SuppressWarnings("rawtypes")
	public String testWhereClause(Session session, String login,String mdp) {
		String name="",mt="",log="";
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from User p where p.login=:login and p.mdp=:mdp");
		readQuery.setString("login", login);
		readQuery.setString("mdp", mdp);
		List result = readQuery.list();

		for(int i = 0 ; i < result.size() ; i++)
		{
			User w = (User)result.get(i);
			name=w.getLogin();
			mt=w.getLogin();
			log=w.getMdp();
		
		}
		user=name;
		
		readTransaction.commit();
		return name+";"+mt+";"+log;
		
	}
	
	public void getInfoUser() {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object ob=session.load(User.class,new Integer(1));
		User u=(User) ob;
		//session.select();
		System.out.println("Nom: "+u.getFirstname());
		
	}
	
	public String getInfoUser(int id) {
		//SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		//Session session=sessionFactory.openSession();
		session.beginTransaction();
		User u=(User) session.get(User.class, id);
		//User u=(User) session.createQuery("SELECT * FROM `user` WHERE `idUser`=1;");
		/*if(u.getFirstname().equals(user)&&u.getLastname().equals(name)) {
			//String name=u.getFirstname()
			System.out.println("Nom: "+u.getLogin()+" Prenom: "+u.getMdp());
			session.getTransaction().commit();
		}
		else {
			System.out.println("quelque chose ne va pas");
		}*/
		String ide=u.getLogin();
		String mpd=u.getMdp();
		session.getTransaction().commit();
			
		return ide+mpd;
		}
	
	public String getUser() {
		return user;
		
	}
	


}
