package test.app.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
	   
		new SudokuSolver().solveSudoku(board);
		
		for ( char[] row : board ) {
			System.out.println( Arrays.toString(row) );
		}
	}
	
	public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    
    public boolean solve ( char[][] board , int r ,int c ){
    	
    	if( r==9 && c==9 )
            return isValidSudoku(board);
        
        r = r%9; c = c%9;
        if( board[r][c] != '.' )
             return solve( board , ( (c+1) >=9 ? r+1 : r) , c+1 );
            		 
        for ( int i=49 ;i<58 ;i++ ){
            
            if ( isValidPlacement ( board,r,c, (char)i )) {
                board[r][c] = (char)i;
                if ( solve( board , ( (c+1) >=9 ? r+1 : r) , c+1))
                    return true;
            }
        }
        
        board[r][c] = '.';
        
        return false;    
    }
    
    public boolean isValidPlacement(char[][] board , int row, int col , char val) {
        if( row < 0 || row > 8 || col < 0 || col > 8 )
            return false;
        
        int i=0;
        
        // Check if same value exists on row
        while ( i < 9 ){
            if( board[row][i++] == val )
                return false;
        }
        
        // Check if same value exists on column
        i=0;
        while ( i < 9 ){
            if( board[i++][col] == val )
                return false;
        }
        
        int r = (row < 3 ) ? 0 : ( row < 6) ? 3 : 6 ;
        int c = (col < 3 ) ? 0 : ( col < 6) ? 3 : 6 ;
        
        int rb = r+3;
        int cb = c+3;
        for ( ; r < rb ; r++ ) {
            for ( ; c < cb ; c++ ){
                if ( board[r][c] == val )
                    return false;
            }
        }
              
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
       
        // check rows & columns
        for(int i = 0; i < 9 ; i++){
            if(!isValidRow(board,i))
                return false;
            
            if(!isValidColumn(board,i))
                return false;
        }
        
        //check 3*3 boxes
         for(int i = 0 ; i < 9; i+=3){
                for(int j=0; j < 9; j+=3) {
                    if(!isValid3x3Box(board,i,j))
                        return false;
                }
         }
        
        return true;
    }
    
    public boolean isValid3x3Box(char[][] board,int r, int c){
        
        if( r < 0 || r > 8 )
            return false;
        
        Set<Character> set = new HashSet<>();
        for(int i = r ; i < (r+3); i++){
            for(int j=c; j < (c+3); j++){
                if(board[i][j] == '.')
                    continue;
            
                if(set.contains(board[i][j]))
                    return false;
            
                set.add(board[i][j]);
            }
        }
        
        return true;  
    }
    
    public boolean isValidRow(char[][] board,int r) {
        if(r < 0 || r > 8)
            return false;
        
        Set<Character> set = new HashSet<>();
        for(int c = 0; c < 9 ; c++){
            if(board[r][c] == '.')
                continue;
            
            if(set.contains(board[r][c]))
                return false;
            
            set.add(board[r][c]);
        }
        
        return true;
    }
    
    public boolean isValidColumn(char[][] board,int c){
        if(c < 0 || c > 8)
            return false;
        
        Set<Character> set = new HashSet<>();
        for(int r = 0; r < 9 ; r++){
            if(board[r][c] == '.')
                continue;
            
            if(set.contains(board[r][c]))
                return false;
            
            set.add(board[r][c]);
        }
        
        return true;        
        
    }
}
