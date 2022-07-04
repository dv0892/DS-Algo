package test.app.array;

import java.util.Arrays;

import test.app.utils.Utils;

public class SortOrderByParityII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( Arrays.toString(new SortOrderByParityII().sortArrayByParityII(new int[] {1,2,3,4}) ));
	}
	
	public int[] sortArrayByParityII(int[] nums) {
        
        int l=0,r=1;
	        
	        while(true ) {
                while( l<nums.length &&  ((nums[l]&1)==0) ) 
                    l+=2;
                
                while( r<nums.length && ((nums[r]&1)==1)  )
                    r+=2;
                
                if(  l>nums.length || r>nums.length ) 
                    break;
                
	            Utils.swap(nums,l,r);
                l+=2;r+=2;
	        }
	        
	        return nums;
        
    }

}
