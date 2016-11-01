package Utility;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Provides methods to generate and manipulate Calendar objects
 * @author NMCG
 * @version 1.0
 *
 */
public class DateUtility 
{
	/**
	 * Returns a Calendar object with the date and time set to the user-defined values
	 * @param date
	 * @param month
	 * @param year
	 * @param hourOfDay
	 * @param minute
	 * @param second
	 * @return Calendar object
	 */
	public static Calendar getCalendarFrom(int date, int month, int year, int hourOfDay, int minute, int second)
	{
		//gets a calendar object BUT sets date and time to current date and time
		Calendar calendar = Calendar.getInstance();
		
		//so we reset to our desired date and time
		calendar.set(year, month, date, hourOfDay, minute, second);
		
		return calendar;
	}
	
	/**
	 * Returns the difference in milliseconds between two dates
	 * @param startDate
	 * @param endDate
	 * @return Difference in milliseconds, or -1 if the dates are in the incorrect order
	 */
	public static long getDifferenceInMs(Calendar startDate, Calendar endDate)
	{
		//check to see if the dates are in the correct order i.e. end after start
		if(endDate.after(startDate))
			return endDate.getTimeInMillis() - startDate.getTimeInMillis();
		//if not, then return -1
		else
			return -1;	
	}
	
	
	/**
	 * Returns the Calendar object as a String based upon a user defined format 
	 * @param date
	 * @param strFormat
	 * @return Returns the date as a string
	 */
	public static String getCalendarAsString(Calendar date, String strFormat)
	{
		/* Typical formats:
		 * 
		 * "d MMM yyyy HH:mm:ss"
		 * "EEE, MMM d, ''yy"
		 * "EEE, d MMM yyyy HH:mm:ss"
		 * 
		 * See http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
		 */
		
		
		SimpleDateFormat sdFormatter = new SimpleDateFormat(strFormat);	
		return sdFormatter.format(date.getTime());
	}}

