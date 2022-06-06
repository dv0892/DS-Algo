package test.app.search;

public class TwoSumIIInputArrayIsSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] twoSum(int[] nums, int target) {
        int s=0,e=nums.length-1;
        while(s < e){
            int sum = nums[s] + nums[e];
            if( sum == target )
                break;
            
            if( sum > target)
                e--;
            else 
                s++;
        }
        
        int[] res = {s+1,e+1};
        
        return res;
    }

}
