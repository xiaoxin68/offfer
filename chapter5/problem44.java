package com.offer.chapter5;

import org.junit.Test;

import com.zxx.mid.b;

/**
 * 数字序列中的某一位数字
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月26日
 * @Since: 1.0
 */
public class problem44 {
	
	@Test
	public void test() {
		System.out.println(getIndexNum(1001));
	}
	
	public int getIndexNum(int n) {
		if (n<=0) {
			return -1;
		}
		int weishu = 1,base = 10;
		while (n > base) {
			weishu++;
			n -= base;
			base = (int)(Math.pow(10, weishu)-Math.pow(10, weishu-1))*weishu;
		}
		int zhengshu = n/weishu;
		int yushu = n%weishu;
		int temp = (weishu == 1 ? 0 :(int)Math.pow(10, weishu-1)) + zhengshu;
		if (yushu == 0) {
			return String.valueOf(temp-1).charAt(weishu-1)-'0';
		}else {
			return String.valueOf(temp).charAt(yushu-1)-'0';
		}
	}
}
