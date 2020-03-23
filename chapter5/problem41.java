package com.offer.chapter5;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * �������е���λ��
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��24��
 * @Since: 1.0
 */
public class problem41 {

	@Test
	public void test() {
		Insert(5);
		System.out.println(GetMedian());
		Insert(2);
		System.out.println(GetMedian());
		Insert(3);
		System.out.println(GetMedian());
		Insert(4);
		System.out.println(GetMedian());
		Insert(1);
		System.out.println(GetMedian());
		Insert(6);
		System.out.println(GetMedian());
		Insert(7);
		System.out.println(GetMedian());
		Insert(0);
		System.out.println(GetMedian());
		Insert(8);
		System.out.println(GetMedian());

		// �����"5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00 "
	}

	// С����
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

	// �󶥶�
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		};
	});

	// ��¼ż��������������
	int count = 0;

	// ÿ�β���С���ѵ��ǵ�ǰ�󶥶���������
	// ÿ�β���󶥶ѵ��ǵ�ǰС��������С����
	// ������֤С�����е�����Զ���ڵ��ڴ󶥶��е���
	// ��λ���Ϳ��Է���ش����ߵĸ�����л�ȡ��
	public void Insert(Integer num) {
		// ����Ϊż���Ļ������Ȳ��뵽�󶥶ѣ�Ȼ�󽫴󶥶�������������С������
		if (count % 2 == 0) {
			maxHeap.offer(num);
			int max = maxHeap.poll();
			minHeap.offer(max);
		} else {
			// ����Ϊ�����Ļ������Ȳ��뵽С���ѣ�Ȼ��С��������С��������󶥶���
			minHeap.offer(num);
			int min = minHeap.poll();
			maxHeap.offer(min);
		}
		count++;
	}

	public Double GetMedian() {
		// ��ǰΪż��������ȡС���Ѻʹ󶥶ѵĶѶ�Ԫ����ƽ��
		if (count % 2 == 0) {
			return new Double(minHeap.peek() + maxHeap.peek()) / 2;
		} else {
			// ��ǰΪ����������ֱ�Ӵ�С������ȡԪ�ؼ���
			return new Double(minHeap.peek());
		}
	}
}
