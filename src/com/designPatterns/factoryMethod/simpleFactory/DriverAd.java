package com.designPatterns.factoryMethod.simpleFactory;

/**
 * 具体工厂类DriverAd，针对AD
 * @author Administrator
 *
 */
public class DriverAd implements DriverInterface {

	@Override
	public Car getCar() {
		return new Ad();
	}

}
