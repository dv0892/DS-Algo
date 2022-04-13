package test.app.string;

public class CountBinarySubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new CountBinarySubStrings().countBinarySubstrings("000111"));
	}
	
	public int countBinarySubstrings(String s,int x) {
        
		
		/*
		 * Logic Building :
		 * 
		 * 1. Check Only Even-sized substrings as only that can contain
		 *  equal number of 0's and 1's. 
		 * 2. Remaining condition that needs to be checked whether this each substring
		 * 	contains 0's and 1's as grouped to one side.
		 *   This can be accomplished using Sliding Window technique, where we slide the
		 *   window ( will be equal to size of substring ) over the array.
		 *   
		 *   This aaproach will show TLE for larger sized arrays.
		 *   How can we improve this Sliding window part ?
		 *   Ans : 
		 *   
		 *   Can we use previous windows result !!!
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
	
	
	public int countBinarySubstrings(String s,char c) {
        
		
		/*
		 * Logic Building :
		 * 
		 * 1. Check Only Even-sized substrings as only that can contain
		 *  equal number of 0's and 1's. 
		 * 2. Remaining condition that needs to be checked whether this each substring
		 * 	contains 0's and 1's as grouped to one side.
		 *   This can be accomplished using Sliding Window technique, where we slide the
		 *   window ( will be equal to size of substring ) over the array.
		 *   
		 *   This aaproach will show TLE for larger sized arrays.
		 *   How can we improve this Sliding window part ?
		 *   Ans : 
		 *   
		 *   Can we use previous windows result !!!
		 * 
		 */
		int res = 0;
		
		for(int i=0;i<s.length()-1;i++) {
			for (int windowSize = 2; (i+windowSize-1)<s.length(); windowSize+=2) {
				int  wr = i+windowSize;
				if(checkIfValidWindow(s,i,wr-1)) {
					res++;
					break;
				}
					
			}
		}
		    
		return res;
    }

	
	public int countBinarySubstrings(String s) {
		
		// Solution that works even for larger data sets
		
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }
	
	
	private boolean checkIfValidWindow(String s, int l, int r) {
		int lp = l;
		int prev1 = s.charAt(l);
		
		int rp = r;
		int prev2 = s.charAt(r);
		
		int len = r-l+1;
		
		while( lp <= r && prev1 == s.charAt(lp))
			lp++;
		
		if(len/2 != (lp-l))
			return false;
		
		while( rp >= l && prev2 == s.charAt(rp))
			rp--;
		
		if( (lp-1==rp) && (lp-l) ==(r-rp))
			return true;
		
		
		return false;
	}

}
