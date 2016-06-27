package com.designPatterns.factoryMethod.simpleFactory;

/**
 * 程序测试
 * @author Administrator
 *
 */
public class SimpleFactory {

	/**启动程序，执行想要的产品初始化
	 * @param args
	 */
	public static void main(String[] args) {
//		simpleTest();//普通工厂模式测试
		
//		StaticFactory();//静态工厂测试
		
		DriverInterface driver = new DriverBmw();
		Car car = driver.getCar();
		car.Driver();
	}

	public static void StaticFactory() {
		//		Driver driver = new Driver();//静态话以后，就不用新建实体了
				Car car = Driver.getBmw();//这样新来的小弟就不会写作带入代码了
				car.Driver();
	}

	public static void simpleTest() {
		Driver driver = new Driver();
		Car car = driver.driverCar("bmw");
		car.Driver();
	}

}
