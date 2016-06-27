package com.reflex;

import com.util.o;

public class runMain {
	public static void main(String[] args) {
//		System.out.println(BeanHelper.describe(Enterty.class));
		String ss = "http://191.168.230.45:84/PathUrl.ashx?path=/typical/12/";
		o.o(ss.replaceAll("path=/typical", "path=typical"));
	}
}
