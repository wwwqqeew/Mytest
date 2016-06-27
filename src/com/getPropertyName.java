package com;

import java.lang.reflect.Field;

public class getPropertyName {

	int i = 10;

	public static void main(String args[]) throws ClassNotFoundException {

		Class<? extends Object> c = new getPropertyName().getClass();

		Field[] fieldList = c.getDeclaredFields();

		for (Field f : fieldList)

			System.out.println(f.getName() + ": " + f.getType());

	}

}