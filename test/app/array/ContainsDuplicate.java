package test.app.array;

import java.util.Arrays;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean containsDuplicate(int[] nums) {
        
		// Two approaches either sort the array or use a set.
		
		
        //Set<Integer> set  = new HashSet<>();
        
        if(nums.length == 1)
            return false;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-1;i++){
           if(nums[i] == nums[i+1])
               return true;
        }
        
        return false;
    }

}
