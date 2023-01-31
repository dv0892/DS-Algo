package test.app.matrix;

import java.util.Deque;
import java.util.LinkedList;

public class SnakesAndLadders {

	public static void main(String[] args) {
		System.out.println(  new SnakesAndLadders().snakesAndLadders(new int[][]{{-1,-1},{-1,3}}));

	}
	
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        Deque<Integer> q = new LinkedList<>();
        q.add(1);
        visited[n-1][0] = true;
        int moves = 0;
        
        while( !q.isEmpty() ){
            int size = q.size();
            while( size-- > 0 ){
                int curr = q.remove();
                if( curr == n*n )
                	return moves;
                for( int dice=1;dice<=6;dice++) {
                	if( (curr+dice) > n*n )
                		break;
                	
                	int[] cord = findCordinate(curr+dice, n);
                	int r = cord[0],c= cord[1];
                	if( !visited[r][c] ) {
                		visited[r][c] = true;
                		if( board[r][c] == -1 ) {
                			q.add(curr+dice);
                		}   else {
                			q.add(board[r][c]);
                		}
                	}
                }
                

            }
            
            moves++;
        }

        return -1;
    }

    public int[] findCordinate(int curr , int n){
        int r = n - (curr-1)/n - 1 ;
        int c = (curr-1)%n ;

        if( r%2==n%2 )
            return new int[] {r,n-c-1};
        else 
            return new int[] {r,c};

    }

}
