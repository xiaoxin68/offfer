package com.offer.chapter2;

/**
 * 旋转数组的最小数字
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月30日
 * @Since: 1.0
 */
public class problem11 {
	public static void main(String[] args) {
		int[] arr = {3,3,3,3};
		System.out.println(minNum(arr));
	}

	public static int minNum(int[] arr) {
		if (arr == null || arr.length <= 0) {
			return -1;
		}
		int p1 = 0, p2 = arr.length - 1, mid = p1;
		//一旦发现数组中第一个数字小于最后一个数字，表明该数组是排序的，可直接返回第一个数字
		//这种情况在下面的顺序查找中包含了
		while (arr[p1] >= arr[p2]) {
			if ((p2 - p1) == 1) {
				mid = p2;
				break;
			}
			mid = (p1 + p2) / 2;
			//这种情况下，只能采用顺序查找:1 0 1 1 1 ; 1 1 1 0 1
			if (arr[p1] == arr[p2] && arr[mid] == arr[p1]) {
				return minOrder(arr,p1,p2);
			}
			if (arr[mid] >= arr[p1]) {
				p1 = mid;
			} else if (arr[mid] <= arr[p2]) {
				p2 = mid;
			}
		}
		return arr[mid];
	}

	//顺序查找
	private static int minOrder(int[] arr, int p1, int p2) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
}
