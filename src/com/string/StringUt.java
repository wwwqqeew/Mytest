package com.string;

public class StringUt {
	public static void main(String[] args) {

	}
	
	 public static boolean isNotNullOrEmpty(String name){
		return  name != null && !"".equals(name);
	 }
	 
	
	/**
	 * 首字母大小写想换转化
	 * @param name
	 * @param isTurnMax (是否是转为大写)
	 * @return
	 */
    public static String firstNameMax(String name, boolean isTurnMax) {
        char[] cs=name.toCharArray();
//        o.o((int) cs[0],isTurnMax);
        if (isCapital(cs[0])) {//大写
        	if (isTurnMax) {
        		return name;
			} else {
				cs[0] += 32;
				return String.valueOf(cs);
			}
		} else if(isLowercase(cs[0])) {//小写
			if (isTurnMax) {
				cs[0] -= 32;
				return String.valueOf(cs);
			} else {
				return name;
			}
		} else{
			System.out.println("字符串：["+name+"]非字母开头");
			return name;
		}
      
    }
    
    /**
     * 检测字母是否大写
     * @param car
     * @return
     */
    public static boolean isCapital( char cs) {
		return 65 <= ((int) cs) && ((int) cs) <= 90;
	}
    
    /**
     * 检测字母是否小
     * @param car
     * @return
     */
    public static boolean isLowercase( char cs) {
		return 97 <= ((int) cs) && ((int) cs) <= 122;
	}
    
}
