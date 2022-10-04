package test.app.matrix;

import java.util.Deque;
import java.util.LinkedList;

public class RottingOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[][] dir = { {1,0},{-1,0},{0,1},{0,-1} };
	
	public int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		Deque<Integer> q = new LinkedList<>();
		for( int r=0;r<m;r++) {
			for( int c=0;c<n;c++) {
				if( grid[r][c] == 2)
					q.add(r*n+ c);
			}
		}
		
		int level = 0;
		while ( !q.isEmpty() ) {
			int sz = q.size();
			while( sz-- > 0 ) {
				Integer cell = q.remove();
				int  r = cell / n;
				int  c = cell % n;
				
				for( int[] d : dir ) {
					int nr = r + d[0];
					int nc = c + d[1];
					
					if( nr >=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1) {
						grid[nr][nc] = 2;
						q.add(nr*n + nc);
					}
				}
            }
				level++;
			
		}
		
		
		for( int r=0;r<m;r++) {
			for( int c=0;c<n;c++) {
				if( grid[r][c] == 1){
				 return -1;
                }
			}
		}
		
		return level == 0 ? level : level-1 ;
    }

}
