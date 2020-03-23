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
 * ��С��k����
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��24��
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
//        ʹ��ָ���ĳ�ʼ��������һ�� PriorityQueue��������ָ���ıȽ�����Ԫ�ؽ�������
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);//o1.compareTo(o2) ��С����  ������ �Ӵ�С
			}
		});
		for (int i = 0; i < length; i++) {
			if (maxHeap.size() != k) {//�������k��Ԫ�أ���ֱ�Ӳ���
				maxHeap.offer(input[i]);//��ָ����Ԫ�ز�������ȼ����С�
			} else if (maxHeap.peek() > input[i]) {//����Ƚϴ˶���ͷԪ�غ͵�ǰԪ�صĴ�С
				maxHeap.poll();//�Ƴ�����������Ԫ��
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
//        ʹ��ָ���ĳ�ʼ��������һ�� PriorityQueue��������ָ���ıȽ�����Ԫ�ؽ�������
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);//o1.compareTo(o2) ��С����  ������ �Ӵ�С
			}
		});
		for (int i = 0; i < length; i++) {
			if (maxHeap.size() != k) {//�������k��Ԫ�أ���ֱ�Ӳ���
				maxHeap.offer(input[i]);//��ָ����Ԫ�ز�������ȼ����С�
			} else if (maxHeap.peek() < input[i]) {//����Ƚϴ˶���ͷԪ�غ͵�ǰԪ�صĴ�С
				maxHeap.poll();//�Ƴ�����������Ԫ��
				maxHeap.offer(input[i]);
			}
		}
		for (Integer integer : maxHeap) {
			result.add(integer);
		}
		return result;
	}

}
