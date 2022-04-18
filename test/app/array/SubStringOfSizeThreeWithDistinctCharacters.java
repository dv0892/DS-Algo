package test.app.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubStringOfSizeThreeWithDistinctCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new SubStringOfSizeThreeWithDistinctCharacters().countGoodSubstrings("aababcabc",3));
	}
	
	public int countGoodSubstrings(String s,int k ) {
		
		/*
		 * This solution is quite naive.
		 * What if they ask us to find a substring of size K with distinct characters.
		 * The below code require lot of changes.
		 * 
		 * Let's use some data structure to keep track of
		 * elements.
		 * 
		 */
		
        int res = 0;
        
        /*for(int i=0;i<s.length()-2;i++){
            if(     s.charAt(i)  !=s.charAt(i+1)
                 && s.charAt(i+1)!=s.charAt(i+2)
                 && s.charAt(i)  !=s.charAt(i+2)
              )
                res++;
        }*/
        
        Set<Integer> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        
        int i=0;
        for( ;i<s.length() && i<k;i++){
        	map.merge(s.charAt(i), 1, (v1,v2)-> v1+v2);
        }
        
        res = map.size() == k ? 1 : 0;
        
        // Let start checking other substring of size
        //Here we are checking the substring of size in backward manner.
        // At index i, the substring being considered will range from i-k to i.
        for( ; i<s.length() ; i++) {
        	
        	map.computeIfPresent(s.charAt(i-k), (key,v)-> v==1 ? null : v-- );
        	map.merge(s.charAt(i), 1, (v1,v2)-> v1+v2);
        	
        	res += (map.size() == k ? 1 : 0);
        }
        
        
        return res;
    }

}
