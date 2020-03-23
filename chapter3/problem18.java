package com.offer.chapter3;

/**
 * ɾ������Ľڵ�
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��11��
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

	        head = deleteNode(head, null); // ɾ���Ľ��Ϊ��
	        printList(head);
	        

	        head = deleteNode(head, head); // ɾ��ͷ���
	        printList(head);
	        head = deleteNode(head, last); // ɾ��β���
	        printList(head);
	        head = deleteNode(head, middle); // ɾ���м���
	        printList(head);

	        ListNode node = new ListNode();
	        node.value = 12;
	        head = deleteNode(head, node); // ɾ���Ľ�㲻��������
	        printList(head);
	    }
	 public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {

	        // �����������п�ֵ�ͷ��ر�ͷ���
	        if (head == null || toBeDeleted == null) {
	            return head;
	        }

	        // ���ɾ������ͷ��㣬ֱ�ӷ���ͷ������һ�����
	        if (head == toBeDeleted) {
	            return head.next;
	        }

	        // �������������������������

	        // �ڶ���ڵ������£����ɾ���������һ��Ԫ��
	        if (toBeDeleted.next == null) {
	            // �Ҵ�ɾ��Ԫ�ص�ǰ��
	            ListNode tmp = head;
	            while (tmp.next !=null && tmp.next != toBeDeleted) {
	                tmp = tmp.next;
	            }
	            // ɾ�������
	            tmp.next = null;

	        }
	        // �ڶ���ڵ������£����ɾ������ĳ���м���
	        else {
	            // ����һ������ֵ���뵱ǰ��ɾ���Ľ��
	            toBeDeleted.value = toBeDeleted.next.value;
	            // ��ɾ���Ľ�����һ��ָ��ԭ�ȴ�ɾ�����ŵ����¸���㣬������ɾ������һ�����ɾ��
	            toBeDeleted.next = toBeDeleted.next.next;
	        }

	        // ����ɾ���ڵ�������ͷ���
	        return head;
	    }

	    /**
	     * ��������Ԫ��ֵ
	     *
	     * @param head �����ͷ���
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
