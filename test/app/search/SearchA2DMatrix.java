package test.app.search;

public class SearchA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {  {1,2,3}, 
							{4,5,6},
							{7,8,9}
				  		  };
		
		System.out.println( new SearchA2DMatrix().searchMatrix(matrix, 9 ));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		/*
		 * Since the matrix is sorted, we will apply binary search row 
		 * wise and then apply column-wise finally
		 */
        int st=0,end=matrix.length-1;
        int n = matrix[0].length-1;
        
        while (st <= end) {
        	int row  = st + (end - st)/2;
        	
        	if( target >= matrix[row][0] && target <= matrix[row][n] )
        		return binarySearch( matrix[row], 0, n ,target);
        	
        	if( target < matrix[row][0]) 
        		end = row - 1;
        	else
        		st = row + 1;
        }
        
        return false;
    }

	private boolean binarySearch(int[] arr, int st, int end,int target) {
		
		while (st <= end) {
			int mid = st + (end - st)/2; 
			
			if( target == arr[mid] )
	    		return true;
	    	
	    	if( target < arr[mid]) 
	    		end = mid - 1;
	    	else
	    		st = mid + 1;
		}
		
		return false;
	}

}
