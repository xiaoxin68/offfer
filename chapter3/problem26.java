package com.offer.chapter3;
/**
 * 树的子结构
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月12日
 * @Since: 1.0
 */
public class problem26 {
	public static void main(String[] args) {
		BinaryTreeNode tree = new BinaryTreeNode();
		tree.val = 8;
		tree.left = new BinaryTreeNode();
		tree.left.val = 8;
		tree.right = new BinaryTreeNode();
		tree.right.val = 7;
		
		tree.left.left = new BinaryTreeNode();
		tree.left.left.val = 9;
		tree.left.right = new BinaryTreeNode();
		tree.left.right.val = 2;
		
		tree.left.right.left = new BinaryTreeNode();
		tree.left.right.left.val = 4;
		
		BinaryTreeNode sub = new BinaryTreeNode();
		sub.val = 8;
		sub.left = new BinaryTreeNode();
		sub.left.val = 9;
		sub.right = new BinaryTreeNode();
		sub.right.val = 3;
	
		System.out.println(hasSubTree(tree, sub));
	}
	
	/**
	 * 循环判断是否含有树的子结构
	 * 
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public static boolean hasSubTree(BinaryTreeNode tree1,BinaryTreeNode tree2) {
		boolean result = false;
		if (tree1!= null && tree2!=null) {
			if (equal(tree1.val, tree2.val)) {
				result = doesTree1HasTree2(tree1,tree2);
			}
			if (!result) {
				result = hasSubTree(tree1.left, tree2) 
						|| hasSubTree(tree1.right, tree2);
			}
		}
		return result;
	}
	
	/**
	 * 具体判断过程
	 * 
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	private static boolean doesTree1HasTree2(BinaryTreeNode tree1, BinaryTreeNode tree2) {
		if (tree2 == null) {
			return true;
		}
		if (tree1 == null) {
			return false;
		}
		if (!equal(tree1.val, tree2.val)) {
			return false;
		}
		return doesTree1HasTree2(tree1.left, tree2.left) && doesTree1HasTree2(tree1.right, tree2.right);
	}

	/**
	 * 比较dubbo类型的数据是否相等
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static boolean equal(double num1,double num2) {
		double dis=1e-6;
		return Math.abs(num1-num2)<dis;
	}
}

class BinaryTreeNode{
	public double val;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
}
