package test.app.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class FindKClosesrElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,2,5,5,6,6,7,7,8,9};
		System.out.println( new FindKClosesrElements().findClosestElementsUsingPriortyQueue(arr, 7, 7));
	}
	
	public List<Integer> findClosestElementsUsingPriortyQueue(int[] arr, int k, int x) { 
		

		    // Time : O( nlogk )
			// Space : O(k)
			
			if( k == arr.length )
	            return Arrays.stream(arr)
	            	      .boxed()
	            	      .collect(Collectors.toList());
			
			PriorityQueue<Pair> pq = new PriorityQueue<>(k,(p1,p2)-> {
				if( p1.diffX < p2.diffX )
					return 1 ;
				else if( p1.diffX == p2.diffX )
					return p1.e - p2.e;
				return 0;
			});
			
			for ( int el : arr) {
				if( pq.size() < k ) {
					pq.add(new Pair(el, Math.abs(x-el)));
				} else {
					int diffX = Math.abs(x-el);
					Pair p = pq.peek();
					if( p.diffX > diffX || ( p.diffX == diffX && el < p.e) ) {
						pq.remove(); pq.add(new Pair(el, diffX) );
					} 
				}
					
			}
			
			List<Integer> ans = new ArrayList<>();
			for( Pair p : pq ) {
				ans.add(p.e);
			}
	        Collections.sort(ans);
			return ans ;
	    }

	    static class Pair {
			
			int e , diffX;
			
			Pair( int e , int diffX){
				this.e = e;
				this.diffX = diffX;
			}
		}
	
public List<Integer> findClosestElements(int[] arr, int k, int x) {
	
			// Time : O( log(n) + k + klogk )
			// Space : O(1)
        
        if( k == arr.length )
            return Arrays.stream(arr)
            	      .boxed()
            	      .collect(Collectors.toList());
        
        int i = bs( arr , x );
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[i]);
        
        int p1 = i-1 , p2 = i+1;
        while( --k > 0 ){
            if( p1 < 0 )
                ans.add(arr[p2++]);
            else if( p2 == arr.length )
                ans.add(arr[p1--]);
            else{
                if( Math.abs(x-arr[p2]) < Math.abs(x-arr[p1]) )
                    ans.add(arr[p2++]);
                else
                    ans.add(arr[p1--]);
            }
        }
        
        Collections.sort(ans);
        return ans;    
    }
    
    public int bs(int[] arr, int x) {
        int s = 0 , e = arr.length-1;
        while( s <= e ) {
            int mid = (s+e)/2;
            if( arr[mid] == x )
                return mid;
            
            if( x > arr[mid] )
                s = mid+1;
            else
                e = mid-1;
        }
        
        if( s == arr.length )
            return e;
        else if ( e < 0 )
            return s;
        else
            return Math.abs(x-arr[e]) < Math.abs(x-arr[s]) || ( Math.abs(x-arr[e]) == Math.abs(x-arr[s]) )  ? e : s;
    }

}
