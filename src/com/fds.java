package com;

import com.util.o;

public class fds {

	private static inClass ic = null;
	private static int i = 5;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getInClass().start();
//		byte a= 'z';
		
//		System.out.println((char) 65);
		String as = "123456789";
//		o.o(as.substring(4),as.substring(2, 4));
		o.o(as.substring(as.length() - 6));
	}
	
	private static inClass getInClass() {
		if (ic == null) {
			ic = new inClass();
		}
		return ic;
	}
	
	public static class inClass extends Thread{
		@Override
		public void run() {
			System.out.println("3223:"+i);
		}
	}

}
