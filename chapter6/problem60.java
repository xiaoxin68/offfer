package com.offer.chapter6;

import java.util.ArrayList;

import org.junit.Test;


/**
 * n个骰子的点数
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年3月2日
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
	 * 表示一共有n个骰子，骰子一共有k面
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public ArrayList<Double> getAllPriority(int number,int gMaxValue){
		if(number == 0 || gMaxValue==0) return null;
		int [][] result= new int[2][number*gMaxValue+1];
		int flag = 0;
		//初始化第一个骰子各点数出现的次数
		for (int i = 1; i <= gMaxValue; i++) {
			result[flag][i] = 1;
		}
		for (int k = 2; k <= number; k++) {//k表示第几个骰子
			//由于有number个骰子，因此点数小于number的均不可能出现
			for (int i = 0; i < k; i++) {
				result[1-flag][i] = 0;
			}
			//有几个骰子，点数的起点就从哪里开始
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
