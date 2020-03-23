package com.offer.chapter4;

import java.util.ArrayList;

import org.junit.Test;

/**
 * �ж������ǲ���ĳ�����������ĺ�������Ľ��
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��23��
 * @Since: 1.0
 */
public class problem33 {
	@Test
	public void test() {
		int [] sequence = {5,7,6,9,11,10,8};
		System.out.println(VerifySquenceOfBST(sequence));
		
	}
	
	 public boolean VerifySquenceOfBST(int [] sequence){
        return VerifySquenceOfBST(sequence,0,sequence.length);
    }
    public boolean VerifySquenceOfBST(int [] sequence,int begin,int end) {
        if(sequence == null || sequence.length <1) return false;
        int len = end;
        int root = sequence[len-1];
        int i=begin;
        for(;i<len-1;i++){
            if(sequence[i] > root){
              break;
           }
        }
        int j = i;
        for(;j<len-1;j++){
            if(sequence[j] < root){
                return false;
            }
        }
        boolean left = true;
        if(i > begin){//��ʾ��������
            left = VerifySquenceOfBST(sequence,begin,i);
        }
        boolean right = true;
        if(i<len-1){//��ʾ��������
            right = VerifySquenceOfBST(sequence,i,len-1);
        }
       return (left && right);
    }
}
