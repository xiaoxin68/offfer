package com.offer.chapter5;

import org.junit.Test;

/**
 * �����ַ�����ַ���
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��26��
 * @Since: 1.0
 */
public class problem46 {
	@Test
	public void test() {
		System.out.println(transNumIntoString("12258"));
	}
	
	public int transNumIntoString(String str) {
		int len = str.length();
		if (len <= 0) {
			return 0;
		}
		if (len == 1) {
			return 1;
		}
		if(len == 2) {
			return 1+inArea(str,0,1);
		}
	
		int []result = new int [len];
		result[len-1] = 1;
		result[len-2] = 1+inArea(str,len-2,len-1);
		for (int j = len-3; j >= 0; j--) {
			result[j] = result[j+1] + inArea(str, j, j+1)*result[j+2];
		}
		return result[0];
	}

	private int inArea(String str,int i,int j) {
		String temp = String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(j));
		//�ַ������ֵ�˳��<�ַ����������򷵻�һ��С�� 0 ��ֵ
		if ("0".compareTo(temp) <= 0 && "25".compareTo(temp)>=0) {
			return 1;
		}
		return 0;
	}
}
