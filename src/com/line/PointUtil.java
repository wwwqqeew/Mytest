package com.line;

/**
 * 点相关的公共类
 * @author Administrator
 *
 */
public class PointUtil {

	/**
	 * 根据两个点计算 x = a*y + z ; 中的 a 和 z
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	private static void getAAndZ(double x1, double y1, double x2, double y2){
		double a = 0;
		double z = 0;
		a = (x1 - x2)/(y1 - y2); //求 a
		z = x1 - a*y1;
		System.out.println("公式为：x = ("+a+")*y + ("+z+")");
	}
	

	/**
	 * 算交点（轴线）
	 * @param isX 是否X平行
	 * @param data 数据
	 * @param a2 
	 * @param z2
	 */
	private static void getIntersection(boolean isX, double data, double a2, double z2) {
		double x = 0;
		double y = 0;
		if (isX) {
			x = a2 * data + z2;
			y = data;
		} else {
			y =  (data - z2) / a2;
			x = data;
		}
		System.out.println("交点坐标为（"+x+":"+y+"）");
	}
	
	/**
	 * 算交点（非轴线）
	 * @param a1
	 * @param z1
	 * @param a2
	 * @param z2
	 */
	private static void getIntersection(double a1, double z1, double a2, double z2) {
		double x = 0;
		double y = 0;
		//去掉交点在原点的情况
		if (z1 != z2 ) {
			y = (z2 - z1)/(a1 -a2);
			x = a1 * y + z1;
		}
		System.out.println("交点坐标为（"+x+":"+y+"）");
	}

}
