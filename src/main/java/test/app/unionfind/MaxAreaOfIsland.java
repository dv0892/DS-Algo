package test.app.unionfind;

import test.app.utils.DisJointSet;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int[][]  grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		
		System.out.println( new MaxAreaOfIsland().maxAreaOfIsland(grid));

	}
	
	public boolean isValid( int r, int c , int m, int n ) {
		return r>-1 && c>-1 && r<m && c<n;
	}
	
	
	public int maxAreaOfIsland(int[][] grid) {

		// Using Union-Find
		
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = { {1,0},{0,1},{-1,0},{0,-1} };
        DisJointSet ds = new DisJointSet(m*n,true);
        for (int r=0;r<m;r++) {
        	for( int c=0;c<n;c++) {
        		if ( grid[r][c] == 1 ) {
        			int v = r*n+c;
        			ds.make(v);
        			for( int[] d : dir ) {
        				int nr = r + d[0];
        				int nc = c + d[1];
        				
        			    if( isValid(nr, nc, m, n) && grid[nr][nc] == 1) {
        			    	int nv = nr*n + nc;
                            
                            ds.make(nv);
        			    	ds.union(v, nv);
        			    }	
        			}
        		}
        	}
        }
        
        int res = 0;
        for (int r=0;r<m;r++) {
        	for( int c=0;c<n;c++) {
        		if ( grid[r][c] == 1 ) {
        			int v = r*n+c;
        			res = Math.max(ds.size(v), res);
        		}
        	}
        }
        
        return res ;
        
    }
}
