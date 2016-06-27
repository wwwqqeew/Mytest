package com.email;

public class TestCommon {
	  public TestCommon() {
	  }
	  public static void main(String[] args){
	    SimpleEmail email = new SimpleEmail();
	    email.setHostName("smtp.163.com");//设置使用发电子邮件的邮件服务器
	    try {
	      email.addTo("收件人信箱");
	      email.setAuthentication("发件人信箱","发件人信箱密码");
	      email.setFrom("发件人信箱");
	      email.setSubject("Test apache.commons.mail message");
	      email.setMsg("This is a simple test of commons-email");
	      email.send();
	    }
	    catch (EmailException ex) {
	      ex.printStackTrace();
	    }
	  }
	}