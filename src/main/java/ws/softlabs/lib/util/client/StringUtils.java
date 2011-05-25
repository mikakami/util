package ws.softlabs.lib.util.client;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils {

	private static final Logger log = 
		LoggerFactory.getLogger("kino.util." + StringUtils.class.getSimpleName());
	
    public static String firstUpcase(String string) {
    	log.debug("ENTER (string = " + string +")");
    	if (string == null) {
        	log.debug("EXIT - NULL input string");
    		return null;
    	}
    	if (string.isEmpty()) {
        	log.debug("EXIT - Empty input string");
    		return string;
    	}
    	String result;
    	if (string.length () == 1) {
    		result    = string.toUpperCase(); 
    	} else {
        	String s1 = string.substring(0, 1);
        	String s2 = string.substring(1, string.length());
        	result    =  s1.toUpperCase() + s2;
    	}
    	log.debug("EXIT - OK (result = " + result +")");
    	return result;
    }
    public static String restoreHTMLString(String string) {
    	log.debug("ENTER (string = " + string +")");
    	String result = restoreHTMLString(string, null); 
    	log.debug("EXIT");
    	return result;
    }
    public static String restoreHTMLString(String string, String charset) {
    	log.debug("ENTER (string = " + string +", charset = " + charset + ")");
    	String charsetName;
    	if (charset == null)
    		charsetName = java.nio.charset.Charset.defaultCharset().name();
    	else 
    		charsetName = charset;
    	String s = string;
    	String replace1 = fromUtf(Constants.laquo, charsetName);
    	String replace2 = fromUtf(Constants.raquo, charsetName);
		s = s.replace(replace1, "&laquo;");
		s = s.replace(replace2, "&raquo;");
    	log.debug("EXIT (result = " + s + ")");
    	return s;
    }
    public static String fromUtf(String string) {
    	log.debug("ENTER (string = " + string + ")");
    	String result = fromUtf(string, null); 
    	log.debug("EXIT (result = " + result + ")");
    	return result;
    }    
    public static String fromUtf(String string, String charset) {
    	log.debug("ENTER (string = " + string +", charset = " + charset + ")");
    	if (string  == null) {
        	log.debug("EXIT - NULL input string");
    		return null;
    	}
    	try {
	    	String charsetName;	    	
	    	if (charset == null)
	    		charsetName = java.nio.charset.Charset.defaultCharset().name();
	    	else 
	    		charsetName = charset;
	    	
	    	if ( charsetName.equals("UTF-8")) {
	        	log.debug("EXIT - OK return original string");
	    		return string;
	    	}	    	
	    	String result = string;
	    	if ( charsetName.equals("windows-1251") )
	    		result = new String(
	    							string.getBytes(
	    								charsetName /*"windows-1251"*/
		    						), 	
		    						"UTF-8" );
	    	log.debug("EXIT - OK (result = " + result + ")");
	    	return result;
    	}
    	catch( UnsupportedEncodingException ex ) {
        	log.debug("EXIT - EXCEPTION UnsupportedEncoding");
    		return string;
    	}
    }
    public static String toUtf(String string) {
    	log.debug("ENTER (string = " + string + ")");
    	String result = toUtf(string, null); 
    	log.debug("EXIT (result = " + result + ")");
    	return result;
    }    
    public static String toUtf(String string, String charset) {
    	log.debug("ENTER (string = " + string +", charset = " + charset + ")");
    	if (string  == null) {
        	log.debug("EXIT - NULL input string");
    		return null;
    	}
    	try {
	    	String charsetName;

	    	if (charset == null)
	    		charsetName = java.nio.charset.Charset.defaultCharset().name();
	    	else 
	    		charsetName = charset;
	    	
	    	if ( charsetName.equals("UTF-8")) {
	        	log.debug("EXIT - OK return original string");
	    		return string;
	    	}
	    	
	    	String result = string;
	    	if ( charsetName.equals("windows-1251") )
	    		result = new String(
	    							string.getBytes("UTF-8"),// original charset
	    							charsetName );
	    	log.debug("EXIT - OK (result = " + result + ")");
	    	return result;
    	}
    	catch( UnsupportedEncodingException ex ) {
        	log.debug("EXIT - EXCEPTION UnsupportedEncoding");
    		return string;
    	}
    }

}
