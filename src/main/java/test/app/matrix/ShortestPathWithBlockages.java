package test.app.matrix;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestPathWithBlockages {

	public static void main( String[] args ) {
		int size = 3;
		int[][] mat = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
		
		System.out.println( new ShortestPathWithBlockages().shortestPath(mat));
	}
	
	public int shortestPath( int[][] mat ) {
		
		int m = mat.length;
		int n = mat[0].length;
		// Starting from 0,0 to m-1,n-1
		boolean[][] visited = new boolean[m][n];
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		Deque<Integer> q = new LinkedList<>();
		q.add(0);
		
		int level = 0;
		while( !q.isEmpty() ) {
			int sz = q.size();
			while( sz-- > 0 ) {
				int cord = q.remove();
				int r = cord / n;
				int c = cord % n;
				
				if( r == m-1 && c== n-1)
					return level;
				
				visited[r][c] = true;
				for( int[] d : dir ) {
					int nr = r + d[0];
					int nc = c + d[1];
					
					if( nr > -1 && nr < m && nc > -1 && nc < n && !visited[nr][nc] && mat[nr][nc] == 0) {
						q.add(nr*n + nc);
					}
				}
			}
			
			level++;
		}
		
		
		
		return -1;
	}
}
