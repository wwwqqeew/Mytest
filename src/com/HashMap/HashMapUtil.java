package com.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapUtil {

	static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 hashMap.put("one", 1);  
	        hashMap.put("two", 2);  
	        hashMap.put("three", 3);  
	        hashMap.put("four", 4);  
	        hashMap.put("five", 5);  
	}
	
	/**
	 *显示所有
	 * @param hashMap
	 */
	public static void showAll(HashMap hashMap) {
		if (hashMap != null) {
			Iterator iter = hashMap.entrySet().iterator();  
	        while (iter.hasNext()) {  
	            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iter.next();  
	            String key = entry.getKey();  
	            Integer value = entry.getValue();  
	            System.out.println("["+key+","+value+"]");  
	        } 
		} else {
			System.out.println("HashMapΪ"+hashMap);
		}
		   
	}

}
