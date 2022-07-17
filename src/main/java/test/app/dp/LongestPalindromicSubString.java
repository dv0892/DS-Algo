package test.app.dp;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new LongestPalindromicSubString().longestPalindrome("babad"));
	}
	
	
	public String longestPalindrome(String s) {
        if( s.isEmpty() || s.length() == 1 || isPalindrome(s) )
        	return s;
        
        String res1 = longestPalindrome(s.substring(1)) ;
        String res2 = longestPalindrome(s.substring(0,s.length()-1)) ;
        
        return res1.length() > res2.length() ? res1 : res2 ;
        		
    }


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
