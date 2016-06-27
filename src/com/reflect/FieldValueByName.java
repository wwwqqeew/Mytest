package com.reflect;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.util.o;
import com.util.sy;

public class FieldValueByName {

	public String name;
	public int age;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FieldValueByName fb = new FieldValueByName();
		fb.setAge(10);
		fb.setName("CGY");
		HashMap<String,Method> hmp = new HashMap<String,Method>();
		sy.o(getFieldValueByName("name", fb ,hmp));
		try {
			o.o(((Method) hmp.get("name")));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


	/**
	 * 根据属性名称和类获取属性值，且把方法放到HashMap中
	 * @param fieldName 属性名称
	 * @param o 类
	 * @param hmp 存放方法的HashMap
	 * @return 返回
	 */
	public static Object getFieldValueByName(String fieldName, Object o,HashMap hmp) {
		try {
			Method method = null;
			//检查HashMap中是否已经有了参数
			if (hmp.get(fieldName) == null) {
				String firstLetter = fieldName.substring(0, 1).toUpperCase();
				String getter = "get" + firstLetter + fieldName.substring(1);
				method = o.getClass().getMethod(getter, new Class[] {});
				hmp.put(fieldName, method);
			}else{
				method = (Method) hmp.get(fieldName);
			}
			//日期类型的转换与其他类型的判断
			if (new Date().getClass() ==  method.getGenericReturnType()) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				return df.format(method.invoke(o, new Object[] {}));
			} else {
				return method.invoke(o, new Object[] {}) + "";
			}
		} catch (Exception e) {
			e.getMessage();
			return "getFieldValueByName出现异常";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
