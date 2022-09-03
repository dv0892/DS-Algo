package test.app.greedy;

public class IntegerReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new IntegerReplacement().integerReplacement(Integer.MAX_VALUE));
	}
	
	
	public int integerReplacement(int n) {
        if ( n <= 1 )
            return 0;
        // checking is n is power of 2
        if( Integer.bitCount(n) == 1 )
            return 31 - Integer.numberOfLeadingZeros(n);
        
        
        if( n%2 == 0 )
            return 1 + integerReplacement(n/2);
        
        /*
         *  if n is odd find nearest power of 2 . Then choose 
         *   if n+1 is closer to that power of 2
         *   else n-1 is closer to that power of 2
         *   
         *   Being greedy
         */
         
        return 1 + Math.min( 0/*integerReplacement(n-1) */, integerReplacement(n+1));
    }
	
	
	public int findNextPowerOf2(int n)
    {
        // decrement `n` (to handle cases when `n` itself
        // is a power of 2)
        n = n - 1;
 
        // do till only one bit is left
        while ((n & n - 1) != 0) {
            n = n & n - 1;        // unset rightmost bit
        }
 
        // `n` is now a power of two (less than `n`)
 
        // return next power of 2
        return n << 1;
    }

}
