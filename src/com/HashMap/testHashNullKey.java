package com.HashMap;

import java.util.HashMap;

public class testHashNullKey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap hm = new HashMap();
		hm.put(1, "10");
		hm.remove(2);
		System.out.println(hm.get(2));
		
//		int i = 1;
//		System.out.println(i++);
//		System.out.println(i);
	}

}
