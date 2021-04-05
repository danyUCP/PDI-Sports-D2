package manager;

/**
 * <code>RequestFriends</code>is a class that implements actions such as adding a new friend,
 *  deleting a friend, etc. linked to the social network part.
 * <strong>NOTE:</strong>
 *This class<code>RequestFriends </code> is a purely motor .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 */
public class RequestFriends {

	/**
	 * Default builder
	 */
	public RequestFriends() {
		
	}
	
	/**
	 * Allows you to accept a friend request
	 */
	public void accept() {
		int ok=0;
		RequestFriends s=new RequestFriends();
		
		if(ok==s.send()) {
			
		System.out.println("Vous avez accepter cette amis");
			
		}
		
	}
	
	/**
	 * Allows you to refuse a friend request
	 */
	public void refuse() {
		
		int no=1;
		RequestFriends s=new RequestFriends();
		
		if(no==s.send()) {
			
			s.remove(0);//en parametre ce sera la recupération de l'identidiant à supprimer
			System.out.println("Vous avez supprimer l'identifiant 0");
			
		}
		
		
	}
	
	/**
	 * Allows you to send a friend request
	 * @return int
	 */
	public int send() {
		
		return 0;
	}
	
	/**
	 * Allows you to delete a friend
	 * @param idFriend
	 */
	public void remove(int idFriend) {
		//requete delete dans la base
		
	}
	
	/**
	 * Allows you to notify a request
	 */
	public void notification() {
		//notification qu'il y a eu une nouvelle donnée dans la base
		int idCurrent=10;//recupere la derniere ligne du tableau (ancienne)
		int inter=20; //nouvelle ligne si changer
		int eval=0;
		
		if(idCurrent<inter) {
			eval= inter-idCurrent;
			System.out.println("Vous avez :"+ eval+" demande d'amis");
			
		}
		
	}
}
