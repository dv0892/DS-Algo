package test.app.sorts;

import java.util.Arrays;

public class FindFirstMissingNumber {

		/*class Solution { public int solution(int[] A); }

		that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

		For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

		Given A = [1, 2, 3], the function should return 4.

		Given A = [−1, −3], the function should return 1.

		Write an efficient algorithm for the following assumptions:

		N is an integer within the range [1..100,000];
		each element of array A is an integer within the range [−1,000,000..1,000,000].*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int solution(int[] A) {
        Arrays.sort(A);
        // Skip all negative and zeroes
        int i=-1,len=A.length-1;
        while( i < len && A[++i] <= 0 );

        int missing = 1;
        while ( i <= len ){
            if( A[i] == missing )
                missing++;
            else if( A[i] > missing )
                return missing;
            i++;
        }

        return missing;
    }

}

