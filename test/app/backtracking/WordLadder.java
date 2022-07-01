package test.app.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wordlist = new ArrayList<>();
		Arrays.asList("hot","dot","tog","cog");
		
		System.out.println( new WordLadder().ladderLength1("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
	}
	
	
public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        
      Set<String> set = new HashSet<>(wordList);
      if( !set.contains(endWord) )
    	  return 0;
      
      Map<String,List<String>> map = new HashMap<>();
      for ( String word : wordList ) {
    	  for( int i=0;i<word.length();i++) {
    		  String key = word.substring(0,i) + "*" + word.substring(i+1);
    		  map.merge(key, new ArrayList<>(Arrays.asList(word)), (l1,l2) -> { l1.addAll(l2); return l1; } );
    	  }
      }
      
      Deque<String> q = new LinkedList<>();
      q.add(beginWord);
      
      Set<String> visited = new HashSet<>();
      int level = 0;
      
      while ( !q.isEmpty() ) {
    	  int size = q.size();
    	  while (size-- > 0 ) {
    		  String word = q.remove();
    		  
    		  if ( word.equals(endWord) )
    			  return level;
    		  
    		  for( int i=0;i<word.length();i++) {
        		  String key = word.substring(0,i) + "*" + word.substring(i+1);
        		  
        		  for ( String neighbour : map.getOrDefault(key,  new ArrayList<>())) {
        			  if( !word.equals(neighbour) && !visited.contains(neighbour)) {
        				  visited.add(neighbour);
        				  q.add(neighbour);
        			  }
        		  }
        	  }
    	  }
    	  level++;
      }
      
        
        return 0;
    }
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        if( !wordSet.contains(endWord) )
        	return 0;
        
        Map<String,List<String>> map = new HashMap<>();
        for ( String word : wordSet) {
            for ( int i=0 ; i < word.length() ; i++ ){
               String key = word.substring(0, i) + "*" + word.substring(i+1);
               map.merge(key, new ArrayList<>(Arrays.asList(word)), (l1,l2)-> { l1.addAll(l2); return l1; });
            }
        }
        
        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        
        
        int level = 1;
        while( !queue.isEmpty() ) {
        	int size = queue.size();
        	while( size-- > 0 ) {
        		String word = queue.remove();
        		
        		if( word.equals(endWord))
        			return level;
        		
        		//wordSet.remove(word);
        		
        		//List<String> choices = new ArrayList<>();// formAllPossibleChoices(word);
        		
        		/*for ( String w : wordSet ) {
        			boolean canChange = formAllPossibleChoices(word,w);
        			
        			if( canChange )
        				queue.add(w);
        		}*/
        		
        		for ( int i=0 ; i < word.length() ; i++ ){
                    String key = word.substring(0, i) + "*" + word.substring(i+1);
                    
                    for (String neighbour : map.getOrDefault(key, new ArrayList<>())) {
                    	if( !word.equals(neighbour) && !visited.contains(neighbour)) {
                    		visited.add(neighbour);
                    		queue.add(neighbour);
                    	}
                    }
                    
                 }
        	}
        	
        	level++;
        }
        
        return 0;
    }
    
    private boolean formAllPossibleChoices(String source, String target ) {
    	
    	if ( source.length() != target.length() )
    		return false;
    	
    	for ( int i=0;i<source.length();i++) {
    		
    		boolean match = true;
    		for ( int j=0;j<target.length();j++) {
    			
    			if (    ( i == j && source.charAt(j) != target.charAt(j) )
    			    ||  ( i != j && source.charAt(j) == target.charAt(j) ) )
    				continue;
    			
    			match = false;
    			break;
    			
    		}
    		
    		if ( match )
    			return true;
    		
    	}
    	
    	return false;
	}

	public List<String> formAllPossibleChoices( String word ){ 
    
        List<String> result = new ArrayList<>();
        char[] input = word.toCharArray();
        
        for ( int i=0 ; i < input.length ; i++ ){
            char temp = input[i];
            for( char c = 'a' ; c <= 'z' ; c++){
                input[i] = c;
                result.add( new String(input));
            }
            input[i] = temp;
        }
    
        return result;
    }

}
