package com.util;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;


public class Xml2Json {
	  public JSON getJSONFromXml(String xmlString)
	  {
	    XMLSerializer xmlSerializer = new XMLSerializer();
	    xmlSerializer.setTypeHintsEnabled(false);
	    JSON json = xmlSerializer.read(xmlString);
	    return json;
	  }

	  public String toJson(String xmlString) {
	    return getJSONFromXml(xmlString).toString(2);
	  }
	 
}
