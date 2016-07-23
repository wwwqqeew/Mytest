package com.file;

import java.io.File;

import com.util.o;

public class readFileInFile {
	public static void main(String[] args) {
		 File  file = new File("logs").getAbsoluteFile();
		 //读取当前工程目前下的文件
		 File[] subFiles = file.listFiles();
			for(int i = 0; i < subFiles.length; i++) {
				o.o(subFiles[i]);
			}
	}
}
