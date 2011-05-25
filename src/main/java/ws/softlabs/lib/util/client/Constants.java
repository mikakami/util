package ws.softlabs.lib.util.client;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final int dayOffset = 4;
	public static final long oneDay = 24 * 60 * 60 * 1000; // msec in 1 day
	
	public static final String	laquo = "«";
	public static final String	raquo = "»";	
	
	/* UTF-8 encoded values */
    @SuppressWarnings("serial")
	public static final Map<String, Integer> STRING_TO_MONTH_MAP = new HashMap<String, Integer>() {{
    	put("января",  	 0);
    	put("февраля", 	 1);
    	put("марта", 	 2);
    	put("апреля", 	 3);
    	put("мая", 		 4);
    	put("июня", 	 5);
    	put("июля", 	 6);
    	put("августа", 	 7);
    	put("сентября",  8);
    	put("октября", 	 9);
    	put("ноября", 	10);
    	put("декабря", 	11);
    }};
    @SuppressWarnings("serial")
    public static final Map<Integer, String> MONTH_TO_STRING_MAP = new HashMap<Integer, String>() {{
    	put( 0, "января"  );
    	put( 1, "февраля" );
    	put( 2, "марта"   );
    	put( 3, "апреля"  );
    	put( 4, "мая"     );
    	put( 5, "июня"    );
    	put( 6, "июля"    );
    	put( 7, "августа" );
    	put( 8, "сентября");
    	put( 9, "октября" );
    	put(10, "ноября"  );
    	put(11, "декабря" );
    }};
    @SuppressWarnings("serial")
    public static final Map<Integer, String> DAY_TO_STRING_MAP   = new HashMap<Integer, String>() {{
    	put(1,  "понедельник" );
    	put(2,  "вторник"     );
    	put(3,  "среда"    	  );
    	put(4,  "четверг" 	  );
    	put(5,  "пятница" 	  );
    	put(6,  "суббота" 	  );
    	put(0,  "воскресенье" );
    }};
}
