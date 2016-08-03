package html.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Create {
	public Create(){
		list = new ArrayList<Create>();
	}
	public Integer name;
	public List<Create> list;
	public Integer getName() {
		return name;
	}
	public void setName(Integer name) {
		this.name = name;
	}
	public List<Create> getList() {
		return list;
	}
	public void setList(List<Create> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Create [name=" + name + ", list=" + list + "]";
	}
	//获取单个的样式
	private String getCssOne(String name) {
		 StringBuffer sb = new StringBuffer();
		 sb.append("."+name+"-div {");
		 sb.append("  bottom: 0px;");
		 sb.append("  left: 0px;");
		 sb.append("  right: 0px;");
		 sb.append("  top: 0px;");
		 sb.append("  position: absolute;");
		 sb.append("  height: 15px;");
		 sb.append("}\n");
		 
		 sb.append("."+name+"-layout {");
		 sb.append("  background-color: white;");
		 sb.append("  width: 100%;");
		 sb.append("  height: 100%;");
		 sb.append("  position: relative;");
		 sb.append("}\n");
		return sb.toString();
	}
	
	//获取样式代码
	public String toCss(String fDiv,HashMap<Integer,Integer> hs) {
		 StringBuffer sb = new StringBuffer();
		 String newName = ""+getName();
		 int cs = 0;//记录前边要加的空格
		 String add = "";
		 String addAll = "";
		 if (fDiv != null && !"".equals(fDiv)) {
			 newName = fDiv + "-" +newName;
		}
		 cs = newName.split("-").length;
		 for (int i = 0; i < cs; i++) {
			 addAll += add;
		}
		
		 if (hs == null) {
			 hs = new HashMap<Integer,Integer>();
		}
		 if (hs.get(getName()) != null) {
			 newName += hs.get(getName());
			 hs.put(getName(), hs.get(getName())+1);
		}else{
			 hs.put(getName(), 0);
		}
		 sb.append(getCssOne(newName));
		 for (int i = 0; i < getList().size(); i++) {
			 sb.append(getList().get(i).toCss(newName,hs));
		}
//		 //如果内部没有list，则不加空格
//		 if (getList().size() == 0) {
//			 addAll = "";
//		}
//		 sb.append(addAll+"</div>\n");
		return sb.toString();
	}
	
	//获取html代码
	public String toHtml(String fDiv,HashMap<Integer,Integer> hs) {
		 StringBuffer sb = new StringBuffer();
		 String newName = ""+getName();
		 int cs = 0;//记录前边要加的空格
		 String add = "	";
		 String addAll = "";
		 if (fDiv != null && !"".equals(fDiv)) {
			 newName = fDiv + "-" +newName;
		}
		 cs = newName.split("-").length;
		 for (int i = 0; i < cs; i++) {
			 addAll += add;
		}
		
		 if (hs == null) {
			 hs = new HashMap<Integer,Integer>();
		}
		 if (hs.get(getName()) != null) {
			 newName += hs.get(getName());
			 hs.put(getName(), hs.get(getName())+1);
		}else{
			 hs.put(getName(), 0);
		}
		 sb.append("\n"+addAll+"<div class='"+newName+"-div'>");
		 for (int i = 0; i < getList().size(); i++) {
			 sb.append(getList().get(i).toHtml(newName,hs));
		}
		 //如果内部没有list，则不加空格
		 if (getList().size() == 0) {
			 addAll = "";
		}
		 sb.append(addAll+"</div>\n");
		return sb.toString();
	}
}
