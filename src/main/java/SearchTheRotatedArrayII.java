
public class SearchTheRotatedArrayII {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
		
		System.out.println( new SearchTheRotatedArrayII().search(nums, 2));

	}
	
	public boolean search(int[] a, int target) {
	       
	       int st = 0, end = a.length - 1;			
		   while(st <= end) {
				int mid = st + (end - st)/2;
				if ( target == a[mid] )
					return true;
				

	            if(  a[st] == a[mid] ){
		            // one half must contain duplicates we must skip that 
		            // either from st to mid or mid to end
	            	// mid is not the answer , that is already ruled out.
		            int j=st;
		            while(j<mid && a[j]==a[st] )
		                  j++;
		                
		            if( j==mid )
		                st=mid+1;
		            else
		                end=mid-1;
	
		            // or from mid to end            
	            
	            } else if ( a[st] <= a[mid] )// <=  sign Because increasing part of mountain could consist of one element 
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

	        return false;
	    }

}
