package test.app.greedy;

import java.util.Arrays;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {322,32};
		System.out.println( new LargestNumber().largestNumber(nums));
	}
	
	
	public String largestNumber(int[] nums) {
        
        int n = nums.length;
        String[] arr = new String[n];
        
        int i=0;
        for( int e : nums )
            arr[i++] = String.valueOf(e);
        
        Arrays.sort( arr, (n1,n2) -> { 
                        if( n1.charAt(0) > n2.charAt(0) ) {
                            return -1;
                        } else if( n1.charAt(0) < n2.charAt(0)) {
                            return 1;
                        } else {
                        	return (n1 + n2).compareTo(n2 + n1) ;                      	 
                        }
        } );
        
        StringBuilder ans = new StringBuilder();
        i=0;
        while( i < n )
            ans.append( arr[i++] );
        
        return ans.toString();
    }

}
