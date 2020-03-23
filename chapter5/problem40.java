package com.offer.chapter5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/**
 * 
 * 最小的k个数
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月24日
 * @Since: 1.0
 */
public class problem40 {

	@Test
	public void test() {
		int arr[] = { 4, 5, 1, 6, 2, 7, 3, 8 };
		//
		ArrayList<Integer> getLeastNumbers_Solution = GetLeastNumbers_Solution(arr, 5);
		System.out.println(getLeastNumbers_Solution.size());
		
		ArrayList<Integer> getMaxNumbers_Solution = GetMaxNumbers_Solution(arr, 5);
		System.out.println(getMaxNumbers_Solution.size());
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int length = input.length;
		if (k > length || k < 1) {
			return result;
		}
//		PriorityQueue(int initialCapacity, Comparator<? super E> comparator) 
//        使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器对元素进行排序。
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);//o1.compareTo(o2) 从小到大  反过来 从大到小
			}
		});
		for (int i = 0; i < length; i++) {
			if (maxHeap.size() != k) {//如果不足k个元素，则直接插入
				maxHeap.offer(input[i]);//将指定的元素插入此优先级队列。
			} else if (maxHeap.peek() > input[i]) {//否则比较此队列头元素和当前元素的大小
				maxHeap.poll();//移除队列中最大的元素
				maxHeap.offer(input[i]);
			}
		}
		for (Integer integer : maxHeap) {
			result.add(integer);
		}
		return result;
	}
	
	public ArrayList<Integer> GetMaxNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int length = input.length;
		if (k > length || k < 1) {
			return result;
		}
//		PriorityQueue(int initialCapacity, Comparator<? super E> comparator) 
//        使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器对元素进行排序。
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);//o1.compareTo(o2) 从小到大  反过来 从大到小
			}
		});
		for (int i = 0; i < length; i++) {
			if (maxHeap.size() != k) {//如果不足k个元素，则直接插入
				maxHeap.offer(input[i]);//将指定的元素插入此优先级队列。
			} else if (maxHeap.peek() < input[i]) {//否则比较此队列头元素和当前元素的大小
				maxHeap.poll();//移除队列中最大的元素
				maxHeap.offer(input[i]);
			}
		}
		for (Integer integer : maxHeap) {
			result.add(integer);
		}
		return result;
	}

}
