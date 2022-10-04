package test.app.matrix;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestPath {
	
	public static void main( String[] args ) {
		int size = 2;
		int[][] mat = new int[size][size];
		
		System.out.println( new ShortestPath().shortestPath(mat));
		
		System.out.println( new ShortestPath().shortestPathUsingBacktracing(mat, 0, 0, new boolean[size][size], 0) );
	}
	
	int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public int shortestPath( int[][] mat ) {
		
		int m = mat.length;
		int n = mat[0].length;
		// Starting from 0,0 to m-1,n-1
		boolean[][] visited = new boolean[m][n];
		Deque<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0][0] = true;
		
		int level = 0;
		while( !q.isEmpty() ) {
			int sz = q.size();
			while( sz-- > 0 ) {
				int cord = q.remove();
				int r = cord / n;
				int c = cord % n;
				
				for( int[] d : dir ) {
					int nr = r + d[0];
					int nc = c + d[1];
					
					if( nr > -1 && nr < m && nc > -1 && nc < n && !visited[nr][nc]) {
						
						if( nr == m-1 && nc== n-1)
							return level+1;
						
						q.add(nr*n + nc);
						visited[nr][nc] = true;
					}
				}
			}
			
			level++;
		}
		
		
		
		return 0;
	}
	
	public int shortestPathUsingBacktracing( int[][] mat , int r , int c , boolean[][] visited , int step ) {
		
		if( r < 0 || c < 0 || r == mat.length || c == mat[r].length || visited[r][c])
			return  Integer.MAX_VALUE;
		
		if( r == mat.length-1 && c == mat[r].length-1 )
			return step;
		
		visited[r][c] = true;
		
		int ans = Integer.MAX_VALUE;
		for( int[] d : dir ) {
			ans = Math.min(ans, shortestPathUsingBacktracing( mat , r + d[0] , c + d[1] , visited ,step + 1 ) );
		}
		
		visited[r][c] = false;
		
		return ans;
		
	}

}
