package com.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HMShowAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 *显示所有
	 * @param hashMap
	 */
	public static void showAll(HashMap hashMap) {
		if (hashMap != null) {
			Iterator iter = hashMap.entrySet().iterator();  
	        while (iter.hasNext()) {  
	            Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();  
	            System.out.println("["+entry.getKey()+","+entry.getValue()+"]");  
	        } 
		} else {
			System.out.println("HashMapΪ"+hashMap);
		}
		   
	}
}
