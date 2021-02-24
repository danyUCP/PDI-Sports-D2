package test;

import data.User;
import ihm.MainFrame;
import manager.UserManager;
import manager.WorkoutManager;

public class TestManager 
{
	public static void main(String[] args) 
	{
		UserManager um = new UserManager();
		
		//User u1 = new User("Alexander","1311","Alexander","Bubb","M",20,186,65);
		User u1 = um.findUser("Alexander", "1311");
		
		WorkoutManager wm = new WorkoutManager(u1);
		
		System.out.println(u1.getId());
		wm.getWorkoutList(1);

		MainFrame frame = new MainFrame();



	}

}
