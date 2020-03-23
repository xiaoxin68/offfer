package com.offer.chapter2;
/**
 * 쳲���������
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019��12��27��
 * @Since: 1.0
 */
public class problem10 {
	public static void main(String[] args) {
		System.out.println(Fibonacci(11));
		System.out.println(Fibonacci2(11));
	}

	//��ʽһ���ݹ��㷨--->̫̫̫����
	public static int Fibonacci(int n) {
		if (n==0) {
			return 0;
		}else if (n==1) {
			return 1;
		}else {
			return Fibonacci(n-1)+Fibonacci(n-2);
		}
	}
	
	//��ʽ��
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
