package test.app.unionfind;

public class NumberOfEnclaves {

	public static void main(String[] args) {
		/*int[][] grid = {{0,0,1,1,1,0,1,1,1,0,1},
				{1,1,1,1,0,1,0,1,1,0,0},
				{0,1,0,1,1,0,0,0,0,1,0},
				{1,0,1,1,1,1,1,0,0,0,1},
				{0,0,1,0,1,1,0,0,1,0,0},
				{1,0,0,1,1,1,0,0,0,1,1},
				{0,1,0,1,1,0,0,0,1,0,0},
				{0,1,1,0,1,0,1,1,1,0,0},
				{1,1,0,1,1,1,0,0,0,0,0},
				{1,0,1,1,0,0,0,1,0,0,1}};*/
		
		
		int[][] grid = { {0,0,0,0,0,0,0},
				 {0,1,1,1,1,1,1},
				 {0,0,0,0,0,0,0} };
		System.out.println( new NumberOfEnclaves().numEnclavesUsingDSU(grid));

	}
	
	public int numEnclavesUsingDSU(int[][] grid) {
	
		int m = grid.length;
		int n = grid[0].length;
		
		UF1 dsu = new UF1(m*n);
		for(int r=0;r<m;r++) {
			 for(int c=0;c<n;c++) {
				 int v = r*n+c;
				if( grid[r][c] == 0 ) {
                    dsu.blacklistComponent(v);
                } else {
                	if( (r==0 || r==m-1  || c==0 || c==n-1) ) {
                		dsu.blacklistComponent(v);
                		
                		for( int[] d : dir ) {
                    		if( isValid(r+d[0], c+d[1], m, n) && grid[r+d[0]][c+d[1]]==1)
                    			dsu.connect(v, (r+d[0])*n + (c+d[1]));
            			}
                	}	else {
                		
                		if( isValid(r+1, c, m, n) && r+1<m-1 && grid[r+1][c]==1)
                			dsu.connect(v, v+n);
                		
                		if( isValid(r, c+1, m, n) && c+1<n-1 && grid[r][c+1]==1)
                			dsu.connect(v, v+1);
                	}
                	
                	
                	
                }
	         }
		}
			 
		return dsu.components;
	}
	
	public int numEnclaves(int[][] grid) {
			
			// Approach 1 : Using DFS for landCell lying on Extreme row or column.
			// Approach 2 : Using Union-Find
			
			int m = grid.length;
			int n = grid[0].length;
			
			for(int r=0;r<m;r++) {
			 for(int c=0;c<n;c++) {
				 if( (r==0 || r==m-1) && grid[r][c] == 1 ) {
					 dfs(r,c,grid);
				 }	else if ( (c==0 || c==n-1) && grid[r][c] == 1 ) {
					 dfs(r,c,grid);
	             }
	         }
			}
			
			int ans=0;
			for(int r=0;r<m;r++) {
				for(int c=0;c<n;c++) {
				 if( grid[r][c] == 1 ) {
					ans++;
				 }	
				}
			}
	        
			return ans;
	    }

		int[][] dir = { {1,0},{0,1},{-1,0},{0,-1} };

		private void dfs(int r, int c, int[][] grid) {
			
			if( !isValid(r,c,grid.length,grid[0].length) || grid[r][c] == 0 )
				return ;
			
			grid[r][c] = 0 ;
			for( int[] d : dir ) {
				dfs( r + d[0], c + d[1],grid);
			}
		}


		private boolean isValid(int r, int c, int m, int n) {
			return r>-1 && c>-1 && r<m && c<n;
		}
		
}
