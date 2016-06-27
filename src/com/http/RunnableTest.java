package com.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.util.sy;

public class RunnableTest {
    public static void main(String[] args) {
         //发送 GET 请求 http://localhost:8090/android/login?username=1&password=12&pid=123
        String ss = "username=1&password=12&pid=123";
        System.out.println((http(" http://127.0.0.1:8090/android/login",ss)));
    }

    public static String http(String url, String ss) {

        URL u = null;

        HttpURLConnection con = null;

        //构建请求参数

        StringBuffer sb = new StringBuffer();

        System.out.println("send_url:"+url);
        System.out.println("send_data:"+ss.toString());

        //尝试发送请求

        try {

        u = new URL(url);

        con = (HttpURLConnection) u.openConnection();

        con.setRequestMethod("POST");

        con.setDoOutput(true);

        con.setDoInput(true);

        con.setUseCaches(false);

        con.setRequestProperty("Content-Type","application/json");

        OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");

        osw.write(ss.toString());

        osw.flush();

        osw.close();
        System.out.println("获取完成");
        } catch (Exception e) {
            System.out.println("出错了");
        e.printStackTrace();

        } finally {

        if (con != null) {

        con.disconnect();

        }

        }

        

        //读取返回内容

        StringBuffer buffer = new StringBuffer();

        try {

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

        String temp;

        while ((temp = br.readLine()) != null) {

        buffer.append(temp);

        buffer.append("\n");

        }

        } catch (Exception e) {

        e.printStackTrace();

        }

        

        return buffer.toString();

        }

    
}