package test.app.search;

import java.util.concurrent.ThreadLocalRandom;

public class kthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,3,1,2,4,5,5,6};
		
		System.out.println( new kthLargest().findKthLargest(nums, 6) );
	}
	
	public int findKthLargest(int[] nums, int k) {
        
		int l=0,r=nums.length-1;
		k = nums.length-k;
		
		while( true ) {
		
			Pair pair = partition(nums, l, r);
			
			if ( k >= pair.s && ( (k)  <= pair.e ) ) {
				int i = pair.s;
				while( i <= pair.e ) {
					if( (k)== i++ )
						return nums[i-1];
				}
			}
			
			if( k < pair.s ) {
				r = pair.s-1;
			} else {
				l = pair.e+1;
			}
			
		}
		
    }
    
    public Pair partition( int[] nums , int l , int r ){
        
        int i = l-1;
        int j = l;
        int k = r+1;
        
        int random = ThreadLocalRandom.current().nextInt(l,r+1);
        int pivot = nums[random];
        
        while( j < k ) {
            if( nums[j] == pivot) {
                j++;
            } else if ( nums[j] < pivot ) {
                swap(nums,++i,j++);
            } else {
                swap(nums,--k,j);
            }
        }
        
        Pair p = new Pair();
        p.s = i+1;
        p.e = j-1;
        
        return p;
    }
    
    public void swap( int[] nums , int i , int j ){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    static class Pair {
        int s , e;
    } 

}
