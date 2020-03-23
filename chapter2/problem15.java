package com.offer.chapter2;

/**
 * 
 * ��������1�ĸ���
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019��12��31��
 * @Since: 1.0
 */
public class problem15 {
	public static void main(String[] args) {
		System.out.println(oneCount(15));
		System.out.println(oneCount2(-15));
		System.out.println(oneCount3(-15));
		System.out.println(isTwoPow(128));
		System.out.println(changeSteps(10,13));
	}

	// ��ʽһ����������������븺����������ѭ��
	public static int oneCount(int num) {
		int count = 0;
		while (num != 0) {
			count += num % 2;
			num = num >> 1;// ���ﲻ�ɰ��������㻻�ɳ���2����Ϊ������Ч�ʱ���λ����͵ö�
		}
		return count;
	}

	// ��ʽ������������1���������㣬�жϵ�ǰλ�Ƿ�Ϊ1
	public static int oneCount2(int num) {
		int count = 0, flag = 1;
		while (flag != 0) {
			if ((num & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	// ��ʽ������������1���������㣬�жϵ�ǰλ�Ƿ�Ϊ1
	public static int oneCount3(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			num = (num - 1) & num;
		}
		return count;
	}

	// �����Ŀ���ж�һ�����ǲ���2�������η�
	public static boolean isTwoPow(int num) {
		boolean flag = false;
		int count = oneCount3(num);
		if (count == 1) {
			flag = true;
		}
		return flag;
	}

	// �����Ŀ��������������m��n��������Ҫ�ı�m�Ķ����Ʊ�ʾ�еĶ���λ���ܵõ�n
	public static int changeSteps(int m, int n) {
		return oneCount3(m ^ n);
	}
}
