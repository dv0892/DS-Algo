package test.app.graph;

import java.util.Arrays;

public class FloydWarshall {

	public static final int INF = 1000000000;
	
	public static void main(String[] args) {
		
		/*int[][] graph = { {0,3,8,INF,-4},
						  {INF,0,INF,1,7},
						  {INF,4,0,INF,INF},
						  {2,INF,-5,0,INF},
						  {INF,INF,INF,6,0},
						};*/
		
		int[][] graph = { {0,1,INF,INF,INF,INF},
						  {1,0,1,INF,INF,INF},
						  {INF,1,0,1,INF,INF},
						  {INF,INF,1,0,1,INF},
						  {INF,INF,INF,1,0,1},
						  {INF,INF,INF,INF,1,0}
						};
		
		new FloydWarshall().allPairShortestPath(graph, 6);
		
		for( int[] g : graph )
			System.out.println( Arrays.toString(g));

	}
	
	public int[][] allPairShortestPath( int[][] dist , int n ){
		
		//O(n^3)
		for( int k=0;k<n;k++) {
			for( int i=0;i<n;i++) {
				for( int j=0;j<n;j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		
		return dist;
	}

}
