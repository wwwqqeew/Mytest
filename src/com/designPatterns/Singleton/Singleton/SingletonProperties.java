package com.designPatterns.Singleton.Singleton;

import java.util.Vector;


public class SingletonProperties {

	private static SingletonProperties instance = null;
	private Vector properties = null;  
	
	
	public Vector getProperties() {
		return properties;
	}

	public static synchronized void syncInit(){
		if (instance == null) {
			instance = new SingletonProperties();
		}
	}
	
    /* 静态工程方法，创建实例 */  
    public static SingletonProperties getInstance(String msg) {
    	if (instance == null) {
    		syncInit();
		}
		return instance;
    } 
    
    public void updateProperties() {  
    	SingletonProperties shadow = new SingletonProperties();  
        properties = shadow.getProperties();  
    }  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
