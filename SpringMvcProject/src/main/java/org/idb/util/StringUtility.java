package org.idb.util;


public class StringUtility {
	
	public static  String toCommaSeparatedString(Object[] contactIds) {
		
		StringBuilder sb=new StringBuilder();
		
		for(Object item: contactIds) {
			
			sb.append(item).append(","); //{12, 15,20,30,}
			
		}
		
		if(sb.length()>0) {
			sb.delete(sb.length() -1, sb.length()); //{12, 15,20,30}
		}
		
		return sb.toString();
	}

}
