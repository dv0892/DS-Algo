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
		dict.addWord("ma");
		
		
		System.out.println( dict.search("..") );
	}
	

    Node root;
    
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        
        for ( int i=0;i<word.length();i++) {
            Node temp = curr.childrens.get( word.charAt(i) );
            if ( temp == null ){
                temp = new Node();
                curr.childrens.put( word.charAt(i) , temp );
            } 
            curr = temp;
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        return search( root , word , 0);
    }
    
    private boolean search ( Node curr , String word , int i ) {
        
        if( curr == null )
            return false;
        
        if( i == word.length() ) {
            return curr.endOfWord;
        }
        
        if( word.charAt(i) != '.') {
            return search( curr.childrens.get(word.charAt(i)) , word , i + 1); 
        }  
        
        Set<Character> allChilds = curr.childrens.keySet();
        for( char c : allChilds  ){
            if( search( curr.childrens.get(c) , word , i + 1) )
                return true;
        }
            
        return false;
    }
}

