package test.app.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class WordDictionary {
	
	
	public static void main(String...strings )	{
		WordDictionary dict = new WordDictionary();
		dict.addWord("bad");
		dict.addWord("dad");
		dict.addWord("mad");
		//dict.addWord("ma");
		
		
		System.out.println( dict.search("..d") );
	}
	

	TrieNode root;
	    
	    public WordDictionary() {
	        root = new TrieNode();
	    }
	    
	   public void addWord(String word) {
		   TrieNode curr = root;
	        
	        for ( int i=0;i<word.length();i++) {
	        	TrieNode temp = curr.getChildren(word.charAt(i));
	            if ( temp == null ){
	                temp = new TrieNode();
	                curr.setChildren(word.charAt(i),temp);
	            } 
	            curr = temp;
	        }
	        curr.endOfWord = true;
	    }
	    
	    public boolean search(String word) {
	        return search( root , word , 0);
	    }
	    
	    private boolean search ( TrieNode curr , String word , int i ) {
	        
	        if( curr == null )
	            return false;
	        
	        if( i == word.length() ) {
	            return curr.endOfWord;
	        }
	        
	        if( word.charAt(i) != '.') {
	            return search( curr.getChildren(word.charAt(i)) , word , i + 1); 
	        }  
	        
	        for( TrieNode n : curr.childrens  ){
	            if( search( n , word , i + 1) )
	                return true;
	        }
	            
	        return false;
	    }
	}

	class TrieNode {
		boolean endOfWord ;
		TrieNode[] childrens;
		
	    TrieNode()	{
	        childrens = new TrieNode[26];
		}
	    
	    public TrieNode getChildren( char c ){
	        return childrens[c-'a'];
	    }
	    
	    public void setChildren( char c , TrieNode node ){
	        childrens[c-'a'] = node ;
	    }
	}

