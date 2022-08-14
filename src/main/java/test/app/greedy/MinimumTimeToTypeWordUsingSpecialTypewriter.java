package test.app.greedy;

public class MinimumTimeToTypeWordUsingSpecialTypewriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minTimeToType(String word) {
        int ans = 0, prev = 0;
        
        for( int i=0;i <word.length(); i++ ){
            
            int c = word.charAt(i) - 'a';
            
            int seconds = 0 ;
            if( (prev-c) > 0 ) {
                seconds +=  Math.min(prev-c, 25 - prev + c + 1);
            } else if( (c-prev) > 0 ) {
                seconds +=  Math.min( c-prev, prev + 25 - c + 1);
            }
            
            ans +=  (++seconds);
            prev = c;
        }
        
        return ans;
    }

}
