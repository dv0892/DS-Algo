package test.app.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
