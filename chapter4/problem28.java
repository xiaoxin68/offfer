package com.offer.chapter4;
/**
 * 对称二叉树
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月14日
 * @Since: 1.0
 */
public class problem28 {

	public static void main(String[] args) {
		BinaryTreeNode tree = new BinaryTreeNode();
		tree.val = 8;
		tree.left = new BinaryTreeNode();
		tree.left.val = 6;
		tree.right = new BinaryTreeNode();
		tree.right.val = 6;
		
		tree.left.left = new BinaryTreeNode();
		tree.left.left.val = 5;
		tree.left.right = new BinaryTreeNode();
		tree.left.right.val = 7;
		
		tree.right.left = new BinaryTreeNode();
		tree.right.left.val = 7;
		tree.right.right = new BinaryTreeNode();
		tree.right.right.val = 5;
		
		System.out.println(isSymmetrical(tree));
	}
	
	public static boolean isSymmetrical(BinaryTreeNode node) {
		if (node == null) {
			return false;
		}
		return isSymmetrical(node.left, node.right);
	}
	
	/**
	 * 判断是否是对称二叉树
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public static boolean isSymmetrical(BinaryTreeNode left,BinaryTreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left!=null && right!=null) {
			if (left.val == right.val) {
				return isSymmetrical(left.left,right.right)
						&& isSymmetrical(left.right,right.left);
			}
		}
		return false;
	}
}
