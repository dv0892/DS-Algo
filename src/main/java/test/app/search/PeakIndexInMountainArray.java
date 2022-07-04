package test.app.search;

public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 24,69,100,99,79,78,67,36,26,19 };
		System.out.println( new PeakIndexInMountainArray().peakIndexInMountainArray(a));
		
	}
	
	public int peakIndexInMountainArray(int[] a) {
		
		
		/*
		 * In this problem the array is resembling a  mountain
		   first increasing and then decreasing. We have to find inflection point.
		   Now if we break the array in half, we could possible land at three 
		   possible positions :
		   1. at inflection point
		       Condition could be something like ( a[mid] > a[mid-1]  && a[mid] > a[mid-1] )
		   2. at increasing part of mountain
		   		Condition could be something like if( a[mid] < a[mid+1] )
		   
		   3. at decreasing part of mountain.
		   
*/        
        
        int st = 0, end = a.length - 1;
		
		while(st <  end) {
			
			int mid = st + (end - st)/2;
			
			if( a[mid] > a[mid-1]  && a[mid] > a[mid+1] )
				return mid;
			
            // Move to part which will contain the mountain
			if( a[mid] < a[mid+1])
				st = mid + 1;
			else
				end = mid - 1;
		}
		
		return -1;
        
    }

}
