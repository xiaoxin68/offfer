package com.offer.chapter5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 最长不含重复字符的子字符串??????????
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月26日
 * @Since: 1.0
 */
public class problem48 {

	@Test
	public void test() {
		System.out.println(lengthOfLongestSubstring("abbabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("abbbbb"));

		System.out.println("========================");

		System.out.println(lengthOfLongestSubstring1("abbabcbb"));
		System.out.println(lengthOfLongestSubstring1("bbbbb"));
		System.out.println(lengthOfLongestSubstring1("abbbbb"));
	}

	public int lengthOfLongestSubstring1(String s) {
		int len = 0;
		Set<Character> sub = new HashSet<>();
		int begin = 0, index = 0;
		while (begin < s.length() && index < s.length()) {
			if (sub.contains(s.charAt(index))) {
				sub.remove(s.charAt(begin++));
			} else {
				sub.add(s.charAt(index));
				index++;
				len = Math.max(len, index - begin);
			}
		}
		return len;
	}

	public int lengthOfLongestSubstring(String s) {
		int len = 0;
		Map<Character, Integer> sub = new HashMap<>();
		int begin = 0, index = 0;
		while (begin < s.length() && index < s.length()) {
			if (sub.containsKey(s.charAt(index))) {
				// 应该保证滑动窗口的起始位置依次向前，不能倒退
				begin = Math.max(begin, sub.get(s.charAt(index)) + 1);// Math.max的作用 ：考虑字符串abba这个例子
			}
			sub.put(s.charAt(index), index);
			index++;
			len = Math.max(len, index - begin);

		}
		return len;
	}

}
