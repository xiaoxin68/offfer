package com.offer.chapter6;

import org.junit.Test;

/**
 * 左旋转字符串
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月27日
 * @Since: 1.0
 */
public class problem58_2 {
	
	@Test
	public void test() {
		String str = "12345";
		int k = 5;
		System.out.println(leftRotateString(str, k));
	}

	public String leftRotateString(String str,int k) {
		if (str == null || "".equals(str) || k>str.length() || k<0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(str.substring(k, str.length()));
		sb.append(str.substring(0, k));
		return sb.toString();
	}
}
