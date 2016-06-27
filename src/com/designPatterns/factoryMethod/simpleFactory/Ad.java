package com.designPatterns.factoryMethod.simpleFactory;

import com.util.o;
/**
 * 具体产品类AD
 * @author Administrator
 *
 */
public class Ad implements Car {

	@Override
	public void Driver() {
		System.out.println("AD开始初始化");
	}


}
