package test.app.dp;

public class GetMaximumInGeneratedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getMaximumGenerated(int n) {
	       int[] arr = new int[n+1];
	       arr[0] = 0; 
	       int max = 0;
	        
	       if( n > 0 ){
	           arr[1] = 1;
	           max = 1;
	       }
	       
	       int i=2; 
	       while(i <= n){
	           arr[i] = arr[i/2];
	           if ( (i&1) == 1 )
	               arr[i] += arr[(i/2)+1];
	           
	           max = Math.max( arr[i] , max );
	           i++;
	       }  
	    
	        return max;
	    }

}
