package com.offer.chapter3;

import com.offer.chapter2.problem6.ListNode;

/**
 * 反转链表
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月12日
 * @Since: 1.0
 */
public class problem24 {
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
		ListNode reverseList = reverseList(root);
		while (reverseList!=null) {
			System.out.print(reverseList.val+" ");
			reverseList = reverseList.nxt;
		}
		System.out.println();
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.nxt == null) {
			return head;
		}
		ListNode pre = null, node = head, post = null;
		while (node != null) {
			post = node.nxt;
			node.nxt = pre;
			pre = node;
			node = post;
		}
		return pre;
	}
}
