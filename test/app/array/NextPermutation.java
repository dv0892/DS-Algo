package test.app.array;

import java.util.Arrays;

import test.app.utils.Utils;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NextPermutation().nextPermutation(new int[] {7,8,11,12,9,7,6,3,1});
	}

	public void nextPermutation(int[] nums) {
        
			int i , j ;
	        i = j = 0;
	    
	        for( i = nums.length - 2 ; i >= 0;  i-- ){
	        	 if( nums[i] < nums[i+1] )    {
	                    break ;
	                } 
	        }
	        
	        if(i<0) {
	        	 for( i=0; i < nums.length/2 ; i++){
	        		 Utils.swap(nums ,i ,nums.length-1-i );
	 	         }
	        	 return;
	        }
	        
	        for( j = nums.length - 1 ; j > i;  j-- ){
	        	 if( nums[j] > nums[i] )    {
	                    break ;
	                } 
	        }
	        
	        Utils.swap(nums,i,j);
	        
	       
	        i++; j=0;
	        int len  = ( i + ( (nums.length - 1 - i + 1) )/2) ;
	        for( ; i < len ; i++){
	        	Utils.swap(nums ,i ,nums.length-1-j );
	            j++;
	        }
	        
	        System.out.println(Arrays.toString(nums));
	         
    }
}
