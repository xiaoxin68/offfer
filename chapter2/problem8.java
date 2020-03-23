package com.offer.chapter2;

import com.offer.chapter2.problem7.BinaryTreeNode;
/**
 * ����������һ���ڵ�
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��14��
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
			// ���һ���ڵ�������������ô������һ���ڵ����������������ڵ�
			if (find.right != null) {
				result = find.right;
				while (result.left != null) {
					result = result.left;
				}
			} else if (find.right ==null && find.parent != null) {// ��ʾ��ǰ�ڵ�û��������
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
