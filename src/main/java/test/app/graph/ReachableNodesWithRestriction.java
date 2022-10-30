package test.app.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import test.app.utils.DisJointSet;

public class ReachableNodesWithRestriction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int reachableNodesUsingDSU(int n, int[][] edges, int[] restricted) {
		
		// Much Much Faster than DFS or BFS.
		
		Set<Integer> restrictedNodes = new HashSet<>(); 
	       for( int r : restricted )
	            restrictedNodes.add(r);
		
	       DisJointSet dsu = new DisJointSet(n);
		for( int[] edge : edges ) {
			if( !restrictedNodes.contains(edge[0]) && !restrictedNodes.contains(edge[1]) ) {
				dsu.union(edge[0], edge[1]);
			}
		}
		
		return dsu.size(0);
	}
	
	public int reachableNodes(int n, int[][] edges, int[] restricted) {
	        
	       // we can use a DFS a BFS to count the number of nodes 
	       // we can reach without visiting a restricted node
	    
	       Map<Integer, List<Integer>> graph = new HashMap<>();
	       initialization(n,edges,graph);
	        
	       Set<Integer> restrictedNodes = new HashSet<>(); 
	       for( int r : restricted )
	            restrictedNodes.add(r);
	        
	        Deque<Integer> q = new LinkedList<>();
	        q.add(0);
	        
	        int count = 1;
	        while( !q.isEmpty() ){
	            int size = q.size();
	            while( size-- > 0 ){
	                int node = q.remove();
	                
	                for( int ne : graph.get(node) ){
	                    if( !restrictedNodes.contains(ne) ){
	                        q.add(ne);
	                        count++;
	                    }
	                }

	                // This is done to avoid using visited array
	                restrictedNodes.add(node);
	            }
	        }
	        
	        return count;
	    }
	    
	    private void initialization(int n, int[][] roads, Map<Integer, List<Integer>> map ) {

			for( int[] road : roads ) {
				int s = road[0];
				int e = road[1];
				
				map.putIfAbsent(s, new ArrayList<>());
				map.putIfAbsent(e, new ArrayList<>());
				
				map.get(s).add(e);
				map.get(e).add(s);
			}
			
		}
	

}
