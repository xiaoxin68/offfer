package com.offer.chapter4;
/**
 * ջ��ѹ�뵯������
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��14��
 * @Since: 1.0
 */

import java.util.Stack;

import org.junit.Test;

public class problem31 {
	
	@Test
	public void test() {
		int[] push = { 1, 2, 3, 4, 5 };
		int[] pop = { 4, 5, 3, 2, 1 };
		System.out.println(IsPopOrder(push,pop));
		
		int[] push2 = { 1, 2, 3, 4, 5 };
		int[] pop2 = { 4, 3, 5, 1, 2 };
		System.out.println(IsPopOrder(push2,pop2));
		
		int[] push3 = { 1, 2, 3, 4, 5 };
		int[] pop3 = { 3, 5, 4, 1, 2 };
		System.out.println(IsPopOrder(push3,pop3));
		
		int[] push4 = { 1 };
		int[] pop4 = { 1 };
		System.out.println(IsPopOrder(push4,pop4));
		
		int[] push5 = { 1 };
		int[] pop5 = { 2 };
		System.out.println(IsPopOrder(push5,pop5));

	}
		
	public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //���ڱ�ʶ�������е�λ��
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //���ջ��Ϊ�գ���ջ��Ԫ�ص��ڵ�������
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //��ջ
                s.pop();
                //�����������һλ
                popIndex++;
            }
        }
        return s.empty();
    }
}
