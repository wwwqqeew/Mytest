package com.xml;

import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
 
 
public class XMLPaser {
    public static void main(String[] args) {
        paserXML();
    }
     
    public static void paserXML(){
        SAXReader reader = new SAXReader();
        try {
            // ¶ÁÈ¡XMLÎÄ¼þ
            Document doc = reader.read("http://api.map.baidu.com/geocoder/v2/?ak=QNhWGopfB1Gs8u2WNBTe8fDy&callback=renderReverse&location=25.90747,119.36470&output=xml&pois=1");
            Element root = doc.getRootElement();
            System.out.println(root.getName());
            List<Element> param = root.elements();
            for (Element element : param) {
//                if(element.attributeValue("name").equals("a")){
                    System.out.println(element.getText());
//                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
