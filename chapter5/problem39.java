package com.offer.chapter5;

import org.junit.Test;

/**
 * �����г��ִ�������һ�������
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��24��
 * @Since: 1.0
 */
public class problem39 {
	
	@Test
	public void test() {
		int arr[] = {1,2,3,2,2,2,5,4,2};
		System.out.println(moreThanHalfNum(arr, arr.length));
	}
	

	// ȫ�ֱ����ж������Ƿ���Ч
	boolean arrayInvalid = false;

	/**
	 * �ж����������Ƿ���Ч
	 * 
	 * @param array
	 * @param length
	 * @return
	 */
	boolean CheckInvalidArray(int[] array, int length){
		arrayInvalid = false;
		if(array == null && length <= 0){
			arrayInvalid = true;
		}
		return arrayInvalid;
	}

	/**
	 * �ж����������г��ִ����������Ƿ񳬹����鳤�ȵ�һ��
	 * 
	 * @param array
	 * @param length
	 * @param number
	 * @return
	 */
	boolean CheckMoreThanHalf(int[] array, int length, int number){
		int times = 0;
		for (int i = 0; i < length; i++) {
			if(array[i] == number){
				times++;
			}
		}
		boolean isMoreThanHalf = true;
		if(times * 2 <= length){
			arrayInvalid = true;
			isMoreThanHalf = false;
		}
		return isMoreThanHalf;
	}

	/**
	 * �ҵ����ִ�������һ�����
	 * 
	 * @param array
	 * @param length
	 * @return
	 */
	int moreThanHalfNum(int []array,int length) {
		if (CheckInvalidArray(array, length)) {
			return 0;
		}
		int result = array[0];
		int times = 1;
		if (length > 1) {
			for (int i = 1; i < length; i++) {
				if (times == 0) {
					result = array[i];
				}
				else if (result == array[i]) {
					times++;
				}else {
					times--;
				}
			}
		}
		if (!CheckMoreThanHalf(array, length, result)) {
			result = 0;
		}
		return result;
	}
}
