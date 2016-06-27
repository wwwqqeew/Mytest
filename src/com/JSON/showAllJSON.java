package com.JSON;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.HashMap.HMShowAll;

/**
 * 遍历JSON
 * @author Administrator
 *
 */
public class showAllJSON {

	public static int iget0 = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="{\"Success\": \"True\",\"Count\": \"1\",\"District\":   {\"DistrictId\": \"620400\",\"Name\": \"白银市\",\"ShortName\": \"白银\",\"TelAreaCode\": \"0943\", \"Longitude\": \"104.549406\",\"Latitude\": \"36.524105\",\"Area\": \"20103.92\",\"IsCapital\": \"False\", \"FlagId\": \"2\",\"ParentId\": \"620000\", \"ProvinceId\": \"620000\", \"ProvinceName\": \"甘肃省\",\"CityId\": \"620400\", \"CityName\": \"白银市\",\"CountyId\": \"0\",\"CountyName\": \"\"}}";
		getCityId(s,"DistrictId");
	}



	public static String getCityId(String resultRiTu,String name) {
		Map map=new HashMap();
		JsonConfig jc=new JsonConfig();
		jc.setClassMap(map);
		jc.setRootClass(Map.class);
		jc.setArrayMode(JsonConfig.MODE_LIST);
		JSONObject jobj=JSONObject.fromObject(resultRiTu,jc);
		//递归遍历
//		HashMap hm = decodeJSONObject(jobj,name);
		HashMap hm  = new HashMap();
		decodeJSONObject(jobj,name,hm);
		if (hm.get(name) != null || !"".equals(hm.get(name))) {
//			System.out.println("找到了："+hm.get(name));
			return (""+hm.get(name));
		}else{
			iget0++;
			System.out.println("找不到");
			return "0";
		}
	}
	
	
	
	/**
	 * 遍历JSON
	 * @param json
	 */
	public static HashMap decodeJSONObject(JSONObject json,String name,HashMap hm){
		Iterator<String> keys=json.keys();
//		HashMap hm = new HashMap();
		JSONObject jo=null;
		Object o;
		String key;
		while(keys.hasNext()){
			key=keys.next();
			o=json.get(key);
			if(o instanceof JSONObject){
				jo=(JSONObject)o;
				if(jo.keySet().size()>0){
					decodeJSONObject(jo,name,hm);
				}else{
					hm.put(key, ""+o);
//					System.out.println(key+" 22: "+o);
				}
			}else{
				hm.put(key, ""+o);
//				System.out.println(key+" : "+o);
//				if (key.equals(name)) {
//					System.out.println(key+" : "+o);
//				}
			}
		}
//		HMShowAll.showAll(hm);
		return hm;
	}
}
