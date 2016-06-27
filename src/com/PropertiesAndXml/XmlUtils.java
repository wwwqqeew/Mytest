package com.PropertiesAndXml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlUtils {

	/**
	 * 获取景区的相关信息
	 * 
	 * @param xmlFilePath
	 *            配置文件路径
	 * @param attrName
	 *            景区相关属性并非景点
	 * @return 返回要景区属性内容
	 */

	public static String getScenicInformation(String xmlFilePath,
			String attrName) {
		File xmlFile = new File(xmlFilePath);
		FileInputStream xmlFileInputStream = null;
		try {
			xmlFileInputStream = new FileInputStream(xmlFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		String scenicName = "";
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFileInputStream);
			;
			Element root = doc.getDocumentElement();
			scenicName = root.getAttribute(attrName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scenicName;
	}

	/**
	 * 获取景区中所有景点的名称
	 * 
	 * @param xmlFilePath
	 *            配置文件路径
	 * @return 景区所有景点的集合.
	 */
	public static ArrayList<String> getAllScenicSpot(String xmlFilePath) {
		ArrayList<String> scenicSpotArrayList = new ArrayList<String>();
		File xmlFile = new File(xmlFilePath);
		FileInputStream xmlFileInputStream = null;
		try {
			xmlFileInputStream = new FileInputStream(xmlFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFileInputStream);
			NodeList scenicSpotList = doc.getElementsByTagName("senic-spot");
			for (int i = 0; i < scenicSpotList.getLength(); i++) {
				Element scenicSpotElement = (Element) scenicSpotList.item(i);
				scenicSpotArrayList.add(scenicSpotElement.getAttribute("name"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scenicSpotArrayList;
	}

	/**
	 * 获取景区中所有景点的名称
	 * 
	 * @param xmlFilePath
	 *            配置文件路径
	 * @param bluetoothNumber
	 *            蓝牙设备编号
	 * @return 蓝牙设备对应的景点的集合
	 */
	public static List<String> getBluetoothScenicSpot(String xmlFilePath,
			int bluetoothNumber) {
		List<String> scenicSpotArrayList = new ArrayList<String>();
		File xmlFile = new File(xmlFilePath);
		FileInputStream xmlFileInputStream = null;
		try {
			xmlFileInputStream = new FileInputStream(xmlFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFileInputStream);
			NodeList bluetoothList = doc.getElementsByTagName("senic-spot");
			for (int i = 0; i < bluetoothList.getLength(); i++) {
				Element scenicSpotElement = (Element) bluetoothList.item(i);
				if (String.valueOf(bluetoothNumber).equals(
						scenicSpotElement.getAttribute("bluetooth"))) {
					scenicSpotArrayList.add(scenicSpotElement
							.getAttribute("name"));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scenicSpotArrayList;
	}
	
	
	/**
	 * 根据景点名称获取经纬度
	 * @param xmlFilePath xml配置文件路径
	 * @param scenicSpotName 景点名称
	 * @return 返回经纬度字符串（格式：113.255420,22.835982）
	 */
	public static String getLngAndLatByScenicSotName(String xmlFilePath,String scenicSpotName)
	{
		String lngAndLatStr="";
		File xmlFile = new File(xmlFilePath);
		FileInputStream xmlFileInputStream = null;
		try {
			xmlFileInputStream = new FileInputStream(xmlFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFileInputStream);
			NodeList scenicSpotList = doc.getElementsByTagName("senic-spot");
			Element scenicSpotElement;
			for (int i = 0; i < scenicSpotList.getLength(); i++) {
				scenicSpotElement = (Element) scenicSpotList.item(i);
				if(scenicSpotElement.getAttribute("name").equals(scenicSpotName))
				{
					if(scenicSpotElement.getAttribute("longitude")!=""&&scenicSpotElement.getAttribute("latitude")!="")
					{
					lngAndLatStr=scenicSpotElement.getAttribute("longitude")+","+scenicSpotElement.getAttribute("latitude");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lngAndLatStr;
	}
}
