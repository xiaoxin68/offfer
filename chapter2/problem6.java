package com.offer.chapter2;

import java.util.Stack;

/**
 * ��ͷ��β��ӡ����
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019��12��23��
 * @Since: 1.0
 */
public class problem6 {
	public static void main(String[] args) {
		ListNode root = new ListNode();
		root.val = 1;
		root.nxt = new ListNode();
		root.nxt.val = 2;
		root.nxt.nxt = new ListNode();
		root.nxt.nxt.val = 3;
		root.nxt.nxt.nxt = new ListNode();
		root.nxt.nxt.nxt.val = 4;
		root.nxt.nxt.nxt.nxt = new ListNode();
		root.nxt.nxt.nxt.nxt.val = 5;
		printListInverselyUsingIteration(root);
	}

	/**
	 * ������
	 */
	public static class ListNode {
	 public	int val; // ����ֵ
	 public	ListNode nxt; // ��һ�����
	}

	/**
	 * ʹ��ջ�Ľṹʵ��
	 * 
	 * @param root
	 */
	public static void printListInverselyUsingIteration(ListNode root) {
		if (root == null) {
			return;
		}
		Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.nxt;
        }
		// ��ջ
		ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.val + " ");
        }
	}

}
