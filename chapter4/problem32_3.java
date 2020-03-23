package com.offer.chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * 之字形打印二叉树
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月14日
 * @Since: 1.0
 */
public class problem32_3 {
	public static void main(String[] args) {
		BinaryTreeNode tree = new BinaryTreeNode();
		tree.val = 1;
		tree.left = new BinaryTreeNode();
		tree.left.val = 2;
		tree.right = new BinaryTreeNode();
		tree.right.val = 3;

		tree.left.left = new BinaryTreeNode();
		tree.left.left.val = 4;
		tree.left.right = new BinaryTreeNode();
		tree.left.right.val = 5;

		tree.right.left = new BinaryTreeNode();
		tree.right.left.val = 6;
		tree.right.right = new BinaryTreeNode();
		tree.right.right.val = 7;

		// printFromTopToBottom(tree);

		//ArrayList<ArrayList<Integer>> resList = Print(tree);

		//System.out.println(resList.size());
	}

	public static void printFromTopToBottom(BinaryTreeNode tree) {
		if (tree == null) {
			return;
		}
		Stack<BinaryTreeNode> levels[] = new Stack[2];
		levels[0] = new Stack<BinaryTreeNode>();
		levels[1] = new Stack<BinaryTreeNode>();
		int current = 0;// 表示下一层节点数目
		int next = 1;// 表示当前层还没有打印的节点数
		levels[current].add(tree);
		while (!levels[0].isEmpty() || !levels[1].isEmpty()) {
			BinaryTreeNode node = levels[current].pop();
			System.out.print(node.val + " ");
			if (current == 0) {
				if (node.left != null) {
					levels[next].push(node.left);
				}
				if (node.right != null) {
					levels[next].push(node.right);
				}
			} else {
				if (node.right != null) {
					levels[next].push(node.right);
				}
				if (node.left != null) {
					levels[next].push(node.left);
				}
			}
			if (levels[current].isEmpty()) {
				System.out.println();
				current = 1 - current;
				next = 1 - next;
			}
		}
	}

	public ArrayList<ArrayList<Integer>> Print(BinaryTreeNode pRoot) {
		if (pRoot == null)
			return new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Stack<BinaryTreeNode> level[] = new Stack[2];
		level[0] = new Stack<BinaryTreeNode>();
		level[1] = new Stack<BinaryTreeNode>();
		int current = 0;
		int next = 1;
		level[current].push(pRoot);
		while (!level[0].isEmpty() || !level[1].isEmpty()) {
			// 输出当前层
			BinaryTreeNode pop = level[current].pop();
			temp.add(pop.val);
			if (current == 0) {
				if (pop.left != null) {
					level[next].push(pop.left);
				}
				if (pop.right != null) {
					level[next].push(pop.right);
				}
			} else {
				if (pop.right != null) {
					level[next].push(pop.right);
				}
				if (pop.left != null) {
					level[next].push(pop.left);
				}
			}
			if (level[current].isEmpty()) {
				result.add(new ArrayList<Integer>(temp));
				temp.clear();
				current = 1 - current;
				next = 1 - next;
			}
		}
		return result;
	}
}
