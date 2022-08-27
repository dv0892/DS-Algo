package test.app.greedy;

public class WiggleSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int wiggleMaxLength(int[] nums) {
	       int len = 1, i = 0;
			boolean  negDiff = true, posDiff = true ;
			
			while( i < nums.length-1 ) {
				if( nums[i+1] - nums[i]  != 0 ) {
					if( nums[i+1] > nums[i] )
						posDiff = false;
					else
						negDiff =  false;
					
					len++;i++;
					break;
				}
				i++;
			}
			
			
			while( i < nums.length-1 ) {
				if( nums[i+1] - nums[i]  != 0 ) {
					if( posDiff && nums[i+1] > nums[i] ) {
						len++ ; negDiff = !negDiff; posDiff = !posDiff;
					} else if( negDiff && nums[i+1] < nums[i] ) {
						len++ ; negDiff = !negDiff; posDiff = !posDiff;
					}
				}
				i++;
			}
			
			
			
			return len;
	    }

}
