package com.designPatterns.factoryMethod.simpleFactory;

/**
 * 具体工厂类DriverBmw，针对Bmw
 * @author Administrator
 *
 */
public class DriverBmw implements DriverInterface {

	@Override
	public Car getCar() {
		return new Bmw();
	}

}
