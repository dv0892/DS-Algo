package test.app.array;

import java.util.Arrays;

import test.app.utils.Utils;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,3,3};
		System.out.println(new RemoveElement().removeElement(nums, 2));
		System.out.println(Arrays.toString(nums));
	}
	
	public int removeElement(int[] nums, int val) {
        
        int  i =  -1, j = 0;
        
        while(j < nums.length){
            if( nums[j] != val )
                Utils.swap(nums,++i,j);
            
            j++;
        }
        
        return ++i;
        
    }

}
