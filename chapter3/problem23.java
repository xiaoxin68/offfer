package com.offer.chapter3;

import com.offer.chapter2.problem6.ListNode;

/**
 * 链表中环的入口节点
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月12日
 * @Since: 1.0
 */
public class problem23 {
	public static void main(String[] args) {
		ListNode node1 = new ListNode();
		node1.val = 1;

		ListNode node2 = new ListNode();
		node2.val = 2;

		ListNode node3 = new ListNode();
		node3.val = 3;

		ListNode node4 = new ListNode();
		node4.val = 4;

		ListNode node5 = new ListNode();
		node5.val = 5;

		ListNode node6 = new ListNode();
		node6.val = 6;

		node1.nxt = node2;
		node2.nxt = node3;
		node3.nxt = node4;
		node4.nxt = node5;
		node5.nxt = node6;
		node6.nxt = node2;

		ListNode entryNodeOfLoop = entryNodeOfLoop(node1);
		
		if (entryNodeOfLoop != null) {
			System.out.println(entryNodeOfLoop.val);
		}else {
			System.out.println("无环");
		}
	}
	
	public static ListNode entryNodeOfLoop(ListNode head) {
		ListNode meetingNode = meetingNode(head);
		if (meetingNode == null) {
			return null;//没有环
		}
		
		int nodesInLoop = 1;//获取环中节点数目
		ListNode temp = meetingNode;//该节点一定在环中
		while (temp.nxt != meetingNode) {
			temp = temp.nxt;
			nodesInLoop++;
		}
		
		//先移动p1，次数为环中节点数目
		ListNode p1 = head,p2=head;
		for (int i = 1; i <= nodesInLoop; i++) {
			p1 = p1.nxt;
		}
		//同时移动p1和p2，第一次相遇的点即为入口节点
		while (p1 != p2) {
			p1 = p1.nxt;
			p2 = p2.nxt;
		}
		return p1;
	}

	/**
	 * 找到一快一慢连个指针相遇的位置 也就是可以用来确定链表中是否存在环
	 * 
	 * @return
	 */
	public static ListNode meetingNode(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head.nxt;// 走了一步
		if (slow == null)
			return null;
		ListNode fast = slow.nxt;// 走了两步
		while (slow != null && fast != null) {
			if (slow == fast) {
				return fast;
			}
			slow = slow.nxt;
			fast = fast.nxt;
			if (fast != null) {
				fast = fast.nxt;
			}
		}
		return null;
	}
}
