package com.offer.chapter4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * �������ľ���
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��12��
 * @Since: 1.0
 */
public class problem27 {
	public static void main(String[] args) {
		BinaryTreeNode tree = new BinaryTreeNode();
		tree.val = 8;
		tree.left = new BinaryTreeNode();
		tree.left.val = 6;
		tree.right = new BinaryTreeNode();
		tree.right.val = 10;
		
		tree.left.left = new BinaryTreeNode();
		tree.left.left.val = 5;
		tree.left.right = new BinaryTreeNode();
		tree.left.right.val = 7;
		
		tree.right.left = new BinaryTreeNode();
		tree.right.left.val = 9;
		tree.right.right = new BinaryTreeNode();
		tree.right.right.val = 11;
		
		prePrintTree(tree);//����������ԭ������
		mirrorRecursively(tree);
		System.out.println();
		prePrintTree(tree);//�����������������ľ���
		
	}
	
	/**
	 * ����������������
	 * 
	 * @param tree
	 */
	public static void prePrintTree(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.val + " ");
			prePrintTree(node.left);
			prePrintTree(node.right);
		}
	}
	
	/**
	 * �������ľ���
	 * 
	 * @param tree
	 */
	public static void mirrorRecursively(BinaryTreeNode tree) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null) {
			return;
		}
		BinaryTreeNode temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		
		if (tree.left!=null) {
			mirrorRecursively(tree.left);
		}
		if (tree.right!=null) {
			mirrorRecursively(tree.right);
		}
		
	}
}

class BinaryTreeNode{
	public int val;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
}
