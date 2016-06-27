package com.designPatterns.Singleton.Singleton;

public class Singleton {

	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
	private static Singleton instance = null;
	
	/* 私有构造方法，防止被实例化 */  
    private Singleton() {  
    } 
    
    /* 静态工程方法，创建实例 */  
    public static Singleton getInstance(String msg) throws InterruptedException{
    	System.out.println("开始静态工程方法，创建实例 ."+msg);
    	if (instance == null) {
    		Thread.sleep(5000);//这里的5秒延迟，是为了测试多线程的时候用的，模拟两个线程同时进入这个方法引起的问题。
    		System.out.println("创建."+msg);
    		instance = new Singleton();
		}
    	System.out.println("结束静态工程方法，创建实例."+msg);
		return instance;
    } 
    
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return instance;  
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
			try {
				Singleton.getInstance("2");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
