package test.app.greedy;

public class SplitAStringInBalancedStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int balancedStringSplit(String s) {
        
        int l=0, r=0, split = 0 ;
        
        for( int i=0; i<s.length(); i++ ){
            if( s.charAt(i) == 'L' )
                l++;
            else
                r++;
            
            if( l == r )
                split++;
        }
        
        return split;
    }

}
