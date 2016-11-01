import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtility {
	public static  String DateTimeZoneFormat = "yyyy-MMMM-dd hh:mm z";
	public static  String DateFormat = "yyyy-MMMM-dd";
	
	public static String getCalenderAsString(Calendar calender, String strFormat)
	{
		SimpleDateFormat f = new SimpleDateFormat(strFormat);
		
		return f.format(calender.getTime());
	}
}
