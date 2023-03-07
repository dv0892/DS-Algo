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
	
	public int solutionNew(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int n = A.length;
        int missing = -1;
        for( int i=0;i<n;i++){
            if( A[i] <= 0 )
                continue;

            if( (i-1)>=0){
                if( A[i-1] <= 0 ){
                    if( A[i] > 1 ) {
                        missing = 1; 
                        break; 
                    }
                } else if( (A[i] - A[i-1]) > 1){
                    missing = A[i-1]+1;
                    break;
                }
            } else if( A[i] > 1 ) {
            	missing = 1;
            	break;
            }
        }

        return missing > 0 ? missing : ( A[n-1] <= 0 ? 1 : (A[n-1]+1) ); 
    }
	
	
	public int solutionNewNew(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int n = A.length;
        int missing = 0;
        for( int i=0;i<n;i++){
            if( A[i] <= 0 )
                continue;

            if( A[i] >= missing && (A[i]-missing) <= 1 ) {
            	missing = Math.max(missing, A[i]);
            } else
            	return missing+1;
        }

        return missing+1;
    }

}

