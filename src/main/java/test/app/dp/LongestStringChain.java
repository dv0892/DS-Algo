package test.app.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
		
		System.out.println( new LongestStringChain().longestStrChain(words));
	}
	
	
	public int longestStrChain(String[] words) {
        
        // 1. Sort the array based on word length
		// 2. Using bottom-up approach find their predecessors answer.
		// 3. For a word of length n, the predecessor will be of length n-1 always.
		
		Arrays.sort(words, (w1,w2) -> w1.length()- w2.length() );
		
		int maxChain = Integer.MIN_VALUE;
		
		Map<String,Integer> dp = new HashMap<>();

		for( int i=0;i<words.length;i++) {
			 int wlen = words[i].length();
			 int clen = 1;
			 
      		 /*int prei = i-1;
			 while( prei >= 0 ) {
				 // we need to check only strings of length len-1 only.
				 if( words[prei].length() == wlen ) {
					 prei--;
					 continue ;
				 }
				// we will break when we are sure we have checked all strings of length len-1.
				 if( words[prei].length() + 2 == wlen )
					 break ;*/
				 
				 
			     // check its predecessor
				 for( int s=0;s<wlen;s++) {
					 String predecessor = words[i].substring(0,s) + words[i].substring(s+1);
					 if( dp.containsKey(predecessor) ) {
						 clen = Math.max(clen, 1 + dp.get(predecessor));
					 }
				 }
				 
				/* prei--;
			 }*/
			 
			 dp.put(words[i], clen);
			 maxChain = Math.max(clen, maxChain);
		}
		
		
		return maxChain;
    }

}
