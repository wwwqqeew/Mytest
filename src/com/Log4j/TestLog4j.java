package com.Log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.util.o;

public class TestLog4j {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("log4j.properties");
//        Logger logger  =  Logger.getLogger(TestLog4j. class );
        Logger logger  =  Logger.getLogger("ss");
        logger.debug( " debug " );
//        logger.error( " error " );
//        logger.warn( " warn " );
        try {
        	String ss = null;
        	ss.equals("ssss");
        	 o.o("完成 ");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error( " error2 " );
			System.out.println("错误");
		}
        o.o("结束 ");
	}

}
