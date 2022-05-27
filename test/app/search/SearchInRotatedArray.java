package test.app.search;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		int[] a = {3,1,2,3,4};
		// TODO Auto-generated method stub
		System.out.println( new SearchInRotatedArray().search( a  , 1) );
	}
	
	
	public int search(int[] a, int target) {
		
		int st = 0, end = a.length - 1;
			
		while(st <= end) {
			int mid = st + (end - st)/2;
			if ( target == a[mid] )
				return mid;
			
			if( a[st] <= a[mid] )// <=  sign Because increasing part of mountain could consist of one element 
			{
				if(  a[st] <= target  && target < a[mid] ) {
					end = mid - 1;
				} else
					st = mid + 1;
				
			} else {
				if(  a[mid] < target  && target <= a[end] ) {
					st = mid + 1;
				} else
					end = mid - 1;
			}
		}
		
		
		return -1;
        
    }

}
