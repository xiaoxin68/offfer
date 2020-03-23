package com.offer.chapter6;

import java.util.ArrayList;

import org.junit.Test;


/**
 * �����������ĵ�k��ڵ�
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��24��
 * @Since: 1.0
 */

public class problem54 {
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
		
		tree.right.left = new BinaryTreeNode();
		tree.right.left.val = 6;
		tree.right.right = new BinaryTreeNode();
		tree.right.right.val = 8;
		
		int k = 3;
		System.out.println(getKNum(tree, k));
	}
	
	/**
	 * ��ȡ��K�����
	 * 
	 * @param tree
	 * @param k
	 * @return
	 */
	public int getKNum(BinaryTreeNode tree,int k) {
		ArrayList<Integer> innerOrder = getInnerOrder(tree);
		if (innerOrder!=null && k>0 && k<=innerOrder.size()) {
			return innerOrder.get(k-1);
		}else {
			throw new RuntimeException("������������");
		}
	}

	
	/**
	 * ����������������������
	 * 
	 * @param tree
	 * @return
	 */
	private ArrayList<Integer> list = new ArrayList<Integer>();
	public ArrayList<Integer> getInnerOrder(BinaryTreeNode tree){
		if (tree == null) {
			return null;
		}
		getInnerOrder(tree.left);
		list.add(tree.val);
		getInnerOrder(tree.right);
		return list;
	}
}

class BinaryTreeNode{
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;
}
