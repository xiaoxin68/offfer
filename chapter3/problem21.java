package com.offer.chapter3;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月12日
 * @Since: 1.0
 */
public class problem21 {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 6, 7, 4, 3, 2 };
		recoderOddEven(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void recoderOddEven(int[] arr) {
		if (arr == null || arr.length == 1) {
			return;
		}
		int p1 = 0, p2 = arr.length - 1;
		while (p1 < p2) {
			while (p1 < p2 && (arr[p1] & 0x1) != 0) {
				p1++;
			}
			while (p1 < p2 && (arr[p2] & 0x1) != 1) {
				p2--;
			}
			if (p1 < p2) {
				int temp = arr[p1];
				arr[p1] = arr[p2];
				arr[p2] = temp;
			}
		}
	}

	public void reOrderArray(int[] arr) {
		int m = arr.length, k = 0;
		for (int i = 0; i < m; i++) {
			if ((arr[i] & 0X1) == 1) {// 奇数
				int j = i;
				while (j > k) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					j--;
				}
				k++;
			}
		}
	}
}
