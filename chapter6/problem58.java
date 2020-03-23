package com.offer.chapter6;

import org.junit.Test;

/**
 * ��ת�ַ���
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��27��
 * @Since: 1.0
 */
public class problem58 {
	
	@Test
	public void test() {
		System.out.println(ReverseSentence("I am a student."));
	}
	
	/**
	 * ��ת�ַ���
	 * 
	 * @param str
	 * @return
	 */
	public String ReverseSentence(String str) {
        if(str == null || str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = a.length-1; i >=0;i--){
            o.append(a[i]);
            if(i != 0){
                o.append(" ");
            }
        }
        return o.toString();
    }
}
