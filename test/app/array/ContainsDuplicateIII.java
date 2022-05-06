package test.app.array;

import java.util.TreeSet;

public class ContainsDuplicateIII {

	public static void main(String[] args) {
		
		int[] nums = {-2147483648,2147483647};
		System.out.println( new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums, 1, 1));

	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
		 TreeSet<Integer> set = new TreeSet<>();
			
			if( k >= nums.length)
				k = nums.length-1;
			
			int i=0;
			for(; i<nums.length && i<=k;i++) {
				Integer e1 = set.floor(nums[i]);
				if(e1 != null && Math.abs((long)(nums[i]-e1.longValue())) <= t)
					return true;
				
				e1 = set.ceiling(nums[i]);
				if(e1 != null && Math.abs((long)(nums[i]-e1.longValue())) <= t)
					return true;
					
				set.add(nums[i]);
			}
			
			for(; i<nums.length ;i++) {
				
				set.remove(nums[i-k-1]);
				
				Integer e1 = set.floor(nums[i]);
				if(e1 != null && Math.abs((long)(nums[i]-e1.longValue())) <= t)
					return true;
				
				e1 = set.ceiling(nums[i]);
				if(e1 != null && Math.abs((long)(nums[i]-e1.longValue())) <= t)
					return true;
					
				set.add(nums[i]);
			}
			
			return false;
		}

}
