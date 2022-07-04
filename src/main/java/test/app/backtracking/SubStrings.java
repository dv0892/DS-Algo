package test.app.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new SubStrings().subStrings(new  ArrayList<>(), "abc", 0) ;
		new SubStrings().subStringsCleaned(new  ArrayList<>(), "abc", 0) ;
	}
	
	public void subStrings( List<List<Character>> ans , String str ,  int lastCharSubStrings ){
		if ( str.isEmpty() ) {
			System.out.println( ans );
			return ;
		} 
		
		List<List<Character>> newAns = new ArrayList<>();
		newAns.addAll(ans);
		
		char ch = str.charAt(0);
		int count = 0;
		
		int lastIndex = newAns.size()-1;
		while ( lastCharSubStrings-- > 0 ) {
			List<Character> tList = new ArrayList<>(ans.get(lastIndex));
			tList.add(ch);
			newAns.add(tList);
			lastIndex--;
			count++;
		}
		
		List<Character> t = new ArrayList<>();t.add(ch);
		newAns.add(t); count++;
		
		subStrings( newAns , str.substring(1), count );
		
	}
	
	
	public void subStringsCleaned( List<List<Character>> ans , String str ,  int i ){
		if ( i == str.length() ) {
			System.out.println( ans );
			return ;
		} 
		
		List<List<Character>> newAns = new ArrayList<>();
		newAns.addAll(ans);
		
		char ch = str.charAt(i);
		
		/*
		 * Basically the charater at ith index should be attached with 
		 * last i String subStrings
		 */
		int lastIndex = newAns.size()-1;
		int count = i ;
		while ( count-- > 0 ) {
			List<Character> tList = new ArrayList<>(ans.get(lastIndex));
			tList.add(ch);
			newAns.add(tList);
			lastIndex--;
		}
		
		List<Character> t = new ArrayList<>();t.add(ch);
		newAns.add(t);
		
		subStringsCleaned( newAns , str, i+1 );
		
	}
	

}
