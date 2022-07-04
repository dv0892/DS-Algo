package test.app.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new NQueens().solveNQueens(4));
	}
	
	public List<List<String>> solveNQueens(int n) {
	    List<String> matrix = new ArrayList<>();
			for(int i=0;i<n;i++) {
				char[] chars = new char[n];
				Arrays.fill(chars, '.');
				
				String row = new String(chars);
				
				matrix.add( row );
			}
			return solveNQueens(matrix , 0 , n) ;
	    }

		private List<List<String>> solveNQueens(List<String> matrix, int r, int queens) {
			// TODO Auto-generated method stub
			if( queens == 0 ) {
				List<List<String>> res = new ArrayList<>();
	            List<String> t = new ArrayList<>();
				for ( String row : matrix) {
					t.add(row);
				}
	            res.add(t);
				return res;
			}
			
			List<List<String>> ans = new ArrayList<>();
			
			String rowObj = matrix.get(r);
			char[] row = rowObj.toCharArray();
			for ( int c = 0 ;c < row.length ; c++ ) {
				if( isValidPlacement(matrix,r,c) ) {// if queen can be placed in this cell in this matrix, This is Constraint required for Backtracking
					row[c] = 'Q';
					matrix.set(r, new String(row) );
					
					ans.addAll( solveNQueens(matrix, r + 1, queens-1) );
					
					row[c] = '.';
					matrix.set(r, new String(row) );
				}
			}
			
			return ans;
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
