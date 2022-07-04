package test.app.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionForAGivenEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
	     
		 	/*
		 	 * This is quite similar to SearchA2DMatrixII Where Matrix data
		 	 * is sorted row wise as well as column wise.
		 	 * 
		 	 * Since bound of x,y is 1 <= x,y <= 1000
		 	 * And calls of customFunction.f are monotonically increasing.
		 	 * This represents a 2D matrix which is sorted row wise and column wise also
		 	 *  
		 	 *
		 	 */
		 
		 	int r=1,c=1000;
		 	List<List<Integer>> res = new ArrayList<>();
		 	while( r <= 1000 & c >= 1) {
		 		int ans = customfunction.f(r, c);
		 		if(ans == z)	{
		 			List<Integer> t = new ArrayList<>();
		 			t.add(r);t.add(c);
		 			res.add(t);
		 			
		 			r++; c--;
		 		} else if( z > ans ) {
		 			r++;
		 		} else {
		 			c--;
		 		}
		 	}
		 
	        return res;
	 }
}

interface CustomFunction {
	public int f(int x, int y);
}
