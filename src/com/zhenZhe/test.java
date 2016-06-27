package com.zhenZhe;

import java.util.Date;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "{47900b6364c11100:1451},{47900b6364c11101:},{47900b6364c11102:1451:1420356919125}";
		int start = str.indexOf("47900b6364c11100");
		int end = str.indexOf("},",start);
		System.out.println(str.substring(start, end));
//		str.substring(beginIndex);
		//str.indexOf(str, fromIndex)
	}

}
