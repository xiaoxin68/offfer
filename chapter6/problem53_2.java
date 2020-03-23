package com.offer.chapter6;

import org.junit.Test;

/**
 * 0~n-1中·缺失的数字
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月24日
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
	 * 方式一：利用理论上0-n的和减去实际数组里面的值，结果就是了
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
