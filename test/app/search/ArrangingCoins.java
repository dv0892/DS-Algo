package test.app.search;

public class ArrangingCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new ArrangingCoins().arrangeCoins( 1804289383 ));
	}

	
	public int arrangeCoins(int n) {
        
		
		// Overflow in Binary Search Great Example
        int r = 1;
        while ( true ) {
        	long coins = ((long)r * (long)(r+1))/2;// Int Over-Flow here if long not used
        	
        	
            if( coins  > n)
                break;
            r <<= 1 ;
        }
        
        int s = r >> 1 , end = r;
         
        while (s <= end) {
        	int mid = s + (end - s)/2;
        	
        	long coins = (long)((long)mid * (long)(mid+1))/2;
        	if( coins == n) 
        		return mid;
        	
        	if( n > coins )
        		s = mid + 1;
        	else 
        		end = mid - 1;
        }
        
        return end;
    }
}
