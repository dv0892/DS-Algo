package test.app.search;

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]  matrix = {
				{1,4,7,11,15},
				{2,5,8,12,19},
				{3,6,9,16,22},
				{10,13,14,17,24},
				{18,21,23,26,30}
				};
		
		
		System.out.println( new SearchA2DMatrixII().searchMatrix(matrix, 30));
		
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		/*
		 * Since the matrix is sorted, we will apply binary search row 
		 * wise and then apply column-wise finally
		 */
        int r = 0, c = 0;
        int m_r = matrix.length-1;
        int m_c = matrix[0].length - 1;
        
        while (r <= m_r && c <= m_c) {
  
        	if( target >= matrix[r][c] ) {
        		
        		//perform binary search on col
        		if ( target <= matrix[r][m_c] ) {
        			if(binarySearch(matrix[r],r,m_c,target))
        				return true;
        		}
        		
        		//perform binary search on row
        		if ( target <= matrix[m_r][c] ) {
        			if(binarySearch(matrix,r,c,target))
        				return true;
        		}
        		r++; 
        		c++;
        	} else
        		return false;
        	
        }
        
        return false;
    }

	private boolean binarySearch(int[][] matrix, int r, int c, int target) {
		
		int st = r , end = matrix.length-1;
		
		while (st <= end) {
			int mid = st + (end - st)/2; 
			
			if( target == matrix[mid][c] )
	    		return true;
	    	
	    	if( target < matrix[mid][c]) 
	    		end = mid - 1;
	    	else
	    		st = mid + 1;
		}
		
		return false;
	}

	private boolean binarySearch(int[] row, int st, int end, int target) {
		
		while (st <= end) {
			int mid = st + (end - st)/2; 
			
			if( target == row[mid] )
	    		return true;
	    	
	    	if( target < row[mid]) 
	    		end = mid - 1;
	    	else
	    		st = mid + 1;
		}
		
		return false;
	}

}
