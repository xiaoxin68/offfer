package com.offer.chapter6;

import org.junit.Test;

/**
 * ��1+2+����+n;
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��3��4��
 * @Since: 1.0
 */
public class problem64 {
	int Sum_Solution(int n) {
		int res = n;
		boolean flag = (n > 0) && ((res += Sum_Solution(n - 1)) > 0);
		return res;
	}
}
