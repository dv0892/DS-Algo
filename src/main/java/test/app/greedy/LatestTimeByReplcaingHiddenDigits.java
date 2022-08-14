package test.app.greedy;

public class LatestTimeByReplcaingHiddenDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new LatestTimeByReplcaingHiddenDigits().maximumTime("0?:??"));
	}
	
	public String maximumTime(String time) {
		char h1 = time.charAt(0);
        char h2 = time.charAt(1);
        
        char m1 = time.charAt(3);
        char m2 = time.charAt(4);
        
        if( h1 == '?' )
        	h1 = (char)( (h2 !='?' && h2 >= 52) ? 49 : 50 );
        
        if( h2 == '?')
        	h2 = (char)( h1 < 50  ? 57 : 51 );
        
        m1 = ( m1 == '?' ? 53 : m1 );
        m2 = ( m2 == '?' ? 57 : m2 );
        
        return new String( new char[] { h1,h2,58,m1,m2} );
    }

}
