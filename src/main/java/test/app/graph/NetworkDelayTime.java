package test.app.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {

	public static void main(String[] args) {
		//GOOD QUESTION
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
		
		// Applying Dijkstra's algo here to shortest path between src (k) and every other node.
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[k] = 0;
		
		dijkstra(map,distance,n,k);
		
		int max = Integer.MIN_VALUE;
		for( int i=1;i<distance.length;i++) {
			if ( distance[i] == Integer.MAX_VALUE)
				return -1;
			
			max = Math.max(max, distance[i]);
		}
		
		return max;
    }
	
	
	
	private void dijkstra(Map<Integer,Map<Integer,Integer>> map, int[] distance, int n, int k) {
		
		boolean[] visited = new boolean[n+1];
		
		PriorityQueue<Node> q = new PriorityQueue<>((n1,n2)->n1.d-n2.d);
		q.add(new Node(k, 0));
		
		while(!q.isEmpty()) {
			Node v = q.remove();
			int src = v.v;
			
			if( visited[src] )
				continue;
			
			visited[src] = true;
			for( Integer neighbour : map.get(src).keySet() ) {
			     
				 int cost = map.get(src).get(neighbour);
			     if ( distance[neighbour] > ( cost + distance[src])) {
			    	 distance[neighbour] = ( cost + distance[src]); 
			    	 q.add(new Node(neighbour,distance[neighbour]));
			     }
			} 
		}
		
	}
	
	static class Node{
		int v , d;
		
		Node( int v, int d ){
			this.v = v;
			this.d = d;
		}
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
