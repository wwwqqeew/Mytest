package com.JSON;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		toArray();
	}

	private static void toArray() {
		String aa = " [{ \"latitude\": \"118.37656236145294\", \"longitue\": \"31.394199227047512\" }, { \"latitude\": \"118.37495361030483\", \"longitue\": \"31.39438129642844\" }, { \"latitude\": \"118.37474137143957\", \"longitue\": \"31.394393032383807\" } ] ";
		List<Point> list = new ArrayList<Point>();
		list = getList4Json(aa,Point.class);
		System.out.println(list.size());
	}

	class Points{

		
	}
    
    /**     
     * 从json对象集合表达式中得到一个java对象列表     
     *      
     * @param jsonString     
     * @param pojoClass     
     * @return     
     */       
    public static List getList4Json(String jsonString, Class pojoClass) {        
       System.out.println("11");
        JSONArray jsonArray = JSONArray.fromObject(jsonString);        
        JSONObject jsonObject;        
        Object pojoValue;        
        System.out.println("22");
        List list = new ArrayList();        
        for (int i = 0; i < jsonArray.size(); i++) {        
            jsonObject = jsonArray.getJSONObject(i);        
            pojoValue = JSONObject.toBean(jsonObject, pojoClass);  
            System.out.println(pojoValue);
            list.add(pojoValue);        
        }        
        return list;        
       
    }  
}
