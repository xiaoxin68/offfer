package com.offer.chapter6;

import java.util.ArrayList;

import org.junit.Test;

/**
 * ��Ϊs��������������
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��27��
 * @Since: 1.0
 */
public class problem57_2 {

	@Test
	public void test() {
		findAllContinuous(15);
		System.out.println(result.size());
	}

	private ArrayList<int[]> result = new ArrayList<int[]>();

	/**
	 * ��Ϊs��������������
	 * 
	 * @param target
	 */
	private void findAllContinuous(int target) {
		if (target <= 2) {
			return;
		}
		int small = 1, big = 2, sum = small + big;
		while (small <= target / 2) {
			if (sum == target) {
				result.add(new int[] { small, big });
			}
			while (small <= target / 2 && sum > target) {// ����ʹ���Ŀ��ֵ�����ϵ����ȥ����Сֵ
				sum -= small;
				small++;
				if (sum == target) {
					result.add(new int[] { small, big });
				}
			}
			// �����С��Ŀ��ֵ�����ϵ�����������ֵ
			big++;
			sum += big;
		}
	}

}
