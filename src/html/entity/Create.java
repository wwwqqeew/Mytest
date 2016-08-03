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
	
	public String toHtml(String fDiv,HashMap<Integer,Integer> hs) {
		 StringBuffer sb = new StringBuffer();
		 String newName = ""+getName();
		 int cs = 0;
		 String add = "  ";
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
		 sb.append(addAll+"</div>\n");
		return sb.toString();
	}
}
