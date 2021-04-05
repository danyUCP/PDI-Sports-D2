package test;


import manager.UserManager;
import trash.HibernateUtil;


/**
 * 
 * @author PDI_D2
 *
 */
public class TestMain {

	public static void main(String[] args) {
		
		/**
		 * Test adding to the user table
		 */
		UserManager um=new UserManager();
		//um.addUser("e-sn", "123", "NIL", "Sam", "M", 30, (float) 1.70, 60);
		//um.addUser("e-KL", "123", "LIL", "Kai", "F", 20, (float)1.60, 40);
		//um.addUser("e-xm", "123", "Mihuel", "xavier", "M", 25, (float)1.90, 80);
		HibernateUtil.sessionFactory.close();//closing the session

	}

}
