package test.app.array;

public class ValidPalindromeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "lcupul";
		//System.out.println(new ValidPalindromeII().validPalindrome(str,0,str.length()-1,true));
		System.out.println(new ValidPalindromeII().validPalindrome("lcupucul"));
	}
	
	public boolean validPalindrome(String s) {
        int l = 0 , r = s.length() - 1;
        
		while(l < r) {			
			
            char ch1 = s.charAt(l);
			char ch2 = s.charAt(r);
			
			if( ch1 == ch2 ) {
                l++;r--;
            } else {
                return validPalindrome(s,l+1,r,false) ||  validPalindrome(s,l,r-1,false) ;
            }
		}
        
        return true;
    }
	
	public boolean validPalindrome(String s,int l, int r,boolean oneCharacterRemoval) {
        /*
         * This is the best and easy to understand example of Greedy approach
         * with two pointer.
         * 
         * Here we are making a choice and then later neglecting it of not found correct.
         * *
         */
		if(l > r) 
			return true;
		
	    char ch1 = s.charAt(l);
		char ch2 = s.charAt(r);
		
		if( ch1 == ch2 ) {
	        return true && validPalindrome(s, l+1, r-1,oneCharacterRemoval);
	    } 
		
		if( oneCharacterRemoval ) {
			return validPalindrome(s, l+1, r, false) ? true : validPalindrome(s, l, r-1, false) ;
			
		}
        	
	    return false;
	}

}
