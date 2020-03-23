package com.offer.chapter5;

import static org.hamcrest.CoreMatchers.not;

import org.junit.Test;

import com.zxx.difficult.a;

/**
 * 礼物的最大价值
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月26日
 * @Since: 1.0
 */
public class problem47 {
	
	@Test
	public void test() {
		int arr[][] = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
		System.out.println(maxGift(arr));
		System.out.println(maxGift2(arr));
	}
	
	public int maxGift(int[][]arr) {
		if (arr == null || arr.length<1) {
			return 0;
		}
		return maxGift(arr,arr.length-1,arr[0].length-1);
	}
	
	/**
	 * 递归写法
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	public int maxGift(int[][]arr,int i,int j) {
		if (i == 0 && j==0) {
			return arr[i][j];
		}
		if (i == 0) {
			return  maxGift(arr, i, j-1) + arr[i][j];
		}
		if (j == 0) {
			return  maxGift(arr, i-1, j) + arr[i][j];
		}
		return Math.max(maxGift(arr, i-1, j), maxGift(arr, i, j-1)) + arr[i][j];
	}
	
	/**
	 * 动态规划写法
	 * 
	 * @param arr
	 * @return
	 */
	public int maxGift2(int[][]arr) {
		if (arr == null || arr.length<1) {
			return 0;
		}
		int rows = arr.length,cols = arr[0].length;
		int [][] gift = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 && j==0) {
					gift[i][j] = arr[i][j];
				}else if (i == 0) {
					gift[i][j] = gift[i][j-1]+arr[i][j];
				}else if (j == 0) {
					gift[i][j] = gift[i-1][j]+arr[i][j];
				}else {
					gift[i][j] = Math.max( gift[i][j-1], gift[i-1][j])+arr[i][j];
				}
			}
		}
		return gift[rows-1][cols-1];
	}
}
