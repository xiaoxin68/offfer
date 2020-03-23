package com.offer.chapter2;
/**
 * ������ջʵ�ֶ���   
 * ����������ʵ��һ��ջ
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019��12��27��
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
		// ������ջʵ��һ������
		problem9 p = new problem9<Character>();
//		p.appendTail('a');
//		p.appendTail('b');
//		p.appendTail('c');
//		System.out.println(p.deleteTail());//ɾ��
//		System.out.println(p.deleteTail());
//		p.appendTail('d');
//		System.out.println(p.deleteTail());

		// ����������ʵ��һ��ջ
		p.appendQueue('a');
		p.appendQueue('b');
		p.appendQueue('c');
		//System.out.println(p.queue1);
		System.out.println(p.deleteQueue());// ɾ��
		System.out.println(p.deleteQueue());
		p.appendQueue('d');
		System.out.println(p.deleteQueue());
	}
	// ������ջʵ��һ������
	public Stack<T> stack1 = new Stack<T>();// ����ջ
	public Stack<T> stack2 = new Stack<T>();// ����ջ

	public void appendTail(T t) {
		stack1.push(t);
	}

	public T deleteTail() {
		if (stack2.isEmpty()) {// �������ջΪ�գ����stack1ȫ��������stack2��
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		if (stack2.isEmpty()) {// ���stack2Ϊ�գ���ʾû��Ԫ�ؿɵ���
			throw new RuntimeException("No more element.");
		}
		return stack2.pop();
	}

	// ��������������һ��ջ
	public Queue<T> queue1 = new ArrayDeque<T>();
	public Queue<T> queue2 = new ArrayDeque<T>();

	public void appendQueue(T t) {
		queue1.add(t);
	}

	public T deleteQueue() {
		T result = null;
		// ����ǰ���е�������һ��Ϊ�յĶ�����
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
