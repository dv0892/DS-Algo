package test.app.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( 1/2*2);
		System.out.println( new LongestPalindrome().longestPalindrome("abcbe"));
	}
	
	public int longestPalindrome(String s) {
		
		/*
		 * In forming a palindrome, we need even number of partners
		 * plus a possibly odd number of centered characters.
		 * 
		 * Even length palindrome : Contains even no of partners
		 * Odd length palindrome : Contains even no of partners plus a odd number of centered characters.
		 * 
		 */
		
        int[][] freq = new int[2][26];
        for( int i=0; i<s.length(); i++ ) {
            
            if( Character.isUpperCase( s.charAt(i) ) )
                freq[0][s.charAt(i)-'A']++;
            else
                freq[1][s.charAt(i)-'a']++;
            
        }
        
        int ans = 0;
        for( int i=0; i<2; i++ ) {
            for( int j=0; j<26; j++ ){
                if( freq[i][j] > 0 ){
	                ans += freq[i][j]/2*2;
	                
	                if( ans%2==0 && freq[i][j]%2==1 )
	                	ans++;
                }
            }
         }
        return ans;
        
       /* int odd=0,even=0;
        for( int i=0; i<2; i++ ) {
           for( int j=0; j<26; j++ ){
               if( freq[i][j] > 0 && freq[i][j]%2 == 0){
                   even+= freq[i][j];
               } else
            	   odd+= freq[i][j];
           }
        }
        
        int len = s.length();
        while( len > 0){
            int target = len;
            
            if( target%2 == 1 ) {
            	int sub = 1;
            	while ( odd >= sub && (target-sub) >= 0  ) {
            		int newTarget = target-sub;
            		
            		if( newTarget == 0 || newTarget <= even )
            			return target;
            		
            		sub += 2;
            	}
            	
            } else {
            	if( target <= even) 
            		return target;
            }
            
            len--;
        }
        
        return 1;
*/    }

}
