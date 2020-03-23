package com.offer.chapter3;

/**
 * 删除链表的节点
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月11日
 * @Since: 1.0
 */
public class problem18 {
	  public static void main(String[] args) {
	        ListNode head = new ListNode();
	        head.value = 1;

	        head.next = new ListNode();
	        head.next.value = 2;

	        head.next.next = new ListNode();
	        head.next.next.value = 3;

	        head.next.next.next = new ListNode();
	        head.next.next.next.value = 4;

	        ListNode middle = head.next.next.next.next = new ListNode();
	        head.next.next.next.next.value = 5;

	        head.next.next.next.next.next = new ListNode();
	        head.next.next.next.next.next.value = 6;

	        head.next.next.next.next.next.next = new ListNode();
	        head.next.next.next.next.next.next.value = 7;

	        head.next.next.next.next.next.next.next = new ListNode();
	        head.next.next.next.next.next.next.next.value = 8;

	        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
	        head.next.next.next.next.next.next.next.next.value = 9;

	        head = deleteNode(head, null); // 删除的结点为空
	        printList(head);
	        

	        head = deleteNode(head, head); // 删除头结点
	        printList(head);
	        head = deleteNode(head, last); // 删除尾结点
	        printList(head);
	        head = deleteNode(head, middle); // 删除中间结点
	        printList(head);

	        ListNode node = new ListNode();
	        node.value = 12;
	        head = deleteNode(head, node); // 删除的结点不在链表中
	        printList(head);
	    }
	 public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {

	        // 如果输入参数有空值就返回表头结点
	        if (head == null || toBeDeleted == null) {
	            return head;
	        }

	        // 如果删除的是头结点，直接返回头结点的下一个结点
	        if (head == toBeDeleted) {
	            return head.next;
	        }

	        // 下面的情况链表至少有两个结点

	        // 在多个节点的情况下，如果删除的是最后一个元素
	        if (toBeDeleted.next == null) {
	            // 找待删除元素的前驱
	            ListNode tmp = head;
	            while (tmp.next !=null && tmp.next != toBeDeleted) {
	                tmp = tmp.next;
	            }
	            // 删除待结点
	            tmp.next = null;

	        }
	        // 在多个节点的情况下，如果删除的是某个中间结点
	        else {
	            // 将下一个结点的值输入当前待删除的结点
	            toBeDeleted.value = toBeDeleted.next.value;
	            // 待删除的结点的下一个指向原先待删除引号的下下个结点，即将待删除的下一个结点删除
	            toBeDeleted.next = toBeDeleted.next.next;
	        }

	        // 返回删除节点后的链表头结点
	        return head;
	    }

	    /**
	     * 输出链表的元素值
	     *
	     * @param head 链表的头结点
	     */
	    public static void printList(ListNode head) {
	        while (head != null) {
	            System.out.print(head.value + "->");
	            head = head.next;
	        }
	        System.out.println("null");
	    }

	  
	}

class ListNode {
	int value;
	ListNode next;
}
