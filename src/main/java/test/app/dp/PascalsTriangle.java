package test.app.dp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> getRow(int rowIndex) {
        int[] pascal = new int[rowIndex+1];
        pascal[0] = 1;
       
        int r = 1; 
        while( r <= rowIndex ){
            int c = r;
            while( c >= 1 ){
                 pascal[c] = pascal[c-1] +  pascal[c] ;
                 c--;
            }
            pascal[c] = 1;
            
            r++;
        }

        return Arrays.stream(pascal).boxed().collect(Collectors.toList());
    }

}
