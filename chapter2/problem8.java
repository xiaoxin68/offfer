package com.offer.chapter2;

import com.offer.chapter2.problem7.BinaryTreeNode;
/**
 * 二叉树的下一个节点
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月14日
 * @Since: 1.0
 */
public class problem8 {
	public static void main(String[] args) {
		
	}

	public static class BinaryTreeNode {
		char value;
		BinaryTreeNode left;
		BinaryTreeNode right;
		BinaryTreeNode parent;
	}

	public static BinaryTreeNode getNext(BinaryTreeNode root, BinaryTreeNode find) {
		BinaryTreeNode result = null;
		if (root != null && find != null) {
			// 如果一个节点有右子树，那么他的下一个节点就是右子树的最左节点
			if (find.right != null) {
				result = find.right;
				while (result.left != null) {
					result = result.left;
				}
			} else if (find.right ==null && find.parent != null) {// 表示当前节点没有右子树
				BinaryTreeNode pCurrent = find;
				BinaryTreeNode pParent = find.parent;
				while (pParent != null && pCurrent == pParent.right) {
					pCurrent = pParent;
					pParent = pParent.parent;
				}
				result = pParent;
			}
		}
		return result;
	}
}
