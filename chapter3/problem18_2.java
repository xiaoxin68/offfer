package com.offer.chapter3;
/**
 * ɾ���������ظ��Ľڵ�
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��11��
 * @Since: 1.0
 */
public class problem18_2 {
	public static void main(String[] args) {
		 	ListNode head = new ListNode();
	        head.value = 1;

	        head.next = new ListNode();
	        head.next.value = 2;

	        head.next.next = new ListNode();
	        head.next.next.value = 3;

	        head.next.next.next = new ListNode();
	        head.next.next.next.value = 3;

	        head.next.next.next.next = new ListNode();
	        head.next.next.next.next.value = 3;

	        head.next.next.next.next.next = new ListNode();
	        head.next.next.next.next.next.value = 4;

	        head.next.next.next.next.next.next = new ListNode();
	        head.next.next.next.next.next.next.value = 4;

	        head.next.next.next.next.next.next.next = new ListNode();
	        head.next.next.next.next.next.next.next.value = 4;

	        head.next.next.next.next.next.next.next.next = new ListNode();
	        head.next.next.next.next.next.next.next.next.value = 4;
	        
	        head = deleteChongFuNode(head); // ɾ���Ľ��Ϊ��
	        problem18.printList(head);

	}
	
	 public static ListNode deleteChongFuNode(ListNode head) {
		 if (head == null) {
			return head;
		}
		ListNode preNode = null;
		ListNode node = head;
		while (node!=null) {
			boolean idDelete = false;
			ListNode nextNode = node.next;
			if (nextNode!=null && node.value == nextNode.value) {
				idDelete = true;//��ʾ��Ҫɾ��
			}
			if (idDelete) {//ɾ���ڵ�
				//�ҵ���Ҫɾ����λ��
				ListNode delNode = node;
				int val = node.value;
				while(delNode!=null && delNode.value == val) {
					delNode = delNode.next;
				}
				if (preNode == null) {//���ǰ���ڵ㻹δ��ʼ������headֱ��ָ��ǰ�ڵ㣬�м��ֱ�ӱ�ɾ����
					head = delNode;
				}else {//��ǰ���ڵ��Ѵ��ڣ���ǰ���ڵ����һ���ڵ���ǵ�ǰ�ڵ�
					preNode.next = delNode;
				}
				node = delNode;
			}else {//����ɾ��
				preNode = node;//ǰ���ڵ�ָ����һ��
				node = node.next;//��ǰ�ڵ�ָ����һ��
			}
		}
		return head;
	 }
}
