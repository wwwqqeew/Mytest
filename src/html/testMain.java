package html;

import java.util.ArrayList;
import java.util.List;

import com.util.o;

import html.entity.Create;

public class testMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String order = "122344344";
		Create create = new Create();
		List <Create> list = new ArrayList<Create>();
		String [] orders = order.split("");
		List <Integer> listInt = new ArrayList<Integer>();
		//数字转换
		for (int a = 0; a < orders.length; a++) {
			if (orders[a] != null && !"".equals(orders[a])) {
				listInt.add(Integer.valueOf(orders[a]));
			}
		}
		o.o(listInt);
		//创建相应list
		for (int i = 0; i < listInt.size(); i++) {
			if (i == 0) {
				create.setName(listInt.get(i));
				list.add(create);
			} else {
				//查找上一级
				for (int j = list.size(); j > 0; j--) {
					if (list.get(j-1).getName() + 1 == listInt.get(i)) {
						Create create1 = new Create();
						create1.setName(listInt.get(i));
						list.get(j-1).getList().add(create1);
						list.add(create1);
						break;
					}
				}
			}
		}
		
		o.o(list.get(0).toHtml("",null));
		o.o(list.get(0).toCss("",null));
	}
	

}
