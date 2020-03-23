package com.offer.chapter6;
/**
 * ��Ʊ���������
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��3��4��
 * @Since: 1.0
 */
public class problem63 {

	public static void main(String[] args) {
		int [] arr = {7,6,4,3,1};
		System.out.println(maxProfit(arr));
	}
	
	/**
	 * ��Ʊ���������
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
        if (prices == null || prices.length<1) {
			return 0;
		}
        int maxDif = 0;
        int preMin = prices[0];
        for (int i = 0; i < prices.length; i++) {
			preMin = prices[i] < preMin ? prices[i]:preMin;
			int temp = prices[i] - preMin;
			maxDif = temp>maxDif ? temp:maxDif;
		}
        return maxDif;
    }
}
