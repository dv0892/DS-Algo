package test.app.greedy;

public class Maximum69Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public int maximum69Number (int num) {
        
        int n = num;
        int pos=1,prev=0;
        int ans = num;
        
        while( n > 0){
            int d = n%10;
            if( d == 6 ) {
                int t = (9*pos) + prev;
                ans   =  Math.max( ans , num - (d*pos + prev) + t );
            }
            
            prev = d*pos + prev;
            pos *= 10;
            
            n /= 10;
        }
        
        
        return ans;
    }
}
