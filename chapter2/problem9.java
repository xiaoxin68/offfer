package com.offer.chapter2;
/**
 * 用两个栈实现队列   
 * 用两个队列实现一个栈
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月27日
 * @Since: 1.0
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.RuntimeErrorException;

public class problem9<T> {

	public static void main(String[] args) {
		// 用两个栈实现一个队列
		problem9 p = new problem9<Character>();
//		p.appendTail('a');
//		p.appendTail('b');
//		p.appendTail('c');
//		System.out.println(p.deleteTail());//删除
//		System.out.println(p.deleteTail());
//		p.appendTail('d');
//		System.out.println(p.deleteTail());

		// 用两个队列实现一个栈
		p.appendQueue('a');
		p.appendQueue('b');
		p.appendQueue('c');
		//System.out.println(p.queue1);
		System.out.println(p.deleteQueue());// 删除
		System.out.println(p.deleteQueue());
		p.appendQueue('d');
		System.out.println(p.deleteQueue());
	}
	// 用两个栈实现一个队列
	public Stack<T> stack1 = new Stack<T>();// 插入栈
	public Stack<T> stack2 = new Stack<T>();// 弹出栈

	public void appendTail(T t) {
		stack1.push(t);
	}

	public T deleteTail() {
		if (stack2.isEmpty()) {// 如果弹出栈为空，则把stack1全部弹出到stack2中
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		if (stack2.isEmpty()) {// 如果stack2为空，表示没有元素可弹出
			throw new RuntimeException("No more element.");
		}
		return stack2.pop();
	}

	// 用两个队列闪现一个栈
	public Queue<T> queue1 = new ArrayDeque<T>();
	public Queue<T> queue2 = new ArrayDeque<T>();

	public void appendQueue(T t) {
		queue1.add(t);
	}

	public T deleteQueue() {
		T result = null;
		// 将当前队列弹出到另一个为空的队列中
		if (!(queue1.isEmpty() && queue2.isEmpty())) {
			int index = 1,size1=queue1.size(),size2=queue2.size();
			if (queue1.isEmpty()) {
				while (index < size2) {
					queue1.add(queue2.remove());
					index++;
				}
				result = queue2.remove();
			} else if (queue2.isEmpty()) {
				while (index < size1) {
					queue2.add(queue1.remove());
					index++;
				}
				result = queue1.remove();
			}
			return result;
		}else {
			throw new RuntimeException("No more element.");
		}
	}
}
