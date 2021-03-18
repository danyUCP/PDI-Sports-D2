package test;

import java.util.ArrayList;

import data.User;
import ihm.MainFrame;
import manager.UserManager;
import manager.WorkoutManager;

public class TestManager 
{
	public static void main(String[] args) 
	{
		
		
		//User u=new User();
		UserManager u=new UserManager();
		
		u.userFriends();
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*UserManager um = new UserManager();		
		User u1 = um.findUser("Seruche", "1311");
		
		WorkoutManager wm = new WorkoutManager(u1);
		
		String name=" ";
		
		if(!wm.getWorkoutList(1).isEmpty()) {
			name+="JoggingWorkout"+" | ";
		}
		if(!wm.getWorkoutList(2).isEmpty()) {
			name+="ClimbingWorkout"+" | ";
		}
		if(!wm.getWorkoutList(3).isEmpty()) {
			name+="RowingWorkout"+" | ";
		}
		if(!wm.getWorkoutList(4).isEmpty()) {
			name+="MusculationWorkout"+" | ";
		}
		if(!wm.getWorkoutList(5).isEmpty()) {
			name+="SwimmingWorkout"+" | ";
		}
		if(!wm.getWorkoutList(6).isEmpty()) {
			name+="ArcheryWorkout"+" | ";
		}*/
		
		//System.out.println(name);
		//System.out.println(u1.getId());
		/*if(!wm.getWorkoutList(1).isEmpty()) {
			System.out.println("Les utilisateurs du sports 1");
			um.findUsersFromSport(1);
		}
		if(!wm.getWorkoutList(2).isEmpty()) {
			System.out.println("Les utilisateurs du sports 2");
			um.findUsersFromSport(2);
		}
		if(!wm.getWorkoutList(3).isEmpty()) {
			System.out.println("Les utilisateurs du sports 3");
			um.findUsersFromSport(3);
		}
		if(!wm.getWorkoutList(4).isEmpty()) {
			System.out.println("Les utilisateurs du sports 1");
			um.findUsersFromSport(4);
		}
		if(!wm.getWorkoutList(5).isEmpty()) {
			System.out.println("Les utilisateurs du sports 1");
			um.findUsersFromSport(5);
		}
		if(!wm.getWorkoutList(6).isEmpty()) {
			System.out.println("Les utilisateurs du sports 1");
			um.findUsersFromSport(6);
		}*/
		/*wm.getWorkoutList(1);
		wm.getWorkoutList(2);
		wm.getWorkoutList(3);
		wm.getWorkoutList(4);
		wm.getWorkoutList(5);
		wm.getWorkoutList(6);*/

		//MainFrame frame = new MainFrame();

		/*um.findUsersFromSport(1);
		um.findUsersFromSport(2);
		um.findUsersFromSport(3);
		um.findUsersFromSport(4);
		um.findUsersFromSport(5);
		um.findUsersFromSport(6);*/
		/*String listElem[] = {}; 
		User result[]= {},result1[]= {},result2[]={},result3[]={},result4[]={},result5[]={},result6[]={};
		ArrayList<User> listFriends1=null, listFriends2=null, listFriends3=null, listFriends4=null, listFriends5=null, listFriends6=null;

		
		UserManager um = new UserManager();		
		User u1 = um.findUser("Seruche", "1311");
		
		WorkoutManager wm = new WorkoutManager(u1);
		System.out.println(u1.getId());
		if(!wm.getWorkoutList(1).isEmpty()) {
			listFriends1=um.findUsersFromSport(2);
			for (int i = 0; i < listFriends1.size(); i++) {
				result1=new User[listFriends1.size()];
				result1[i] = (User) listFriends1.get(i);*/
				//System.out.println("Vide mais afficher 1"+listFriends1.get(i));
				//System.out.println("Vide mais afficher1");
			//}
		//}
		/*if(!wm.getWorkoutList(2).isEmpty()) {
			 listFriends2=um.findUsersFromSport(2);
			for (int i = 0; i < listFriends2.size(); i++) {
				result2=new User[listFriends2.size()];
				result2[i] = (User) listFriends2.get(i);*/
				//System.out.println("Vide mais afficher 2"+listFriends2.get(i));
				//System.out.println("Vide mais afficher2");
				//System.out.println(" User table 2"+listFriends2.get(i)+"\n");
				
		//	}
		//}
		/*if(!wm.getWorkoutList(3).isEmpty()) {
			listFriends3=um.findUsersFromSport(3);
			for (int i = 0; i < listFriends3.size(); i++) {
				result3=new User[listFriends3.size()];
				result3[i] = (User) listFriends3.get(i);*/
				//System.out.println("Vide mais afficher 3"+listFriends3.get(i));
				
		//	}
		//}
		/*if(!wm.getWorkoutList(4).isEmpty()) {
			listFriends4=um.findUsersFromSport(4);
			for (int i = 0; i < listFriends4.size(); i++) {
				result4=new User[listFriends4.size()];
				result4[i] = (User) listFriends4.get(i);*/
				//System.out.println("Vide mais afficher 4"+listFriends4.get(i));
				//System.out.println("Vide mais afficher4");
				
		//	}
		//}
		/*if(!wm.getWorkoutList(5).isEmpty()) {
			listFriends5=um.findUsersFromSport(5);
			for (int i = 0; i < listFriends5.size(); i++) {
				result5=new User[listFriends5.size()];
				result5[i] = (User) listFriends5.get(i);*/
				//System.out.println("Vide mais afficher 5"+result5[i]);
				/* listElem =new String[listFriends5.size()];
				listElem[i]=result.getFirstname();*/
				//System.out.println(listElem[i]+"\n");
				
			//}
		//}
		/*if(!wm.getWorkoutList(6).isEmpty()) {
			listFriends6=um.findUsersFromSport(6);
			for (int i = 0; i < listFriends6.size(); i++) {
				result6=new User[listFriends6.size()];
				result6[i] = (User) listFriends6.get(i);*/
				//System.out.println("Vide mais afficher 6"+listFriends6.get(i));
				
			//}
		//}
		/*System.out.println("Aucun tableau afficher pour l'instant");
		
		for(int i=0;i<result5.length;i++) {
			//System.out.println("Affiche Table 5"+result5[i]);
		}*/
		
		/*if(result1==null) {
			 result1.length=0;
		}*/
		/*int len = result1.length + result2.length+ result3.length+ result4.length+ result5.length+ result6.length;
		System.out.println("total longeur: "+len);
		
		result=new User[len];
		int position = 0;
		
		if(result1!=null) {
			for (User object : result1)
	        {
				result[position] = object;
	            position++;
	        }
		}
		
		if(result2!=null) {
			for (User object : result2)
	        {
				result[position] = object;
	            position++;
	        }
		}
		
		if(result3!=null) {
			for (User object : result3)
	        {
				result[position] = object;
	            position++;
	        }
		}
		
		if(result4!=null) {
			for (User object : result4)
	        {
				result[position] = object;
	            position++;
	        }
		}
		
		if(result5!=null) {
			//for (User object : result5)
	        //{
				for(int i=0;i<result5.length;i++) {
					result[position] = result5[i];
					//System.out.println("Table 5"+result5[i]);
		            position++;
				//}
				
				}
		}
		
		if(result6!=null) {
			for (User object : result6)
	        {
				result[position] = object;
	            position++;
	        }
		}
		
		for(int k=0;k<result.length;k++) {
			if(result[k]!=null) {
				listElem=new String[result.length];
				listElem[k]=result[k].getFirstname();
				System.out.println(listElem[k]);
			}
		}*/
		
		
		

	}

}
