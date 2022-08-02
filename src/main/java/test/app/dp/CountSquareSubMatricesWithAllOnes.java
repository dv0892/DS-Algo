package test.app.dp;

public class CountSquareSubMatricesWithAllOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[][] mat = {{0,1},{1,1}};
       
       System.out.println( new CountSquareSubMatricesWithAllOnes().countSquares(mat));
	}
	
	public int countSquares(int[][] matrix) {
        int i = 1;
        int sum = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        
        while( i <= Math.min(rows,cols) ) {
            for( int r=0;r<(rows-i+1); r++){
                for( int c=0;c<(cols-i+1); c++) {
                    sum += checkSubMatrix( matrix, r, c , i );
                }
            }
            i++;
        }
        
        return sum;
    }
    
    public int checkSubMatrix(int[][] matrix ,int r , int c , int n) {
        
        
        
        int rf = r + n;
        int cf = c + n;
        
        while(r < rf){
            int ci = c;
            while(ci < cf){
                if( matrix[r][ci] == 0)
                    return 0;
                ci++;
            }
            r++;
        }
        
        return 1;
    }

}
