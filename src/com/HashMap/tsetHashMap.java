package com.HashMap;

import java.util.*;

public class tsetHashMap {

	
	static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();  
    
    public static void main(String [] args) {  
        hashMap.put("one", 1);  
        hashMap.put("two", 2);  
        hashMap.put("three", 3);  
        hashMap.put("four", 4);  
        hashMap.put("five", 5);  
          
        Iterator iter = hashMap.entrySet().iterator();  
          
        // the first method to travel the map  
        while (iter.hasNext()) {  
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iter.next();  
              
            String key = entry.getKey();  
            Integer value = entry.getValue();  
              
            System.out.println(key + " " + value);  
        }  
          
        iter = hashMap.keySet().iterator();  
          
        // the second method to travel the map  
//        while (iter.hasNext()) {  
//            String key = (String) iter.next();  
//            Integer value = hashMap.get(key);  
//              
//            System.out.println(key + " " + value);  
//        }  
    } // close main()  
	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		testList();
//		testPutReturn();
//	}

	private static void testPutReturn() {
		HashMap hm = new HashMap();
		System.out.println(hm.put(0, 0));
		System.out.println(hm.put(0, 1));
	}

	private static void testList() {
		List mapList = new ArrayList();
		mapList.add("6");
		System.out.println(mapList.size());
		HashMap<String,List> Pmap = new HashMap();
		Pmap.put("0", mapList);
		for (int i = 0; i < 3; i++) {
			if (i == 0 && Pmap.get(""+i) != null) {
				Pmap.get(""+i).add(""+i);
				System.out.println("dd");
			} else {

			}
			
		}
		System.out.println("11:"+Pmap.get("0"));
		System.out.println("11:"+mapList);
	}

}
