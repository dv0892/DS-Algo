package test.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TheTimeWhenTheNetworkBecomesIdle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	    public int networkBecomesIdle(int[][] edges, int[] patience) {
	        int n = patience.length;

			//Build Graph 
	        Map<Integer,List<Integer>> graph = new HashMap<>();
			initialization(n,edges,graph);

	        // Run a BFS to find the shortest distance of each data server from master server
	        int[] dist = new int[n];
	        bfs(graph,dist);
	         
	        System.out.println( Arrays.toString(dist) ); 

	        int maxIdle = Integer.MIN_VALUE;
	        for( int i=1;i<n;i++){
	            int roundTrip = dist[i]*2;
	            if( patience[i] >= roundTrip ){
	                maxIdle = Math.max( maxIdle , roundTrip );
	                continue;
	            }

	            int rePings = roundTrip % patience[i] == 0 ? (roundTrip/patience[i])-1 : (roundTrip/patience[i]) ;
	            maxIdle = Math.max( maxIdle , rePings*patience[i] + roundTrip );
	        }

	        return maxIdle+1 ;
	    }

	    private void bfs( Map<Integer,List<Integer>> graph , int[] dist ){
	        
	        Arrays.fill(dist,Integer.MAX_VALUE);

	        Deque<Integer> q = new LinkedList<>();
	        q.add(0);
	        dist[0] = 0;

	        int level = 0;
	        while( !q.isEmpty() ) {
	            int size = q.size();
	            while( size-- > 0 ){
	                int node = q.remove();
	               
	                for( int ne : graph.get(node) ){
	                    if( level+1 < dist[ne] ){
	                       dist[ne] = level+1;
	                       q.add(ne);
	                    }
	                }
	            }

	            level++;
	        }
	    }

	    private void initialization(int n, int[][] edges, Map<Integer,List<Integer>> map) {

			for( int[] edge : edges ) {
				int s = edge[0];
				int e = edge[1];
				
				map.putIfAbsent(s, new ArrayList<>());
				map.putIfAbsent(e, new ArrayList<>());
				
				map.get(s).add(e);
				map.get(e).add(s);
			}
			
		}
	}


