package test.app.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Matrix01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { {0,0,0},{0,1,0},{1,1,1}};
		
		new Matrix01().updateMatrixDP(mat);
	}
	
	public int[][] updateMatrixDP(int[][] mat) { 
		int m = mat.length;
        int n = mat[0].length;
		
		int[][] dist = new int[m][n];
		int[][] dir = { {0,-1},{-1,0},{1,0},{0,1} };

		for( int[] arr : dist )
			Arrays.fill(arr,Integer.MAX_VALUE-10000);
		
		itr( mat , dist , dir[0] );
		itr( mat , dist , dir[1] );
		
		itr1( mat , dist , dir[2] );
		itr1( mat , dist , dir[3] );
		
		return dist;
	}
	
	public void itr( int[][] mat , int[][] dist , int[] dir ) {
		
		int m = mat.length;
        int n = mat[0].length;
		
		for ( int r=0;r<m;r++){
			for (int c=0;c<n;c++ )
                if( mat[r][c] != 0 ) {
                	if( (r+dir[0])>-1 && (c + dir[1])>-1) 
                		dist[r][c] = Math.min(dist[r][c] , dist[r + dir[0]][c + dir[1]] + 1 );
                } else {
                	dist[r][c] = 0;
                }
        } 
	}
	
	public void itr1( int[][] mat , int[][] dist , int[] dir ) {
		int m = mat.length;
        int n = mat[0].length;
		
		for ( int r=m-1;r>-1;r--){
			for (int c=n-1;c>-1;c-- )
                if( mat[r][c] != 0 ) {
                	if( (r+dir[0])<m && (c + dir[1])<n ) 
                    	dist[r][c] = Math.min(dist[r][c] , dist[r + dir[0]][c + dir[1]] + 1 );
                } else {
                	dist[r][c] = 0;
                }
        } 
	}
	
	
	
public int[][] updateMatrixMultiSourceMultiDestBFS(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        Deque<Integer> q = new LinkedList<>();
        
        for ( int r=0;r<m;r++){
			for (int c=0;c<n;c++ )
                if( mat[r][c] ==0 ){
                    q.add(r*n+c);
                } else
                	ans[r][c] = -1;
        }
        
        
        
        int[][] dir = { {1,0},{-1,0},{0,1},{0,-1} };
        int level = 1;
        while( !q.isEmpty() ) {
        	int size = q.size();
        	while( size-- > 0 ) {
        		int cord = q.remove();
        		int cr = cord / n;
        		int cc = cord % n;
        		
        		for( int k=0;k<dir.length;k++) {
        			int r = cr + dir[k][0];
        			int c = cc + dir[k][1];
        			
        			if( r > -1 && c > -1 && r < m && c < n && ans[r][c] == -1 ) {
        				ans[r][c] = level;
        				q.add( r*n + c );
        			}	
        		
        		}
        	}
        	level++;
        }
        
        for( int[] a : ans ) {
        	System.out.println( Arrays.toString(a));
        }
        
        
        return ans;
        
    }
	
	
public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        for ( int r=0;r<m;r++){
            for (int c=0;c<n;c++ )
                if( mat[r][c] !=0 ){
                    mat[r][c] = bfs(r,c,mat);
                }
        }
        
        return mat;
        
    }
    
    public int bfs ( int r, int c , int[][] mat ){
        
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        
        Deque<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        
        int level = 0;
        while( !q.isEmpty() ){
            int size = q.size();
            while( size-- > 0 ){
                Pair cord = q.remove();
                if( mat[cord.r][cord.c] == 0 )
                    return level;
                
                visited [cord.r][cord.c] = true;
                if( (cord.r + 1) < m )
                    q.add( new Pair(cord.r+1,cord.c));
                    
                if( (cord.r - 1) >= 0 )
                    q.add( new Pair(cord.r-1,cord.c));
                
                if( (cord.c + 1) < n)
                    q.add( new Pair(cord.r,cord.c+1));
                    
                if( (cord.c - 1) >= 0 )
                    q.add( new Pair(cord.r,cord.c-1));
            }
            
            level++;
        }
        
        return -1;
    }
    
    static class Pair {
        int r , c;
        Pair( int r , int c ){
            this.r = r;
            this.c = c;
        }
    }

}
