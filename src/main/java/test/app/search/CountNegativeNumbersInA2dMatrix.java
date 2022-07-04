package test.app.search;

public class CountNegativeNumbersInA2dMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int countNegatives(int[][] grid) {
        /*
         * Since the grid is sorted, this could be easily by applying 
         * binary search either row or column wise resulting in
         * nlogn or mlogn time complexity.
         * 
         * Can we do it better like in O(n+m)
         * The idea is the element at top right is a result of two different rows that 
         * are in diff order like it be min element of first and max element of last column.
         * So we can some interesting things there like it can fall in 3 possible scenarios 
         * 1. +ive 2. 0 3. -ive
         * if it is greater than equal to zero we can neglect entire row(Since it is min and all element left to it will gretater tha na it and +ive)
         * or it it is less than 0 we can count entire column in our answer and add it in our answer.
         *          
         */
        int r=0,c = grid[0].length-1;
        int rows = grid.length;
        int ct=0;
        while( r < rows && c >= 0 ){
            if( grid[r][c] >= 0){
                r++;
            } else {
                c--;
                ct += (rows - r) ;
            }
        }
        
            
        return ct;
    }

}
