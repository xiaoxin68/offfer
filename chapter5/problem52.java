package com.offer.chapter5;
/**
 * 两个链表的第一个公共节点
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月26日
 * @Since: 1.0
 */
public class problem52 {
	
	public ListNode FindFirstCommonNode(ListNode pHead1,ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		int len1 = getLenOfListNode(pHead1);
		int len2 = getLenOfListNode(pHead2);
		int dis = Math.abs(len1 - len2);
		
		ListNode node1 = pHead1,node2 = pHead2;
		if (len1 > len2) {
			while (dis > 0) {
				node1 = node1.next;
				dis--;
			}
		}
		if (len1 < len2) {
			while (dis > 0) {
				node2 = node2.next;
				dis--;
			}
		}
		while (node1!=null && node2!=null) {
			if (node1 == node2) {
				return node1;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		return null;
	}

	int getLenOfListNode(ListNode head) {
		int count = 0;
		ListNode node = head;
		while (node !=null) {
			count++;
			node = node.next;
		}
		return count;
	}
}
class ListNode{
	int val;
	ListNode next;
}
