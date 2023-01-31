package test.app.codility;

import java.util.Arrays;

public class TheCoderOfRivia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( Arrays.toString( new TheCoderOfRivia().solution( new int[] { 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1 } ) ) ) ;
	}
	
	public int[] solution(int[] A) {
		long max = Long.MIN_VALUE;
        long[][] mat = new long[4][4];
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                long el = A[r*3 + c];
                mat[r][c] = el;
                mat[r][3] += el;
                mat[3][c] += el;
                max = Math.max(max,Math.max(mat[r][3],mat[3][c]));
            }
        }
        
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                if( mat[r][3] == max )
                	break;
                
                if( mat[3][c] == max )
                	continue;
                
                long diff = (max -  Math.max(mat[r][3], mat[3][c] ));
                mat[r][3]+= diff;
                mat[3][c]+= diff;
                mat[r][c]+= diff;
                A[r*3+c] = (int) mat[r][c];
            }
        }
 
        return A;
    }

}
