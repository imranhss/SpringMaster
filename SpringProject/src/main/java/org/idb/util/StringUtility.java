package org.idb.util;



public class StringUtility {

	public static String toCommaSeparatedString(Object[] items) {
		
		StringBuilder sb=new StringBuilder();
		
		for(Object item: items) {
			sb.append(item).append(",");
		}
		if(sb.length()>0) {
			sb.delete(sb.length() -1, sb.length());
			System.out.println(sb+" ++++++++++++++++++++++++++++++++++");
		}
		
		return sb.toString();
	}
}
