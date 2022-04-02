package test.app.array;

import java.util.Arrays;

public class RangeAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new RangeAddition().maxCount(18, 3, 
        		 new int[][] {{16,1},{14,3},{14,2},{4,1},{10,1},{11,1},{8,3},{16,2},{13,1},{8,3},{2,2},{9,1},{3,1},{2,2},{6,3}});
	}
	
	
	
	public int maxCount(int m, int n, int[][] ops) {
	    
		int r = m , c = n;       
        for(int[] op : ops){
             r = Math.min(r,op[0]);
             c = Math.min(c,op[1]);
        }
        
        return r*c;
       
        /*
		int[][] mat = new int[m][n];
        int r = m*n;
        
        for(int[] op : ops){
           int r = op[0], c = op[1];
           if( (r*c) < count )
               count = r*c;
           
           performOp(mat,op);
           System.out.println("Op : " + Arrays.toString(op) + " --- ");
           for(int i=0;i<m;i++) {
           	System.out.println(Arrays.toString(mat[i]));
   		}
        }
        
        for(int i=0;i<m;i++) {
        	System.out.println(Arrays.toString(mat[i]));
		}
        
        System.out.append(Arrays.toString(mat));
        return count;
        */
        
    }
	
	public void performOp(int[][] mat, int[] op) {
		int r = op[0], c = op[1];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				mat[i][j]++;
			}
		}
	}

}
