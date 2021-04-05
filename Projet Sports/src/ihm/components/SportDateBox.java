package ihm.components;


import java.awt.Color;
import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SportDateBox extends JPanel
{
	private SportComboBox dayBox;
	private SportComboBox monthBox;
	private SportComboBox yearBox;
		
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
	private SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
	private SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
	private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

	private String[] days;
	private String[] months;
	private String[] years;

	public SportDateBox()
	{
		java.util.Date d = new java.util.Date();
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(new Color(28, 28, 28));

		initLists();
		
		dayBox = new SportComboBox(days);
		monthBox = new SportComboBox(months);
		yearBox = new SportComboBox(years);
		
		dayBox.setSelectedItem(dayFormat.format(d));
		monthBox.setSelectedItem(monthFormat.format(d));
		yearBox.setSelectedItem(yearFormat.format(d));

		
		this.add(dayBox);
		this.add(monthBox);
		this.add(yearBox);
	}
	
	public SportDateBox(Date date)
	{		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(new Color(28, 28, 28));

		initLists();
		
		dayBox = new SportComboBox(days);
		monthBox = new SportComboBox(months);
		yearBox = new SportComboBox(years);
		
		dayBox.setSelectedItem(dayFormat.format(date));
		monthBox.setSelectedItem(monthFormat.format(date));
		yearBox.setSelectedItem(yearFormat.format(date));

		
		this.add(dayBox);
		this.add(monthBox);
		this.add(yearBox);
	}
	
	public void initLists()
	{
		this.days = new String[31];
		
		for(int i = 0 ; i < days.length ; i++)
		{
			if(i < 9)
				this.days[i] = "0" + (i + 1);
			else
				this.days[i] = "" + (i + 1);			
		}
		
		
		this.months = new DateFormatSymbols().getShortMonths();

		
		this.years = new String[21];
		int actualYear = Calendar.getInstance().get(Calendar.YEAR);
		
		for(int i = 0 ; i < years.length ; i++)
			this.years[i] = "" + (actualYear - 10 + i);
	}
	
	public void setDateBox(Date date)
	{		
		dayBox.setSelectedItem(dayFormat.format(date));
		monthBox.setSelectedItem(monthFormat.format(date));
		yearBox.setSelectedItem(yearFormat.format(date));
	}
	
	public Date getDateBox()
	{
		Date date = null;
		String d = "";
		
		d += dayBox.getSelectedItem() + " ";
		d += monthBox.getSelectedItem() + " ";
		d += yearBox.getSelectedItem();

		System.out.println(d);

		try 
		{
			date = new Date(dateFormat.parse(d).getTime());
		} 
		catch (ParseException e) 
		{
			date = new Date(new java.util.Date().getTime());
		}
		
		System.out.println(date);
		
		return date;
	}
	
	

}
