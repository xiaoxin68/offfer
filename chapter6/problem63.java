package com.offer.chapter6;
/**
 * 股票的最大利润
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年3月4日
 * @Since: 1.0
 */
public class problem63 {

	public static void main(String[] args) {
		int [] arr = {7,6,4,3,1};
		System.out.println(maxProfit(arr));
	}
	
	/**
	 * 股票的最大利润
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
