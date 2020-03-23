package com.offer.chapter2;

/**
 * 重建二叉树
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月23日
 * @Since: 1.0
 */
public class problem7 {
	public static void main(String[] args) {
		int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		int[] postorder = {7 ,4 ,2 ,5, 8, 6, 3 ,1  };
//		BinaryTreeNode root = construct(preorder, inorder);// 通过先序和中序构造二叉树
//		postPrintTree(root);
//
//		System.out.println();

		BinaryTreeNode root2 = construct2(postorder, inorder);// 通过中序和后序构造二叉树
		inPrintTree(root2);
	}

	public static class BinaryTreeNode {
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}

	// 先序遍历输出
	public static void prePrintTree(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.value + " ");
			prePrintTree(node.left);
			prePrintTree(node.right);

		}
	}

	// 中序遍历输出
	public static void inPrintTree(BinaryTreeNode node) {
		if (node != null) {
			inPrintTree(node.left);
			System.out.print(node.value + " ");
			inPrintTree(node.right);
		}
	}

	// 后序遍历输出
	public static void postPrintTree(BinaryTreeNode node) {
		if (node != null) {
			postPrintTree(node.left);
			postPrintTree(node.right);
			System.out.print(node.value + " ");
		}
	}

	// ==========================通过中序和后序构造二叉树======================================
	public static BinaryTreeNode construct2(int[] postorder, int[] inorder) {
		// 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
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

	// ==========================通过中序和后序构造二叉树======================================

	// ==========================通过先序和中序构造二叉树======================================
	public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
		// 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
		if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
			return null;
		}
		return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		// 开始位置大于结束位置说明已经没有需要处理的元素了
		if (ps > pe) {
			return null;
		}
		int value = preorder[ps];
		int index = is;
		while (index <= ie && inorder[index] != value) {
			index++;
		}
		// 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
		if (index > ie) {
			throw new RuntimeException("Invalid input");
		}
		// 创建当前的根结点，并且为结点赋值
		BinaryTreeNode node = new BinaryTreeNode();
		node.value = value;

		// 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
		// 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
		// 左子树对应的中序遍历的位置在[is, index-1]
		node.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
		// 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
		// 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
		// 右子树对应的中序遍历的位置在[index+1, ie]
		node.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);

		// 返回创建的根结点
		return node;
	}
	// ==========================通过先序和中序构造二叉树======================================

}
