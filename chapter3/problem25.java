package com.offer.chapter3;

import com.offer.chapter2.problem6.ListNode;

/**
 * �ϲ��������������
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��12��
 * @Since: 1.0
 */
public class problem25 {
	public static void main(String[] args) {
		ListNode head1 = new ListNode();
		head1.val = 1;
		head1.nxt = new ListNode();
		head1.nxt.val = 3;
		head1.nxt.nxt = new ListNode();
		head1.nxt.nxt.val = 5;
		head1.nxt.nxt.nxt = new ListNode();
		head1.nxt.nxt.nxt.val = 7;
		
		ListNode head2 = new ListNode();
		head2.val = 1;
		head2.nxt = new ListNode();
		head2.nxt.val = 4;
		head2.nxt.nxt = new ListNode();
		head2.nxt.nxt.val = 6;
		head2.nxt.nxt.nxt = new ListNode();
		head2.nxt.nxt.nxt.val = 8;
		head2.nxt.nxt.nxt.nxt = new ListNode();
		head2.nxt.nxt.nxt.nxt.val = 9;
		head2.nxt.nxt.nxt.nxt.nxt = new ListNode();
		head2.nxt.nxt.nxt.nxt.nxt.val = 11;
		
		ListNode merge = merge(head1,head2);
		while (merge!=null) {
			System.out.print(merge.val+" ");
			merge = merge.nxt;
		}
		System.out.println();
	}

	/**
	 * �ϲ������ź��������
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null ) {//�������ѭ�������ˣ���ֱ���˻���һ���ǿ�����ƴ���ں��漴��
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		ListNode head = null;
		if (head1.val <= head2.val) {
			head = head1;
			head.nxt = merge(head1.nxt, head2);//ÿ�εع��ź���һ���ڵ�
		} else {
			head = head2;
			head.nxt = merge(head1, head2.nxt);
		}

		return head;
	}
}
