package test.app.array;

public class SumOfEvenNumberQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int evenSum = 0;
        for( int n : nums ) { 
            evenSum += ( (n&1) == 0 ) ? n : 0;
        }
        
        int i=0;
        int[] answer = new int[queries.length];
        for (int[] q : queries ){
            int val   = q[0];
            int index = q[1];
            
            int newNums = nums[index] + val;
            
            evenSum = answer[i++] = ( evenSum 
                                     - ( (Math.abs(nums[index]) & 1) == 0 ? nums[index] : 0 ) 
                                     + ( (Math.abs(newNums) & 1) == 0 ? newNums : 0 ) 
                                    );
            
            nums[index] = newNums;
        }
        
        
        return answer;
    }
}
