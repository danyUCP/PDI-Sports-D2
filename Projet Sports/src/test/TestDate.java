package test;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import data.JoggingWorkout;
import ihm.components.SportDateBox;

public class TestDate 
{
	public static void main(String[] args) 
	{
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		
		JoggingWorkout w = new JoggingWorkout(new java.sql.Date(0), 50, 2000);


		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

		System.out.println(dateFormat.format(new java.sql.Date(date.getTime())));
		System.out.println(dateFormat.format(new Date(w.getDate().getTime())));
		System.out.println(Calendar.getInstance().get(Calendar.YEAR));


		SportDateBox db = new SportDateBox();
		
		db.initLists();

	}
}
