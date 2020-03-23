package com.offer.chapter3;

/**
 * ��ӡ��1������nλ��***
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��1��2��
 * @Since: 1.0
 */
public class problem17 {
	public static void main(String[] args) {
		//printDidits(3);
		//printToMaxOfNDigits(3);
		printMaxDig(3);
	}

	/* ================================��ʽһ================================ */
	/**
	 * ��ʽһ��³���Խϲδ�������ݷ�Χ
	 * 
	 * @param n
	 */
	public static void printDidits(int n) {
		long number = 1;
		int i = 0;
		while (i < n) { // ����whileѭ���������nλʮ���ƶ�1����
			number *= 10;
			++i;
		}
		for (long j = 1; j < number; j++) { // ����forѭ�������1������nλ��
			System.out.print(j + " ");
			if (j % 5 == 0) {
				System.out.println();
			}
		}
	}
	
	/* ================================��ʽһ================================ */
	
	
	/* ================================��ʽ��================================ */
	public static void printToMaxOfNDigits(int n) {
		if (n < 1) {
			return;
		}
		char[] number = new char[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		while (!increament(number)) {// δ������Χ
			printNumber(number);// ������һ�������ַ�ʱ�ſ�ʼ���
		}
	}

	private static boolean increament(char[] number) {
		boolean isOverFlow = false;//�Ƿ񳬹���Χ
		int nTakeOver = 0;//�Ƿ��λ
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

	//��ӡ����
	private static void printNumber(char[] number) {
		boolean isBeginning0 = true;
		int nLength = number.length;
		for (int i = 0; i < nLength; ++i) {
			//����ڿ�ͷ����ô�������ſ����
			if(isBeginning0 && number[i]!='0'){
				isBeginning0 = false;//һ��������һ������ļ��޸ı�־λ
			}
			//�粻�ڿ�ͷ�������ж��Ƿ�Ϊ�㼴�����
			if(!isBeginning0){
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
	/* ================================��ʽ��================================ */
	
	/* ================================��ʽ��================================ */
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
	/* ================================��ʽ��================================ */

	
}
