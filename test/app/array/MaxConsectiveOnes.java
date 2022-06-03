package test.app.array;

public class MaxConsectiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,0,1,1,1};
		System.out.println( new MaxConsectiveOnes().findMaxConsecutiveOnes(nums));
 	}
	
	public int findMaxConsecutiveOnes(int[] nums) {
        
        int max = Integer.MIN_VALUE, currCt = 0;
        
        for(int i=0;i<nums.length;i++){
            if( nums[i] == 0){
                max = Math.max(max,currCt);
                currCt = 0;
            } else
                currCt++;
        }
        
        return Math.max(max,currCt);
    }

}
