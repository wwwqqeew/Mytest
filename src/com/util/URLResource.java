package com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServlet;


public class URLResource extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7703699081521852884L;

	public URLResource() {
		super();
	}

	public String getURLResource(String url) throws Exception {
				URL localURL = new URL(url);
				URLConnection connection = localURL.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
			
				InputStream inputStream = null;
				InputStreamReader inputStreamReader = null;
				BufferedReader reader = null;
				StringBuffer resultBuffer = new StringBuffer();
				String tempLine = null;
				try {
					inputStream = httpURLConnection.getInputStream();
					inputStreamReader = new InputStreamReader(inputStream, "utf-8");
					reader = new BufferedReader(inputStreamReader);
			
					while ((tempLine = reader.readLine()) != null) {
						resultBuffer.append(tempLine);
					}
				} finally {
					if (reader != null) {
						reader.close();
					}
					if (inputStreamReader != null) {
						inputStreamReader.close();
					}
					if (inputStream != null) {
						inputStream.close();
					}
				}
				return resultBuffer.toString();
			}

}