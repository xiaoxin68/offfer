
package com.offer.chapter4;
/**
 * 顺时针打印矩阵
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月14日
 * @Since: 1.0
 */
public class problem29 {
	public static void main(String[] args) {
		int[][] numbers = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrixClockwisely(numbers);
		System.out.println();
		int[][] numbers2 = {{1,2,3,4}};
		printMatrixClockwisely(numbers2);
		System.out.println();
		int[][] numbers3 = {{1},{2},{3},{4}};
		printMatrixClockwisely(numbers3);
		System.out.println();
		int[][] numbers4 = {{1,2,3,4},{5,6,7,8}};
		printMatrixClockwisely(numbers4);
		System.out.println();
		
	}

	/**
	 * 顺时针打印矩阵
	 * 
	 * @param numbers
	 */
	public static void printMatrixClockwisely(int[][] numbers) {
		if (numbers==null || numbers.length<1) {
			return;
		}
		int rows = numbers.length,cols = numbers[0].length;
		int start = 0;
		while (rows>start*2 && cols>start*2) {
			printMatrixInCircle(numbers,rows,cols,start);
			start++;
		}
	}

	/**
	 * 从start开始打印一圈
	 * 
	 * @param numbers
	 * @param rows
	 * @param cols
	 * @param start
	 */
	private static void printMatrixInCircle(int[][] numbers, int rows, int cols, int start) {
		int endX = cols-start-1;
		int endY = rows-start-1;
		//从左到右打印一行
		for (int i = start; i <= endX; i++) {
			System.out.print(numbers[start][i]+",");
		}
		//从上到下打印一列
		if (start < endY) {
			for (int i = start+1; i <=endY; i++) {
				System.out.print(numbers[i][endX]+",");
			}
		}
		//从右向左打印一行
		if (start<endX && start< endY) {
			for (int i = endX -1; i >=start; i--) {
				System.out.print(numbers[endY][i]+",");
			}
		}
		//从下到上打印一列
		if (start+1 < endY && start < endX) {
			for (int i = endY-1; i >start; i--) {
				System.out.print(numbers[i][start]+",");
			}
		}
	}
}
