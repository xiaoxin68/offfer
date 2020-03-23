package com.offer.chapter3;

import com.offer.chapter2.problem6.ListNode;

/**
 * �����е�����k���ڵ�
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��12��
 * @Since: 1.0
 */
public class problem22 {
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
		root.nxt.nxt.nxt.nxt.nxt = new ListNode();
		root.nxt.nxt.nxt.nxt.nxt.val = 6;
		int k = 4;
		ListNode findKthToTail = findKthToTail(root, k);
		System.out.println(findKthToTail.val);
	}
	
	public static ListNode findKthToTail(ListNode head,int k) {
		if (head == null) {
			throw new RuntimeException("����Ϊ��");
		}
		if (k == 0) {
			throw new RuntimeException("������0��������");
		}
		//p1��ǰ��k-1��
		ListNode node1 = head;
		ListNode node2 = head;
		for (int i = 1; i <= k-1; i++) {
			if (node1.nxt!=null) {
				node1 = node1.nxt;
			}else {
				throw new RuntimeException("k���������ȣ�������");
			}
		}
		//p1��p2������ߣ�ֱ��p1�ߵ�ĩβ
		while (node1.nxt!=null) {
			node1 = node1.nxt;
			node2 = node2.nxt;
		}
		return node2;
	}
}
