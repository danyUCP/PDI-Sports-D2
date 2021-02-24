package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFrame {

	public static void main(String[] args) 
	{		 
		 Date today = new Date();
		 SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE dd MMMM yyyy");
		 SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
		 System.out.println(dayFormat.format(today));
		 System.out.println(hourFormat.format(today));


	}

}
