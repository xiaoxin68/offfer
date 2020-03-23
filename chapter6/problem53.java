package com.offer.chapter6;

import org.junit.Test;

/**
 * 在排序数组中查找数字
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月24日
 * @Since: 1.0
 */
public class problem53 {
	@Test
	public void test() {
		int arr[] = {1,2,3,3,3,3,4,4,5,5,5,5,5};
		int num = 5;
		System.out.println(existCount(arr, num));
	}
	
	public int existCount(int []arr,int num) {
		if (arr==null ||arr.length<1) {
			return 0;
		}
		//二分查找
		int index = binarySearch(arr,num,0,arr.length-1);
		int count = 0;
		if (index != -1) {//表示找到了
			count++;
			int left = index-1;
			int right = index+1;
			while (left>=0 && arr[left] == num) {
				count++;
				left--;
			}
			while (right<arr.length && arr[right]==num) {
				count++;
				right++;
			}
		}
		return count;//表示这个数不存在
	}
	
	public int binarySearch(int []arr,int num,int left,int right) {
		if (arr==null ||arr.length<1) {
			return -1;
		}
		while(left <= right) {
			int mid =(left+right)/2;
			if (arr[mid] == num) {
				return mid;
			}
			else if (num < arr[mid]) {
					right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		
		return -1;
	}
}
