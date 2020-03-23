package com.offer.chapter2;

/**
 * �ؽ�������
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019��12��23��
 * @Since: 1.0
 */
public class problem7 {
	public static void main(String[] args) {
		int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		int[] postorder = {7 ,4 ,2 ,5, 8, 6, 3 ,1  };
//		BinaryTreeNode root = construct(preorder, inorder);// ͨ������������������
//		postPrintTree(root);
//
//		System.out.println();

		BinaryTreeNode root2 = construct2(postorder, inorder);// ͨ������ͺ����������
		inPrintTree(root2);
	}

	public static class BinaryTreeNode {
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}

	// ����������
	public static void prePrintTree(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.value + " ");
			prePrintTree(node.left);
			prePrintTree(node.right);

		}
	}

	// ����������
	public static void inPrintTree(BinaryTreeNode node) {
		if (node != null) {
			inPrintTree(node.left);
			System.out.print(node.value + " ");
			inPrintTree(node.right);
		}
	}

	// ����������
	public static void postPrintTree(BinaryTreeNode node) {
		if (node != null) {
			postPrintTree(node.left);
			postPrintTree(node.right);
			System.out.print(node.value + " ");
		}
	}

	// ==========================ͨ������ͺ����������======================================
	public static BinaryTreeNode construct2(int[] postorder, int[] inorder) {
		// ����ĺϷ����жϣ��������鶼����Ϊ�գ����Ҷ������ݣ��������ݵ���Ŀ��ͬ
		if (postorder == null || inorder == null || postorder.length != inorder.length || inorder.length < 1) {
			return null;
		}
		return construct2(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public static BinaryTreeNode construct2(int[] postorder, int ps, int pe, int[] inorder, int is, int ie) {
		if (ps > pe) {
			return null;
		}
		int value = postorder[pe];
		int index = is;
		while (index <= ie && inorder[index] != value) {
			index++;
		}
		BinaryTreeNode node = new BinaryTreeNode();
		node.value = value;
		node.left = construct2(postorder, ps, pe - (ie - index) - 1, inorder, is, index - 1);
		node.right = construct2(postorder, pe - (ie - index), pe - 1, inorder, index + 1, ie);
		return node;
	}

	// ==========================ͨ������ͺ����������======================================

	// ==========================ͨ������������������======================================
	public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
		// ����ĺϷ����жϣ��������鶼����Ϊ�գ����Ҷ������ݣ��������ݵ���Ŀ��ͬ
		if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
			return null;
		}
		return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		// ��ʼλ�ô��ڽ���λ��˵���Ѿ�û����Ҫ�����Ԫ����
		if (ps > pe) {
			return null;
		}
		int value = preorder[ps];
		int index = is;
		while (index <= ie && inorder[index] != value) {
			index++;
		}
		// ������������������������û���ҵ���˵������Ĳ����ǲ��Ϸ��ģ��׳��쳣
		if (index > ie) {
			throw new RuntimeException("Invalid input");
		}
		// ������ǰ�ĸ���㣬����Ϊ��㸳ֵ
		BinaryTreeNode node = new BinaryTreeNode();
		node.value = value;

		// �ݹ鹹����ǰ����������������������Ԫ�ظ�����index-is+1��
		// ��������Ӧ��ǰ�������λ����[ps+1, ps+index-is]
		// ��������Ӧ�����������λ����[is, index-1]
		node.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
		// �ݹ鹹����ǰ����������������������Ԫ�ظ�����ie-index��
		// ��������Ӧ��ǰ�������λ����[ps+index-is+1, pe]
		// ��������Ӧ�����������λ����[index+1, ie]
		node.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);

		// ���ش����ĸ����
		return node;
	}
	// ==========================ͨ������������������======================================

}
