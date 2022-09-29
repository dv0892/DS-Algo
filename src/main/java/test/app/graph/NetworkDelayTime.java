package test.app.graph;

import java.util.HashMap;
import java.util.Map;

public class NetworkDelayTime {

	public static void main(String[] args) {
		
		int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
		int n = 4;
		int k = 2;
		
		System.out.println( new NetworkDelayTime().networkDelayTime(times, n, k));
	}
	
	public int networkDelayTime(int[][] times, int n, int k) {
		
		Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
		for( int i=1;i<=n;i++) {
			map.put(i, new HashMap<>());
		}
		
		for( int i=0;i<times.length;i++) {
			map.get(times[i][0]).put(times[i][1], times[i][2]);
		}
		
		
		boolean[] visited = new boolean[n+1];
		visited[0] = true;
		dfs(k, map, visited, 0 );
		
        return this.cost == Integer.MAX_VALUE ? -1 : this.cost;
    }
	
	public void dfs ( int n , Map<Integer,Map<Integer,Integer>> map , boolean[] visited , int cost ) {
		
		visited[n] = true;
		
		int maxEdge = -1 , maxNeigh = -1;
		for( Integer neigh : map.get(n).keySet() ) {
			if( !visited[ neigh ] ) {
				
				int costToReachNeighbour = map.get(n).get(neigh);
				dfs ( neigh , map , visited , cost + costToReachNeighbour);
				
				
			
			    if( costToReachNeighbour > maxEdge ) {
			    	maxEdge = costToReachNeighbour;
			    	maxNeigh = neigh;
			    }
			    	
			}
			
		}
		
		if ( maxNeigh != -1 ) {
			for( Integer neigh : map.get(n).keySet() ) {
				if( !visited[ neigh ] ) {
					visited[n] = true;
				}
			}	
		    dfs( maxNeigh, map, visited ,cost + maxEdge );
			
			for( Integer neigh : map.get(n).keySet() ) {
				if( !visited[ neigh ] ) {
					visited[n] = false;
				}
			}
		}
		
		if(allVisited(visited)) {
			this.cost = Math.min(this.cost, cost);
		}
		
		visited[n] = false;
		
	}
	
	int cost = Integer.MAX_VALUE;
	
	public boolean allVisited( boolean[] v ) {
		
		for( boolean b : v  ) {
			if( !b ) return false;
		}
		
		return true;
	}

}
