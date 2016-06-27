package com;

public class testLockThread extends Thread{
	
	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				i++;
				send("线程"+i);
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	synchronized static void send(String a) {
		System.out.println("执行了发送【"+a+"】\n");
	}

}
