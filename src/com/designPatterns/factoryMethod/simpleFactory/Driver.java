package com.designPatterns.factoryMethod.simpleFactory;

/**
 * 工厂类
 * @author Administrator
 *
 */
public class Driver {

	/**
	 * 多工厂模式的优化Bmw
	 * 静态化方法
	 * @return
	 */
	public static Car getBmw() {
		return new Bmw();
	}
	
	/**
	 * 多工厂模式的优化Ad
	 * 静态化方法
	 * @return
	 */
	public static Car getAd() {
		return new Ad();
	}
	
	/**
	 * 这是普通工厂类的调用模式
	 * @param car 代码
	 * @return
	 */
	public Car driverCar(String car) {
		if ("bmw".equals(car)) {
			return new Bmw();
		}else if("ad".equals(car)){
			return new Ad();
		}else{
			System.out.println("无效字符");
			return null;
		}

	}
}
