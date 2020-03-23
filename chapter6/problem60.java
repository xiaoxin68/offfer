package com.offer.chapter6;

import java.util.ArrayList;

import org.junit.Test;


/**
 * n�����ӵĵ���
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��3��2��
 * @Since: 1.0
 */
public class problem60 {
	
	@Test
	public void test() {
		 ArrayList<Double> allPriority = getAllPriority(2, 6);
		 System.out.println(allPriority.size());
		if (allPriority != null && allPriority.size()>0) {
			for(Double prop : allPriority) {
				System.out.println(prop);
			}
		}
	}
	
	/**
	 * ��ʾһ����n�����ӣ�����һ����k��
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public ArrayList<Double> getAllPriority(int number,int gMaxValue){
		if(number == 0 || gMaxValue==0) return null;
		int [][] result= new int[2][number*gMaxValue+1];
		int flag = 0;
		//��ʼ����һ�����Ӹ��������ֵĴ���
		for (int i = 1; i <= gMaxValue; i++) {
			result[flag][i] = 1;
		}
		for (int k = 2; k <= number; k++) {//k��ʾ�ڼ�������
			//������number�����ӣ���˵���С��number�ľ������ܳ���
			for (int i = 0; i < k; i++) {
				result[1-flag][i] = 0;
			}
			//�м������ӣ����������ʹ����￪ʼ
			for (int i = k; i <= gMaxValue * k; i++) {
				result[1-flag][i] = 0;
				for (int j = 1; j <= i && j <= gMaxValue; j++) {
					result[1-flag][i] += result[flag][i-j];
				}
			}
			flag = 1-flag;
		}
		
		double total = Math.pow(gMaxValue, number);
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = number; i <= number*gMaxValue; i++) {
				list.add(result[flag][i]/total);
		}
		return list;
	}
}
