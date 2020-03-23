package com.offer.chapter6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

import org.junit.Test;

/**
 * 滑动窗口的最大值
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月27日
 * @Since: 1.0
 */
public class problem59 {
	
	@Test
	public void test() {
		int []num = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> maxInWindows = maxInWindows(num, 4);
		for(Integer max :maxInWindows) {
			System.out.print(max+" ");
		}
	}
 
	/**
	 * 滑动窗口的最大值
	 * 
	 * @param num
	 * @param size
	 * @return
	 */
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		if (num == null || size < 0) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (size == 0) {
			return list;
		}
		ArrayList<Integer> temp = null;
		int length = num.length;
		if (length < size) {
			return list;
		} else {
			for (int i = 0; i < length - size + 1; i++) {
				temp = new ArrayList<Integer>();
				for (int j = i; j < size + i; j++) {
					temp.add(num[j]);
				}
				Collections.sort(temp);
				list.add(temp.get(temp.size() - 1));
			}
		}
		return list;
	}
}
