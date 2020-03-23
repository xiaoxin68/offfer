package com.offer.chapter4;

import java.util.Stack;

/**
 * ����min������ջ
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��14��
 * @Since: 1.0
 */
public class problem30 {
	
	public static void main(String[] args) {
		MySatck mySatck = new MySatck();
		mySatck.myPush(3);
		mySatck.myPush(4);
		mySatck.myPush(2);
		mySatck.myPush(1);
		System.out.println("����ջ��"+mySatck.dataSatck);
		System.out.println("����ջ��"+mySatck.auxStack);
		System.out.println("��Сֵ��"+mySatck.min);
		mySatck.myPop();
		System.out.println("����ջ��"+mySatck.dataSatck);
		System.out.println("����ջ��"+mySatck.auxStack);
		System.out.println("��Сֵ��"+mySatck.min);
		mySatck.myPop();
		System.out.println("����ջ��"+mySatck.dataSatck);
		System.out.println("����ջ��"+mySatck.auxStack);
		System.out.println("��Сֵ��"+mySatck.min);
		mySatck.myPush(0);
		System.out.println("����ջ��"+mySatck.dataSatck);
		System.out.println("����ջ��"+mySatck.auxStack);
		System.out.println("��Сֵ��"+mySatck.min);
		mySatck.myPop();
		System.out.println("����ջ��"+mySatck.dataSatck);
		System.out.println("����ջ��"+mySatck.auxStack);
		System.out.println("��Сֵ��"+mySatck.min);
		mySatck.myPop();
		System.out.println("����ջ��"+mySatck.dataSatck);
		System.out.println("����ջ��"+mySatck.auxStack);
		System.out.println("��Сֵ��"+mySatck.min);
		mySatck.myPop();
		System.out.println("����ջ��"+mySatck.dataSatck);
		System.out.println("����ջ��"+mySatck.auxStack);
		System.out.println("��Сֵ��"+mySatck.min);
	}
}

class MySatck{
	public Stack<Integer> dataSatck = new Stack<Integer>();// ����ջ
	public Stack<Integer> auxStack = new Stack<Integer>();// ����ջ
	public Integer min;//��Сֵ
	
	//��ջ
	public void myPush(Integer data) {
		if (dataSatck.isEmpty()) {
			auxStack.push(data);
			min = data;
		}else {
			int temp = data<min?data:min;
			auxStack.push(temp);
			min = temp;
		}
		dataSatck.push(data);
	}
	
	//��ջ
	public void myPop() {
		if (!(dataSatck.isEmpty() && auxStack.isEmpty())) {
			dataSatck.pop();
			auxStack.pop();
			if (!auxStack.isEmpty()) {
				min = auxStack.peek();
			}else {
				min = null;
			}
		}
	}
}