package com.offer.chapter5;

import org.junit.Test;

/**
 * 数组中出现次数超过一半的数字(基于快排的思想）
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月24日
 * @Since: 1.0
 */
public class problem39_2 {
	@Test
	public void test() {
		int arr[] = {1,2,3,2,2,2,5,4,2};
		System.out.println(getMoreThanHalf(arr));
	}

	/**
	 * 判断输入数组中出现次数最多的数是否超过数组长度的一般
	 * 
	 * @param array
	 * @param length
	 * @param number
	 * @return
	 */
	boolean CheckMoreThanHalf(int[] array,int number) {
		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				times++;
			}
		}
		boolean isMoreThanHalf = true;
		if (times * 2 <= array.length) {
			isMoreThanHalf = false;
		}
		return isMoreThanHalf;
	}

	/**
	 * 获取数组中出现次数超过一半的数
	 * 
	 * @param arr
	 * @return
	 */
	public int getMoreThanHalf(int arr[]) {
		if (arr == null || arr.length<1) {
			return 0;
		}
		int result = quickSort(arr,0,arr.length-1);
		if (!CheckMoreThanHalf(arr, result)) {
			result = 0;
		}
		return result;
	}
	
	/**
	 * 快排
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	private int quickSort(int[] arr, int l, int r) {
		int mid = arr.length>>1;
		int result = 0;
		if (l < r) {
			swap(arr, l + (int) Math.random()*(r-l+1), r);
			int p[] = partition(arr, l, r);
			if (mid >= p[0] && mid<= p[1]) {
				result = arr[p[0]];
			}else if(mid < p[0]) {
				result = quickSort(arr,l,p[0]-1);
			}else {//即mid > p[1]
				result = quickSort(arr,p[1]+1,r);
			}
		}
		return result;
	}

	private int[] partition(int[] arr, int l, int r) {
		int less = l-1;
		int more = r;
		while (l < more) {
			if (arr[l]<arr[r]) {
				swap(arr,++less,l++);
			}else if (arr[l]>arr[r]) {
				swap(arr, --more, l);
			}else {
				l++;
			}
		}
		swap(arr, more, r);
		return new int[] { less + 1, more };
	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
