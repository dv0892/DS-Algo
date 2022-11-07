package test.app.graph;

import java.util.Arrays;

public class OddNetworkLinksCodility {

	public static void main(String[] args) {
		
		System.out.println( new OddNetworkLinksCodility().solution( new int[] {0, 3, 4, 2, 6, 3}, 
																	new int[] {3, 1, 3, 3, 3, 5} ));
		
	}
	
	public static final int INF = 1000000000;

    public int solution(int[] A, int[] B) {
       int n = A.length ;
       int[][] graph = new int[n+1][n+1];

       for( int i=0;i<=n;i++) {
				for( int j=0;j<=n;j++) {
					if( i == j) {
                        graph[i][j] = 0 ;
                    } else{
                        graph[i][j] = INF;
                    }
				}
		}


        for( int i=0;i<n;i++) {
            int s = A[i];
            int e = B[i];

            graph[s][e] = graph[e][s] = 1;
        }

        allPairShortestPath(graph,n+1);
        
        for( int[] g : graph )
			System.out.println( Arrays.toString(g));

        int count = 0;
        for( int i=0;i<=n;i++){
            for( int j=i+1 ;j<=n;j++){
                if( (graph[i][j]&1)==0 )
                    continue;
                 
                count++;
            }
        }


        return count;
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
