package com.offer.chapter6;

import org.junit.Test;

/**
 * ���������ֳ��ֵĴ���
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��27��
 * @Since: 1.0
 */
public class problem56 {

	@Test
	public void test() {
		int num[] = { 2, 4, 3, 6, 3, 2, 5, 5 };
		int[] result = FindNumAppearOnce(num);
		if (result != null) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
		}
	}

	public int[] FindNumAppearOnce(int[] num) {
		// �����������������
		int yihuo = yihuo(num);
		if (yihuo == 0) {
			return null;
		}
		// �ҵ������е�һ��1���ֵ�λ��(������������index��0��ʼ)
		int firstOncePosition = getFirstOncePosition(yihuo);

		int[] result = firstTwoSingleNums(num, firstOncePosition);

		return result;
	}

	/**
	 * �����������������
	 * 
	 * @param num
	 * @return
	 */
	public int yihuo(int[] num) {
		if (num == null || num.length <= 1) {
			return -1;
		}
		int result = num[0];
		for (int i = 1; i < num.length; i++) {
			result = result ^ num[i];
		}
		return result;
	}

	/**
	 * �ҵ������е�һ��1���ֵ�λ��(������������index��0��ʼ)
	 * 
	 * @return
	 */
	public int getFirstOncePosition(int num) {
		int result = -1;
		if (num == 0)
			return result;
		int index = 0;
		while ((num & (int) Math.pow(2, index)) == 0) {
			index++;
		}
		return index;
	}

	/**
	 * ������ֳ������֣�������ÿһ���ֵ�Ψһһ������
	 * 
	 * @param num
	 * @param firstOncePosition
	 * @return
	 */
	private int[] firstTwoSingleNums(int[] num, int index) {
		if (index == -1) {
			return null;
		}
		int result1 = 0, result2 = 0;
		for (int i = 0; i < num.length; i++) {
			if ((num[i] & (int) Math.pow(2, index)) == 0) {
				result1 = result1 ^ num[i];
			} else {
				result2 = result2 ^ num[i];
			}
		}
		if (result1 == 0 || result2 == 0) {
			return null;
		}
		return new int[] { result1, result2 };
	}
}
