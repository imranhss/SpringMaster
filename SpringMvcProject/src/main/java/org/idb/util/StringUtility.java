package org.idb.util;


public class StringUtility {
	
	public static  String toCommaSeparatedString(Object[] contactIds) {
		
		StringBuilder sb=new StringBuilder();
		
		for(Object item: contactIds) {
			
			sb.append(item).append(","); //{12, 15,}
			
		}
		
		if(sb.length()>0) {
			sb.delete(sb.length(), -1);
		}
		
		return sb.toString();
	}

}
