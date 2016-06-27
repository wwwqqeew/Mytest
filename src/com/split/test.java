package com.split;

import java.util.ArrayList;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st = "aredId=34&provinecId=440000&cityId=440100";
		String[] list = list = st.split("&");
		for (String string : list) {
			System.out.println(string);
		}
	}

}
