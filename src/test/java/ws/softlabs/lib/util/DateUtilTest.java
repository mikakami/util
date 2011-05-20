package ws.softlabs.lib.util;

import java.util.Date;

import org.junit.Test;

import ws.softlabs.lib.util.client.DateUtils;
import ws.softlabs.lib.util.client.StringUtils;

import junit.framework.TestCase;


public class DateUtilTest extends TestCase {
	
	private final String dateString = "Пятница, 22 апреля";
	private final String timeString = "10:00";
	
	@SuppressWarnings("deprecation")
	private boolean equalDates(Date date1, Date date2) {
		return 
			date1.getYear()    == date1.getYear()	&&
			date1.getMonth()   == date1.getMonth()	&&
			date1.getDate()    == date1.getDate()	&&
			date1.getHours()   == date1.getHours()	&&
			date1.getMinutes() == date1.getMinutes()&&
			date1.getSeconds() == date1.getSeconds();	
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testIsCorrectDateString(){
		assertEquals(DateUtils.isCorrectDateString(null), false);
		assertEquals(DateUtils.isCorrectDateString(""), false);
		assertEquals(DateUtils.isCorrectDateString((new Date(2011, 3, 25, 0, 0, 0).toString())), false);
		assertEquals(DateUtils.isCorrectDateString("Пятница, 22 апреля"), true);
		assertEquals(DateUtils.isCorrectDateString("Суббота, 23 апреля"), true);		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testIsCorrectTimeString(){
		assertEquals(DateUtils.isCorrectTimeString(null), false);
		assertEquals(DateUtils.isCorrectTimeString(""), false);
		assertEquals(DateUtils.isCorrectTimeString((new Date(2011, 3, 25, 0, 0, 0).toString())), false);
		assertEquals(DateUtils.isCorrectTimeString("10:00:00"), false);
		assertEquals(DateUtils.isCorrectTimeString("10;00"), false);		
		assertEquals(DateUtils.isCorrectTimeString("10.00"), false);		
		assertEquals(DateUtils.isCorrectTimeString("10:00"), true);		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testStringToDate()  {
		assertEquals(DateUtils.stringToDate(null), null);
		assertEquals(DateUtils.stringToDate(""), null);
		assertEquals(DateUtils.stringToDate("21.12.2010"), null);		
		Date date = new Date(System.currentTimeMillis());
		date.setMonth(3);
		date.setDate(22);
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);		
		Date newDate = DateUtils.stringToDate(
				StringUtils.fromUtf(dateString));
		assertTrue(equalDates(date, newDate));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testStringToDateTime() {
		assertEquals(DateUtils.stringToDate(null, null), null);
		assertEquals(DateUtils.stringToDate(dateString, null), null);
		assertEquals(DateUtils.stringToDate(null, timeString), null);
		assertEquals(DateUtils.stringToDate("", ""), null);
		assertEquals(DateUtils.stringToDate(dateString, ""), null);
		assertEquals(DateUtils.stringToDate("", timeString), null);
		assertEquals(DateUtils.stringToDate("21.12.2010", timeString), null);
		assertEquals(DateUtils.stringToDate(dateString, "10:00:00"), null);
		Date date = new Date(System.currentTimeMillis());
		date.setMonth(3);
		date.setDate(22);
		date.setHours(10);
		date.setMinutes(0);
		date.setSeconds(0);
		Date newDate = DateUtils.stringToDate(
				StringUtils.fromUtf(dateString), timeString);
		assertTrue(equalDates(date, newDate));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testDateToStringSpecial(){
		Date date = new Date(2011 - 1900, 3, 22, 10, 0, 0);
		assertEquals(
						DateUtils.dateToStringSpecial(date), 
						StringUtils.fromUtf("Пятница, 22 апреля")
					);
	}

}
