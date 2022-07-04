package test.app.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		List<String> dict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		
		System.out.println( new WordBreak().wordBreak("leetcode1", Arrays.asList("leet","code") ) );
		System.out.println( new WordBreak().wordBreak(s , dict ));
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
        // First of all, we will build a trie for the wordDict so
        // that look ups can be time efficient .
		Trie trie = new Trie();
		for( String word : wordDict ) {
			trie.insert(word);
		}
		
		return wordBreak( s, trie);
        //return wordBreak( s, new HashSet<>(wordDict) );
    }
    
    /*
     * This is giving TLE
     * s   : "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
	   set : ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
	   
	   Let' build a trie of gievn set .
     */
	
	Map<String, Boolean > dp = new HashMap<>();
	
    public boolean wordBreak(String s, Set<String> set) {
        // First of all, we will build a trie for the wordDict so
        // that look ups can be time efficient .
    	
    	if( s.isEmpty() )
    		return true;
    	
        
    	for ( int i=1;i<=s.length();i++){
            String segment   = s.substring(0,i);
            String remaining = s.substring(i);
            
           /* SInce the decision tree can be quite large
            * We need to cache store computed results of "remaining" ( Somewhat DynamicProgramming )
            * Otherwise it throw a TLE for large negative test cases as mentioned in method header.
            * 
            * if ( set.contains(segment) &&  wordBreak( s.substring(i) ,set ) )
                return  true;*/
            
            if ( set.contains(segment) ) {
            	
            	Boolean res = dp.get(remaining);
            	
            	if ( java.util.Objects.isNull(res) ) { 
            		res = wordBreak( remaining, set );
            		dp.put(remaining, res );
            	}
            	 
            	if ( res.booleanValue() )
            		return true;
            }
        }
        
        return false;
    }
    
    
    
    public boolean wordBreak(String s, Trie trie ) {
        // First of all, we will build a trie for the wordDict so
        // that look ups can be time efficient .
    	
    	if( s.isEmpty() )
    		return true;
    	
        
    	for ( int i=1;i<=s.length();i++){
            String segment   = s.substring(0,i);
            String remaining = s.substring(i);
            
            /* SInce the decision tree can be quite large
             * We need to cache store computed results of "remaining" ( Somewhat DynamicProgramming )
             * Otherwise it throw a TLE for large negative test cases as mentioned in method header.
             * 
             * if ( set.contains(segment) &&  wordBreak( s.substring(i) ,set ) )
                 return  true;*/
             
             if ( trie.search(segment)) {
             	
             	Boolean res = dp.get(remaining);
             	
             	if ( java.util.Objects.isNull(res) ) { 
             		res = wordBreak( remaining, trie );
             		dp.put(remaining, res );
             	}
             	 
             	if ( res.booleanValue() )
             		return true;
             }
        }
        
        return false;
    }

}
