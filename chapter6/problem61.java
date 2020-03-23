package com.offer.chapter6;

import java.util.Arrays;

/**
 * �˿����е�˳��
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��3��3��
 * @Since: 1.0
 */
public class problem61 {

	public boolean isShunzi(int []num) {
		if(num==null || num.length!=5) {
			return false;
		}
		Arrays.sort(num);
		int countZero = 0;
		int countGap = 0;
		
		//ͳ��0�ĸ���
		while(num[countZero] == 0 && countZero<num.length) {
			countZero++;
		}
	
		int small = countZero;
		int big = small+1;
		while (big < num.length) {
			//���������ȣ�û��˳��
			if(num[small] == num[big]) return false;
			countGap += (num[big] - num[small] -1);
			small = big;
			big++;
		}
		return countGap>countZero?false:true;
	}

}
