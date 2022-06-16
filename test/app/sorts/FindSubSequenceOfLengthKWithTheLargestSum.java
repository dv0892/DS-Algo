package test.app.sorts;

import java.util.Arrays;

public class FindSubSequenceOfLengthKWithTheLargestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5,-2,6,1};
		
		System.out.println( Arrays.toString(  new FindSubSequenceOfLengthKWithTheLargestSum().maxSubsequence(nums, 3)));
	}
	
	
	public int[] maxSubsequence(int[] nums, int k) {
        
        int[][] t1 = new int[nums.length][2];
        for( int i=0;i<nums.length;i++){
            t1[i][0] = nums[i] ; t1[i][1] = i ;
        }
        
        /*Arrays.sort(t1, ( e1 ,e2 ) -> e1[0] - e2[0] );
        
        System.out.println( Arrays.toString( t1 ) );
        
        Arrays.sort(t1, ( e1 ,e2 ) -> e2[0] - e1[0] );
        
        System.out.println( Arrays.toString( t1 ) );*/
        
        Arrays.sort(t1, ( e1 ,e2 ) -> e1[0] - e2[0] );
        
        Arrays.sort(t1 , t1.length-k,t1.length, ( e1 ,e2 ) -> e1[1] - e2[1] );
        
        int[] res = new int[k];
        for( int i=t1.length-k,j=0;i<t1.length;i++){
        	res[j++] = t1[i][0];
        }
        
        return res;
        
    }

}
