package com.other;

import java.nio.ByteOrder;

public class IsBIG_ENDIAN {
	public static void main(String[] args) {
	    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
	      System.out.println("BIG_ENDIAN");
	    } else {
	      System.out.println("LITTLE_ENDIAN");
	    }
	  }
}
