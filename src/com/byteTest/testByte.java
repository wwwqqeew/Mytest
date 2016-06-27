package com.byteTest;

public class testByte {

	/**
	 * @param args
	 */ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ss());
		;
	}

	public static String  ss() {
		try {
			String a = null;
			a.equals("ss");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败了");
			return "0";
		}
		return "1";
	}

}
