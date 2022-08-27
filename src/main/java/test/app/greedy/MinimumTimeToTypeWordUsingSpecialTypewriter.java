package test.app.greedy;

public class MinimumTimeToTypeWordUsingSpecialTypewriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minTimeToType(String word) {
        int ans = 0, prev = 0;
        
        for( int i=0;i <word.length(); i++ ){
            
            int target = word.charAt(i) - 'a';
            
            int seconds = 0 ;
            if( (prev-target) > 0 ) {
                seconds +=  Math.min(prev-target, 26 + target-prev);
            } else if( (target-prev) > 0 ) {
                seconds +=  Math.min(target-prev, 26 + prev-target);
            }
            
            ans += (seconds+1);
            prev = target;
        }
        
        return ans;
    }

}
