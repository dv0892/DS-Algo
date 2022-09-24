package tes.app.bitmanipulation;

public class ConcatenationOfConsectiveBinaryNumbers {

	public static void main(String[] args) {
		
		System.out.println( new ConcatenationOfConsectiveBinaryNumbers().concatenatedBinaryOptimized(1000));
	}
	
	
public int concatenatedBinaryOptimized(int n) {
        
		
		int MOD = (int)1e9+7;
		
		int i=2 ;int ans = 1;
		while ( i <= n ) {
			int shift = bits(i);
			System.out.println( i + " --> " + shift);
			ans = ( ((ans<<shift)) + i ) % MOD;
			i++;
		}
	
		
		return (int)ans;
    }
	
	private int bits(int n) {
		return Integer.SIZE - Integer.numberOfLeadingZeros(n);
	}


	public int concatenatedBinary(int n) {
        
		// Time : O( n + lg2(1+2+3+4+5+...+n)
		StringBuilder sb = new StringBuilder();
		
		int MOD = 1000000007;
		
		int i=1;
		while ( i <= n ) {
			sb.append(Integer.toBinaryString(i));
			i++;
		}
	
		int ans = 1;
		i = 1 ;
		while ( i < sb.length() ) {
			ans =  (ans*2)%MOD;
			if( sb.charAt(i++) == 49 )
				ans =  (ans+1)%MOD;
		}
		
		return ans;
    }

}
