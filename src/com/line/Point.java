package com.line;

/**
 * 一个在坐标系里的点
 * @author Administrator
 *
 */
public class Point {
	
	public Point(double x1, double y1, double x2, double y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		//判断是否为x或者y轴的平行线
		if (x1 == x2) {
			this.isX = x1;
			this.isXorY = 1;
		}else if(y1 == y2){
			this.isY = y1;
			this.isXorY = 2;
		}else{
			
		}
		
		//获取线的公式
		if ( this.isXorY == 0) {
			this.a = (x1 - x2)/(y1 - y2); //求 a
			this.z = x1 - a*y1;
		}
	};
	
	/**
	 * 判断线段交点
	 * @param point
	 */
	public int getIntersection(Point point) {
		double x = 0;
		double y = 0;
		int rt = 0;
		
		//判断是否有和轴线平行的线
		if (point.getIsXorY() != 0 ) {
			if (this.getIsXorY() != 0) {
				//是否都是平行线
				if (point.getIsXorY() == this.getIsXorY()) {
					System.out.println("平行线");
					return 0;
				} else {
					//是否
					//否：
					if (this.getIsXorY() == 1) {
						x = point.getIsY();
						y = this.getIsX();
					} else {
						x = this.getIsY();
						y = point.getIsX();
					}
					System.out.println("(两条为轴平行线)交点坐标为（"+x+":"+y+"）");
					return 1;
				}
			} else {
				//判断X平行或者Y平行
				if (point.getIsXorY() == 1) {
					y = point.isX;
					x = y*this.getA() + this.getZ();
				} else if(point.getIsXorY() == 2){
					x = point.isY;
					y = (x - this.getZ()) / this.getA();
				}else{
					
				}
				System.out.println("(一条为轴平行线)交点坐标为（"+x+":"+y+"）");
			}
		}else{
			//去掉交点在原点的情况
			if (this.z != point.getZ() ) {
				y = (point.getZ() - this.z)/(this.a -point.getA());
				x = this.a * y + z;
				System.out.println("交点坐标为（"+x+":"+y+"）");
			}else{
				System.out.println("交点坐标为（0:0）");
			}
		}
		
		return rt;
	}
	
	private double x1 = 0; //第一个点x
	private double y1 = 0; //第一个点y

	private double x2 = 0; //第二个点x
	private double y2 = 0; //第二个点y

	private double a = 0; //x = a*y + z
	private double z = 0; //x = a*y + z
	
	private int isXorY = 0; //是否为平行 x 和 y 的线？ 0:非， 1：X平行， 2：Y平行
	private double isX ; //为平行X时候的Y值
	private double isY ; //为平行y时候的X值

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public int getIsXorY() {
		return isXorY;
	}

	public void setIsXorY(int isXorY) {
		this.isXorY = isXorY;
	}

	public double getIsX() {
		return isX;
	}

	public void setIsX(double isX) {
		this.isX = isX;
	}

	public double getIsY() {
		return isY;
	}

	public void setIsY(double isY) {
		this.isY = isY;
	}

}
