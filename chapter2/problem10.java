package com.offer.chapter2;
/**
 * 斐波拉契函数
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月27日
 * @Since: 1.0
 */
public class problem10 {
	public static void main(String[] args) {
		System.out.println(Fibonacci(11));
		System.out.println(Fibonacci2(11));
	}

	//方式一：递归算法--->太太太慢了
	public static int Fibonacci(int n) {
		if (n==0) {
			return 0;
		}else if (n==1) {
			return 1;
		}else {
			return Fibonacci(n-1)+Fibonacci(n-2);
		}
	}
	
	//方式二
	public static int Fibonacci2(int n) {
		if (n==0) {
			return 0;
		}else if (n==1) {
			return 1;
		}else {
			int result=0,num0 = 0,num1 =1;
			for (int i = 2; i <= n; i++) {
				result = num0 + num1;
				num0 = num1;
				num1 = result;
			}
			return result;
		}
	}
}
