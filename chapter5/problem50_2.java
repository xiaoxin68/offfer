package com.offer.chapter5;

/**
 * �ַ����е�һ��ֻ����һ�ε��ַ�
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��26��
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
