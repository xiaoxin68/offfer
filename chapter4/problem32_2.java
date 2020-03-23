package com.offer.chapter4;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 分行从上到下打印二叉树
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月14日
 * @Since: 1.0
 */
public class problem32_2 {
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
	 * 分行从上到下打印二叉树
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
		int nextLevel = 0;//表示下一层节点数目
		int toBePrinted = 1;//表示当前层还没有打印的节点数
		while (!queue.isEmpty()) {
			//出队列
			BinaryTreeNode poll = queue.poll();
			//打印当前节点
			System.out.print(poll.val+" ");
			toBePrinted--;
			if (poll.left != null) {
				queue.add(poll.left);
				nextLevel++;
			}
			if (poll.right != null) {
				queue.add(poll.right);
				nextLevel++;
			}
			if (toBePrinted == 0) {
				System.out.println();
				toBePrinted = nextLevel;
				nextLevel = 0;
			}
		}
	}
}
