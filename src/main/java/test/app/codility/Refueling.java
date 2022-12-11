package test.app.codility;

import java.util.ArrayList;
import java.util.List;

public class Refueling {

	public static void main(String[] args) {
		int[] A = {0, 1, 0, 1, 1, 1, 0};
		int[] X = {1, 2, 3, 4, 5, 6, 7};
		
		System.out.println( new Refueling().solutionusingDP(A, X));
		
	}
	
	
	public int solutionusingDP(int[] A, int[] X) {
        
        int ans = 1;
        int len = A.length;
        int[][] dp = new int[len][len];
        for( int r=0;r<len;r++) {
        	for( int c=0;c<len;c++) {
        		dp[r][c] = -1;
        	}
        	dp[r][r] = A[r];
        }
        
        for( int r = len-2; r>=0 ;r-- ) {
        	for( int c=r+1;c<len;c++) {
        		
        		updateFuel(r, c, dp, dp[r][c-1], X[c] - X[c-1], A[c]);
        		updateFuel(r, c, dp, dp[c-1][r], X[c] - X[r], A[c]);
        		
        		updateFuel(c, r, dp, dp[c][r+1], X[r+1] - X[r], A[r]);
        		updateFuel(c, r, dp, dp[r+1][c], X[c] - X[r], A[r]);
        		
        		if( dp[r][c] >= 0 || dp[c][r] >=0 ) {
        			ans = Math.max(ans, c - r + 1);
        		}
        	}
        }

        return ans;
    }
	
	public void updateFuel( int r , int c , int[][] dp , int availFuel , int dist , int newFuel ) {
		if( availFuel >= dist ) {
			dp[r][c] = Math.max(dp[r][c], availFuel - dist + newFuel );
		}
	}
	
	public int solution(int[] A, int[] X) {
        
        int ans = Integer.MIN_VALUE;
        int len = A.length;
        boolean[] visited = new boolean[len];
        for( int i=0;i<len;i++){
            ans = Math.max( ans , travel(i,visited,A,X,A[i]));
        }

        return ans;
    }
	
	
	

	public int travelCleaned ( int city, boolean[] visited , int[] A, int[] X , int availFuel ) {
	
	    visited[city] = true;
	
	    int rightMostCity = Math.min(city+availFuel,X.length-1);
	    int lefttMostCity = Math.max(city-availFuel,0);
	    int ans = 1;
	    
	    // check on left side
	    for( ;lefttMostCity<city; ){
	        if( !visited[lefttMostCity] && availFuel >= Math.abs( X[lefttMostCity] - X[city] ) ){
	            int temp = ( availFuel - Math.abs( X[lefttMostCity] - X[city] ) + A[lefttMostCity]);
	            ans = Math.max(ans , 1 + travelCleaned( lefttMostCity , visited , A, X , temp ) ) ;
	        }
	        lefttMostCity++;
	    }
	
	    // check on right side
	    for( ;rightMostCity>city; ){
	        if( !visited[rightMostCity] && availFuel >= Math.abs( X[rightMostCity] - X[city] )){
	            int temp = ( availFuel - Math.abs( X[rightMostCity] - X[city] ) + A[rightMostCity]);
	            ans = Math.max(ans , 1 + travelCleaned( rightMostCity , visited , A, X , temp ) ) ;
	        }
	        rightMostCity--;
	    }
	
	    visited[city] = false; 
	    return ans ;
	}

    public int travel ( int city, boolean[] visited , int[] A, int[] X , int availFuel ){

        visited[city] = true;

        int rightMostCity = Math.min(city+availFuel,X.length-1);
        int leftMostCity = Math.max(city-availFuel,0);
        int newLeftTankCapacity = Integer.MIN_VALUE;
        int nextLeftCity = -1;
        int ans = 1;
        
        // check on left side
        for( ;leftMostCity<city; ){
            if( !visited[leftMostCity] && availFuel >= Math.abs( X[leftMostCity] - X[city] ) ){
                int temp = ( availFuel - Math.abs( X[leftMostCity] - X[city] ) + A[leftMostCity]);
                if( newLeftTankCapacity < temp ){
                	newLeftTankCapacity = temp;
                    nextLeftCity = leftMostCity;
                } 
            }
            leftMostCity++;
        }
        
        int nextRightCity = -1;
        int newRightTankCapacity = Integer.MIN_VALUE;
        // check on right side
        for( ;rightMostCity>city; ){
            if( !visited[rightMostCity] && availFuel >= Math.abs( X[rightMostCity] - X[city] )){
                int temp = ( availFuel - Math.abs( X[rightMostCity] - X[city] ) + A[rightMostCity]);
                if( newRightTankCapacity < temp ){
                	newRightTankCapacity = temp;
                    nextRightCity = rightMostCity;
                } 
            }
            rightMostCity--;
        }
        
        if( nextLeftCity != -1 ) {
        	ans = Math.max(ans , 1 + travel( nextLeftCity , visited , A, X , newLeftTankCapacity ) ) ;
        } else if( nextRightCity != -1 ){
         	ans = Math.max(ans , 1 + travel( nextRightCity , visited , A, X , newRightTankCapacity ) ) ;
         }
        
        visited[city] = false; 

        return ans ;
    }

}
