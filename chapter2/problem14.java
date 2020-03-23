package com.offer.chapter2;
/**
 * 剪绳子
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月31日
 * @Since: 1.0
 */
public class problem14 {
	public static void main(String[] args) {
		System.out.println(cut(8));
		System.out.println(cut2(8));
	}
	
	//方式一：动态规划
	public static int cut(int n) {
		if (n<2) {
			return 0;
		}else if (n==2) {
			return 1;
		}else if (n==3) {
			return 2;
		}
		int max = 0;
		int result[] = new int[n+1];//存储子问题的最优解
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;
		for (int i = 4; i <= n; i++) {
			max = 0;
			for (int j = 1; j <= i/2; j++) {
				max = result[j]*result[i-j] > max ? result[j]*result[i-j] : max;
				result[i] = max;
			}
		}
		max = result[n];
		return max;
	}
	
	
	//贪婪算法
	//尽可能去剪长度为3的绳子
	public static int cut2(int n) {
		if (n<2) {
			return 0;
		}else if (n==2) {
			return 1;
		}else if (n==3) {
			return 2;
		}
		int timesOfThree = n/3;
		if ((n- timesOfThree * 3) == 1) {
			timesOfThree--;
		}
		int timesOfTwo = (n - timesOfThree * 3)/2;
		return (int) (Math.pow(3, timesOfThree)*Math.pow(2, timesOfTwo));
	}
}
