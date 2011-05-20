package ws.softlabs.lib.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;

import org.junit.Test;

import ws.softlabs.lib.util.client.StringUtils;

public class StringUtilsTest {
	private final String dateStringUTF = "Пятница, 22 апреля";
	private final String dateStringWIN = "�������, 22 ������";
	
	@Test
	public void testStringConversions() {	
		String stringUtf, stringWin;

		stringWin = StringUtils.fromUtf(dateStringUTF);
		stringUtf = StringUtils.toUtf(stringWin);
		assertTrue(dateStringUTF.equals(stringUtf));
		
		stringUtf = StringUtils.toUtf(dateStringWIN);
		stringWin = StringUtils.fromUtf(stringUtf);
		assertTrue(dateStringWIN.equals(stringWin));

		stringUtf = StringUtils.toUtf(dateStringWIN, "windows-1251");
		stringWin = StringUtils.fromUtf(stringUtf, "windows-1251");
		assertTrue(dateStringWIN.equals(stringWin));
		
		assertTrue(dateStringWIN.equals(StringUtils.fromUtf(dateStringWIN, "UTF-8")));
		assertTrue(dateStringUTF.equals(StringUtils.toUtf(dateStringUTF, "UTF-8")));
		
//		assertTrue(dateStringUTF.equals(StringUtils.toUtf(dateStringWIN)));
//		assertTrue(dateStringWIN.equals(StringUtils.fromUtf(dateStringUTF)));
	}
	@Test
	public void testFirstUpcase() {
		String sWIN   = "�������, 22 ������";
		String sUTF   = "пятница, 22 апреля";
		if (Charset.defaultCharset().name().equals("UTF-8"))		
			assertTrue(dateStringUTF.equals(StringUtils.firstUpcase(sUTF)));		
		//if (Charset.defaultCharset().name().contains("1251"))
		//	assertTrue(dateStringWIN.equals(StringUtils.firstUpcase(sWIN)));		
	}
	@Test
	public void testRestoreHTML_UTF() {
		if (Charset.defaultCharset().name().equals("UTF-8")) {		
			String sUTF  = "«VIP»";
			String rsUTF = StringUtils.restoreHTMLString(sUTF);
			assertEquals(rsUTF, "&laquo;VIP&raquo;");
		}
	}
	@Test
	public void testRestoreHTML_WIN() {
		if (Charset.defaultCharset().name().contains("1251")) {
			String sWIN  = "�VIP�";
			String rsWIN = StringUtils.restoreHTMLString(sWIN);
			//assertEquals(rsWIN, "&laquo;VIP&raquo;");
		}
	}
}
