package test.app.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new LetterCombinationsOfAPhoneNumber().letterCombinationsUsingBFS("23"));
	}
	
	public List<String> letterCombinations(String digits) {
        return letterCombinations("", digits, 0);
    }
    
    static Map<Character, List<Character>> myMap = createMap();

    private static Map<Character, List<Character> > createMap() {
        Map<Character, List<Character>> myMap = new HashMap<Character, List<Character>>();
        myMap.put('2', Arrays.asList('a','b','c'));
        myMap.put('3', Arrays.asList('d','e','f'));
        myMap.put('4', Arrays.asList('g','h','i'));
        myMap.put('5', Arrays.asList('j','k','l'));
        myMap.put('6', Arrays.asList('m','n','o'));
        myMap.put('7', Arrays.asList('p','q','r','s'));
        myMap.put('8', Arrays.asList('t','u','v'));
        myMap.put('9', Arrays.asList('w','x','y','z'));
        return myMap;
    } 
    
    public List<String> letterCombinations(String text, String digits,int i) {
        if( i == digits.length() ) {
            List<String> list = new ArrayList<>();
            list.add(text.toString());
            return list;
        }
        
        List<String> answer = new ArrayList<>();
        Character c = digits.charAt(i);
        List<Character> mappedKeys = myMap.get(c) ;
        for ( Character  ch : mappedKeys ){
            answer.addAll(letterCombinations( text+ch , digits, i+1 ));
        }
        
        return answer;
    }
    
    
    public List<String> letterCombinationsUsingBFS( String digits ) {
        
        LinkedList<String> result = new LinkedList<>();
        
        if( !digits.isEmpty() )
        	result.add("");
        
        for ( Character digit : digits.toCharArray() ) {
        	List<Character> mappedKeys = myMap.get(digit) ;
        		
        	int n = result.size();
    		while ( n-- > 0 ) {
    			 String t = result.removeFirst();
    			 for ( Character k : mappedKeys ) {
    				 result.add(t+k);
    			 }
    	    }
        }
        
        return result;
    }

}
