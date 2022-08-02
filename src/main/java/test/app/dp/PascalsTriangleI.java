package test.app.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
       
       for( int r=0; r<numRows;r++) {
           List<Integer> row = new ArrayList<>();
           row.add(1);
           
           for( int c=1; c<=r;c++) {
               row.add( ( c==r ? 0 : res.get(r-1).get(c) ) + res.get(r-1).get(c-1) );
           }
           
           res.add(row);
       }
           
       return res;
       
   }

}
