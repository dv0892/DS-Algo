package test.app.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> partition(String s) {
        return partitionPalindrome( s , new ArrayList<>()) ;
    }
    
    
    public List<List<String>> partitionPalindrome(String s, List<String> list) {
        if ( s.isEmpty() ){
            List<List<String>> res = new ArrayList<>();
            res.add( new ArrayList<>(list));
            
            return res;
        }
        
        List<List<String>> res = new ArrayList<>();
        for ( int i=1 ; i <= s.length(); i++ ){
            String partition = s.substring(0,i);
           
            if( isPalindrome(partition) )  {
                
                list.add(partition);
                res.addAll( partitionPalindrome( s.substring(i),list) );
                list.remove(list.size()-1);
            }
        }
        
        return res;
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
