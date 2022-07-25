package test.app.dp;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteOperationForTwoStrings obj = new DeleteOperationForTwoStrings();
		System.out.println( obj.minDistance ("leetcode","etco") );
		System.out.println("Min Distance 1");
		System.out.println( obj.minDistance1("leetcode","etco") );
	}
	
	
	public int minDistance(String w1, String w2) {
        
		int l1 = w1.length();
		int l2 = w2.length();
		
		int[][] dp = new int[l1+1][l2+1];
		
		int r = l1-1,c = l2;
		while( r >= 0) {
			dp[r][c] = dp[r+1][c]+1;
			r--;
		}		
		
		//print(dp);
		
		r = l1;c = l2-1;
		while( c >= 0) {
			dp[r][c] = dp[r][c+1]+1;
			c--;
		}
		
		//print(dp);
		
		r = l1-1;
		while( r >= 0) {
			c = l2-1;
			while( c >= 0) {
				 if ( w1.charAt(r) == w2.charAt(c) ) {
					dp[r][c] =  dp[r+1][c+1];
				} else
					dp[r][c] =  1 + Math.min(dp[r+1][c], dp[r][c+1]) ;
				
				
				c--;
            }
			print(dp);
			r--;
		}
		
		return dp[0][0];
		
    }
	
	
	
	    public int minDistance1(String s1, String s2) {
	        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
	        for (int i = 0; i <= s1.length(); i++) {
	            for (int j = 0; j <= s2.length(); j++) {
	                if (i == 0 || j == 0)
	                    dp[i][j] = i + j;
	                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
	                    dp[i][j] = dp[i - 1][j - 1];
	                else
	                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
	                
	                System.out.print( dp[i][j] + " ");
	            }
	            System.out.println();
	        }
	        return dp[s1.length()][s2.length()];
	    }
	
	    
	    public void print( int[][] arr ) {
	    	for( int[] ar : arr ) {
	    		System.out.println( Arrays.toString(ar));
	    	}
	    	System.out.println( " --- ");
	    }

}
