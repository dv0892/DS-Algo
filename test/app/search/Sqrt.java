package test.app.search;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new Sqrt().mySqrt( 2147395599 ));
	}
	
	public int mySqrt(int x) {
        
        if( x <= 1 )
            return x;
        
        int st = 1, end = x >> 1;
		
		while(st <=  end) {
			
			int mid = st + (end - st)/2;
			
            long sq =  (long)mid*(long)mid;
			if(sq == x)
				return mid;
			
			if( sq < x)
				st = mid + 1;
			else
				end = mid - 1;
		}
		
		return end;
        
    }

}
