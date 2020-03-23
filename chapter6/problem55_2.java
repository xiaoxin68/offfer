package com.offer.chapter6;

import org.junit.Test;

/**
 * 判断二叉树是不是平衡二叉树
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月24日
 * @Since: 1.0
 */
public class problem55_2 {
	
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
		
//		tree.right.right = new BinaryTreeNode();
//		tree.right.right.val = 6;
		
		tree.left.right.left = new BinaryTreeNode();
		tree.left.right.left.val = 7;
		
		System.out.println(isBalancedTree(tree));
	}
	

	private boolean ret = true;
	public boolean isBalancedTree(BinaryTreeNode tree){
		height(tree);
		return ret;
	}
	private int height(BinaryTreeNode root) {
		if (ret == false)  return 0;
		if (root == null) return 0;
		int left = height(root.left);
		int right = height(root.right);
		//在计算高度的时候加一步判断就好了
		if (Math.abs(left-right) > 1) {
			ret = false;
		}
		return Math.max(left, right)+1;
	}
}
