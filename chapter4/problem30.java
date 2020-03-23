package com.offer.chapter4;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月14日
 * @Since: 1.0
 */
public class problem30 {
	
	public static void main(String[] args) {
		MySatck mySatck = new MySatck();
		mySatck.myPush(3);
		mySatck.myPush(4);
		mySatck.myPush(2);
		mySatck.myPush(1);
		System.out.println("数据栈："+mySatck.dataSatck);
		System.out.println("辅助栈："+mySatck.auxStack);
		System.out.println("最小值："+mySatck.min);
		mySatck.myPop();
		System.out.println("数据栈："+mySatck.dataSatck);
		System.out.println("辅助栈："+mySatck.auxStack);
		System.out.println("最小值："+mySatck.min);
		mySatck.myPop();
		System.out.println("数据栈："+mySatck.dataSatck);
		System.out.println("辅助栈："+mySatck.auxStack);
		System.out.println("最小值："+mySatck.min);
		mySatck.myPush(0);
		System.out.println("数据栈："+mySatck.dataSatck);
		System.out.println("辅助栈："+mySatck.auxStack);
		System.out.println("最小值："+mySatck.min);
		mySatck.myPop();
		System.out.println("数据栈："+mySatck.dataSatck);
		System.out.println("辅助栈："+mySatck.auxStack);
		System.out.println("最小值："+mySatck.min);
		mySatck.myPop();
		System.out.println("数据栈："+mySatck.dataSatck);
		System.out.println("辅助栈："+mySatck.auxStack);
		System.out.println("最小值："+mySatck.min);
		mySatck.myPop();
		System.out.println("数据栈："+mySatck.dataSatck);
		System.out.println("辅助栈："+mySatck.auxStack);
		System.out.println("最小值："+mySatck.min);
	}
}

class MySatck{
	public Stack<Integer> dataSatck = new Stack<Integer>();// 数据栈
	public Stack<Integer> auxStack = new Stack<Integer>();// 辅助栈
	public Integer min;//最小值
	
	//入栈
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
	
	//出栈
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