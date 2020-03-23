package com.offer.chapter2;

/**
 * 数组中的重复数字
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月22日
 * @Since: 1.0
 */
public class problem3 {
	public static void main(String[] args) {
//		int arr[] = {0,1};
//		System.out.println(get(arr));

		int arr2[] = { 2, 3, 1,0,2,5,3 };
		System.out.println(get2(arr2));
	}

	/**
	 * 找出数组中的重复数字
	 * 
	 * @param arr
	 * @return
	 */
	public static int get(int arr[]) {
		// 无效输入测试用例，输入空指针
		if (arr == null || arr.length < 1) {
			return -1;
		}
		// 无效输入测试用例，长度无为n的数组中包含0~n-1之外的数字
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 || arr[i] > arr.length - 1) {
				return -1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i) {
				if (arr[i] == arr[arr[i]]) {// 找到一个重复的数字
					return arr[i];
				}
				int temp = arr[i];
				arr[i] = arr[arr[i]];
				arr[temp] = temp;
			} // 相等的时候继续扫描
		}
		return -1;
	}

	// 不修改数组找出重复数字
	public static int get2(int arr[]) {
		// 无效输入测试用例，输入空指针
		if (arr == null || arr.length < 1) {
			return -1;
		}
		int l = 1, r = arr.length - 1, mid;
		while (r >= l) {
			mid = (l + r) / 2;
			// 计算范围在[l,mid]之间的数字个数；计算范围在[mid+1,r]之间的数字个数
			int leftLen = count(arr, l, mid);
			// 出口
			if (l == r) {
				if (leftLen > 1) {
					return l;
				} else {
					break;
				}
			}
			// int rightLen = count(arr,mid+1,r);
			if (leftLen > (mid - l + 1)) {
				// 说明重复的元素在左半部分
				r = mid;
			} else {
				// 说明重复的元素在右半部分
				l = mid + 1;
			}
		}
		return -1;

	}

	public static int count(int arr[], int start, int end) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= start && arr[i] <= end) {
				count++;
			}
		}
		return count;
	}
}
