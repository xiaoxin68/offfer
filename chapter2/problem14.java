package com.offer.chapter2;
/**
 * ������
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019��12��31��
 * @Since: 1.0
 */
public class problem14 {
	public static void main(String[] args) {
		System.out.println(cut(8));
		System.out.println(cut2(8));
	}
	
	//��ʽһ����̬�滮
	public static int cut(int n) {
		if (n<2) {
			return 0;
		}else if (n==2) {
			return 1;
		}else if (n==3) {
			return 2;
		}
		int max = 0;
		int result[] = new int[n+1];//�洢����������Ž�
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
	
	
	//̰���㷨
	//������ȥ������Ϊ3������
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
