package com;

import com.entity.testEntity;
import com.util.ObjectSerializeUitls;
import com.util.sy;

public class testss extends sy{

	public static void main(String[] args) {
//		testEntity testEntity = new testEntity("tt");
//		testEntity.start();
//		testEntity testEntity2 = new testEntity("tt2");
//		testEntity2.start();
//		testEntity.setAa("bb");
//		testEntity.start();
//		testEntity2.start();
//		o(testEntity.getAa(),testEntity.getBb());
//		o(testEntity2.getAa(),testEntity2.getBb());
//		String rt = "[{\"Dir\":1,\"Turn\":2},{\"Dir\":2,\"Turn\":2},{\"Dir\":3,\"Turn\":1}]";
//		o(rt);
		byte a ='\0';
		byte b ='\0';

		o(a=='\0');
	}
	
	private void testPutLing2BS() {
		byte a =0x01;
		byte b ='\0';
		byte c =0x02;
		byte[] str = new byte[4];
		byte[] tm = null;
		
		int index = 0;
		
		tm = ObjectSerializeUitls.fromByte(a);
		System.arraycopy(tm, 0, str, index, tm.length);
		index += tm.length;
		
		tm = ObjectSerializeUitls.fromByte(b);
		System.arraycopy(tm, 0, str, index, tm.length);
		index += tm.length;
		
		tm = ObjectSerializeUitls.fromByte(c);
		System.arraycopy(tm, 0, str, index, tm.length);
		index += tm.length;
		
		o(ObjectSerializeUitls.toByte(str, 2, 1));
	}
}
