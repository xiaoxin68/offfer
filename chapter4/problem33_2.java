package com.offer.chapter4;
/**
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��3��3��
 * @Since: 1.0
 */
public class problem33_2 {

	private boolean ret = true;
    public boolean IsBalanced_Solution(BinaryTreeNode root) {
        heightTree(root);
        return ret;
    }
    public int heightTree(BinaryTreeNode root) {
        if (ret == false)  return 0;
		if (root == null) return 0;
        int left = heightTree(root.left);
        int right = heightTree(root.right);
        if (Math.abs(left-right) > 1) {
			ret = false;
		}
        return Math.max(left, right)+1;
    }
}
