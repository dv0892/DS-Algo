package test.app.array;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
		
	}
	
	public boolean isPalindrome(String s) {
        /*
         * Problem with this solution is that
         * we are using too much space by creating strings 
         * and pattern matcher is slowing the entire execution.
         * */
        /*s = s.replaceAll("[^(A-Za-z)&&^\\d]", "").toLowerCase();
        
        System.out.println(s);
        
        char[] str = s.toCharArray();
        int i = 0,j = str.length-1;
        
        while( i < j ){
            if((str[i++]!=str[j--]))
                return false;
        }        
        */
		
		int l = 0 , r = s.length() - 1;
		
		while(l < r) {
			if( !isAlphaNumeric(s.charAt(l)) )
				while( l<r && !isAlphaNumeric(s.charAt(++l)) );
			
			if( !isAlphaNumeric(s.charAt(r)) )
				while( r>l &&!isAlphaNumeric(s.charAt(--r)) );
			
			char ch1 = s.charAt(l++);
			char ch2 = s.charAt(r--);
			if ( Character.isUpperCase(ch1) )
					ch1 = Character.toLowerCase(ch1);
			
			if ( Character.isUpperCase(ch2) )
					ch2 = Character.toLowerCase(ch2);
			
			if( ch1 != ch2 )
				return false;
				
		}
        
        return true;
        
    }

	private boolean isAlphaNumeric(char ch) {
		// TODO Auto-generated method stub
		return Character.isAlphabetic(ch) || Character.isDigit(ch);
	}

}
