package test.app.matrix;

import java.util.Deque;
import java.util.LinkedList;

import test.app.utils.Utils;

public class ShortestBridge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = Utils.readLeetInput("leetinput");
		
		System.out.println( new ShortestBridge().shortestBridge(grid));
	}
	
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Deque<Integer> q = new LinkedList<>();
        
        outerloop:
        for( int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if( grid[r][c] == 1){
                    dfs(grid,visited,q,r,c);
                    break outerloop;
                } 
            }
        }
        
        int level = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int cord = q.remove();
                int r = cord / n;
                int c = cord % n;
                
                for( int[] d : dir ) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                     
                    if( nr<0 || nc<0 || nr==n || nc==n || visited[nr][nc] )
                       continue;
                    
                    if( grid[nr][nc] == 1 )
                    	return level ;
                     
                    visited[nr][nc] = true;
                    q.add(nr*n + nc);
                     
                 }
                
                /*
                 * This is giving TLE
                 * if( grid[r][c] == 1 && !visited[r][c] )
                    return level-1;
                
                 visited[r][c] = true;
                 for( int[] d : dir ) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                     
                    if( nr<0 || nc<0 || nr==n || nc==n || visited[nr][nc] )
                       continue;
                     
                    q.add(nr*n + nc);
                     
                 }*/
            }
            level++;
        }
        
        return level;
        
    }
    
    int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
    
    public void dfs( int[][] grid , boolean[][] visited , Deque<Integer> q ,int r, int c){
        if( r<0 || c<0 || r==grid.length || c==grid[r].length || visited[r][c] || grid[r][c] == 0)
            return ;
        
        visited[r][c] = true;
        q.add(r*grid.length + c);
        for( int[] d : dir ){
            dfs( grid , visited , q , r + d[0] , c + d[1]);
        }
            
    }

}
