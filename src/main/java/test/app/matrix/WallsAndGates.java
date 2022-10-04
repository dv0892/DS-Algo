package test.app.matrix;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class WallsAndGates {
	
	public static int INF = Integer.MAX_VALUE;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rooms = { {INF,-1,0,INF },
				{INF,INF,INF,-1},
				{INF,-1,INF,-1},
				{0,-1,INF,INF}};
	
	
		for( int[] r : rooms )
			System.out.println(  Arrays.toString(r) ) ;
		
		new WallsAndGates().wallsAndGates(rooms);
		
		System.out.println();
		
		for( int[] r : rooms )
			System.out.println(  Arrays.toString(r) ) ;
	}
	
	
	int[][] dir = { {1,0},{-1,0},{0,1},{0,-1} };
	
	public void wallsAndGates(int[][] rooms) {
		
		int m = rooms.length;
		int n = rooms[0].length;
		
		Deque<Integer> q = new LinkedList<>();
		for( int r=0;r<m;r++) {
			for( int c=0;c<n;c++) {
				if( rooms[r][c] == 0)
					q.add(r*n+ c);
			}
		}
		
		int level = 0;
		while(!q.isEmpty()) {
			int sz = q.size();
			while(sz-- > 0) {
				Integer cell = q.remove();
				int r = cell / n;
				int c = cell % n;
			
				for( int[] d : dir ) {
					int nr = r + d[0];
					int nc = c + d[1];
					
					if( nr >= 0 && nc>=0 && nr<m && nc<n && rooms[nr][nc]!=-1 ) {
						if( rooms[nr][nc] > (level+1)) {
							rooms[nr][nc] = level + 1;
							q.add(nr*n + nc);
						}
					}
				}
			}
			level++;
		}
		
	}

}
