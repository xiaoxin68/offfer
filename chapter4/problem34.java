package com.offer.chapter4;
/**
 * 二叉树中和为某一值的路径
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月23日
 * @Since: 1.0
 */

import java.util.ArrayList;

import org.junit.Test;

public class problem34 {
	@Test
	public void test() {
		BinaryTreeNode tree = new BinaryTreeNode();
		tree.val = 10;
		tree.left = new BinaryTreeNode();
		tree.left.val = 5;
		tree.right = new BinaryTreeNode();
		tree.right.val = 12;
		
		tree.left.left = new BinaryTreeNode();
		tree.left.left.val = 4;
		tree.left.right = new BinaryTreeNode();
		tree.left.right.val = 7;
		
		getAllEqualPath(tree, 22);
		
		System.out.println(allList.size());
	}
	
	private ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private void getAllEqualPath(BinaryTreeNode tree,int target) {
		if (tree == null) {
			return ;
		}
		list.add(tree.val);
		target -= tree.val;
		if (target == 0 && tree.left==null && tree.right==null) {
			allList.add(new ArrayList<Integer>(list));
		}
		getAllEqualPath(tree.left, target);
		getAllEqualPath(tree.right, target);
		list.remove(list.size()-1);
	}
}
