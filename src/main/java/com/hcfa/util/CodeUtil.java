package com.hcfa.util;

import java.io.UnsupportedEncodingException;

public class CodeUtil {
	public static String getZW(String str) throws UnsupportedEncodingException {
		return new String(str.getBytes("ISO8859-1"),"gbk");
	}
	
	public static String getLM(String str) throws UnsupportedEncodingException {
		return new String(str.getBytes("gbk"),"ISO8859-1");
	}
}
