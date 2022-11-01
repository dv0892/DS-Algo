package test.app.graph;

public class WhereWillTheBallFall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] findBall(int[][] grid) {
	       
	       int rows = grid.length;
	       int balls = grid[0].length;
	        
	       int rwall = grid[0].length;
	       int lwall = -1;
	        
	       int[] ans = new int[balls]; 
	       
	       for( int b=0;b<balls;b++) {
	           int r=0,c=b;
	           while(true) {
	               // check the ball is being blocked
	               if(grid[r][c]==1 && ( (c+1)==rwall || grid[r][c+1]==-1 ) )
	                   break;
	               
	               if(grid[r][c]==-1 && ((c-1)==lwall || grid[r][c-1]==1) )
	                   break;
	               
	               // Move the ball
	               c+=grid[r][c];
	               r++;
	               
	               // REached the bottom
	               if(r==rows) 
	                   break;
	               
	               
	           }
	           
	           ans[b] = (r==rows) ? c : -1;
	       } 
	        
	       return ans; 
	    }

}
