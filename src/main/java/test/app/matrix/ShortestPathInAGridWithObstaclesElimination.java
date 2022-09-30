package test.app.matrix;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestPathInAGridWithObstaclesElimination {

	public static void main( String[] args ) {
		int size = 3;
		int[][] mat = {{0,0,0},{1,1,1},{1,1,1},{0,1,1},{1,1,0}};
		
		System.out.println( new ShortestPathInAGridWithObstaclesElimination().shortestPath(mat,2));
	}
	
	static class Node {
		int r ,c ,k;
		Node( int row , int col, int k){
			this.r = row;
			this.c = col;
			this.k = k;
		}
	}
	
	public int shortestPath( int[][] mat ,int k) {
		
		int m = mat.length;
		int n = mat[0].length;
		// Starting from 0,0 to m-1,n-1
		//boolean[][] visited = new boolean[m][n];
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		int[][] maxSuperPower = new int[m][n];// This will play the role of both being visited and storing super power for each node.
		for( int[] arr : maxSuperPower )
			Arrays.fill(arr, -1);
		
		
		Deque<Node> q = new LinkedList<>();
		q.add( new Node(0, 0, k));
		
		int level = 0;
		while( !q.isEmpty() ) {
			int sz = q.size();
			while( sz-- > 0 ) {
				Node curr = q.remove();
				int r = curr.r;
				int c = curr.c;
				
				if( r == m-1 && c== n-1)
					return level;
				
				
				for( int[] d : dir ) {
					int nr = r + d[0];
					int nc = c + d[1];
					
					if( nr > -1 && nr < m && nc > -1 && nc < n ) {
						if( mat[nr][nc] == 0 ) {
							if( maxSuperPower[nr][nc] < curr.k ) {
								q.add( new Node(nr,nc,curr.k));
								maxSuperPower[nr][nc] = curr.k;
							}
						} else {
							if( curr.k > 0 && maxSuperPower[nr][nc] < (curr.k-1) ) {
								q.add( new Node(nr,nc,curr.k-1));
								maxSuperPower[nr][nc] = curr.k-1;
							}
						}
					} 
				}
			}
			
			level++;
		}
		
		
		
		return -1;
	}

}
