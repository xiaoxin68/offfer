package com.offer.chapter3;

import com.offer.chapter2.problem6.ListNode;

/**
 * �����л�����ڽڵ�
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��12��
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
			System.out.println("�޻�");
		}
	}
	
	public static ListNode entryNodeOfLoop(ListNode head) {
		ListNode meetingNode = meetingNode(head);
		if (meetingNode == null) {
			return null;//û�л�
		}
		
		int nodesInLoop = 1;//��ȡ���нڵ���Ŀ
		ListNode temp = meetingNode;//�ýڵ�һ���ڻ���
		while (temp.nxt != meetingNode) {
			temp = temp.nxt;
			nodesInLoop++;
		}
		
		//���ƶ�p1������Ϊ���нڵ���Ŀ
		ListNode p1 = head,p2=head;
		for (int i = 1; i <= nodesInLoop; i++) {
			p1 = p1.nxt;
		}
		//ͬʱ�ƶ�p1��p2����һ�������ĵ㼴Ϊ��ڽڵ�
		while (p1 != p2) {
			p1 = p1.nxt;
			p2 = p2.nxt;
		}
		return p1;
	}

	/**
	 * �ҵ�һ��һ������ָ��������λ�� Ҳ���ǿ�������ȷ���������Ƿ���ڻ�
	 * 
	 * @return
	 */
	public static ListNode meetingNode(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head.nxt;// ����һ��
		if (slow == null)
			return null;
		ListNode fast = slow.nxt;// ��������
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
