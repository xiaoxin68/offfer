package com.offer.chapter6;

import org.junit.Test;

/**
 * 和为s的两个数字
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月27日
 * @Since: 1.0
 */
public class problem57 {
	
	@Test
	public void tese() {
		int []nums = {1,2,4,7,10,11,15};
		int[] is = getSumEqlTarget(nums, 14);
		if (is!=null) {
			System.out.println(is[0] + " " + is[1]);
		}else {
			System.out.println("不存在");
		}
	}
	
	/**
	 * 和为s的两个数
	 * 
	 * @param num
	 * @param target
	 * @return
	 */
	public int[] getSumEqlTarget(int[]num,int target) {
		if (num == null || num.length<1 || target<num[0]) {
			return null;
		}
		int p1 = 0,p2 = num.length-1;
		while (p1<p2) {
			int temp = num[p1]+num[p2];
			if (temp == target) {
				return new int[] {num[p1],num[p2]};
			}else if(temp > target) {
				p2--;
			}else {
				p1++;
			}
		}
		return null;
	}
}
