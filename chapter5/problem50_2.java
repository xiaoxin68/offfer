package com.offer.chapter5;

/**
 * 字符流中第一个只出现一次的字符
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月26日
 * @Since: 1.0
 */
public class problem50_2 {

	int[] hashtable = new int[256];
	StringBuffer s = new StringBuffer();

	public void Insert(char ch) {
		s.append(ch);
		hashtable[ch]++;
	}

	public char FirstAppearingOnce() {
		char[] str = s.toString().toCharArray();
		for (char c : str) {
			if (hashtable[c] == 1)
				return c;
		}
		return '#';
	}
}
