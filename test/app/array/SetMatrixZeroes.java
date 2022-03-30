package test.app.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
         new SetMatrixZeroes().setZeroes(matrix);
         
         System.out.println(Arrays.toString(matrix[2]));
	}
	
	public void setZeroes(int[][] matrix) {
        
        Set<Integer> rows , cols ;
        rows = new HashSet<>();
        cols = new HashSet<>();
        
        for(int r = 0 ; r < matrix.length; r++){
            System.out.println( " matrix[r].length " + matrix[r].length);
            for(int c =0; c<matrix[r].length; c++){
                
                if(matrix[r][c] != 0){
                    System.out.println("r "+ r + " c " + c+  " " + matrix[r][c]);
                    if(rows.contains(r) || cols.contains(c))
                        matrix[r][c] = 0;
                      System.out.println("r "+ r + " c " + c+  " " + matrix[r][c]);
                } else{
                    if(!rows.contains(r)) {
                        for(int k = 0;  k < c; k++){
                            matrix[r][k] = 0;
                        }
                    }
                    
                    if(!cols.contains(c)) {
                        for(int k = 0;  k < r ; k++){
                            matrix[k][c] = 0;
                        }
                    }
                    
                    rows.add(r); cols.add(c);
                }   
            }
        }
        
    }

}
