package com.offer.chapter5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * 第一个只出现一次的字符
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月26日
 * @Since: 1.0
 */
public class problem50 {

	@Test
	public void test() {
		System.out.println(getFirstOne("adaccbeff"));
		System.out.println(FirstNotRepeatingChar("adaccbeff"));
	}
	
	
	
	/**
	 * 方式一
	 * 
	 * @param str
	 * @return
	 */
	char getFirstOne(String str) {
		if (str == null || "".equals(str)) {
			return '#';
		}
		Map<Character,Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			}else {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
		}
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		Iterator<Entry<Character, Integer>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<Character, Integer> next = iterator.next();
			if (next.getValue() == 1) {
				return next.getKey();
			}
		}
		return '#';
	}
	
	/**
	 * 方式二
	 * 
	 * @param str
	 * @return
	 */
	int[] hashtable = new int[256];
    public char FirstNotRepeatingChar(String str) {
        if(str == null || "".equals(str)) return '#';
        for(int i = 0;i < str.length();i++){
           hashtable[str.charAt(i)]++;
         }
         for(int i = 0;i < str.length();i++){
           if (hashtable[str.charAt(i)] == 1) return str.charAt(i);
         }
         return '#';
    }
}
