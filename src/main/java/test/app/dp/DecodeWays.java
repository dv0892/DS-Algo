package test.app.dp;

public class DecodeWays {

	public static void main(String[] args) {
		System.out.println( new DecodeWays().numDecodingsDpOpt("999999999119999999"));
	}
	
	
	public int numDecodingsDpOpt(String s) {
		if( s.charAt(0) == 48 )
        	return 0;
		
		int n2  = 1;
		int n1  = (s.charAt(s.length()-1) == 48) ? 0 : 1;
		for( int i=s.length()-2;i>-1;i--) {
			int n = 0;
			if( s.charAt(i) != 48 )  {
				n = n1 ;
				if( s.charAt(i) == 49 || ( s.charAt(i) == 50 && s.charAt(i+1) < 55) ) {
					n +=  n2;
				}
			}
				n2 = n1;
				n1 = n;
	    }
		
		
		return n1;
    }
	
	public int numDecodingsDp(String s) {
		if( s.charAt(0) == 48 )
        	return 0;
		
		int[] dp = new int[s.length()+2];
		dp[dp.length-1] = 0;
		dp[dp.length-2] = 1;
		dp[dp.length-3] = s.charAt(s.length()-1) == 48 ? 0 : 1;
		for( int i=s.length()-2;i>-1;i--) {
			if( s.charAt(i) == 48 )
	        	dp[i] = 0;
			else {
				dp[i] += dp[i+1];
				if( s.charAt(i) == 49 || ( s.charAt(i) == 50 && s.charAt(i+1) < 55) ) {
					dp[i] += dp[i+2];
				}
			}
		}
		
		return dp[0];
    }
	
	public int numDecodings(String s) {
        return numDecodings(s, 0);
    }
    
    public int numDecodings(String s , int i ) {
        if( i == s.length() )
            return 1;
        
        if( s.charAt(i) == 48 )
            return 0;
        
        int ans1 = numDecodings(s,i+1);
        int ans2 = 0;
        
        if( i+2 <= s.length() ) {
            int n = Integer.parseInt(s.substring(i,i+2));
            if( n <= 26 ){
                ans2 = numDecodings(s,i+2);
            }
        }
        
        return ans1 + ans2;
    }

}
