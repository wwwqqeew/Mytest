package com.Thread;

import java.util.Map;
import java.util.Set;

import com.util.o;


public class ThreadTest {
    
	public static Thread thread = null;
    /**
     * 观察直接调用run()和用start()启动一个线程的差别 
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args){
         thread=new ThreadDemo();
        //第一种
        //表明: run()和其他方法的调用没任何不同,main方法按顺序执行了它,并打印出最后一句
//        thread.run();
       
        
        //第二种
        //表明: start()方法重新创建了一个线程,在main方法执行结束后,由于start()方法创建的线程没有运行结束,
        //因此主线程未能退出,直到线程thread也执行完毕.这里要注意,默认创建的线程是用户线程(非守护线程)
        thread.start();
//        thread.start();
        //第三种
        //1、为什么没有打印出100句呢?因为我们将thread线程设置为了daemon(守护)线程,程序中只有守护线程存在的时候,是可以退出的,所以只打印了七句便退出了
        //2、当java虚拟机中有守护线程在运行的时候，java虚拟机会关闭。当所有常规线程运行完毕以后，
        //守护线程不管运行到哪里，虚拟机都会退出运行。所以你的守护线程最好不要写一些会影响程序的业务逻辑。否则无法预料程序到底会出现什么问题
        //thread.setDaemon(true);
        thread.start();
        
        //第四种
        //用户线程可以被System.exit(0)强制kill掉,所以也只打印出七句
//        thread.start();
//        System.out.println("main thread is over");
//        System.exit(1);
    }
    
    private static void sdf() throws InterruptedException {
		// TODO Auto-generated method stub
    	o.o("进入",thread);
    	thread.stop();
    	Thread.sleep(5000);
    	o.o("退出",thread);
	}
    
    public static class ThreadDemo extends Thread{
    	public ThreadDemo ttd = null;
    	Map<Thread,StackTraceElement[]> all = ThreadDemo.getAllStackTraces();
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
            	Set<Thread> keys = all.keySet();
//            	int t = 0;
//            	for (Thread thread : keys) {
//					o.o("第："+t++,thread.getId());
//				}
                System.out.println("\n This is a "+all.size()+" Thread test"+i);
                try {
                	o.o("进入",thread.getId());
                	thread.stop();
//                	thread = null;
//                	thread = new ThreadDemo();
//                	thread.start();
                	Thread.sleep(5000);
                	o.o("退出",thread);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
                o.o("ThreadDemo:"+i);
            }
//            try {
//				sdf();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
            o.o("ThreadDemo结束");
//            o.o(this,this.isAlive(),this.isInterrupted());
//			this.stop();
//            o.o(this,this.isAlive(),this.isInterrupted());
//            this.start();
//            o.o(this,this.isAlive(),this.isInterrupted());
//            try {
//				this.wait();
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//            o.o(this,this.isAlive(),this.isInterrupted());
//            try {
//				this.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        }
    }
}
