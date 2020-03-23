package com.offer.chapter5;

import org.junit.Test;

/**
 * 数组中出现次数超过一半的数字
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月24日
 * @Since: 1.0
 */
public class problem39 {
	
	@Test
	public void test() {
		int arr[] = {1,2,3,2,2,2,5,4,2};
		System.out.println(moreThanHalfNum(arr, arr.length));
	}
	

	// 全局变量判断数组是否无效
	boolean arrayInvalid = false;

	/**
	 * 判断输入数组是否有效
	 * 
	 * @param array
	 * @param length
	 * @return
	 */
	boolean CheckInvalidArray(int[] array, int length){
		arrayInvalid = false;
		if(array == null && length <= 0){
			arrayInvalid = true;
		}
		return arrayInvalid;
	}

	/**
	 * 判断输入数组中出现次数最多的数是否超过数组长度的一般
	 * 
	 * @param array
	 * @param length
	 * @param number
	 * @return
	 */
	boolean CheckMoreThanHalf(int[] array, int length, int number){
		int times = 0;
		for (int i = 0; i < length; i++) {
			if(array[i] == number){
				times++;
			}
		}
		boolean isMoreThanHalf = true;
		if(times * 2 <= length){
			arrayInvalid = true;
			isMoreThanHalf = false;
		}
		return isMoreThanHalf;
	}

	/**
	 * 找到出现次数超过一半的数
	 * 
	 * @param array
	 * @param length
	 * @return
	 */
	int moreThanHalfNum(int []array,int length) {
		if (CheckInvalidArray(array, length)) {
			return 0;
		}
		int result = array[0];
		int times = 1;
		if (length > 1) {
			for (int i = 1; i < length; i++) {
				if (times == 0) {
					result = array[i];
				}
				else if (result == array[i]) {
					times++;
				}else {
					times--;
				}
			}
		}
		if (!CheckMoreThanHalf(array, length, result)) {
			result = 0;
		}
		return result;
	}
}
