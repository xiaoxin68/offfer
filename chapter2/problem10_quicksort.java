package com.offer.chapter2;
/**
 * 快速排序
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月30日
 * @Since: 1.0
 */
public class problem10_quicksort {
	
	public void quickSort(int arr[]) {
		if (arr == null || arr.length<1) {
			return;
		}
		quickSort(arr,0,arr.length-1);
	}
	
	private void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, l + (int) Math.random()*(r-l+1), r);
			int p[] = partition(arr, l, r);
			quickSort(arr,l,p[0]-1);
			quickSort(arr,p[1]+1,r);
		}
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

	
	//给公司所有员工年龄排序
	//数字在一个很小的范围之内
	public static void sortAge(int[] arr) {
		if (arr == null || arr.length<=0) {
			return;
		}
		int []ageNums = new int[100];
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			if (temp < 0 || temp > 100) {
				throw new RuntimeException("超出年龄范围");
			}
			ageNums[temp]++;
		}
		int index = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 1; j <= ageNums[i]; j++) {
				arr[index] = i;
				++index;
			}
		}
	}
}
