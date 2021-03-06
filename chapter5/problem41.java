package com.offer.chapter5;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * 数据流中的中位数
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月24日
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

		// 输出是"5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00 "
	}

	// 小顶堆
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

	// 大顶堆
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		};
	});

	// 记录偶数个还是奇数个
	int count = 0;

	// 每次插入小顶堆的是当前大顶堆中最大的数
	// 每次插入大顶堆的是当前小顶堆中最小的数
	// 这样保证小顶堆中的数永远大于等于大顶堆中的数
	// 中位数就可以方便地从两者的根结点中获取了
	public void Insert(Integer num) {
		// 个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
		if (count % 2 == 0) {
			maxHeap.offer(num);
			int max = maxHeap.poll();
			minHeap.offer(max);
		} else {
			// 个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
			minHeap.offer(num);
			int min = minHeap.poll();
			maxHeap.offer(min);
		}
		count++;
	}

	public Double GetMedian() {
		// 当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
		if (count % 2 == 0) {
			return new Double(minHeap.peek() + maxHeap.peek()) / 2;
		} else {
			// 当前为奇数个，则直接从小顶堆中取元素即可
			return new Double(minHeap.peek());
		}
	}
}
