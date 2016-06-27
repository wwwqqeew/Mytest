package com.designPatterns.Singleton.Singleton;

public class SingletonThread {

	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
	private static SingletonThread instance = null;
	
	/* 私有构造方法，防止被实例化 */  
    private SingletonThread() {  
//    	try {
//    		System.out.println("进入八秒休眠");
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    } 
    
    /* 静态工程方法，创建实例 */  
    public static synchronized  SingletonThread getInstance(String msg) throws InterruptedException{
    	System.out.println("开始静态工程方法，创建实例 ."+msg);
    	if (instance == null) {
//    		 synchronized (instance) {  //这里这样写会报空指针错误
                 if (instance == null) {  
                	 Thread.sleep(5000);//这里的5秒延迟，是为了测试多线程的时候用的，模拟两个线程同时进入这个方法引起的问题。
                	 System.out.println("创建单例."+msg);
                     instance = new SingletonThread();  
                     System.out.println("创建单例完毕."+msg);
                 }  
//             }  
  
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
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Singleton singleton = new Singleton();
//		singleton.getInstance();

		ThreadTestA threadTestA = new ThreadTestA();
		ThreadTestB threadTestB = new ThreadTestB();
		threadTestA.start();
		threadTestB.start();
	}

	public static class ThreadTestA extends Thread{
		@Override
		public void run() {
			try {
				SingletonThread.getInstance("ThreadTestA");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static class ThreadTestB extends Thread{
		@Override
		public void run() {
			try {
				SingletonThread.getInstance("threadTestB");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
