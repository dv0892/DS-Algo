package test.app.array;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ShortestDistanceToCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(new ShortestDistanceToCharacter().shortestToChar("loveleetcode",'e')));
	}
	
	public int[] shortestToChar(String s, char c,int t1, int t2) {
        /*
         * this approach is quite in-efficient in terms of time.
         * Since for each value we launching two pointers to check the nearest one.
         * And then picking one.
         * We can also use a tree-set here
         */
		
        int[] ans = new int[s.length()];
        for( int i=0; i<s.length(); i++){
             if( c == s.charAt(i)){
                  ans[i] = 0;
                  continue;
             }
            
             int l = i-1, r = i+1;
             
             while(true){
                 if(l < 0){
                     l = Integer.MAX_VALUE;
                     break;
                 }
                 
                 if(c == s.charAt(l))
                     break;
                 
                 l--;
             }
            
             while(true){
                 if( r == s.length() ){
                     r = Integer.MAX_VALUE;
                     break;
                 }
                 
                 if(c == s.charAt(r))
                     break;
                 
                 r++;
             }
            
             ans[i] = Math.min(Math.abs(i-l), Math.abs(r-i)); 
        }
        
        return ans;
    }
	
	
	public int[] shortestToChar(String s, char c,int t2) {
        /*
         * this approach is quite in-efficient in terms of time.
         * Since for each value we launching two pointers to check the nearest one.
         * And then picking one.
         * We can also use a tree-set here
         */
		TreeSet<Integer> set = new TreeSet<>();
        int[] ans = new int[s.length()];
        for( int i=0; i<s.length(); i++ ){
             if( c == s.charAt(i)){
                  set.add(i);
             }
        }
        
	    for( int i=0; i<s.length(); i++ ){
	        if(set.contains(i)) {
	        	ans[i] = 0;
	            continue;
	        }
	        
	        Integer h = set.higher(i);
	        Integer l = set.lower(i);
	        
	        if(Objects.nonNull(h) && Objects.nonNull(l))
	        	ans[i] = Math.min(Math.abs(i-l), Math.abs(h-i));
	        else if(Objects.nonNull(h))
	        	ans[i] = Math.abs(h-i);
	        else
	        	ans[i] = Math.abs(i-l);
	   }

        return ans;
    }
	

	public int[] shortestToChar(String s, char c) {
		
		int prev = Integer.MAX_VALUE;
		int[] ans = new int[s.length()];
        for( int i=0; i<s.length(); i++ ){
             if( c == s.charAt(i)){
                  prev = i;
             }
             
             ans[i] =  Math.abs(prev-i);
        }
        
        prev = Integer.MAX_VALUE;
	    for( int i=s.length()-1; i>=0; i-- ){
	    	if( c == s.charAt(i)){
                prev = i;
           }
	    	
	    ans[i] =  Math.min( ans[i], Math.abs(prev-i) );
	    }
		
	    return ans;
	}
}
