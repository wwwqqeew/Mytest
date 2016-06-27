package com;

public class testLock {

	private static String ss = null;
	private static testLockThread testLockThread = null;
			
	
	private static void getSS(){
		if (testLockThread == null) {
			testLockThread = new testLockThread();
		}
	}
	
	public static void test() {
		getSS();
		testLockThread.send("µ¥¶À-------------------------------");
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		getSS();
		testLockThread.start();
		while (true) {
			Thread.sleep(3000);
			test();
		}
		

	}
	
	

}
