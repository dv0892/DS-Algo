package test.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralOrderMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]  A = {
		    { 1, 2, 3 ,10},
		    { 4, 5, 6 ,11},
		    { 7, 8, 9 ,12},
		    { 13, 14, 15,16}
		};
		
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(1, 2, 3 ));
		input.add(Arrays.asList(4, 5, 6 ));
		
		//int[] res = new SpiralOrderMatrix().spiralOrder(A);
		
		
		
		System.out.println(new SpiralOrderMatrix().spiralOrder(input));
	}
	
	public int[] spiralOrder(final int[][] A) {
    
		List<Integer> res = new ArrayList<>();
		
		Set<Integer> completedRows    = new HashSet<>();
		Set<Integer> completedCols    = new HashSet<>();
		
		int r = 0,c = -1;
		
		boolean isValid = true,rF = true,rB,cD,cU;
		
		cD = rB = cU = false;
		
		while(isValid) {
			
			isValid = false;
			/*4 conditions
			1. Increment the Col
			2. Increment the row
			3. Decrement the col
			4. Decrement the row
			*/
			if( rF )
				if( ((c+1) < A[r].length) && !completedCols.contains(c+1) ) {
					c++;
					isValid = true;
				} else {
					completedRows.add(r);
					rF = rB = cU = false;
				    cD = true;
				}
			
			
			if( cD ) 
				if( ((r+1) < A.length) && !completedRows.contains(r+1) ) {
					r++;
					isValid = true;
				} else {
					completedCols.add(c);
					rF = cD = cU = false;
				    rB = true;
				}
			
			
			if( rB )
				if( ((c-1) >= 0) && !completedCols.contains(c-1) ) {
					c--;
					isValid = true;
				} else {
					completedRows.add(r);
					rF = rB = cD = false;
					cU = true;
				}
			
			
			if( cU )
				if( ((r-1) >= 0) && !completedRows.contains(r-1) ) {
					r--;
					isValid = true;
				} else {
					completedCols.add(c);
					cD = rB = cU = false;
					rF = true;
					// This completes one spiral circle. Before it, we need to check whether the next cell is 
					// already covered or not.
					if( ((c+1) < A[r].length) && !completedCols.contains(c+1) )
						isValid = true;
					
					continue;
				}
			
			if(isValid)
				res.add(A[r][c]);
		
	    } 
		
		
		
		return res.stream().mapToInt(i -> i.intValue()).toArray();
	}

	
	public ArrayList<Integer> spiralOrder(final List<List<Integer>> A) {
		
		ArrayList<Integer> res = new ArrayList<>();
		
		Set<Integer> completedRows    = new HashSet<>();
		Set<Integer> completedCols    = new HashSet<>();
		
		int r = 0,c = -1;
		
		boolean isValid = true,rF = true,rB,cD,cU;
		
		cD = rB = cU = false;
		
		while(isValid) {
			
			isValid = false;
			/*4 conditions
			1. Increment the Col
			2. Increment the row
			3. Decrement the col
			4. Decrement the row
			*/
			if( rF )
				if( ((c+1) < A.get(r).size()) && !isVisited(completedRows,r,completedCols,c+1) ) {
					c++;
					isValid = true;
				} else {
					completedRows.add(r);
					rF = rB = cU = false;
				    cD = true;
				}
			
			
			if( cD ) 
				if( ((r+1) < A.size()) && !isVisited(completedRows,r+1,completedCols,c) ) {
					r++;
					isValid = true;
				} else {
					completedCols.add(c);
					rF = cD = cU = false;
				    rB = true;
				}
			
			
			if( rB )
				if( ((c-1) >= 0) && !isVisited(completedRows,r,completedCols,c-1) ) {
					c--;
					isValid = true;
				} else {
					completedRows.add(r);
					rF = rB = cD = false;
					cU = true;
				}
			
			
			if( cU )
				if( ((r-1) >= 0) && !isVisited(completedRows,r-1,completedCols,c) ) {
					r--;
					isValid = true;
				} else {
					completedCols.add(c);
					cD = rB = cU = false;
					rF = true;
					// This completes one spiral circle. Before it, we need to check whether the next cell is 
					// already covered or not.
					if( ((c+1) < A.get(r).size()) && !isVisited(completedRows,r,completedCols,c+1) )
						isValid = true;
					
					continue;
				}
			
			if(isValid)
				res.add(A.get(r).get(c));
		
	    } 
		
		
		
		return res;
	}

	private boolean isVisited(Set<Integer> completedRows, int r, Set<Integer> completedCols, int c) {
		// TODO Auto-generated method stub
		return completedRows.contains(r) || completedCols.contains(c);
	}
}
