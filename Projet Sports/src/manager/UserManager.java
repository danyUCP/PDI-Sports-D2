package manager;

import org.hibernate.Session;

import util.HibernateUtil;
import data.User;
import manager.UserManager;

/**
 * 
 * this class create and modify the manager table
 *@author PDI_D2
 */
public class UserManager {
	
	public UserManager() {
		
	}
	
	/**
	 * This method add the user in the base
	 * @param login
	 * @param mdp
	 * @param firstname
	 * @param lastname
	 * @param sexe
	 * @param age
	 * @param size
	 * @param weight
	 */
	public void addUser(String login,String mdp,String firstname,String lastname,String sexe,int age,float size,float weight) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User u=new User();
		u.getAge();
		u.getFirstname();
		u.getLastname();
		u.setAge(age);
		u.setLogin(login);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setMdp(mdp);
		u.setSexe(sexe);
		u.setSize(size);
		u.setWeight(weight);
		session.save(u);
		session.getTransaction().commit();
	}
	
	/**
	 * This method removes the user by his id in the base
	 * @param idUser
	 */
	public void deletteUser(int idUser) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		User u=(User) session.load(User.class,idUser);
		session.delete(u);
		session.getTransaction().commit();
		
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
		
		
		
		


}
