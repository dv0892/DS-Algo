package test.app.graph;

import java.util.Arrays;

public class TopologicalSortingAdjMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[][] mat = new int[n][n];
		
		mat[0][1] = mat[0][2] = mat[0][5] = 1; 
		mat[1][2] = mat[1][3] = 1; 
		mat[2][4] = mat[2][3] = 1; 
		
		mat[3][4] = 1;
		mat[5][4] = 1;
		
		System.out.println( Arrays.toString( new TopologicalSortingAdjMatrix().topologicalSort(mat)));
	}
    
	public int[] topologicalSort( int[][] adjMatrix ) {
		
		int n = adjMatrix.length;
		int[] order = new int[n];
		boolean[] visited = new boolean[n];
		int index = n-1;
		
		for ( int v=0;v<n;v++ ) {
			if( !visited[v])
				index = visit( v , adjMatrix, visited, order , index );
		}
		
		
		return order;
	}

	private int visit(int v, int[][] adjMatrix, boolean[] visited, int[] order , int index ) {
		
		if( visited[v] )
			return index;
		
		visited[v] = true;
		
		int neighbour = 0;
		for( int edge : adjMatrix[v] ) {
			if( edge == 1 )
				index = visit( neighbour ,adjMatrix , visited , order , index);
			
			neighbour++;
		}
		
		
		order[index--] = v;
		
		return index;
	}
}


