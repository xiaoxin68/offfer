package com.offer.chapter2;

/**
 * 
 * 二进制中1的个数
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月31日
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

	// 方式一：这种做法如果输入负数会陷入死循环
	public static int oneCount(int num) {
		int count = 0;
		while (num != 0) {
			count += num % 2;
			num = num >> 1;// 这里不可把右移运算换成除以2，因为除法的效率比移位运算低得多
		}
		return count;
	}

	// 方式二：依次左移1，做与运算，判断当前位是否为1
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

	// 方式三：依次左移1，做与运算，判断当前位是否为1
	public static int oneCount3(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			num = (num - 1) & num;
		}
		return count;
	}

	// 相关题目：判断一个数是不是2的整数次方
	public static boolean isTwoPow(int num) {
		boolean flag = false;
		int count = oneCount3(num);
		if (count == 1) {
			flag = true;
		}
		return flag;
	}

	// 相关题目：输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n
	public static int changeSteps(int m, int n) {
		return oneCount3(m ^ n);
	}
}
