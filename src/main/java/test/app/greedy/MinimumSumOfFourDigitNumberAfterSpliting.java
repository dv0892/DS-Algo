package test.app.greedy;

import java.util.Arrays;

public class MinimumSumOfFourDigitNumberAfterSpliting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minimumSum(int num) {
        int[] nums = new int[4];
	
        int i=0;
        while(num > 0) {
            nums[i++]++;
            num /= 10;
        }
	
        Arrays.sort(nums);
	    return (nums[0]*10+nums[2]) + ( (nums[1]*10+nums[3]) );
        
	}
	
	public int minimumSum_BadCode(int num) {
        int[] nums = new int[10];
        
        while(num > 0) {
            nums[num%10]++;
            num /= 10;
        }
        
        int n1 , n2;
        
        int i = 0;
        while( nums[i] == 0 )
            i++;
        
        nums[i]--;
        n1 = 10*i;
        
        while( nums[i] == 0 )
            i++;
        
        nums[i]--;
        n2 = 10*i;
        
        while( nums[i] == 0 )
            i++;
        
        nums[i]--;
        n1 += i;
        
        while( nums[i] == 0 )
            i++;
        
        nums[i]--;
        n2 += i;
        
        
        return n1 + n2;
    }

}
