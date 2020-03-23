package com.offer.chapter6;
/**
 * 圆圈中最后剩下的数字
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年3月4日
 * @Since: 1.0
 */
public class problem62 {
	
	public int LastRemaining_Solution(int n, int m) {
		if(n < 1 || m < 1) return -1;
        if(n == 1) return 1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
			last = (last+m)%i;
		}
        return last;
    }
}
