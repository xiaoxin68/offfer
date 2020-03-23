package com.offer.chapter6;

import org.junit.Test;

/**
 * 0~n-1�С�ȱʧ������
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��24��
 * @Since: 1.0
 */
public class problem53_2 {
	@Test
	public void test() {
		int num[] = {0,1,2,3,5,6,7,8};
		System.out.println(blankNum(num));
		System.out.println(blankNum2(num));
	}
	
	/**
	 * ��ʽһ������������0-n�ĺͼ�ȥʵ�����������ֵ�����������
	 * 
	 * @param num
	 * @return
	 */
	public int blankNum(int []num) {
		if (num == null ||num.length<1) {
			return -1;
		}
		int theroySum = num.length*(num.length+1)/2;
		int realSum = 0;
		for (int i = 0; i < num.length; i++) {
			realSum+=num[i];
		}
		return theroySum-realSum;
	}
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public int blankNum2(int []num) {
		if (num == null ||num.length<1) {
			return -1;
		}
		for (int i = 0; i < num.length; i++) {
			if (i!=num[i]) {
				return i;
			}
		}
		return num.length;
	}
}
