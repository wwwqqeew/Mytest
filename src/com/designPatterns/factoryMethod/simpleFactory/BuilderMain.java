package com.designPatterns.factoryMethod.simpleFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者类 BuilderMain
 * @author Administrator
 *
 */
public class BuilderMain {

	private List<DriverInterface> list = new ArrayList<DriverInterface>();  
	
	/**
	 * 制造Ad
	 * @param count
	 */
	public void produceAd(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new DriverAd());
		}
	}
	
	/**
	 * 制造Bmw
	 * @param count
	 */
	public void produceBmw(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new DriverBmw());
		}
	}
	
	public static void main(String[] args) {
		BuilderMain builderMain = new BuilderMain();
		builderMain.produceAd(5);
	}


}
