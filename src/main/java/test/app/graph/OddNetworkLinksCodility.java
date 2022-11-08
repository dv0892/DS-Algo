package test.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OddNetworkLinksCodility {

	public static void main(String[] args) {
		
		System.out.println( new OddNetworkLinksCodility().solutionOptimized( 
				new int[] {0,2,6,4,4,4,4,11,15,11,12,0,2, 6,1}, 
	            new int[] {3,3,3,3,1,7,5,5 , 5,12,13,9,8,10,14} ));
		
		//System.out.println( new OddNetworkLinksCodility().solutionOptimized( 
		//		new int[] {1}, 
	    //        new int[] {0} ));
		
	}
	
	public static final int INF = 1000000000;
	
	
	public int solutionOptmizedFinal(int[] A, int[] B) {
        if( A.length <= 1 )
			return A.length;
		
		Map<Integer,List<Integer>> graph = new HashMap<>();
		for(int e=0;e<A.length;e++) {
			int s = A[e];
			int t = B[e];
			
			graph.putIfAbsent(s, new ArrayList<>());
			graph.putIfAbsent(t, new ArrayList<>());
			
			graph.get(s).add(t);
			graph.get(t).add(s);
		}
		
		// Do a BFS starting from any of node and count the nodes at each level
		int evenNodesTillNow = 1;
		int oddNodesTillNow = 0;
		
		boolean[] visited = new boolean[A.length+1];
		Deque<Integer> q = new LinkedList<>();
		q.add(0);
		
		int level=0,res=0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			// New Level
			int count = 0;
			while( size-- > 0 ) {
				int node = q.remove();
				for( int neigh : graph.get(node) ) {
					if( !visited[neigh] ) {
						count++;
						q.add(neigh);
					} 
				}
				visited[node] = true;
			}
			
			
			if( count == 0 )
				break;
			
			++level;
			
			if( level%2 == 0) {			
				res += ( oddNodesTillNow*count );
				evenNodesTillNow += count;
			} else {
				res += ( evenNodesTillNow*count );
				oddNodesTillNow += count;
			}
			
		}
		// BFS Completed

		
		return res;
    }

	public int solutionOptimized(int[] A, int[] B) { 
		
		if( A.length <= 1 )
			return A.length;
		
		Map<Integer,List<Integer>> graph = new HashMap<>();
		for(int e=0;e<A.length;e++) {
			int s = A[e];
			int t = B[e];
			
			graph.putIfAbsent(s, new ArrayList<>());
			graph.putIfAbsent(t, new ArrayList<>());
			
			graph.get(s).add(t);
			graph.get(t).add(s);
		}
		
		// Do a BFS starting from any of node and count the nodes at each level
		int evenNodesTillNow = 1;
		int oddNodesTillNow = 0;
		
		// USING SET Was the main Culprit here , Stopped giving TLE when I used visited array 
		Set<Integer> prevLevel = new HashSet<>();
		Set<Integer> currLevel = new HashSet<>();
		Deque<Integer> q = new LinkedList<>();
		q.add(0);
		
		int level=0,res=0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			// New Level
			int count = 0;
			currLevel.clear();
			while( size-- > 0 ) {
				int node = q.remove();
				for( int neigh : graph.get(node) ) {
					if( !prevLevel.contains(neigh) ) {
						count++;
						q.add(neigh);
					} 
				}
				currLevel.add(node);
			}
			
			prevLevel.clear();
			prevLevel.addAll(currLevel);
			if( count == 0 )
				break;
			
			++level;
			
			if( level%2 == 0) {
				
				//res += ( oddNodesTillNow*count );
				evenNodesTillNow += count;
			} else {
				//res += ( evenNodesTillNow*count );
				oddNodesTillNow += count;
			}
			
		}
		// BFS Completed
		
		/*int res = 0;
		for( int i=1;i<currLevelNodes.size();i++) {
			res += ( ( (i%2 == 1) ? nodesPerLevel.get(i-1) : nodesPerLevelOdd.get(i-1)  )  * currLevelNodes.get(i) );
		}
		*/
		
		//nodes with odd number of connecting edges
		return oddNodesTillNow * evenNodesTillNow;
		
	}
	
	// Using DFS
	int evenNodesTillNow = 0;
	int oddNodesTillNow = 0;
	
	public void dfs ( int par , int node ,Map<Integer,List<Integer>> graph , int level ) {
		
		if( (level&1) == 0) {						
			evenNodesTillNow++;
		} else {
			oddNodesTillNow++;
		}
		
		for( int neigh : graph.get(node) ) {
			if( par != neigh ) {
				dfs(node, neigh, graph, level+1);
			} 
		}
	}
	
    public int solution(int[] A, int[] B) {
    	
       // Approach is fine but it is giving TLE on codility
       // Looks like using fllyod warshall is overkill since the given graph is tree only 
       // is there any other way we can derive, the shortest distance between nodes 
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

    public void allPairShortestPath( int[][] dist , int n ){
		
		//O(n^3)
		for( int k=0;k<n;k++) {
			for( int i=0;i<n;i++) {
				for( int j=0;j<n;j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
	}

}
