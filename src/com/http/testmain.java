package com.http;

public class testmain {

	public static void main(String[] args) {
        //发送 GET 请求http://120.132.55.5/android/login?username=admin&password=admin&pid=0000000000000000000
        String s=HttpRequest.sendGet("http://hsjadmin.365ditu.com/clientController/carstewardupdateclient", "userName=张三&sex=1&province=广东&city=广州&phone=13825678954&carBrand=丰田&carNumber=粤A98989&IMEI=12345678945612&callback="+(int)(Math.random()*10000));
        System.out.println(s);
        
        //发送 POST 请求
//        String sr=HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
//        System.out.println(sr);
    }

}
