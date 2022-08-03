package test.app.dp;

public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int maximalSquare(char[][] matrix) {
        
        int max = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        
        for( int r=rows-1;r>=0; r--){
            for( int c=cols-1;c>=0; c--) {
            	if( matrix[r][c] == 49) { // ASCII code for 1
            		
            		dp[r][c] = 1 ;
            		
            		if( r+1 < rows && c+1 < cols )
            			dp[r][c] += Math.min( dp[r+1][c+1], Math.min( dp[r+1][c], dp[r][c+1] ) );
            		
            	}
            	
            	max = Math.max( dp[r][c] , max );
            }
        }
        
        return max*max;
    }

}
