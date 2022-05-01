package test.app.array;

import java.util.Arrays;

public class ArrayParitionI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new ArrayParitionI().arrayPairSum(new int[] {1,4,2,3}));
	}

	public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int res = 0;
        for(int i=0;i<nums.length-1;i+=2){
            res += Math.min(nums[i], nums[i+1]);            
        }
        
        return res;
    }
}
