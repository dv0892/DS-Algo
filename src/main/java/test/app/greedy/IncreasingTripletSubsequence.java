package test.app.greedy;

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new IncreasingTripletSubsequence().increasingTriplet( new int[] {
		/*1,0,0,0,0,10,0,0,0,10000*/		
		50,40,60,30,39,30,20,25,27}));
	}
	
	 public boolean increasingTriplet(int[] nums) {
	     //  GOOD QUESTION
         if( nums.length < 3 )
        	 return false;
         
         int min1 , min2, pmin1 , pmin2 ;
         pmin1 = pmin2 =min1 = min2 = nums[0];
         
         for ( int i=1;i<nums.length;i++) {
        	 if( (pmin1 < pmin2 && pmin2 < nums[i]) || (min1 < min2 && min2 < nums[i]))
        		 return true;
        	 
        	 if( nums[i] < min1 ) {
        		 pmin1 = min1;
        		 pmin2 = min2;
        		 min1 = min2 = nums[i];
        	 } else if( min1 == min2 && nums[i] > min1 ) {
        		 min2 = nums[i];
        	 } else if ( nums[i] > min1 && nums[i] <= min2 ) {
        		 min2 = nums[i];
        	 } 
         }
         
		 return false;   
	 }
	 
	 
	 public boolean increasingTriplet_Old(int[] nums) {
	     if( nums.length < 3 )
	        	 return false;
	         
	         int min1 , min2, pmin1 , pmin2 ;
	         pmin1 = pmin2 =min1 = min2 = nums[0];
	         
	         for ( int i=1;i<nums.length;i++) {
	        	 if( (pmin1 < pmin2 && pmin2 < nums[i]) || (min1 < min2 && min2 < nums[i]))
	        		 return true;
	        	 
	        	 if( nums[i] <= min1 ) {
	        		 pmin1 = min1;
	        		 pmin2 = min2;
	        		 min1 = min2 = nums[i];
	        	 } else if( min1 == min2 ) {
	        		 min2 = nums[i];
	        	 } else if ( nums[i] <= min2 ) {
	        		 min2 = nums[i];
	        	 } 
	         }
	         
			 return false;      
	    }

}
