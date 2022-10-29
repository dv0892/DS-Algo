package test.app.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int n = 7;
		//int[][] roads = {{0,6,1000000000},{0,1,1000000000},{1,2,1000000000},{1,3,1000000000},{6,3,1000000000},{3,5,1000000000},{6,5,1000000000},{2,5,1000000000},{0,4,1000000000},{4,6,1000000000}};
		
		int n = 7;
		int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		
		System.out.println( new NumberOfWaysToArriveAtDestination().countPaths(n, roads));
	}
	
	long MOD = 100_00_00_000 + 7;
    
    long INF = Long.MAX_VALUE ;
	
	public int countPaths(int n, int[][] roads) {
        
        if( roads.length == 0 )
            return 1;
        
		Map<Integer,Map<Integer,Integer>> graph = new HashMap<>();
		//Build Graph 
		initialization(n,roads,graph);
		
		
		return dijkstraImprovized(n, graph);
		
		/*//Using Dijkstra's algo to find the dist array containing distance from n-1 node
		long[] dist = dijkstra(n,graph);
		
		//Convert it into DAG
		return countPathsByConvertingItIntoDAG(dist,graph,n,roads);*/
		
    }


	private int countPathsByConvertingItIntoDAG(long[] dist, Map<Integer, Map<Integer, Integer>> graph, int n,
			int[][] roads) {
		
		int[] indegree = new int[n];
		for( int[] road : roads ) {
			
			int s = road[0];
			int e = road[1];
			int w = road[2];
			
			if( dist[s] == ( w + dist[e] ) ) {
				graph.get(e).remove(s);
				indegree[e]++;
			} else if ( dist[e] == ( w + dist[s] ) ) {
				graph.get(s).remove(e);
				indegree[s]++;
			} else {
				graph.get(e).remove(s);
				graph.get(s).remove(e);
			}
		}
		// Conversion into a DAG Complete
        
		// Now count ways
		int[] paths = new int[n];
		Deque<Integer> q = new LinkedList<>();
		
		
		for( int i=0;i<indegree.length;i++ ) {
			if( indegree[i] == 0 ) {
				paths[0] = 1;
				q.add(i);
			}
		}
		
		while( !q.isEmpty() ) {
			int curr = q.remove();
			
			for( int ne : graph.get(curr).keySet() ) {
				if( indegree[ne] == 1  ) {
                    q.add(ne);
				}
				paths[ne] = ( paths[ne] + paths[curr] ) % 100_00_00_007;
				indegree[ne]--;
			}
		}
		
         System.out.println( Arrays.toString(dist));
         System.out.println( Arrays.toString(paths));
        
		return paths[n-1];
		
 	}

		private long[] dijkstra(int n, Map<Integer, Map<Integer, Integer>> graph) {
			
			long[] time = new long[n];
			Arrays.fill(time, INF);
			PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> Long.compare(p1.dist, p2.dist) );
			time[n-1]=0;
			pq.add( new Pair(n-1,(int) time[n-1]) );
			
			while( !pq.isEmpty() ) {
				Pair p = pq.remove();
				int curr = p.node;
				
				for( int ne : graph.get(curr).keySet() ) {
					if( time[ne] > ( graph.get(curr).get(ne) + time[curr] ) ) {
						time[ne] = graph.get(curr).get(ne) + time[curr];
						pq.add( new Pair(ne, (int) time[ne]) );
					}
				}
			}
			
			
			return time;
		}
		
		
		private int dijkstraImprovized(int n, Map<Integer, Map<Integer, Integer>> graph) {
			
			long[] time = new long[n];
			long[] ways = new long[n];
			Arrays.fill(time, INF);
			PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> Long.compare(p1.dist, p2.dist) );
			time[0]=0;
			ways[0]=1;
			
			pq.add( new Pair(0,(int) time[0]) );
			
			while( !pq.isEmpty() ) {
				Pair p = pq.remove();
				int curr = p.node;
				
				for( int ne : graph.get(curr).keySet() ) {
					if( time[ne] > ( graph.get(curr).get(ne) + time[curr] ) ) {
						time[ne] = graph.get(curr).get(ne) + time[curr];
						pq.add( new Pair(ne, (int) time[ne]) );
						ways[ne] = ways[curr];
					} else if( time[ne] == ( graph.get(curr).get(ne) + time[curr] ) ) { 
						ways[ne] = (ways[ne] + ways[curr]) % MOD;
					}
				}
			}
			
			
			return (int)ways[n-1];
		}
		
		private int dijkstraImprovizedWorking(int n, Map<Integer, Map<Integer, Integer>> graph) {
			
			int[] time = new int[n];
			long[] ways = new long[n];
			Arrays.fill(time, Integer.MAX_VALUE);
			PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> p1.dist - p2.dist );
			time[0]=0;
			pq.add( new Pair(0,time[0]) );
			ways[0]=1;
			
			while(pq.size()!=0){
			    int dis = pq.peek().dist;
			    int node = pq.peek().node;
			    pq.remove();

            Map<Integer,Integer> neighs = graph.get(node);
	            
	            for( int ne : neighs.keySet() ) {
                    int edW = neighs.get(ne);
	                if( time[ne] > ( dis + edW ) ) {
	                    time[ne] =   dis + edW ;
	                    pq.add( new Pair( ne , time[ne] ) );
                        ways[ne] = ways[node];
	                } else if(dis+edW == time[ne]){
					    ways[ne] = (ways[ne] + ways[node]) % MOD;
				    }
	            }
                
			}
		
		return (int)ways[n-1];
		}
		
		class Pair {
	        int node ; int dist ;
	        
	        Pair( int node , int dist ) {
	            this.node = node;
	            this.dist = dist;
	        }
	    }

	private void initialization(int n, int[][] roads, Map<Integer, Map<Integer, Integer>> map) {

		for( int[] road : roads ) {
			int s = road[0];
			int e = road[1];
			int w = road[2];
			
			map.putIfAbsent(s, new HashMap<>());
			map.putIfAbsent(e, new HashMap<>());
			
			map.get(s).put(e, w);
			map.get(e).put(s, w);
		}
		
	}


}
