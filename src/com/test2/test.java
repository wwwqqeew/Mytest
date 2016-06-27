package com.test2;

import java.util.HashMap;

import com.JSON.Point;
import com.util.o;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ttt();
		int a = 2;
		int b = 3 ;
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		hp.put(a, a);
		hp.put(b, b);
		o.o(hp.get(a),hp.get(b));
		swap(hp);
		o.o(hp.get(a),hp.get(b));
//		a = a^b;
//		o.o(a,b);
//		
//		b = a^b;
//		o.o(a,b);
//		
//		a = a^b;
//		o.o(a,b);
//		o.o(3<<b);

	}
	
	public static void swap(HashMap<Integer, Integer> hp) {
		int b;
		b = hp.get(2);
		hp.put(2, hp.get(3));
		hp.put(3, b);
		}

	private static void ttt() {
		Point aa1 = null;
		aa1 =	new Point();
		String s = "5";
		aa1.setLatitude(s);
		aa1.setLongitue(s);
		System.out.println(aa1);
		
		tess(aa1);
		System.out.println(aa1);
	}

	private static void tess(Point aa1) {
		String s2 = "6";
		aa1.setLatitude(s2);
		aa1.setLongitue(s2);
	}

	private static String tt(String a) {
//		int a;
		a = ""+6;
		return a;
	}

}
