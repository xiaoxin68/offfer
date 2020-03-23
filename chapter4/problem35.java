package com.offer.chapter4;

import org.junit.Test;

/**
 * 复杂链表复制
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月23日
 * @Since: 1.0
 */
public class problem35 {
	@Test
	public void test() {
		ComplexListNode node1 = new ComplexListNode();
		node1.val = 1;
		
		ComplexListNode node2 = new ComplexListNode();
		node2.val = 2;
		
		ComplexListNode node3 = new ComplexListNode();
		node3.val = 3;
		
		ComplexListNode node4 = new ComplexListNode();
		node4.val = 4;
		
		ComplexListNode node5 = new ComplexListNode();
		node5.val = 5;

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		node1.sibling = node3;
		node4.sibling = node2;
		node5.sibling = node2;
		
		ComplexListNode copy = copyComplexNode(node1);
	}
	
	public ComplexListNode copyComplexNode(ComplexListNode head) {
		if (head == null || head.next==null) {
			return head;
		}
		head = copyNext(head);
		head = connectSiblingNode(head);
		ComplexListNode[] list = divideIntoTwoComplexNode(head);
		System.out.println(list.length);
		return list[1];
	}
	
	/**
	 * 复制next链表
	 * 
	 * @param head
	 * @return
	 */
	private ComplexListNode copyNext(ComplexListNode head) {
		ComplexListNode node = head;
		while (node!=null) {
			//新增node节点
			ComplexListNode copyNode = new ComplexListNode();
			copyNode.val = node.val;
			copyNode.next = node.next;
			copyNode.sibling = null;
			node.next = copyNode;
			node = copyNode.next;
		}
		return head;
	}
	
	/**
	 * 复制sibling节点
	 * 
	 * @param head
	 * @return
	 */
	public ComplexListNode connectSiblingNode(ComplexListNode head) {
		ComplexListNode node = head;
		while (node!=null) {
			ComplexListNode nodeSibling = node.sibling;
			if (nodeSibling!=null) {
				node.next.sibling = nodeSibling.next;
			}
			node = node.next.next;
		}
		return head;
	}
	
	/**
	 * 拆分成两步分，偶数部分串起来就是一个复制链表
	 * 
	 * @param head
	 * @return
	 */
	public ComplexListNode[] divideIntoTwoComplexNode(ComplexListNode head) {
		ComplexListNode[] list = new ComplexListNode[2];
		// 变成两个List
		ComplexListNode node1 = null;
		ComplexListNode node2 = null;

		ComplexListNode head1 = null;
		ComplexListNode head2 = null;
		boolean odd = true;
		while (head != null) {
			if (odd) {
				if (node1 == null) {
					node1 = head;
					head1 = node1;
				} else {
					node1.next = head;
					node1 = node1.next;
				}
			} else {
				if (node2 == null) {
					node2 = head;
					head2 = node2;
				} else {
					node2.next = head;
					node2 = node2.next;
				}
			}
			head = head.next;
			odd = !odd;
		}
		//这两句话很重要
		node1.next = null;
		node2.next = null;
		
		list[0]=head1;
		list[1]=head2;
		
		return list;
	}
}
class ComplexListNode{
	int val;
	ComplexListNode next;
	ComplexListNode sibling;
}
