package test.app.array;

public class FindTheMiddleIndexInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findMiddleIndex(int[] nums) {
	       
        int rightSum = 0;
        for(int n : nums)
            rightSum += n;
        
        int leftSum = 0;
        for( int i=0;i<nums.length;i++){
            rightSum -= nums[i];
            
            if( rightSum == leftSum )
                return i;
            
            leftSum += nums[i];
        }
        
        return -1;
    }

}
