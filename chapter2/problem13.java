package com.offer.chapter2;
/**
 * 机器人运动范围
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月31日
 * @Since: 1.0
 */
public class problem13 {
	public static void main(String[] args) {
		System.out.println(moveCount(3, 4, 3));
	}

	public static int moveCount(int rows,int cols,int threshold ) {
		if (threshold<=0 || rows<=0 || cols<=0) {
			return 0;
		}
		boolean [][]visited = new boolean[rows][cols];
		return moveCountCroe(rows,cols,0,0,threshold,visited);
	}

	private static int moveCountCroe(int rows, int cols, int i, int j, int threshold, boolean[][] visited) {
		int count = 0;
		if (i>=0 && i<rows && j>=0 && j<cols && canGetIn(i,j,threshold) && !visited[i][j]) {
			visited[i][j] = true;
			count = 1+ moveCountCroe(rows, cols, i-1, j, threshold, visited)//加1表示当前i，j
			+ moveCountCroe(rows, cols, i, j-1, threshold, visited)
			+ moveCountCroe(rows, cols, i+1, j, threshold, visited)
			+ moveCountCroe(rows, cols, i, j+1, threshold, visited);
		}
		return count;
	}
	
	private static boolean canGetIn(int i,int j,int threshold) {
		return (sum(i) + sum(j)) <= threshold;
	}
	
	private static int sum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += (num%10);
			num /= 10;
		}
		return sum;
	}
}
