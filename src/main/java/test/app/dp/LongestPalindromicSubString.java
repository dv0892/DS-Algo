package test.app.dp;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new LongestPalindromicSubString().longestPalindrome("babad"));
	}
	
	
	
	public String longestPalindrome(String str, int s , int e ) {
        if ( s > e )
        	return "";
        
        if( s == e )
        	return str.substring(s,s+1);
        
        if( str.charAt(s) == str.charAt(e) ) {
        	String res = longestPalindrome( str , s+1, e-1);
        	if( res.length()+2 == str.length() )
        		return res;
        } 
        
        String res1 = longestPalindrome(str , s+1 ,e  ) ;
        String res2 = longestPalindrome(str , s   ,e-1) ;
        
        return res1.length() > res2.length() ? res1 : res2 ;
        
        		
    }
	
	
	public String longestPalindrome(String s) {
        if( s.isEmpty() || s.length() == 1 )
        	return s;
        
        if( s.charAt(0) == s.charAt(s.length()-1) ) {
        	String res = longestPalindrome( s.substring(0,s.length()-2) );
        	if( res.length()+2 == s.length() )
        		return s;
        } 
        
        String res1 = longestPalindrome(s.substring(1)) ;
        String res2 = longestPalindrome(s.substring(0,s.length()-1)) ;
        
        return res1.length() > res2.length() ? res1 : res2 ;
        		
    }
	
	/*public String longestPalindrome(String s) {
        if( s.isEmpty() || s.length() == 1 )
        	return s;
        
        
        String res1 = longestPalindrome(s.substring(1)) ;
        String res2 = longestPalindrome(s.substring(0,s.length()-1)) ;
        
        return res1.length() > res2.length() ? res1 : res2 ;
        		
    }*/
	
	
	


	private boolean isPalindrome(String str) {
		int s = 0 ;
		int e = str.length()-1;
		
		while( s < e) {
			if( str.charAt(s) != str.charAt(e))
				return false;
			s++;
			e--;
		}
		
		return true;
	}

}
