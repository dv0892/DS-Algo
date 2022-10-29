package test.app.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class NumberOfRestrictedPathsFromFirstToLastNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	    
	class Solution {
	    
	    int MOD = 1000000007;
	    
	    public int countRestrictedPaths(int n, int[][] edges) {
	        
	        // Build the graph
	        Map<Integer, Map<Integer,Integer> > graph = new HashMap<>();
	        
	        for( int[]  edge : edges ){
	            int s = edge[0];
	            int e = edge[1];
	            int w = edge[2];
	            
	            graph.putIfAbsent(s , new HashMap<>() );
	            graph.putIfAbsent(e , new HashMap<>() );
	            
	            graph.get(s).put(e,w);
	            graph.get(e).put(s,w);
	        }
	        // Graph Built
	        
	        // Now find the shortest distance distance of each node from n node using dijkstra's algo
	        int[] distanceToLastNode = dijkstralgo(graph, n );              
	        
	        
	        // Using Topological Sorting or a kind of bottom up DP
	        return bottomUpDP(n, edges, graph, distanceToLastNode);
	    }

		private int bottomUpDP(int n, int[][] edges, Map<Integer, Map<Integer, Integer>> graph,
				int[] distanceToLastNode) {
			
			int[] indegree = new int[n+1];
		        for( int[]  edge : edges ){
		            int s = edge[0];
		            int e = edge[1];
		            
		            
		            if( distanceToLastNode[s] == distanceToLastNode[e] ) {
		            	graph.get(s).remove(e);
		            	graph.get(e).remove(s);
		            } else {
		            	if( distanceToLastNode[s] >  distanceToLastNode[e] ) {
		            		graph.get(s).remove(e);
		            		indegree[s] += 1;
		            	} else {
		            		graph.get(e).remove(s);
		            		indegree[e] += 1;
		            	}
		            }
		        }
		        
		        int[] paths = new int[n+1];
		        paths[n] = 1;
		        
		        Deque<Integer> q = new LinkedList<>();
		        q.add(n);
		        
		        while( !q.isEmpty() ) {
		            int curr =  q.remove();
	                
	                if( curr == 1 )
	                    break;
		            
		            Map<Integer,Integer> neighs = graph.get(curr);
		            
		            for( int ne : neighs.keySet() ) {
		                if( indegree[ne] == 1 ) {
		                	q.add(ne);
		                }
	                    paths[ne] = (paths[ne] + paths[curr]) % MOD;
		                indegree[ne]--;	
		            }
		        }
		        
		       
		        
		        return paths[1] ;
		}
	    
	    
	    
	    // By using Top Down DP, which is more intuitive 
	    public int dfs(int s, int e, Map<Integer, Map<Integer, Integer>> graph, int[] dp, int[] dist ) {
		        if(s == e)
		            return 1;
		        
		        if(dp[s] != -1) return dp[s];
		        
		        long res = 0;
		        
		        if(graph.get(s) != null){
		            for(int c: graph.get(s).keySet()){
		                if(dist[s] > dist[c]){
		                    res += (dfs(c, e, graph, dp, dist ) % MOD);
		                }
		            }
		        }    
		        
		        res = (res % MOD);
		        dp[s] = (int)res;
		        
		        return dp[s];
		}
		    
	    
	    public int[] dijkstralgo(Map<Integer, Map<Integer,Integer> > graph , int n ) {
	        
	        int[] dist = new int[n+1];
	        Arrays.fill(dist,Integer.MAX_VALUE);
	        dist[n] = 0;
	        
	        PriorityQueue<Pair> q = new PriorityQueue<>((n1,n2) -> n1.dist - n2.dist);
	        q.add( new Pair( n, dist[n] ) );
	        
	        while( !q.isEmpty() ){
	            Pair p = q.remove();
	            int curr = p.node;
	            
	            
	            Map<Integer,Integer> neighs = graph.get(curr);
	            
	            for( int ne : neighs.keySet() ) {
	                if( dist[ne] > ( dist[curr] + neighs.get(ne) ) ) {
	                    dist[ne] =   dist[curr] + neighs.get(ne) ;
	                    q.add( new Pair( ne , dist[ne] ) );
	                }
	            }
	        }
	        
	        return dist;
	    }
	    
	    class Pair {
	        int node , dist ;
	        
	        Pair( int node , int dist ) {
	            this.node = node;
	            this.dist = dist;
	        }
	    }
	}
}

