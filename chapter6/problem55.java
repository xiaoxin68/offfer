package com.offer.chapter6;

import org.junit.Test;

/**
 * 二叉树的深度
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月24日
 * @Since: 1.0
 */
public class problem55 {
	@Test
	public void test() {
		BinaryTreeNode tree = new BinaryTreeNode();
		tree.val = 5;
		tree.left = new BinaryTreeNode();
		tree.left.val = 3;
		tree.right = new BinaryTreeNode();
		tree.right.val = 7;
		
		tree.left.left = new BinaryTreeNode();
		tree.left.left.val = 2;
		tree.left.right = new BinaryTreeNode();
		tree.left.right.val = 4;
		
		tree.right.right = new BinaryTreeNode();
		tree.right.right.val = 6;
		
		tree.left.right.left = new BinaryTreeNode();
		tree.left.right.left.val = 6;
		
		System.out.println(getDeptOfTree(tree));
	}

	/**
	 * 二叉树的深度
	 * 
	 * @param tree
	 * @return
	 */
	public int getDeptOfTree(BinaryTreeNode tree){
		if (tree == null) {
			return 0;
		}
		int left = getDeptOfTree(tree.left);
		int right = getDeptOfTree(tree.right);
		return left>right?left+1:right+1;
	}
}
