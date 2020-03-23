package com.offer.chapter3;
/**
 * ��ֵ�������η�
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��1��2��
 * @Since: 1.0
 */
public class problem16 {
	public static void main(String[] args) {
		System.out.println(myPow(2,-3));
		System.out.println(myPow2(-2,-3));
	}
	
	/**
	 * ��ʽһ���Ը����������ȫ���ۺϴ���
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double myPow(double base,int exponent) {
		//double�������ݱȽϴ�С
		double dis=1e-6;
		if (Math.abs(base-0.0)<dis && exponent<0) {
			throw new RuntimeException("���벻�Ϸ�");
		}
		if (Math.abs(base-0.0)<dis || exponent==0) {
			return 1;
		}
		//���ڸ�������δ���
		boolean isFuShu = false;
		if (exponent<0) {
			isFuShu = true;
			exponent = -exponent;
		}
		double result = 1;
		for (int i = 1; i <= exponent; i++) {
			result*=base;
		}
		if (isFuShu) {
			result = 1/result;
		}
		return result;
	}
	
	/**
	 * ��ʽ����Ч�ʸ��ߵ�һ�ִ���ʽ
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double myPow2(double base,int exponent) {
		double dis=1e-6;
		if (Math.abs(base-0.0)<dis && exponent<0) {
			throw new RuntimeException("���벻�Ϸ�");
		}
		if (Math.abs(base-0.0)<dis || exponent==0) {
			return 1;
		}
		//�ݹ�ĳ���
		if (exponent ==1) {
			return base;
		}
		if (exponent == -1) {
			return 1/base;
		}
		double result = myPow2(base, exponent>>1);
		result *= result;
		if ((exponent & 0x1) == 1) {
			result*=base;
		}
		return result;
	}
}