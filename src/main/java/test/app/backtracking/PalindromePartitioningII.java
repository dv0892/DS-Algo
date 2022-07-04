package test.app.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minCut(String s) {
        return partitionPalindrome( s , new ArrayList<>());
    }
    
    
    public int partitionPalindrome(String s, List<String> list) {
    	
    	/*
    	 *  This Solution is fine but since this is a Hard problem ,we need to use 
    	 *  Dynamic Programming in this.
    	 *  
    	 *  
    	 */
    	
    	
        if ( s.isEmpty() ){
            return list.size()-1;
        }
        
        int min = Integer.MAX_VALUE;
        for ( int i=1 ; i <= s.length(); i++ ){
            String partition = s.substring(0,i);
           
            if( isPalindrome(partition) )  {
                
                list.add(partition);
                min = Math.min( partitionPalindrome( s.substring(i),list) , min );
                list.remove(list.size()-1);
            }
        }
        
        return min;
    }
    
    public boolean isPalindrome( String str ){
        int s = 0 ; int e = str.length()-1;
        while ( s <= e){
            if ( str.charAt(s++) != str.charAt(e--) )
                return false;
        }
        return true;
    }

}
