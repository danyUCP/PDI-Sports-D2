package data;

/**
 * 
 * @author PDI_D2
 *
 */
public class RequestFriends {

	public RequestFriends() {
		
	}
	
	public void accept() {
		int ok=0;
		RequestFriends s=new RequestFriends();
		
		if(ok==s.send()) {
			
		System.out.println("Vous avez accepter cette amis");
			
		}
		
	}
	
	public void refuse() {
		
		int no=1;
		RequestFriends s=new RequestFriends();
		
		if(no==s.send()) {
			
			s.remove(0);//en parametre ce sera la recupération de l'identidiant à supprimer
			System.out.println("Vous avez supprimer l'identifiant 0");
			
		}
		
		
	}
	
	public int send() {
		
		return 0;
	}
	
	public void remove(int idFriend) {
		//requete delete dans la base
		
	}
	
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
