package test.app.unionfind;

public class NumberOfClosedIslands {

	public static void main(String[] args) {

		int[][] grid = {{1,1,1,1,1,0,1},{1,0,0,0,0,0,1},{1,0,1,1,1,0,1},{1,0,1,0,1,0,1},{1,0,1,1,1,0,1},{1,0,0,0,0,0,1},{1,1,1,1,1,1,1}};
		
		
		System.out.println( new NumberOfClosedIslands().closedIslandDSU(grid));
	}
	
	
	public int closedIslandDSU(int[][] grid) {
        
        //Approach 1 : Use DFS on first land you found and 
        
            int m = grid.length;
			int n = grid[0].length;
		    UF dsu = new UF(m*n);	
        
			for(int r=0;r<m;r++) {
			 for(int c=0;c<n;c++) {
				 int v =  r*n+c;
				 if( grid[r][c] == 1 ) {
					 dsu.blacklistComponent(v);
				 }	else {
					 boolean isClosed = true; 
					 for( int[] d : dir ) {
						   isClosed = isClosed && isValid(r + d[0], c + d[1], m, n);
					 }
					 
					 if( !isClosed ) {
						 dsu.blacklistComponent(v);
					 }
					 
					 if ( r+1<m && grid[r+1][c] == 0 ) {
						 dsu.connect(v,v+n);
					 }
					 
					 if ( c+1<n && grid[r][c+1] == 0 ) {
						 dsu.connect(v,v+1);
					 }
				 }
	          }
			}
			
			
	        
			return dsu.components;
    }
	
	public int closedIsland(int[][] grid) {
        
        //Approach 1 : Use DFS on first land you found and 
        
            int m = grid.length;
			int n = grid[0].length;
		    int ans = 0;	
        
			for(int r=0;r<m;r++) {
			 for(int c=0;c<n;c++) {
				 if( grid[r][c] == 0 ) {
					 if( dfs(r,c,grid) ) 
                         ans++;
				 }	
	          }
			}
			
			
	        
			return ans;
    }
    
    
		int[][] dir = { {1,0},{0,1},{-1,0},{0,-1} };

		private boolean dfs(int r, int c, int[][] grid) {
			
			if( !isValid(r,c,grid.length,grid[0].length) )
				return false ;
            
            if( grid[r][c] == 1)
                return true;
			
            // changing it to water to avoid using visited array
			grid[r][c] =  1 ;
            
            boolean res = true;
			for( int[] d : dir ) {
			    boolean t = dfs( r + d[0], c + d[1],grid);
                res = res && t ;
			}
            
            return res;
		}


		private boolean isValid(int r, int c, int m, int n) {
			return r>-1 && c>-1 && r<m && c<n;
		}
}
