package com.offer.chapter3;
/**
 * 数值的整数次方
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年1月2日
 * @Since: 1.0
 */
public class problem16 {
	public static void main(String[] args) {
		System.out.println(myPow(2,-3));
		System.out.println(myPow2(-2,-3));
	}
	
	/**
	 * 方式一：对各种情况进行全面综合处理
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double myPow(double base,int exponent) {
		//double类型数据比较大小
		double dis=1e-6;
		if (Math.abs(base-0.0)<dis && exponent<0) {
			throw new RuntimeException("输入不合法");
		}
		if (Math.abs(base-0.0)<dis || exponent==0) {
			return 1;
		}
		//对于负数幂如何处理
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
	 * 方式二：效率更高的一种处理方式
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double myPow2(double base,int exponent) {
		double dis=1e-6;
		if (Math.abs(base-0.0)<dis && exponent<0) {
			throw new RuntimeException("输入不合法");
		}
		if (Math.abs(base-0.0)<dis || exponent==0) {
			return 1;
		}
		//递归的出口
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