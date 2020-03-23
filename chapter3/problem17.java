package com.offer.chapter3;

/**
 * 打印从1到最大的n位数***
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年1月2日
 * @Since: 1.0
 */
public class problem17 {
	public static void main(String[] args) {
		//printDidits(3);
		//printToMaxOfNDigits(3);
		printMaxDig(3);
	}

	/* ================================方式一================================ */
	/**
	 * 方式一：鲁棒性较差，未考虑数据范围
	 * 
	 * @param n
	 */
	public static void printDidits(int n) {
		long number = 1;
		int i = 0;
		while (i < n) { // 利用while循环计算出比n位十进制多1的数
			number *= 10;
			++i;
		}
		for (long j = 1; j < number; j++) { // 利用for循环输出从1到最大的n位数
			System.out.print(j + " ");
			if (j % 5 == 0) {
				System.out.println();
			}
		}
	}
	
	/* ================================方式一================================ */
	
	
	/* ================================方式二================================ */
	public static void printToMaxOfNDigits(int n) {
		if (n < 1) {
			return;
		}
		char[] number = new char[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		while (!increament(number)) {// 未超出范围
			printNumber(number);// 遇到第一个非零字符时才开始输出
		}
	}

	private static boolean increament(char[] number) {
		boolean isOverFlow = false;//是否超过范围
		int nTakeOver = 0;//是否进位
		int len = number.length;
		for (int i = len-1; i >= 0; i--) {
			int nSum = number[i] - '0' + nTakeOver;
			if (i == len-1) {
				nSum++;
			}
			if (nSum>=10) {
				if (i == 0) {
					isOverFlow = true;
				}else {
					nTakeOver = 1;
					nSum -= 10;
					number[i] = (char) ('0'+nSum);
				}
			}else {
				number[i] = (char) ('0'+nSum);
				break;
			}
		}

		return isOverFlow;
	}

	//打印数字
	private static void printNumber(char[] number) {
		boolean isBeginning0 = true;
		int nLength = number.length;
		for (int i = 0; i < nLength; ++i) {
			//如果在开头，那么必须非零才可输出
			if(isBeginning0 && number[i]!='0'){
				isBeginning0 = false;//一旦遇到第一个非零的及修改标志位
			}
			//如不在开头，不用判断是否为零即可输出
			if(!isBeginning0){
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
	/* ================================方式二================================ */
	
	/* ================================方式三================================ */
	public static void printMaxDig(int n) {
		if (n<=0) {
			return;
		}
		char []number = new char[n];
		for (int i = 0; i < 10; i++) {
			number[0] = (char) (i + '0');
			printMaxDigRecursively(number,n,0);
		}		
	}
	
	private static void printMaxDigRecursively(char[] number, int length, int index) {
		if (index == length-1) {
			printNumber(number);
			return;
		}
		for (int i = 0; i < 10; i++) {
			number[index+1] = (char) (i + '0');
			printMaxDigRecursively(number, length, index+1);
		}
	}
	/* ================================方式三================================ */

	
}
