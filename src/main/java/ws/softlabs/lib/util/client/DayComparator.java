package ws.softlabs.lib.util.client;

import java.util.Comparator;
import java.util.Date;

public class DayComparator implements Comparator<String> {
	public int compare(String o1, String o2) {
	    final int BEFORE = -1;
	    final int EQUAL  = 0;
	    final int AFTER  = 1;
		int result;
	    Date d1 = DateUtils.stringToDate(o1);
		Date d2 = DateUtils.stringToDate(o2);

	    if ( o1 == o2 )       result = EQUAL;
	    else if ( d1 == null) result = BEFORE;
	    else if ( d2 == null) result = AFTER;
	    else result = d1.compareTo(d2);
		//System.out.println(d1 + "\n" + d2 + "\n" + result + "\n");
	    return result;
	}
}
