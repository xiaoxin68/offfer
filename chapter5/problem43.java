package com.offer.chapter5;

import org.junit.Test;

/**
 * 1-n整数中1出现的次数
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月24日
 * @Since: 1.0
 */
public class problem43 {
	@Test
	public void test() {
		System.out.println(count(10));
	}

	public int count(int n){
	    if(n<1)
	        return 0;
	    int count = 0;
	    int base = 1;
	    int round = n;
	    while(round>0){
	        int weight = round%10;
	        round/=10;
	        count += round*base;
	        if(weight==1)
	            count+=(n%base)+1;
	        else if(weight>1)
	            count+=base;
	        base*=10;
	    }
	    return count;
	}
}
