package test.app.array;

import java.util.Arrays;

import test.app.utils.Utils;

public class SortArrayByParity {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println(Arrays.toString( new SortArrayByParity().sortArrayByParity( new int[] {1,2,3,4,5})));
		}
	
	  public int[] sortArrayByParity(int[] nums) {
	        
	        int evenCntr=0,oddCntr=nums.length-1;
	        
	        while(evenCntr<oddCntr) {
	            if((nums[evenCntr]&1)== 0)
	                evenCntr++;
	            else
	                Utils.swap(nums,evenCntr,oddCntr--);
	        }
	        
	        return nums;
	        
	 }

}
