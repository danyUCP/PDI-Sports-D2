package manager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import data.User;
import util.HibernateUtil;

/**
 * 
 * cette classe créer et modifie la table manager
 *
 */
public class Managers {
	private String user="";
	public Managers() {
		
	}
	public void addUser(int idUser,String login,String mdp,String firstname,String lastname,String sexe,int age,float size,float weight) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User u=new User();
		u.getAge();
		u.getFirstname();
		u.getLastname();
		u.setAge(age);
		u.setLogin(login);
		session.save(u);
		session.getTransaction().commit();
	}
	
	public void deletteUser(int idUser) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		User u=(User) session.load(User.class,idUser);
		session.delete(u);
		session.getTransaction().commit();
		
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
	
	public String getUser() {
		return user;
		
	}

}
