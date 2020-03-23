package com.offer.chapter5;

import org.junit.Test;

/**
 * ���������������
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��24��
 * @Since: 1.0
 */
public class problem42 {
	@Test
	public void test() {
		int arr[] = {1,-2,3,10,-4,7,2,-5};
		System.out.println(maxSunArray(arr));
	}
	
	public int maxSunArray(int []num) {
		if (num == null || num.length<1) {
			throw new RuntimeException("�������ݲ��Ϸ�");
		}
		if (num.length == 1) {
			return num[0];
		}
		int max[] = new int[num.length];
		max[0] = num[0];
		for (int i = 1; i < max.length; i++) {
			if (max[i-1] <= 0) {
				max[i] = num[i];
			}else {
				max[i] = max[i-1] + num[i];
			}
		}
		int result = max[0];
		for (int i = 0; i < max.length; i++) {
			result = result>max[i] ? result:max[i];
		}
		return result;
	}
}
