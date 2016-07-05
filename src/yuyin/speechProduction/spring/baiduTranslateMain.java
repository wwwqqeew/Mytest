package yuyin.speechProduction.spring;

import com.util.o;



/**
 * 直接运行main方法即可输出翻译结果
 */
public class baiduTranslateMain {
	
	public static void main(String[] args) throws Exception {
		String source = "测试";
		String result = BaiduTranslateDemo.translateToEn(source);
		if(result == null){
			System.out.println("翻译出错，参考百度错误代码和说明。");
			return;
		}
		System.out.println(source + "：" + result);
	}
	/**
	 * 百度翻译
	 * @param source 字段
	 * @return
	 * @throws Exception
	 */
	public static String Translate(String source) throws Exception {
		String result = BaiduTranslateDemo.translateToEn(source);
		if(result == null){
			System.out.println("翻译出错，参考百度错误代码和说明。");
			return "";
		}
		o.o(source,result,"百度翻译");
		return result;
	}
}
