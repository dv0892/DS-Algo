package test.app.dp;

import java.util.Arrays;

public class KnightProbabilityInChessBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new KnightProbabilityInChessBoard().knightProbability(8, 30, 6, 4));
	}
	
    public double knightProbability(int n, int k, int row, int column) {
        if( k == 0 )
            return 1d;

        double[][] board = new double[n][n];
        
        
        board[row][column] = 1d;
        double base = Math.pow(k, 8d);
        while( k-- > 0 ) {
        	double[][] temp  = new double[n][n];
        	for( int r=0;r<n;r++) {
        		for( int c=0;c<n;c++) {
        			double prob = board[r][c];
            		if( prob > 0d ) {
            			for( int[] d : dir ) {
            	            if( isValid(r+d[0],c+d[1],n) )
            	               temp[r+d[0]][c+d[1]] += prob/8d;
            	        }
            		}
            	}
        	}
        	
        	board = temp ;
        }
        
        double total = 0;
        for( int r=0;r<n;r++) 
    		for( int c=0;c<n;c++) {
    			System.out.println(Arrays.toString(board[r]));
    			total += board[r][c];
    	}
    	System.out.println( total );
    	System.out.println( base );
 
        return total / base; 
    }

    int[][] dir = {{2,1},{2,-1},{-2,-1},{-2,1},{1,2},{-1,2},{1,-2},{-1,-2}};

    public int initialize( int r, int c , int n ) {
        int moves = 0;
        for( int[] d : dir ) {
            if( isValid(r+d[0],c+d[1],n) )
                moves++;
        }

        return moves;
    }

    public double fillProbability( int r, int c , int n, double[][] board ) {
        double prob = 1d;
        for( int[] d : dir ) {
            if( isValid(r+d[0],c+d[1],n) )
            	prob *= board[r+d[0]][c+d[1]];
        }

        return prob;
    }

    
	
	/*public double knightProbabilityBacktracking(int n, int k, int row, int column) {
        if( k == 0 )
            return 1d;

        double[][] board = new double[n][n];
        for(int r=0;r<n;r++){
            for( int c=0;c<n;c++){
                board[r][c] = initialize(r,c,n);
                System.out.print(board[r][c] + "  ");
            }
            System.out.println();
        }

        for(int r=0;r<n;r++){
            for( int c=0;c<n;c++){
                System.out.print(board[r][c] + "  ");
            }
            System.out.println();
        }
        

        return 0d;
        
    }*/


    

    public boolean isValid( int r , int c , int n ) {
        return r>-1 && c>-1 && r<n && c<n ;
    }

}
