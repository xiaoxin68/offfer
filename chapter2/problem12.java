package com.offer.chapter2;
/**
 * 矩阵中的路径
 * 
 * @Description: 
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2019年12月30日
 * @Since: 1.0
 */
public class problem12 {
	public static void main(String[] args) {
		char[][] matrix = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
		char[]path = {'b','f','c','e'};
		System.out.println(hasPath(matrix, path));
		System.out.println(hasPath(null, path));
		System.out.println(hasPath(new char[][] {{'a','b','t','g'}}, new char[] {'a'}));
		System.out.println(hasPath(new char[][] {{'a','b','t','g'}}, new char[] {'t','a'}));
	}
	
	public static boolean hasPath(char[][] matrix,char[]path) {
		if (matrix == null ||path == null || matrix.length<=0 ) {
			return false;
		}
		int rows = matrix.length,cols = matrix[0].length;
		boolean [][]visited = new boolean[rows][cols];
		int pathLength = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				//从任意起点开始，判断是否存在可行路径
				if (hasCorePath(matrix,rows,cols,path,i,j,visited,pathLength)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasCorePath(char[][] matrix,int rows, int cols, char[] path, int i, int j,boolean [][]visited,int pathLength) {
		//结束的表示；如果已经查找的最后一个，则结束
		if (pathLength == path.length) {
			return true;
		}
		boolean hasPath = false;
		if ((i>=0 && i<rows) && (j>=0 && j<cols) && (matrix[i][j] == path[pathLength]) && (!visited[i][j])) {
			++pathLength;
			visited[i][j] = true;
			hasPath = hasCorePath(matrix,rows,cols, path, i, j-1, visited,pathLength) 
					|| hasCorePath(matrix,rows,cols, path, i-1, j, visited,pathLength) 
					|| hasCorePath(matrix,rows,cols, path, i, j+1, visited,pathLength) 
					|| hasCorePath(matrix, rows,cols,path, i+1, j, visited,pathLength) ;
			if (!hasPath) {
				--pathLength;
				visited[i][j] = false;
			}
		}
		return hasPath;
	}
}
