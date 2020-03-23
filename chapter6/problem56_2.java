package com.offer.chapter6;

import org.junit.Test;

/** 
 * 在数组中唯一只出现一次的数字 
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月27日
 * @Since: 1.0
 */
public class problem56_2 {
	
	@Test
	public void test() {
		int []nums = {3,3,5,7,6,5,7,7,5,3};
		System.out.println(findNumberAppearing(nums));
	}
	
	public int findNumberAppearing(int[]nums) {
		if (nums == null  || nums.length<=0) {
			throw new RuntimeException("Invalid Input");
		}
		int bitSum[] = new int[32];
		for (int i = 0; i < nums.length; i++) {
			int bitMask = 1;
			for (int j = 31; j >= 0; j--) {
				int bit = nums[i] & bitMask;
				if (bit!=0) {
					bitSum[j] += 1;
				}
				bitMask = bitMask<<1;
			}
			
		}
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = result<<1;
			result+=bitSum[i]%3;
		}
		return result;
	}
}
