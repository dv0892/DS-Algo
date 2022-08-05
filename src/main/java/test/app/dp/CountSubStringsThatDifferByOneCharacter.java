package test.app.dp;

public class CountSubStringsThatDifferByOneCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new CountSubStringsThatDifferByOneCharacter().countSubstrings("aba", "aba"));
	}
	
	public int countSubstrings(String s, String t) {
        
        int ans=0;
        for( int i=0;i<s.length();i++) {
        	for( int j=0;j<t.length();j++) {
        		
        		int st = i ;
        		int end = j;
        		int d=0;
        		
        		while( st<s.length() && end<t.length() ) {
        			if( s.charAt(st) != t.charAt(end) )
        				d++;
        			
        			if( d == 1 ) ans++;
        			if( d == 2 ) break;
        			
        			st++; end++;
        		}
        	}
        }
        
        return ans;
    }

}
