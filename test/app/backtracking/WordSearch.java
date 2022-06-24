package test.app.backtracking;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'},
				          {'S','F','C','S'},
				          {'A','D','E','E'}};
		
		System.out.println( new WordSearch().exist(board, "ABCCED"));
	}
	

	public boolean exist(char[][] board, String word) {
		
		for ( int r =0; r < board.length ; r++ ) {
			for ( int c =0; c < board[r].length ; c++ ) {
				if ( exist( board, word, 0 ,r ,c , new HashSet<>()) )
					return true;
			}
		}
        return false ;
    }
    
    
    public boolean exist(char[][] board, String word ,int i ,int r ,int c , Set<Cell> set ) {
      /*
       * Since this algorithm works in forward manner, we have to call for every cell in matrix;
       * Time Complexity O( m * n * pow(4,len(word)) 
       */
    	
    	
      if( i == word.length() )
          return true;
        
      if( r < 0 || c < 0 || r == board.length || c == board[r].length || word.charAt(i) != board[r][c] || set.contains(new Cell(r,c))   )
          return false;
      
        Cell cell = new Cell(r,c);
        set.add(cell);
        
        boolean result = exist( board , word , i + 1, r, c-1,set) || 
        		         exist( board , word , i + 1, r, c+1,set) || 
        		         exist( board , word , i + 1, r-1, c,set) || 
        		         exist( board , word , i + 1, r+1, c,set) ;
        
        set.remove(cell); 
        
        return result;
             
    }
    
    static class Cell {
        int r,c;
        
        Cell ( int r , int c ){
            this.r = r;
            this.c = c;
        }
        
        public boolean equals(Object o)  {
        	
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
     
            Cell cell = (Cell) o;
            return ( cell.r == this.r && cell.c == this.c ) ;
        }
     
        @Override
        public int hashCode()  {
            return r * 2 ;
        }
    }

}
