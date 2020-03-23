package com.offer.chapter5;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * 把数组排成最小的数
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月26日
 * @Since: 1.0
 */
public class problem45 {
	
	@Test
	public void test() {
		int []num = {1,5,4,2,3,4};
		System.out.println(PrintMinNumber(num));
		
		String []arr = {"sqqe","s","sa","sb","sbc","sabb"};
		System.out.println(PrintMinNumber(arr));
	}
	
	public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
	
	
	public String PrintMinNumber(String [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        StringBuilder sb = new StringBuilder();
        Arrays.sort(numbers,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(numbers[i]);
        }
        return sb.toString();
    }
}
