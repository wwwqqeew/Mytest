package com.PropertiesAndXml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.util.o;

public class testMain {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InvalidPropertiesFormatException 
	 */
	public static void main(String[] args) throws InvalidPropertiesFormatException, IOException{
		// TODO Auto-generated method stub
//		System.out.println("00:"+getAllScenicSpot("d://scenic.xml"));
//		 FileInputStream fis = new FileInputStream("d:/application.properties");
		 File pFile = new File("d:/application.properties");
		 Properties prop = new Properties();
		 FileInputStream   pInStream = new FileInputStream(pFile );
		prop.load(pInStream);
		o.o(prop.getProperty("mapRoot"),prop.getProperty("leaveDistance"));
	}

}
