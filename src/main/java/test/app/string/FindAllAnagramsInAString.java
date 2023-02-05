package test.app.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

	public static void main(String[] args) {
		System.out.println( new FindAllAnagramsInAString().findAnagrams("baa","aa"));

	}
	
	public List<Integer> findAnagrams(String s, String p) {
        if( p.length() > s.length() )
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        int[] windowCount = new int[26];
        for( int i=0;i<p.length();i++) {
            count[s.charAt(i)-'a']++;
            windowCount[p.charAt(i)-'a']++;
        }
        
        if( Arrays.equals(count,windowCount) )
            res.add(0);

        for( int i=1;(i + p.length())<=(s.length()); i++) {
        	 count[s.charAt(i-1)-'a']--;
        	 count[s.charAt(i + p.length()-1)-'a']++;
             if( Arrays.equals(count,windowCount) )
                res.add(i);
        }

        return res;
    }

}
