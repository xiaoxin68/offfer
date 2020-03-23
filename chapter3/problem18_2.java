package com.offer.chapter3;
/**
 * 删除链表中重复的节点
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月11日
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
	        
	        head = deleteChongFuNode(head); // 删除的结点为空
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
				idDelete = true;//表示需要删除
			}
			if (idDelete) {//删除节点
				//找到需要删除的位置
				ListNode delNode = node;
				int val = node.value;
				while(delNode!=null && delNode.value == val) {
					delNode = delNode.next;
				}
				if (preNode == null) {//如果前驱节点还未初始化，则head直接指向当前节点，中间的直接被删除了
					head = delNode;
				}else {//如前驱节点已存在，则前驱节点的下一个节点就是当前节点
					preNode.next = delNode;
				}
				node = delNode;
			}else {//不用删除
				preNode = node;//前驱节点指向下一个
				node = node.next;//当前节点指向下一个
			}
		}
		return head;
	 }
}
