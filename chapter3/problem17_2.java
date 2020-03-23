package com.offer.chapter3;

/**
 * ʵ���������������ļӷ�
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��11��
 * @Since: 1.0
 */
public class problem17_2 {
	public static void main(String[] args) {
		String str1 = "123459";
		String str2 = "123";
		System.out.println(add(str1, str2));// 123582
		System.out.println(add2(str1, str2));// 123582
	}

	private static String add(String str1, String str2) {
		// �κ�һ���ַ���Ϊnull����ַ�����������Ҫ�����
		if (str1 == null || "".equals(str1)) {
			return str2;
		}
		if (str2 == null || "".equals(str2)) {
			return str1;
		}
		int maxLength = Math.max(str1.length(), str2.length());
		// ����һ������������ַ���������Ҫ����󳤶��ַ�������һλ�����ڴ洢���ܳ��ֵĽ�λ
		StringBuffer result = new StringBuffer(maxLength + 1);

		// ��ת�����ַ���
		str1 = new StringBuffer(str1).reverse().toString();
		str2 = new StringBuffer(str2).reverse().toString();

		// ��ת��Ľ���ֱ�Ϊ��
		// 954321
		// 321
		int minLength = Math.min(str1.length(), str2.length());
		// ��λ
		int carry = 0;
		// ��ǰλ�ϵ���ֵ
		int currentNum = 0;
		// ѭ������
		int i = 0;
		for (; i < minLength; i++) {
			// �ֱ��ȡ�����ַ���Ӧ��������ֵ��Ȼ����ӣ��ټ��Ͻ�λ
			currentNum = str1.charAt(i) + str2.charAt(i) - 2 * '0' + carry;
			// ��ȡ��λ
			carry = currentNum / 10;
			// ����ǰλ������ֵ
			currentNum %= 10;
			// ���浱ǰλ��ֵ�����յ��ַ���������
			result.append(String.valueOf(currentNum));
		}
		if (str1.length() < str2.length()) {
			// ѡ��
			str1 = str2;
		}
		for (; i < str1.length(); i++) {
			// �ֱ��ȡ�����ַ���Ӧ��������ֵ��Ȼ����ӣ��ټ��Ͻ�λ
			currentNum = str1.charAt(i) - '0' + carry;
			// ��ȡ��λ
			carry = currentNum / 10;
			// ����ǰλ������ֵ
			currentNum %= 10;
			// ���浱ǰλ��ֵ�����յ��ַ���������
			result.append(String.valueOf(currentNum));
		}
		// �������һ���Ľ�λ(��ѭ���������ǲ��ǻ����ܻ���һ����λ)
		if (carry > 0) {
			result.append(String.valueOf(carry));
		}
		// ���ת�ָ��ַ������ٷ���
		return result.reverse().toString();
	}

	// �������д�ñȽϼ�࣬�ȽϺã�������δ���Ǹ���
	public static String add2(String num1, String num2) {
		StringBuilder res = new StringBuilder("");
		int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
			int tmp = n1 + n2 + carry;
			carry = tmp / 10;
			res.append(tmp % 10);
			i--;
			j--;
		}
		if (carry == 1)
			res.append(1);
		return res.reverse().toString();
	}

}