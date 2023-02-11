package test.app.matrix;

import java.util.Deque;
import java.util.LinkedList;

public class AsFarFromLandAsPossible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	    public int maxDistance(int[][] grid) {
	        int n = grid.length;
	        int[][] dist = new int[n][n];

	        Deque<int[]> q = new LinkedList<>();
	        for( int r=0;r<n;r++){
	            for( int c=0;c<n;c++){
	                dist[r][c] = grid[r][c];
	                if( dist[r][c] == 1 )
	                    q.add( new int[]{r,c});
	            }
	        }
	        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	        int max = -1;
	        int level = 1;
	        while( !q.isEmpty() ){
	            int size = q.size();
	            while( size-- > 0 ){
	                int[] cell = q.remove();
	                int r = cell[0];
	                int c = cell[1];

	                for( int[] d : dir ){
	                    int nr = r + d[0] , nc = c + d[1];
	                    if( isValid(nr,nc,n) ){
	                            if( dist[nr][nc] == 0 ){
	                                q.add( new int[]{nr,nc});
	                                dist[nr][nc] = level ;
	                                max = level ;
	                            }
	                    }
	                }
	            }
	            level++;
	        }
	        
	        return max;
	    }

	    public boolean isValid( int x, int y, int n ){
	        return x > -1 && y > -1 && x<n && y<n;
	    }
	

}
