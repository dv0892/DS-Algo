package test.app.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();
        
        
        int i=0;
        for( ;i<nums.length && i<=k; i++){
            set.add(nums[i]);
        }
        
        if(set.size()>1 && set.size() < (k+1))
            return true;
        
        for( ; i<nums.length ; i++){
            set.remove(nums[i-k-1]);
            set.add(nums[i]);
                
            if(set.size()>1 && set.size() < (k+1))
                return true;
        }
        
        return false;
        
    }
	
}
