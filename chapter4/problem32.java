package com.offer.chapter4;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月14日
 * @Since: 1.0
 */
public class problem32 {
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
		
		printFromTopToBottom(tree);
	}
	
	/**
	 * 从上到下打印二叉树
	 * 
	 * @param tree
	 */
	public static void printFromTopToBottom(BinaryTreeNode tree) {
		if (tree == null) {
			return;
		}
		Queue<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();
		//进队列
		queue.add(tree);
		while (!queue.isEmpty()) {
			//出队列
			BinaryTreeNode poll = queue.poll();
			//打印当前节点
			System.out.print(poll.val+",");
			if (poll.left != null) {
				queue.add(poll.left);
			}
			if (poll.right != null) {
				queue.add(poll.right);
			}
		}
	}
}
