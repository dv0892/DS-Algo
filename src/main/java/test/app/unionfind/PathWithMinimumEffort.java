package test.app.unionfind;

public class PathWithMinimumEffort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] heights = { {1,2},{1,2} };
		
		System.out.println( new PathWithMinimumEffort().minimumEffortPath(heights));
	}
	
	public int minimumEffortPath(int[][] heights) {
        return dfs(0,0,heights,0 ,new boolean[heights.length][heights[0].length] );
    }
    
    int[][] dir ={{1,0},{0,1},{-1,0},{0,-1}};
    
    public int dfs(int r , int c , int[][] heights, int effort , boolean[][] visited ) {
            
        if( (r==(heights.length-1))  && (c==heights[0].length-1))
            return effort;
        
        visited[r][c] = true;
        int minEffort = Integer.MAX_VALUE;
        int[] mindir = null;
        for( int[] d : dir ) {
            if( isValid( r+d[0], c+d[1], heights.length, heights[0].length ) && !visited[r+d[0]][c+d[1]] ) {
            	if( minEffort > Math.abs( heights[r][c] - heights[r+d[0]][c+d[1]] ) ) {
            		minEffort =  Math.abs( heights[r][c] - heights[r+d[0]][c+d[1]] );
            		mindir = d;
            	}
            }
        }
        
        if( minEffort == Integer.MAX_VALUE )
            return effort;
        
        
        return dfs(r+mindir[0],c+mindir[1],heights , Math.max( effort , minEffort ) ,visited);
    }
    
    public boolean isValid( int r, int c , int m , int n ){
        return r>-1 && c>-1 && r<m && c<n;
    }

}
