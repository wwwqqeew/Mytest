package com.list;

import java.util.ArrayList;
import java.util.List;

public class testLsit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		for (int i = 0; i < 3; i++) {
			list.add(i);
			System.out.println(list.get(i));
		}
		list.remove(0);
		System.out.println("\nÒÆ³ýºó£º"+list.size());
		list.add(4);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+" £º"+list.get(i));
		}
	}

}
