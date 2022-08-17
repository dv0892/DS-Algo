package test.app.greedy;

public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
		System.out.println( new JumpGameII().jump_Leet(nums));
	}

	
public int jump_CleanCode(int[] nums) {
		
		if( nums.length == 1 )
			return 0;
		
		int n = nums.length-1;
		int farthestIndex = 0 , count = 0 , EndOfRange = 0;
		
		
		for( int i=0;i<n;i++) {
			farthestIndex = Math.max(farthestIndex, i + nums[i]);
			if( i == EndOfRange ) {
				farthestIndex = EndOfRange = farthestIndex;
				count++;
			}
		}
		
		return count;
		
    }
	
	public int jump(int[] nums) {
		
		if( nums.length == 1 )
			return 0;
		
		int n = nums.length-1;
		int s = 0 , count = 0 ;
		
		while( true ) {
			
			int t = Math.min(n, s + nums[s]);
			if ( t == n ) 
				return count + 1;
			
			int i = s , j = t, t1 = Math.min(n,t+nums[t]) , max_i = t;
			while( ++i < j ) {
				if ( ( Math.min(n,i+nums[i]) ) > t1 ) {
					max_i = i;
					t1 = Math.min(n,i+nums[i]);
				}
			}
			count++;
			s = max_i ;
		}
    }
	
	
	public int jump_Leet(int[] nums) {
        int n = nums.length;
        int jump =0;
        for(int a =0; a<n-1;)
        {
            int endofrangeindex = a+nums[a];
            if( endofrangeindex >= n-1)
            {
                jump++;
                break;
            }
            int farthestindex = a;
            int indexwithfarthestindexjump = a;
            
            for(int b = a+1; b<=endofrangeindex; b++)
            {
                if(b+nums[b] > farthestindex)
                {
                    farthestindex = b + nums[b];
                    indexwithfarthestindexjump = b;
                }
            }
            a = indexwithfarthestindexjump;
            jump++;
        }
        return jump;
    }
}
