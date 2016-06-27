package com.entity;

public class testEntity extends Thread{
	public static String aa;
	public static final String bb = "final";
	
	public testEntity(String ab){
		this.aa = ab;
	}
	
	public static String getAa() {
		return aa;
	}
	public static void setAa(String aa) {
		testEntity.aa = aa;
	}
	public static String getBb() {
		return bb;
	}
	
	@Override
	public void run() {
		System.out.println("‘À––¡À:"+this.aa);
	}
	
}
