package com.offer.chapter2;

/**
 * ��ά�����еĲ���
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019��12��22��
 * @Since: 1.0
 */
public class problem4 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(fintNum(matrix, 7)); // Ҫ���ҵ�����������
		System.out.println(fintNum(matrix, 5)); // Ҫ���ҵ�������������
		System.out.println(fintNum(matrix, 1)); // Ҫ���ҵ�������������С������
		System.out.println(fintNum(matrix, 15)); // Ҫ���ҵ�������������������
		System.out.println(fintNum(matrix, 0)); // Ҫ���ҵ�������������С�����ֻ�С
		System.out.println(fintNum(matrix, 16)); // Ҫ���ҵ������������������ֻ���
		System.out.println(fintNum(null, 16)); // ��׳�Բ��ԣ������ָ��
	}

	public static boolean fintNum(int[][] arr, int num) {
		boolean flag = false;
		if (arr != null && arr.length > 0 && arr[0].length > 0) {
			int m = arr.length-1, n = arr[0].length-1;//�����������������
			int row = 0, col = n;//���Ͻ�Ԫ�صĽǱ�
			while (row <= m && col >= 0) {
				int temp = arr[row][col];
				// �жϵ�ǰֵ��num�Ĵ�С
				if (temp == num) {// ���ڣ����ҵ���
					flag = true;
					break;
				} else if (temp > num) {// ���ڣ���ȥ����ǰֵ���ڵ���
					col--;
				} else {
					row++;
				}
			}

		}
		return flag;
	}
}
