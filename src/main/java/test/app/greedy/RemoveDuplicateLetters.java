package test.app.greedy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new RemoveDuplicateLetters().removeDuplicateLetters("abacb"));
	}
	
	public String removeDuplicateLetters(String s) {
        
		int[] freq = new int[26];
		for (int i=0;i<s.length();i++)
        	freq[s.charAt(i)-97]++;
		
		boolean[] occ = new boolean[26];
		Deque<Character> ans = new LinkedList<Character>();

		for ( int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			freq[c-97]--;
			if( occ[c-97] ) continue ;
			
			while( !ans.isEmpty() && ans.peek() >= c && freq[ans.peek()-97] > 0 &&  !occ[c-97] ) {
				char removed = ans.remove();
				occ[removed-97] = false;
			}
			
			ans.push(c);
			occ[c-97] = true;
		}
		
		StringBuilder s2 = new StringBuilder();
		for( Character c : ans ) {
			s2.append(c);
		}
		
		return s2.reverse().toString();
    }
	
	
	public StringBuilder removeDuplicateLetters(int i, String s, StringBuilder sb,  Map<Character,Integer> freq ) {
        
		if( i == s.length() )
			return sb;
		
		int  t = freq.get(s.charAt(i));
		
		if ( t == 0)
			return removeDuplicateLetters(i+1, s, sb , freq );
		
		if ( t == 1)
			return removeDuplicateLetters(i+1, s, sb.append(s.charAt(i)) , freq ) ;
		
		StringBuilder s2 = new StringBuilder(removeDuplicateLetters(i+1, s, sb , freq ) );
		
		freq.put(s.charAt(i), 0);
		sb.delete( (i+1 == s.length() ? sb.length() : sb.indexOf( ""+s.charAt(i+1) ) ), sb.length() );
		
		StringBuilder s1 = new StringBuilder(removeDuplicateLetters(i+1, s, sb.append(s.charAt(i)) , freq ) );
		
		freq.put(s.charAt(i), t);
		
		
		if ( s1.length() == s2.length() ) {
			int j = 0,k = 0;
			while ( i < s1.length() && j < s2.length() ) {
			  if( s1.charAt(j) < s2.charAt(k) )
				  return s1;
			  else if( s1.charAt(j) > s2.charAt(k) )
				  return s2;
			}
			
			return s1;
		} else
			return s1.length() > s2.length() ? s1 : s2;
    }

}
