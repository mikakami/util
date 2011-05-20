package ws.softlabs.lib.util.client;


public class CollectionUtils {
	
	public static int getIndexOf(Object[] list, Object object) {
		int idx = 0;
		if (object == null) return -1;
		while(idx < list.length &&  !list[idx].equals(object)) 
			idx++;
		if (idx >= list.length)
			return -1;
		return idx;
	}
	
}
