package com.designPatterns.factoryMethod.simpleFactory;

import com.util.o;

/**
 * 具体产品类BMW
 * @author Administrator
 *
 */
public class Bmw implements Car {

	@Override
	public void Driver() {
		System.out.println("BMW开始初始化");
	}


}
