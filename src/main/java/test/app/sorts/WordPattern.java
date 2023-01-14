package test.app.sorts;

import java.security.KeyStore.Builder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new WordPattern().wordPatternCorrect("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
																 "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"));
	}
	
	public boolean wordPatternCorrect(String pattern, String s) {
		
		Map<Character,Integer> pMap = new HashMap<>();
		Map<String,Integer> sMap = new HashMap<>();
		
		StringBuilder sb = new StringBuilder();int w = 0;
        for(int i=0;i<s.length();i++) {
        	
            if( s.charAt(i) == ' ' || i == (s.length()-1) ) {
            	if( i == (s.length()-1) )
            		sb.append(s.charAt(i));
            	
            	if( w == pattern.length()) 
            		return false;
            	
            	if( !pMap.containsKey(pattern.charAt(w)) ) {
                	pMap.put(pattern.charAt(w), w);
                } 
            	
            	String temp = sb.toString();
            	if( !sMap.containsKey(temp) ) {
            		sMap.put(temp, w);
                } 
            	
                
            	if( Integer.compare( sMap.get(temp) , pMap.get(pattern.charAt(w)) ) != 0 )
            		return false;
            	
            	w++;
                sb.delete(0, sb.length());
                
            } else{
                sb.append(s.charAt(i));
            }
        }
		
		return w == pattern.length();
	}
	
	
	public boolean wordPattern(String pattern, String s) {
        Map<Character,Integer> pMap = new HashMap<>();
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            pMap.merge(pattern.charAt(i),1,(v1,v2)->v1+v2);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if( s.charAt(i) == ' ') {
                map.merge(sb.toString(),1,(v1,v2)->v1+v2);
                sb.delete(0, sb.length());
            } else{
                sb.append(s.charAt(i));
            }
        }

        Collection<Integer> plist = pMap.values();
        Collection<Integer> slist = map.values();
        
        if( plist.size() != slist.size() )
        	return false;
        
        Integer[] a1 = plist.toArray(new Integer[plist.size()]);
        Integer[] a2 = slist.toArray(new Integer[slist.size()]);
        
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        return Arrays.equals(a1, a2);
    }

}
