package test.app.string;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ThreeBlockLettersCodility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new ThreeBlockLettersCodility().solutionDpBottomUp("aaaattcccccbbbb"));
		//aaaattcccccbbbb
	}
	
	
	public int solutionDpBottomUp(String S) {

		/*
		 * This is based on the intuition( which is very hard to conceive ) that each ith 
		 * character can either be part of 1 block or 2 block or 3rd block.
		 * 
		 * k = 0,1,2
		 * The answer of ith char when it is part of kth group 
		 * will max of answers already computed for chars from i+1 to n-1.
		 * 
		 * ans[i][k] = 1 + max of( ans[i+1][k] , ans[i+1][k], ans[i+1][k] ..... ans[n-1][k]  if( char[i] == char[i+1] ) ,
		 *                         ans[i+1][k+1] , ans[i+1][k+1], ans[i+1][k+1] ..... ans[n-1][k+1]  if( char[i] != char[i+1] ))
		 *                         
		 *                         
		 */
		int n = S.length();
        int[][] dp = new int[n][4];
        int len = 1 ;
        dp[n-1][0] = dp[n-1][1] = dp[n-1][2] = 1;
        
        int i = n-2;
        while( i >= 0 ) {
        	char ch = S.charAt(i);
        	
        	for(int k = 2 ; k >=0 ;k-- ) {
        		
        		int maxSame = 0, maxDiff = 0;
        		
        		for( int j=i+1; j<n; j++ ) {
        			if( ch == S.charAt(j) ) {
        				maxSame = Math.max(maxSame,1 + dp[j][k] );
        				if( maxDiff > 0 )
        					break;
        			} else {
        				maxDiff = Math.max(maxDiff,1 + dp[j][k+1] ); 
        		    }
        		}
        		
        		dp[i][k] = Math.max(maxSame, maxDiff) ;
        		len = Math.max(len , dp[i][k] );
        	}
        	
        	i--;
        }
        
        return len;
    }
	
	public int solution(String S) {
        
        int[] freq = new int[26];
        Map<Character,TreeSet<Integer>> treeSet = new HashMap<>();
        for(int i=0;i<S.length();i++) {
        	freq[S.charAt(i)-'a']++;
        	treeSet.putIfAbsent(S.charAt(i), new TreeSet<>());
        	treeSet.get(S.charAt(i)).add(i);
        }
        
        
        int len = Integer.MIN_VALUE ;
        for(int i=0;i<26;i++) {
        	len = Math.max(len, freq[i]);
        }
        
        for(int i=0;i<26;i++) {
        	if( freq[i]>0 ) {
        		Integer charIndex = treeSet.get((char)('a'+i)).higher(-1);
        		len = Math.max( len, len( S ,charIndex.intValue(),(char)('a'+i), treeSet, 1, 2) );
        	}
        }
        
        return len;
    }
	
	public int len(String s, int i , char ch ,Map<Character,TreeSet<Integer>> treeSet, int len, int blockCount ) {
        
        while( ++i<s.length() ) {
        	if( s.charAt(i) == s.charAt(i-1) ) {
        		len++;
        	} else 
        		break;
        }
        
        if( i == s.length() )
        	return len;
        
        Integer sameCharIndex = treeSet.get(ch).higher(i);
        
        // Case 1 : When there is no more characters for the on-going block and we can't accommodate any more blocks also
        if( sameCharIndex == null && blockCount == 0 )
        	return len;
        
        // Case 2 : When there are more characters for the on-going block but we can't accommodate any more new  blocks 
        if( blockCount == 0 ) {
        	while( sameCharIndex != null ) {
        		len++;
        		sameCharIndex = treeSet.get(ch).higher(sameCharIndex);
        	}
        	return len; 
        }
  
       // Case 3 : We can definitely accommodate more blocks
        int originalLen = len;
        for(int c=0;c<26;c++) {
        	char key = (char)('a'+c);
			if( treeSet.get(key) != null ) {
	    		Integer newCharIndex = treeSet.get(key).higher(i-1);
	    		if( newCharIndex != null ) {
	    			len = Math.max( len, len( s , newCharIndex.intValue(),key, treeSet, originalLen+1, key == ch ? blockCount : blockCount-1) );
	    		}
        	}
        }
        
        return len;
        
        // Case 3 terminated here
     /*   if( sameCharIndex == null )
        	return len;
        
        
        // Case 4 : Case 3 + check for more characters for the on-going block 
        return Math.max( len , len(s, sameCharIndex.intValue(), ch, treeSet, originalLen + 1, blockCount) );*/
       
    }

}
