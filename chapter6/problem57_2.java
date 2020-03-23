package com.offer.chapter6;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 和为s的连续正数序列
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月27日
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
	 * 和为s的连续正数序列
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
			while (small <= target / 2 && sum > target) {// 如果和大于目标值，则从系列中去掉最小值
				sum -= small;
				small++;
				if (sum == target) {
					result.add(new int[] { small, big });
				}
			}
			// 如果和小于目标值，则从系列中增加最大值
			big++;
			sum += big;
		}
	}

}
