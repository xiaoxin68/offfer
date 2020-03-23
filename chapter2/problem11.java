package com.offer.chapter2;

/**
 * ��ת�������С����
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019��12��30��
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
		//һ�����������е�һ������С�����һ�����֣�����������������ģ���ֱ�ӷ��ص�һ������
		//��������������˳������а�����
		while (arr[p1] >= arr[p2]) {
			if ((p2 - p1) == 1) {
				mid = p2;
				break;
			}
			mid = (p1 + p2) / 2;
			//��������£�ֻ�ܲ���˳�����:1 0 1 1 1 ; 1 1 1 0 1
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

	//˳�����
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
