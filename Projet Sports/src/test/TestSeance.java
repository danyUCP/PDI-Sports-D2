package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*import data.Seance;
import data.SeanceAviron;
import data.SeanceJogging;*/

public class TestSeance 
{
	
	public static void main(String[] args) 
	{
		//Seance s1 = new SeanceJogging(null, 50, 2000);
		//Seance s2 = new SeanceAviron(null, 120, 3500, 600);

		//System.out.println(s1);
		//System.out.println(s2);
		TestSeance test=new TestSeance();
		System.out.println(test.ConvertIntoNumeric("10"));
		System.out.println(test.ConvertIntoNumeric("30"));
		System.out.println(test.ConvertIntoNumeric("602"));
		int i=test.ConvertIntoNumeric("602")+1;
		System.out.println(i);
		
		SimpleDateFormat formater = null;

	    Date aujourdhui = new Date();

	    formater = new SimpleDateFormat("yyyy-MM-dd");
	    //System.out.println(formater.format(aujourdhui));
	    
	    String s = "2011-07-08";
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			Date d = sdf.parse(s);
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	private int ConvertIntoNumeric(String xVal)
	{
	 try
	  { 
	     return Integer.parseInt(xVal);
	  }
	 catch(Exception ex) 
	  {
	     return 0; 
	  }
	}

}
