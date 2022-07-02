package test.app.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import test.app.trie.WordBreak;

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new WordBreakII().wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple") ) );
	}
	
	 public List<String> wordBreak(String s, List<String> wordDict) {
	        return wordBreak( s, new HashSet<>(wordDict) );
	    }
	    
	    Map<String, List<String> > dp = new HashMap<>();
	    public List<String> wordBreak( String s, Set<String> set) {
	        // First of all, we will build a trie for the wordDict so
	        // that look ups can be time efficient .
	    	
	    	if( s.isEmpty() ) {
	            List<String> res = new ArrayList<>();
	            res.add("");
	            return res;
	        }
	    	
	       List<String> res = new ArrayList<>() ;
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
	            	
	            	List<String> t = dp.get(remaining);
	            	
	            	if ( java.util.Objects.isNull(t) ) { 
	            		t = wordBreak( remaining, set );
	            	}
	                
	                for ( String t1 : t ){
	                    res.add( (segment + " " + t1).trim() );
	                }
	                
	                                
	            }
	        }
	        
	        dp.put(s,res);
	        
	        return res;
	    }

}
