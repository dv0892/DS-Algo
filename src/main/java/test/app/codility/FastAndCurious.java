package test.app.codility;

public class FastAndCurious {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int[] A) {
	       long dist = 0l;
	       long[] cityWise = new long[A.length];

	       for( int i=0;i<A.length;i++ ){
	           dist += cityWise[i] = ( A[A.length-1] - A[i]) ;
	        }

	        long maxReducedDist = Long.MIN_VALUE;
	        for( long i=0;i<A.length-1;i++) {
	            maxReducedDist = Math.max( maxReducedDist , ((i+1)*cityWise[(int)i]) );
	        }
	       return (int)((dist - maxReducedDist)%(1_000_000_007));
	    }

}
