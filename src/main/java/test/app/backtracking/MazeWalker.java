package test.app.backtracking;

public class MazeWalker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = new int[3][3];
		boolean[][] visited = new boolean[3][3];
		
		new MazeWalker().walkMaze("", 0, 0, visited ) ;
		/*
		 * Perfect Example of BackTracking
		 * This find all the possible path in a maze to reach the right bottom
		 */
	}
	
	public void walkMaze( String path ,int r, int c , boolean[][] visited) {
		
		if ( r > 0 && c > 0 && r == visited.length-1 && c == visited[r].length-1 ) {
			System.out.println( path );
		}
		
		if ( r < 0 || c < 0 || r == visited.length || c == visited[r].length || visited[r][c] )
			return ;
		
		visited[r][c] = true;
		
		walkMaze( path + "R" , r,   c + 1, visited );
		walkMaze( path + "L" , r,   c - 1, visited );
		walkMaze( path + "U" , r-1, c,     visited );
		walkMaze( path + "D" , r+1, c,     visited );
		
		/*
		 * This is where the back tracking is happening because we are reverting the decisions taken by this 
		 * particular call .
		 */
		visited[r][c] = false;
	}

}
