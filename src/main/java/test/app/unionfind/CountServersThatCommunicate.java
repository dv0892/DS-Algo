package test.app.unionfind;

public class CountServersThatCommunicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]  grid = {{1,0},{0,1}};
		
		System.out.println( new CountServersThatCommunicate().countServersUnionFind(grid));
	}
	
	
	public int countServersUnionFind(int[][] grid) { 
		
		
		int m = grid.length;
		int n = grid[0].length;
		UF dsu = new UF(m*n);
		
	    int ans = 0;	
    
	    int prev = -1;
		for(int r=0;r<m;r++) {
			prev = -1;
			 for(int c=0;c<n;c++) {	
				 if( grid[r][c] == 0 ) {
	                 continue ;
				 }	
				 
				 if( prev != -1 )
					 dsu.connect(r*n + c, prev);
				 
				 prev = r*n + c;
				 
	          }
		}
		
		for(int c=0;c<n;c++) {	
			prev = -1;
			for(int r=0;r<m;r++) {
			 if( grid[r][c] == 0 ) {
                continue ;
			 }	
			 
			 if( prev != -1 )
				 dsu.connect(r*n + c, prev);
			 
			 prev = r*n + c;
			}
         }
		
		
		for( int i=0;i<(m*n);i++) {
			if( dsu.parent(i) == i && dsu.size(i) > 1 )
				ans += dsu.size(i);
		}
        
		return ans;
		
	}
	
	
	public int countServers(int[][] grid) {
	      //Approach 1 : Use DFS on first server you found and 
	        
	            int m = grid.length;
				int n = grid[0].length;
			    int ans = 0;	
	        
				for(int r=0;r<m;r++) {
				 for(int c=0;c<n;c++) {
					 if( grid[r][c] == 1 ) {
	                     int t = dfs(r,c,grid);
						 if( t > 1 ) 
	                         ans+=t;
					 }	
		          }
				}
				
				
		        
				return ans;
	    }
	    
	    
			int[][] dir = { {1,0},{0,1},{-1,0},{0,-1} };

			private int dfs(int r, int c, int[][] grid) {
				
				if( grid[r][c] == 0 )
	                return 0;
	            
	            // changing it non-server node
				grid[r][c] =  0 ;
	            int count = 1;
	            
	            for( int i=0;i<grid.length;i++){
	                count += dfs(i,c,grid);
	            }
	            
	            for( int j=0;j<grid[r].length;j++){
	                count += dfs(r,j,grid);
	            }
				
	            return count;
			}


}
