package com.designPatterns.factoryMethod.simpleFactory;

/**
 * 抽象工厂类
 * @author Administrator
 *
 */
public interface DriverInterface {
	/**
	 * 获取服务
	 * @return
	 */
	public Car getCar();
}
