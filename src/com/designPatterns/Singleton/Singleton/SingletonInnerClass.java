package com.designPatterns.Singleton.Singleton;

public class SingletonInnerClass {

	/* 私有构造方法，防止被实例化 */  
    private SingletonInnerClass() {  
    	System.out.println("创建了一次");
    	String test = null;
    	System.out.println("测试初始化出错");
    	test.equals("test");
    } 
    
    /* 内部类维护单例  */
    private static class SingletonFactory{
    	private static SingletonInnerClass instance = new SingletonInnerClass();
    }
    
    /* 静态工程方法，创建实例 */  
    public static SingletonInnerClass getInstance(String msg) {
    	System.out.println("开始静态工程方法，创建实例 ."+msg);
		return SingletonFactory.instance;
    } 
    
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return getInstance("readResolve");  
    }
    
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

//		Singleton.getInstance("main测试1");
//		Singleton.getInstance("main测试2");
		
		TestThread testThread = new TestThread();
		TestThread testThread2 = new TestThread();
		testThread.start();
		testThread2.start();
	}

	public static class TestThread extends Thread{
		@Override
		public void run() {
			SingletonInnerClass.getInstance("2");
		}
	}
}
