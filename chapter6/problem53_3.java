package com.offer.chapter6;

import org.junit.Test;

/**
 * 数组中数值和下标相等的元素
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月24日
 * @Since: 1.0
 */
public class problem53_3 {

	@Test
	public void test() {
		int arr[] = { -3, -1, 1, 3, 5 };
		System.out.println(getIndexEqualNum(arr, 0, arr.length - 1));
	}

	public int getIndexEqualNum(int arr[], int left, int right) {
		if (arr == null || arr.length < 1) {
			return -1;
		}
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid == arr[mid]) {
				return mid;
			} else if (arr[mid] > mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
