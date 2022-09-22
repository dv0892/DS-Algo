package test.app.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumLengthOfRepeatedSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new MaximumLengthOfRepeatedSubarray().findLength_UsingDp(
				 new int[]{1,2,3,2,1}, new int[]{ 3,2,1,4,7} ) );
		
	}

	
	public int findLength_UsingDp(int[] nums1, int[] nums2) {
       int[][] dp = new int[nums1.length+1][nums2.length+1];
       
       int max = Integer.MIN_VALUE;
       for ( int i=nums1.length-1;i>=0 ; i-- ) {
    	   for ( int j=nums2.length-1;j>=0 ; j--) {
        	   dp[i][j] = ( ( nums1[i] == nums2[j] ) ? 1 : 0 ) + dp[i+1][j+1];
        	   max = Math.max(max, dp[i][j]);
           }
       }
       
       for( int[] d : dp) {
    	   System.out.println(  Arrays.toString(d) ) ;
       }
       
       
       return max ;
		
        
    }
	
	
	public int findLength_UsingHashing(int[] nums1, int[] nums2) {
        // Space - O(m)
		// Time -  O(m*n*min(m,n))
		Map<Integer,List<Integer>> hash = new HashMap<>();
		for ( int j=0;j<nums2.length;j++){
            List<Integer> indexes = hash.getOrDefault(nums2[j],new ArrayList<>());
            indexes.add(j);
            hash.put(nums2[j], indexes );
        }
		
        int count = 0;
        for ( int i=0;i<nums1.length;i++){
           for ( Integer j : hash.getOrDefault(nums1[i],new ArrayList<>()) ){
                count = Math.max(count,count(i,j,nums1,nums2));
           }  
        }
        
        return count;
        
    }
	
	public int findLength_TLE(int[] nums1, int[] nums2) {
        
        int count = Integer.MIN_VALUE;
        for ( int i=0;i<nums1.length;i++){
           for ( int j=0;j<nums1.length;j++){
                count = Math.max(count,count(i,j,nums1,nums2));
            } 
        }
        
        return count;
        
    }
    
    public int count ( int i, int j, int[] nums1 , int[] nums2 ){
              
        int count = 0;
        while ( i<nums1.length   && 
                j<nums2.length   && 
                nums1[i] == nums2[j]  ) {
            count++;
            i++;j++;
        }

        return count;
    }

}
