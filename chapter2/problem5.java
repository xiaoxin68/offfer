package com.offer.chapter2;
/**
 * 替换空格
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月23日
 * @Since: 1.0
 */
public class problem5 {
	public static void main(String[] args) {
//		char[] string = new char[50];
//        string[0] = 'w';
//        string[1] = 'e';
//        string[2] = 'w';
//        string[3] = 'a';
//        string[4] = 'r';
//        string[5] = 'e';
//        string[6] = 'w';
//        string[7] = 'h';
//        string[8] = 'a';
//        string[9] = 'p';
//        string[10] = 'p';
//        string[11] = 'w';
//
//        int length = replaceBlank(string,12);
//        System.out.println(new String(string, 0, length));
		
		int []num1 = new int[50];
		num1[0] = 1;
		num1[1] = 4;
		num1[2] = 6;
		num1[3] = 8;
		num1[4] = 11;
		int []num2 = {1,4,5,7,9,10};
		int len = arraySort(num1,5,num2);
		for (int i = 0; i < len; i++) {
			System.out.print(num1[i] + " ");
		}
	}
	
	public static int replaceBlank(char[] chs,int size) {
		int len = size;
		for (int i = 0; i < size; i++) {
			if (chs[i] == ' ') {
				len+=2;
			}
		}
		if (len != size) {//说明含有空格
			int index = len;
			for (int i = size-1; i >= 0; i--) {
				if (chs[i]!=' ') {//直接复制
					chs[--index] = chs[i];
				}else {//该位置是空格
					chs[--index] = '0';
					chs[--index] = '2';
					chs[--index] = '%';
				}
			}
		}
		return len;
	}
	
	//相关题目，实现数组排序
	public static int arraySort(int[] num1,int len1,int []num2) {
		//处理空的情况
		if (num2 == null) {
			return len1;
		}
		if (len1 == 0) {
			for (int i = num2.length-1; i >= 0; i--) {
				num1[i] = num2[i];
			}
			return num2.length;
		}
		int len = len1+num2.length,len2 = num2.length;
		len1--;
		len2--;
		for (int cur = len-1; cur >=0; cur--) {
			if (len1>=0 && len2>=0) {
				if (num1[len1] >=  num2[len2]) {
					num1[cur] = num1[len1];
					len1--;
				}else {
					num1[cur] = num2[len2];
					len2--;
				}
			} else {
				if(len2>=0){
					for (int j = len2; j >= 0; j--) {
						num1[cur] = num2[j];
					}
				}
			}
			
		}
		return len;
	}
}
