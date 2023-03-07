package test.app.dp;

public class NumberOfSubArraysWithOddSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numOfSubarrays(int[] arr) {
        int len  = arr.length;
        int[] dp = new int[len];

        int count=0;
        for( int i=0;i<len;i++){
            for( int j=0;j<=i;j++){
                dp[j] += arr[i];
                if( dp[j] % 2 == 1) 
                    count++;
            }
        }

        return count;
    }
	final int MOD = 1_000_000_007;
	public int numOfSubarraysOptimized(int[] arr) {

        int oddStreams = 0, evenStreams =0;
        int count=0;
        for( int e : arr ){
           if( e%2 == 1 ) {
        	   int t = evenStreams + 1;
        	   evenStreams = oddStreams;
        	   oddStreams = t;
           } else 
        	   evenStreams++;
           
           count = (count + oddStreams) % MOD ;
        }

        return count; 
    }

}
