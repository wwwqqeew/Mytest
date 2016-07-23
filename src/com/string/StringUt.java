package com.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUt {
	public static void main(String[] args) {
	    /**
	     * 声明字符串you
	     */
	    String you = "^&^&^you123$%$%你好";
	    /**
	     * 调用过滤出数字的方法
	     */
	    you = filterNumber(you);
	    /**
	     * 打印结果
	     */
	    System.out.println("过滤出数字：" + you);
	    
	    /**
	     * 声明字符串hai
	     */
	    String hai = "￥%……4556ahihdjsadhj$%$%你好吗wewewe";
	    /**
	     * 调用过滤出字母的方法
	     */
	    hai = filterAlphabet(hai);
	    /**
	     * 打印结果
	     */
	    System.out.println("过滤出字母：" + hai);
	    
	    /**
	     * 声明字符串dong
	     */
	    String dong = "$%$%$张三34584yuojk李四@#￥#%%￥……%&";
	    /**
	     * 调用过滤出中文的方法
	     */
	    dong = filterChinese(dong);
	    /**
	     * 打印结果
	     */
	    System.out.println("过滤出中文：" + dong);
	    
	    /**
	     * 声明字符串str
	     */
	    String str = "$%$%$张三34584yuojk李四@#￥#%%￥……%&";
	    /**
	     * 调用过滤出字母、数字和中文的方法
	     */
	    str = filterNumber(str);
	    /**
	     * 打印结果
	     */
	    System.out.println("过滤出字母、数字和中文：" + str);
	}

	/**
	   * 
	   * @Title : filterNumber
	   * @Type : FilterStr
	   * @date : 2014年3月12日 下午7:23:03
	   * @Description : 过滤出数字
	   * @param str
	   * @return
	   */
	  public static String filterNumber(String number)
	  {
	    number = number.replaceAll("[^(0-9)]", "");
	    return number;
	  }
	  
	  /**
	   * 
	   * @Title : filterAlphabet
	   * @Type : FilterStr
	   * @date : 2014年3月12日 下午7:28:54
	   * @Description : 过滤出字母
	   * @param alph
	   * @return
	   */
	  public static String filterAlphabet(String alph)
	  {
	    alph = alph.replaceAll("[^(A-Za-z)]", "");
	    return alph;
	  }
	  
	  /**
	   * 
	   * @Title : filterChinese
	   * @Type : FilterStr
	   * @date : 2014年3月12日 下午9:12:37
	   * @Description : 过滤出中文
	   * @param chin
	   * @return
	   */
	  public static String filterChinese(String chin)
	  {
	    chin = chin.replaceAll("[^(\\u4e00-\\u9fa5)]", "");
	    return chin;
	  }
	  
	  /**
	   * 
	   * @Title : filter
	   * @Type : FilterStr
	   * @date : 2014年3月12日 下午9:17:22
	   * @Description : 过滤出字母、数字和中文
	   * @param character
	   * @return
	   */
	  public static String filter(String character)
	  {
	    character = character.replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", "");
	    return character;
	  }
	  

	/**
	 * 判断是否包含中文
	 * @param str
	 * @return
	 */
   public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
	
	/**
	 * 为null或为空
	 * @param name
	 * @return
	 */
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
