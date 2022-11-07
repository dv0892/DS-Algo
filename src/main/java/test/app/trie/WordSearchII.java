package test.app.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
		String[] words = {"oa","oaa"};
		
		System.out.println( new WordSearchII().findWords(board, words));
	}
	
	public List<String> findWords(char[][] board, String[] words) {
       
		TrieNode root = new TrieNode();
		// Build a trie using given words
		for( String w : words ) {
			addToTrie(w,root);
		}
		
		
		List<String> ans = new ArrayList<>();
		// Now we will visit each node of matrix and start a backtracking procedure from it to check every possible word
		int rows = board.length , cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for( int r = 0;r<rows;r++) {
			for( int c = 0;c<cols;c++) {
				checkWords(board,r,c,ans,root,visited);
			}
		}
		
		return ans;
		
    }

	int[][] dir = { {1,0},{0,1},{-1,0},{0,-1} };
	
	private void checkWords(char[][] board, int r, int c, List<String> ans, TrieNode trie , boolean[][] visited ) {
		
		if( !isValid(board,r,c) )
			return;
			
	    if( visited[r][c] || trie.children[board[r][c]-'a'] == null)
			return;
		
		visited[r][c] = true;
		
		// checking in trie
		trie = trie.children[board[r][c]-'a'];
		if( trie.word != null ) {
			ans.add(trie.word);
			trie.word = null;
		}
		
		for( int[] d : dir ) {
			checkWords(board, r+d[0], c+d[1], ans, trie, visited);
		}
	
		visited[r][c] = false;
		
	}

	private boolean isValid(char[][] board, int r, int c) {
		
		return r >= 0 && c >= 0 && r < board.length && c < board[r].length;
	}
	
	public void addToTrie ( String word , TrieNode root ) {
		
		
        for ( int i=0;i<word.length();i++) {
        	if( root.children[word.charAt(i) - 'a'] == null ) {
        		root.children[word.charAt(i) - 'a'] = new TrieNode();
        	}
        	root = root.children[word.charAt(i) - 'a'];
        }
       
        root.word = word;
	} 
	
	class TrieNode {
		
		TrieNode[] children = new TrieNode[26];
		String word;
	}

}


