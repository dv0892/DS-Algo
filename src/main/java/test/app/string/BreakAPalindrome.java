package test.app.string;

public class BreakAPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String breakPalindrome(String pal ) {
        if( pal.length() == 1 )
            return "";
        
        char[] arr = pal.toCharArray();
        int i=0,len = arr.length ;
        while( i < (len/2) && arr[i]=='a' )
            i++;
        
        if( i < len/2 )
            arr[i] = 'a' ;
        else 
            arr[len-1] = (char)(arr[len-1]+1) ;
            
        
        
        return new String(arr);
        
    }

}
