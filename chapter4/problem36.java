package com.offer.chapter4;

import org.junit.Test;

/**
 * ������������˫������
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��23��
 * @Since: 1.0
 */
//����˼·��
//1.�������������˫��������������ͷ�ڵ㡣
//2.��λ��������˫�������һ���ڵ㡣
//3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
//4.�������������˫��������������ͷ�ڵ㡣
//5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
//6.���������������Ƿ�Ϊ��ȷ�����صĽڵ㡣
public class problem36 {
	
	@Test 
	public void test() {
		BinaryTreeNode tree = new BinaryTreeNode();
		tree.val = 10;
		tree.left = new BinaryTreeNode();
		tree.left.val = 6;
		tree.right = new BinaryTreeNode();
		tree.right.val = 14;
		
		tree.left.left = new BinaryTreeNode();
		tree.left.left.val = 4;
		tree.left.right = new BinaryTreeNode();
		tree.left.right.val = 8;
		
		tree.right.left = new BinaryTreeNode();
		tree.right.left.val = 12;
		tree.right.right = new BinaryTreeNode();
		tree.right.right.val = 16;
		
		BinaryTreeNode convertTreeToNode = convertTreeToNode(tree);
		
		System.out.println(convertTreeToNode);
	}
	
	
	
	private BinaryTreeNode convertTreeToNode(BinaryTreeNode head) {
		if (head == null || (head.left==null && head.right==null)) {
			return head;
		}
		//�������������˫��������������ͷ�ڵ㡣
		BinaryTreeNode leftTree = convertTreeToNode(head.left);
		//��λ��������˫�������һ���ڵ㡣
		BinaryTreeNode p = leftTree;
		while (p!=null && p.right!=null) {
			p = p.right;
		}
		//�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
		if (leftTree!=null) {
			p.right = head;
			head.left = p;
		}
		//�������������˫��������������ͷ�ڵ㡣
		BinaryTreeNode rightTree = convertTreeToNode(head.right);
		//�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
		if (rightTree!=null) {
			head.right = rightTree;
			rightTree.left = head;
		}
		//���������������Ƿ�Ϊ��ȷ�����صĽڵ㡣
		return leftTree!=null?leftTree:head;
	}
}

