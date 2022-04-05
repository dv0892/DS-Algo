package test.app.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(Arrays.toString( new TwoSum().twoSum(new int[]{2,4,1,5}, 5) ));
	}
	
	public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> map  = new HashMap<>();
        
        int[] ans = new int[]{0,0};
        for(int i=0; i < nums.length ;  i++) {
            
            if( map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            
            map.put(nums[i],i);
            
                
        }
        
        return ans;
        
    }

}
