package ws.softlabs.lib.util.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class DateUtils {

	private static final Logger log = 
		Logger.getLogger("kino.util." + DateUtils.class.getSimpleName());


    public static boolean isCorrectDateString(String string) {
    	log.debug("ENTER (string = " + string + ")");
    	if (string == null) {
        	log.debug("EXIT - FALSE (NULL input)");
    		return false;
    	}
    	if (string.isEmpty()) {
        	log.debug("EXIT - FALSE (empty input)");
    		return false;
    	}
    	boolean result = StringUtils.fromUtf(string).matches("^.{1,},\\s\\d{1,2}\\s.*$");
    	log.debug("EXIT - OK (result = " + result + ")");
   		return result;
    }    
    public static boolean isCorrectTimeString(String string) {
    	log.debug("ENTER (string = " + string + ")");
    	if (string == null) {
        	log.debug("EXIT - FALSE (NULL input)");
    		return false;
    	}
    	if (string.isEmpty()) {
        	log.debug("EXIT - FALSE (empty input)");
    		return false;
    	}
    	boolean result =  StringUtils.fromUtf(string).matches("^\\d{1,2}:\\d{1,2}$");
    	log.debug("EXIT - OK (result = " + result + ")");
   		return result;
    }    
    @SuppressWarnings("deprecation")
	public static Date stringToDate(String string) {
    	log.debug("ENTER (string = " + string + ")");
    	try {
	    	if (!isCorrectDateString(string)) return null;
	    	String[] strings = string.replaceAll(",", "").toLowerCase().split(" ");
	    	assert (strings.length == 3);    	
	    	
	    	Date newDate = new Date(System.currentTimeMillis());
	    	
	    	newDate.setDate(Integer.parseInt(strings[1]));
	    	newDate.setMonth(	Constants.STRING_TO_MONTH_MAP.get(
	    						StringUtils.toUtf(strings[2])));
	    	newDate.setHours(0);
	    	newDate.setMinutes(0);
	    	newDate.setSeconds(0);

	    	log.debug("EXIT - OK (result = " + newDate + ")");
	    	return newDate;
    	}
    	catch (Exception ex) {
	    	log.debug("EXIT - EXCEPTION: " + ex + ")");
    		return null;
    	}
    }    
    @SuppressWarnings("deprecation")
	public static Date stringToDate(String dateString, String timeString) {
    	log.debug("ENTER (dateString = " + dateString + ", timeString = " + timeString + ")");
    	try {
	    	if (!isCorrectDateString(dateString)) return null;
	    	if (!isCorrectTimeString(timeString)) return null;
	    	
	    	Date newDate = stringToDate(dateString);
	    	String[] strings = timeString.split(":");
	    	assert (strings.length == 2);
	    	newDate.setHours(Integer.parseInt(strings[0]));    	
	    	newDate.setMinutes(Integer.parseInt(strings[1]));  
	    	newDate.setSeconds(0);
	    	log.debug("EXIT - OK (result = " + newDate + ")");
	    	return newDate;
		}
		catch (Exception ex) {
	    	log.debug("EXIT - EXCEPTION: " + ex + ")");
			return null;
		}    	
    }    
    /* returns: "Пятница, 22 апреля" */
    @SuppressWarnings("deprecation")
	public static String dateToStringSpecial(Date date){
    	log.debug("ENTER (date = " + date + ")");
    	String weekday  = StringUtils.fromUtf(Constants.DAY_TO_STRING_MAP.get(date.getDay()));
    	String monthday = ((Integer)date.getDate()).toString();
    	String month    = StringUtils.fromUtf(Constants.MONTH_TO_STRING_MAP.get(date.getMonth()));
    	String result = StringUtils.firstUpcase(weekday) + ", " + monthday + " " + month;
    	log.debug("EXIT - OK (result = " + result + ")");
    	return result;
    }    
    /* returns: ["Пятница, 22 апреля", "10:00"] */
    @SuppressWarnings("deprecation")
	public static List<String> dateToStringList(Date date){
    	log.debug("ENTER (date = " + date + ")");
    	String dateString = dateToStringSpecial(date);
    	String h  = "" + date.getHours();
    	String hs = (h.length() > 1) ? h : "0" + h;
    	String m  = "" + date.getMinutes();
    	String ms = (m.length() > 1) ? h : "0" + m;
//String hs = String.format("%02d", date.getHours());
//String ms = String.format("%02d", date.getMinutes());
		String timeString =  hs + ":" + ms;
    	List<String> result = new ArrayList<String>();
    	result.add(dateString);
    	result.add(timeString);    	
    	log.debug("EXIT - OK (result = " + result + ")");
    	return result;
    }    
	@SuppressWarnings("deprecation")
	public static boolean equalDates(Date date1, Date date2) {
    	log.debug("ENTER (date1 = " + date1 + ", date2 = " + date2 + ")");
    	boolean result = date1.getYear()  == date2.getYear()  &&
						 date1.getMonth() == date2.getMonth() &&
						 date1.getDate()  == date2.getDate(); 
    	log.debug("EXIT - OK (result = " + result + ")");
		return 	result;
	}	
	@SuppressWarnings("deprecation")
	public static boolean equalTimes(Date date1, Date date2) {
    	log.debug("ENTER (date1 = " + date1 + ", date2 = " + date2 + ")");
		boolean result = equalDates(date1, date2) &&
						 date1.getHours()   == date2.getHours() &&
						 date1.getMinutes() == date2.getMinutes();
    	log.debug("EXIT - OK (result = " + result + ")");
		return result;
	}
	@SuppressWarnings("deprecation")
	public static Date dateToMidnight(Date date) {
    	log.debug("ENTER (date1 = " + date + ")");
		Date newDate = (Date) date.clone();
		newDate.setHours(0);
		newDate.setMinutes(0);
		newDate.setSeconds(0);		
    	log.debug("EXIT - OK (result = " + newDate + ")");
		return newDate;
	}
}
