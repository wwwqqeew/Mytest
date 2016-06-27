package com;

public class testb extends test{
	public String i = "子类";

	testb(){
		show();
		 System.out.println(" 显示初始化"); 
		 show();
		 System.out.println(" 显示初始化结束"); 
	}
	
@Override
public void show() {
	// TODO Auto-generated method stub
	System.out.println("子类："+i);
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test t = new testb();
		System.out.println(t.i);
		t.show();
	}

}
