package test.app.search;

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,4,2,2};
		System.out.println( new FindTheDuplicateNumber().findDuplicateUsingBinarySearch(nums));
	}
	
	public int findDuplicateUsingBinarySearch(int[] nums) {
		
		// Since the range of numbers is 1-n so the missing number would be from this range only.
		// what we can do is do binary search over this range and for each element 
		// if the count of elements <= number  is true ( this means there is no duplicate number on left other wise this count wouldn't have hold true)
		// So we would move to right region l = mid + 1;
		
		// if the count of elements <= number if false 
		// ( this means this(mid) could be duplicate number or there could be more duplicate number on left)
		//So we would move to left region h = mid - 1;
        
		int l=1,h=nums.length-1;
		while(l <= h) {
			int mid =  l +(h-l)/2;
			
			int ct=0;
			for(int n : nums) {
				if( n <= mid ) {
					ct++;
				}
			}
			
			if( ct <= mid)
				l = mid+1;
			else
				h = mid-1;
		}
		
		return l;
	}
	
	public int findDuplicate(int[] nums) {
		
		// This is actually using the idea of  Floyd's cycle-finding algorithm
        
		if( nums.length <= 1)
            return -1;
        
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(true ) {
        	if( slow == fast )
        		break;
            
            slow = nums[slow];
        	fast = nums[nums[fast]];
        }
        
        fast = 0;
        while (fast != slow) {
          slow = nums[slow];
          fast = nums[fast];
        }
        
        return slow;
	}

}
