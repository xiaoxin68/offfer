package com.offer.chapter4;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

/**
 * 字符串的排列
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月23日
 * @Since: 1.0
 */
public class problem38 {
	
	@Test
	public void test() {
		ArrayList<String> permutation = getPermutation("abc");
		System.out.println(permutation.size());
	}

	public ArrayList<String> getPermutation(String A) {
		ArrayList<String> list = new ArrayList<>();
		permutation(list, A.toCharArray(), 0);
		Collections.sort(list);
		return list;
	}

	public void permutation(ArrayList<String> list, char[] array, int k) {
		if (k == array.length) {
			list.add(new String(array));
			return;
		}
		for (int i = k; i < array.length; i++) {
			swap(array, i, k);
			permutation(list, array, k + 1);
			swap(array, i, k);
		}
	}

	public void swap(char[] array, int i, int j) {
		if (i != j) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
}
