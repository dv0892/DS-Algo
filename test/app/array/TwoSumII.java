package test.app.array;

import java.util.Arrays;

public class TwoSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(Arrays.toString( new TwoSumII().twoSum(new int[]{1,2,4,5}, 5) ));
	}
	
	 public int[] twoSum(int[] nums, int target) {
	        
	        int[] ans = new int[]{0,0};
	        for(int i=0,j=nums.length-1; i < j;  ){
	            if(nums[i] + nums[j] == target){
	                ans[0] = i+1;
	                ans[1] = j+1;
	                break;
	            } else if ( (nums[i] + nums[j]) > target) {
	                j--;
	            } else {
	                i++;
	            }
	                
	        }
	        
	        return ans;
	        
	    }

}
