package test.app.search;

import java.util.Arrays;

public class CheckIfNAndItsDoubleExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,2};
		
		System.out.println( new CheckIfNAndItsDoubleExist().checkIfExist(arr));
	}
	
	public boolean checkIfExist(int[] arr) {
		
		// This is taking O(n)
		
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length; i++) {
			
			if(arr[i] > 0) {
				if( binarySearch( arr, i+1,  Math.min(arr.length-1, i + arr[i]) , arr[i]*2  ) )
					return true;
			} else if( arr[i] < 0) {
				if( binarySearch( arr, Math.max(0, i + arr[i]) , i-1 , arr[i]*2  ) )
					return true;
			} else {
				if( arr[Math.min(arr.length-1, i + 1 )] == 0 )
					return true;
			}
		}
		
		return false;
		
        
    }

	private boolean  binarySearch(int[] arr, int st, int end, int target ) {
		
	    while( st <= end ) {
	    	int mid = st + (end - st)/2;
	    	if( arr[mid] == target)
	    		return true;
	    	
	    	if( target > arr[mid] )
	    		st = mid + 1;
	    	else 
	    		end = mid - 1;
	    }
		
		return false;
	}


}
