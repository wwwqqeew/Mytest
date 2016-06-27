package com.finalT;

import java.util.ArrayList;
import java.util.List;

public class testfinal {
	public final List list = new ArrayList();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testfinal testfinal1 = new testfinal();
		testfinal testfinal2 = new testfinal();
		System.out.println(testfinal1.getList().size());
		testfinal2.ss(1);
		System.out.println(testfinal2.getList().size());
	}
	public List getList() {
		return list;
	}
	
	public void ss(int i){
		list.add(i);
	}
}
