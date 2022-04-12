package test.app.string;

public class CountBinarySubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new CountBinarySubStrings().countBinarySubstrings("00110011"));
	}
	
	public int countBinarySubstrings(String s) {
        
		
		/*
		 * Logic Building :
		 * 
		 * 1. Check Only Even-sized substrings as only that can contain
		 *  equal number of 0's and 1's. 
		 * 2. Remaining condition that needs to check whether this each substring
		 * 	contains 0's and 1's as grouped to one side.
		 * 
		 */
		int res = 0;
		
		for (int windowSize = 2; windowSize<s.length(); windowSize+=2) {
			
			int wl = 0, wr = windowSize-1;
			
			while( (wr < s.length()) ) {
				
				if(checkIfValidWindow(s,wl,wr))
					res++;
				
				wl++;
				wr++;
			}
		}
		
		return res;
    }

	private boolean checkIfValidWindow(String s, int l, int r) {
		int lp = l;
		int prev1 = s.charAt(l);
		
		int rp = r;
		int prev2 = s.charAt(r);
		
		while( lp <= r && prev1 == s.charAt(lp))
			lp++;
		
		while( rp >= l && prev2 == s.charAt(rp))
			rp--;
		
		if( (lp-1==rp) && (lp-l) ==(r-rp))
			return true;
		
		
		return false;
	}

}
