package test.app.search;

import java.util.Arrays;

public class KeepMultiplyingFoundValuesBy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {5,3,6,1,12};
		
		System.out.println( new KeepMultiplyingFoundValuesBy2().findFinalValue( nums, 3 ));
	}
	
	 public int findFinalValue(int[] nums, int original) {
	        
	        Arrays.sort(nums);
	        
	        while( true ){
	            
	            boolean found = binarySearch(nums,0,nums.length-1,original);
	            
	            if(!found)
	                break;
	            
	            original *= 2 ;
	            
	        }
	        
	        return original;
	    }
	    
	    
	    public boolean binarySearch(int[] nums, int st, int end, int x){
	        
	        while (st <= end){
	            int mid = st + (end-st)/2;
	            
	            if(nums[mid] == x)
	                return true;
	            
	            if( x > nums[mid] )
	                st = mid + 1;
	            else
	                end = mid - 1;
	        }
	        
	        return false;
	    }

}
