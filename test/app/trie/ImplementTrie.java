package test.app.trie;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Trie {

	
	Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for ( int i=0;i<word.length();i++) {
        	if( !curr.childrens.containsKey(word.charAt(i)) ) {
        		curr.childrens.put( word.charAt(i) , new Node() );
        	}
        	curr = curr.childrens.get(word.charAt(i));
        }
        
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
    	Node curr = root;
        for ( int i=0;i<word.length();i++) {
        	if( curr.childrens.containsKey(word.charAt(i)) ) {
        		curr = curr.childrens.get(word.charAt(i));
        		continue;
        	}
        	
        	return false;
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
    	Node curr = root;
        for ( int i=0;i<prefix.length();i++) {
        	if( curr.childrens.containsKey(prefix.charAt(i)) ) {
        		curr = curr.childrens.get(prefix.charAt(i));
        		continue;
        	}
        	
        	return false;
        }
        return true;
    }

}

class Node {
	Map<Character,Node> childrens;
	boolean endOfWord ;
	
	Node()	{
		childrens = new HashMap<>();
	}
}