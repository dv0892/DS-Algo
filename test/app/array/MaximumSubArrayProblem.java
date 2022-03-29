package test.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubArrayProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(-2,1,-3,4,-1,2,1,-5,4));
		System.out.println(new MaximumSubArrayProblem().maxSubArray(A));
	}
	
	public int maxSubArray(final List<Integer> A) {
        int local_max = 0;
        int global_max = Integer.MIN_VALUE;

        for(int el : A){
            local_max  = Math.max(el , el + local_max);
            global_max = Math.max(local_max, global_max) ;
        }

        return global_max;
        
    }

	
}
