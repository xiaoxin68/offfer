package com.offer.chapter4;

import org.junit.Test;

/**
 * 二叉搜索树与双向链表
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月23日
 * @Since: 1.0
 */
//解题思路：
//1.将左子树构造成双链表，并返回链表头节点。
//2.定位至左子树双链表最后一个节点。
//3.如果左子树链表不为空的话，将当前root追加到左子树链表。
//4.将右子树构造成双链表，并返回链表头节点。
//5.如果右子树链表不为空的话，将该链表追加到root节点之后。
//6.根据左子树链表是否为空确定返回的节点。
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
		//将左子树构造成双链表，并返回链表头节点。
		BinaryTreeNode leftTree = convertTreeToNode(head.left);
		//定位至左子树双链表最后一个节点。
		BinaryTreeNode p = leftTree;
		while (p!=null && p.right!=null) {
			p = p.right;
		}
		//如果左子树链表不为空的话，将当前root追加到左子树链表。
		if (leftTree!=null) {
			p.right = head;
			head.left = p;
		}
		//将右子树构造成双链表，并返回链表头节点。
		BinaryTreeNode rightTree = convertTreeToNode(head.right);
		//如果右子树链表不为空的话，将该链表追加到root节点之后。
		if (rightTree!=null) {
			head.right = rightTree;
			rightTree.left = head;
		}
		//根据左子树链表是否为空确定返回的节点。
		return leftTree!=null?leftTree:head;
	}
}

