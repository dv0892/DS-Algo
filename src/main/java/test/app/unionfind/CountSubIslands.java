package test.app.unionfind;

public class CountSubIslands {

	public static void main(String[] args) {
		int[][] grid1 = {{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}};
		int[][] grid2 = {{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}};
		
		int[][] grid12 = {{1,1,0,0,0,0,0},
						  {0,1,0,0,0,0,0},
		                  {1,1,0,0,0,0,0},
						  {0,1,0,0,0,0,0}};
		
		int[][] grid23 = {{1,1,0,0,1,0,0},
						  {1,1,0,0,1,0,0},
					      {1,1,0,0,1,0,0},
		                  {1,1,0,0,1,0,0}
					      };
		
		
		int[][] grid56 = {{1,1,1,1},
				  		  {0,1,1,0},
				  		  {1,1,1,1}
			      };
		
		System.out.println( new CountSubIslands().countSubIslandsDSU(grid12, grid56));
	}
	
	
	public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        
        int ans = 0;
        for( int r=0;r<m;r++){
           for( int c=0;c<n;c++){
            if( grid2[r][c] == 1 )
               if( dfs(grid1,grid2,r,c) )
                   ans++;
           } 
        }
        
        return ans;
    }
    
    public boolean isValid( int r, int c , int m, int n ) {
		return r>-1 && c>-1 && r<m && c<n;
	}
    
    int[][] dir = { {1,0},{0,1},{-1,0},{0,-1} };
    
    public boolean dfs(int[][] grid1, int[][] grid2,int r,int c) {
        
        if( !isValid(r,c,grid2.length,grid2[0].length) || grid2[r][c] == 0)
            return true;
        
        grid2[r][c] = 0;
        
        boolean ans = true;
        for( int[] d : dir ) {
            int nr = r + d[0];
            int nc = c + d[1];

            boolean t = dfs(grid1,grid2,nr,nc);
            ans = ans && t;
        }	
        
        ans = ans && ( grid1[r][c] == 1 ) ;

        
        return ans;
    }
	
	public int countSubIslandsDSU(int[][] grid1, int[][] grid2) {
        int rows = grid2.length;
        int cols = grid2[0].length;
        UF uf = new UF(cols * rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            	
            	// This will handle two cases :
            	//1. When their is water in Grid2
            	//2. When their is water is Grid1 , it will simply go and mark that corresponding cell of grid2( parent in DSU ) as blacklisted and reduce the component size by 1 if it doing it for first time
                if ( grid2[i][j] == 0 /*|| grid1[i][j] == 0*/) {
                    uf.blacklistComponent(index(i, j, cols));
                } 
                if (grid2[i][j] == 1) {
                    if (i + 1 < rows && grid2[i + 1][j] == 1) {
                        uf.connect(index(i, j, cols), index(i + 1, j, cols));
                    }
                    if (j + 1 < cols && grid2[i][j + 1] == 1) {
                        uf.connect(index(i, j, cols), index(i, j + 1, cols));
                    }
                }
            }
        }
        
        return uf.components;

	}
	
	private int index(int i, int j, int cols) {
        return i * cols + j;
    }
}
