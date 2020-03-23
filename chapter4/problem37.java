package com.offer.chapter4;

import org.junit.Test;

/**
 * ���л�������
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��23��
 * @Since: 1.0
 */
public class problem37 {
	@Test
	public void test() {
		Tree tree = new Tree();
		tree.val = '1';
		tree.left = new Tree();
		tree.left.val = '2';
		tree.right = new Tree();
		tree.right.val = '3';

		tree.left.left = new Tree();
		tree.left.left.val = '4';

		tree.right.left = new Tree();
		tree.right.left.val = '5';
		tree.right.right = new Tree();
		tree.right.right.val = '6';

		String s = getSerialize(tree);
		System.out.println(s);

		Tree reverseSerialize = reverseSerialize(s);
		System.out.println(reverseSerialize);
	}

	private String getSerialize(Tree head) {
		if (head == null) {
			return "";
		}
		return serialize(head);
	}

	/**
	 * ���л�������
	 * 
	 * @param head
	 * @return
	 */
	private String serialize(Tree head) {
		StringBuffer sb = new StringBuffer();
		if (head == null) {
			sb.append("$");
			return sb.toString();
		} else {
			sb.append(head.val);
		}
		sb.append(serialize(head.left));
		sb.append(serialize(head.right));
		return sb.toString();
	}

	/**
	 * �����л�������
	 * 
	 * @param str
	 * @return
	 */
	private int index = -1;//ע������һ��Ҫ�����ȫ�ֱ���������������
	private Tree reverseSerialize(String str) {
		index++;
		if (index >= str.length()) {
			return null;
		}
		Tree node = null;
		if (str.charAt(index) != '$') {
			node = new Tree();
			node.val = str.charAt(index);
			node.left = reverseSerialize(str);
			node.right = reverseSerialize(str);
		}
		return node;
	}
}

class Tree {
	char val;
	Tree left;
	Tree right;
}
