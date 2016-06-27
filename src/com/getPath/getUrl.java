package com.getPath;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.util.o;
import com.util.sy;

public class getUrl {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws URISyntaxException, IOException {
		// TODO Auto-generated method stub
		testURLGet();
	}

	private  static void testURLGet() throws URISyntaxException, IOException {
		// TODO Auto-generated method stub
		URL url = getUrl.class.getResource("/port.properties");
		o.o(url);
		System.out.println("222:"+url.toURI());
        File file = new File(url.toURI());
        FileWriter writer = new FileWriter(file, true);
	}
}
