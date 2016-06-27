package com.line;

public class intersection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//getAAndZ(1, 0, 2, 0);
		Point point1 = new Point(1,0,2,2);
		Point point2 = new Point(0,2,4,2);
		point1.getIntersection(point2);
//		getIntersection(point1.getA(), point1.getZ(), point2.getA(), point2.getZ());
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

}
