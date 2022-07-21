package test.app.dp;

import java.util.Arrays;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println( new LongestCommonSubstring().longestCommonSubstring("bc", "bcd"));
		//System.out.println( new LongestCommonSubstring().longestCommonSubstringWithIndices("bce", "bcde",0,0));
		System.out.println( new LongestCommonSubstring().longestCommonSubstringBottomUp("bce", "bcde"));
	}
	
	public int longestCommonSubstring( String s1, String s2 ) {
		if( s1.isEmpty() || s2.isEmpty() )
			return 0;
		
		if(s1.length()==1 || s2.length()==1)
			return 1;
		
		int max = 0;
		int i=0;
        
        while ( i<s1.length() && i<s2.length() && s1.charAt(i) == s2.charAt(i) )
        		i++;
        		
        max = i;
        
        if(s1.length()==i || s2.length()==i)
			return max;
        	
        return Math.max(max, Math.max( longestCommonSubstring( s1.substring(i+1) , s2  ),
        							   longestCommonSubstring( s1 , s2.substring(i+1)  ) ) );
					

	}
	
	public int longestCommonSubstringWithIndices( String s1, String s2 , int i1, int i2) {
		
		int max = 0;
        
        while ( i1<s1.length() && i2<s2.length() && s1.charAt(i1) == s2.charAt(i2) ) {
        		i1++; i2++; max++;
        }
        		
        if(s1.length()==i1 || s2.length()==i2)
			return max;
        	
        return Math.max(max, Math.max( longestCommonSubstringWithIndices( s1 , s2 ,i1+1 ,i2 ),
        							   longestCommonSubstringWithIndices( s1 , s2 ,i1, i2+1 ) ) );

	}
	
	
public int longestCommonSubstringBottomUp( String s1, String s2 ) {
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
        Arrays.fill(dp[dp.length-1], 0);
        
        int i,j,max =0;
        i = s1.length()-1;
        
        while ( i >= 0) {
        	j = s2.length()-1;
        	while ( j >= 0) {
        		/*if( s1.charAt(i) == s2.charAt(j) ) {
        			dp[i][j] = 1 + ( ( i+1 < s1.length()) && (j+1 < s2.length()) && s1.charAt(i+1) == s2.charAt(j+1) ? (dp[i+1][j+1]) : 0 ) ;
        		}
        		
        		dp[i][j] = Math.max(dp[i][j], Math.max(dp[i+1][j], dp[i][j+1] ) );
        		
        		IT CAN BE SIMPLIFIED AS BELOW
        		
        		*/
        		
        		if( s1.charAt(i) == s2.charAt(j) ) {
        			dp[i][j] = 1 + (  dp[i+1][j+1] ) ;
        			max = Math.max(max, dp[i][j]);
        		} else
        			dp[i][j] = 0;
        		
        		j--;
        	}
            i--;
        }
        	
        return max;

	}

}
