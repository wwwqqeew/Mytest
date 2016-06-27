package com.substring;

import com.util.o;

public class tets {
	public static void main(String[] args) {
//		test();
		String lot = "20.1234567";
		String lot2 = "20.1234";
		
		int weishu = 6;
		int dian = lot.indexOf(".");
		int cd = lot.length() - 1 - dian; 
		if (cd > weishu) {
			o.o(cd,dian+cd);
		}
		
	}

	public static void test() {
		String as = "123456789";
//		o.o(as.substring(4),as.substring(2, 4));
		o.o(as.substring(5));
	}
	
	
}
