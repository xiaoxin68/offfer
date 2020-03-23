package com.offer.chapter2;

/**
 * 二维数组中的查找
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月22日
 * @Since: 1.0
 */
public class problem4 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(fintNum(matrix, 7)); // 要查找的数在数组中
		System.out.println(fintNum(matrix, 5)); // 要查找的数不在数组中
		System.out.println(fintNum(matrix, 1)); // 要查找的数是数组中最小的数字
		System.out.println(fintNum(matrix, 15)); // 要查找的数是数组中最大的数字
		System.out.println(fintNum(matrix, 0)); // 要查找的数比数组中最小的数字还小
		System.out.println(fintNum(matrix, 16)); // 要查找的数比数组中最大的数字还大
		System.out.println(fintNum(null, 16)); // 健壮性测试，输入空指针
	}

	public static boolean fintNum(int[][] arr, int num) {
		boolean flag = false;
		if (arr != null && arr.length > 0 && arr[0].length > 0) {
			int m = arr.length-1, n = arr[0].length-1;//最大的行坐标和列坐标
			int row = 0, col = n;//右上角元素的角标
			while (row <= m && col >= 0) {
				int temp = arr[row][col];
				// 判断当前值与num的大小
				if (temp == num) {// 等于，则找到了
					flag = true;
					break;
				} else if (temp > num) {// 大于，则去掉当前值所在的列
					col--;
				} else {
					row++;
				}
			}

		}
		return flag;
	}
}
