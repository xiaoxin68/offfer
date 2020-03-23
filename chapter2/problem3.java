package com.offer.chapter2;

/**
 * �����е��ظ�����
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019��12��22��
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
	 * �ҳ������е��ظ�����
	 * 
	 * @param arr
	 * @return
	 */
	public static int get(int arr[]) {
		// ��Ч������������������ָ��
		if (arr == null || arr.length < 1) {
			return -1;
		}
		// ��Ч�������������������Ϊn�������а���0~n-1֮�������
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 || arr[i] > arr.length - 1) {
				return -1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i) {
				if (arr[i] == arr[arr[i]]) {// �ҵ�һ���ظ�������
					return arr[i];
				}
				int temp = arr[i];
				arr[i] = arr[arr[i]];
				arr[temp] = temp;
			} // ��ȵ�ʱ�����ɨ��
		}
		return -1;
	}

	// ���޸������ҳ��ظ�����
	public static int get2(int arr[]) {
		// ��Ч������������������ָ��
		if (arr == null || arr.length < 1) {
			return -1;
		}
		int l = 1, r = arr.length - 1, mid;
		while (r >= l) {
			mid = (l + r) / 2;
			// ���㷶Χ��[l,mid]֮������ָ��������㷶Χ��[mid+1,r]֮������ָ���
			int leftLen = count(arr, l, mid);
			// ����
			if (l == r) {
				if (leftLen > 1) {
					return l;
				} else {
					break;
				}
			}
			// int rightLen = count(arr,mid+1,r);
			if (leftLen > (mid - l + 1)) {
				// ˵���ظ���Ԫ������벿��
				r = mid;
			} else {
				// ˵���ظ���Ԫ�����Ұ벿��
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
