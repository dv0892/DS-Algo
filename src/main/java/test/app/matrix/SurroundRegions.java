package test.app.matrix;

public class SurroundRegions {

	public static void main(String[] args) {
		//char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		char[][] board = {{'O','O'},{'O','O'}};
	    new SurroundRegions().solve(board);

	}
	
	public void solve(char[][] board ) {
        
		int m = board.length;
		int n = board[0].length;
		for( int r=0;r<m;r++) {
			for(int c=0;c<n;c++) {
				if( (r==0 || c==0 || r==m-1 || c==n-1) && board[r][c]=='O')
					dfs(board,r,c);
			}
		}
		
		
		for( int r=0;r<m;r++) {
			for(int c=0;c<n;c++) {
				if( board[r][c] == 'S' )
					board[r][c] ='O';
				else if (board[r][c] == 'O' )
					board[r][c] ='X';
			}
		}
    }
	
	int[][] dir = { {1,0},{-1,0},{0,1},{0,-1} };
	
	public void dfs(char[][] board , int r , int c ) {
		
		if( r < 0 || c < 0 || r==board.length || c==board[0].length || board[r][c]=='X' || board[r][c]=='S')
			return ;
			
		board[r][c] ='S';
		for(int[] d : dir ) {
			dfs(board,r+d[0],c+d[1]);
		}
    }

}
