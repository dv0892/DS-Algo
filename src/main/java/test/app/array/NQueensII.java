package test.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new NQueensII().totalNQueens(5));
	}
	public int totalNQueens(int n) {
	      List<String> matrix = new ArrayList<>();
				for(int i=0;i<n;i++) {
					char[] chars = new char[n];
					Arrays.fill(chars, '.');
					
					String row = new String(chars);
					
					matrix.add( row );
				}
				return solveNQueens(matrix , 0 , n) ;
		    }

			private int solveNQueens(List<String> matrix, int r, int queens) {
				// TODO Auto-generated method stub
				if( queens == 0 ) {
					return 1;
				}
				
				int count = 0;
				
				String rowObj = matrix.get(r);
				char[] row = rowObj.toCharArray();
				for ( int c = 0 ;c < row.length ; c++ ) {
					if( isValidPlacement(matrix,r,c) ) {// if queen can be placed in this cell in this matrix, This is Constraint required for Backtracking
						row[c] = 'Q';
						matrix.set(r, new String(row) );
						
						count += solveNQueens(matrix, r + 1, queens-1) ;
						
						row[c] = '.';
						matrix.set(r, new String(row) );
					}
				}
				
				return count;
			}

			private boolean isValidPlacement(List<String> matrix, int r, int c) {
				
				// vertical column
				for ( int i=0; i<r; i++) {
					if( matrix.get(i).charAt(c) == 'Q' )
						return false;
				}
				
				// left diagonal
				int i = r-1 , j = c-1;
				while( i >=0 && j >=0 ) {
					if( matrix.get(i).charAt(j) == 'Q' )
						return false;
					
					i-- ; j--;
				}
				
				//right diagonal
				i = r-1 ; j = c+1;
				while( i >=0 && j < matrix.get(i).length() ) {
					if( matrix.get(i).charAt(j) == 'Q' )
						return false;
					
					i-- ; j++;
				}
				
				return true;
			}
}
