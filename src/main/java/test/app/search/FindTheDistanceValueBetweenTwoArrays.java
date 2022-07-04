package test.app.search;

import java.util.Arrays;

public class FindTheDistanceValueBetweenTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,4,2,3};
		int[] arr2 = {-4,-3,6,10,20,30};
		
		System.out.println( new FindTheDistanceValueBetweenTwoArrays().findTheDistanceValue(arr1, arr2, 3));
	}
	
	
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		
		int ans = arr1.length;
		
		Arrays.sort(arr2);
		
		for( int el : arr1) {
			if(binarySearch(arr2,el,d))
				ans--;
		}
		
		return ans;
        
    }


	private boolean binarySearch(int[] arr2, int el, int d) {
		
		int st = 0, end = arr2.length - 1;
		int l = el - d, r = el + d;
		
		while ( st <= end ) {
			int mid = st + (end-st)/2;
			
			if( arr2[mid] >= l && arr2[mid] <= r)
				return true;
			
			if( arr2[mid] > r)
				end = mid - 1;
			else
				st = mid + 1;
		}
		
		return false;
	}

}
