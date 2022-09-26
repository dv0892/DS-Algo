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
import java.util.TreeMap;

public class MinimumHeightTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] edges = {{1,0},{0,2},{0,3},{3,4},{4,5}};
		
		System.out.println( new MinimumHeightTree().findMinHeightTrees_Optimized(n, edges));
	}
	
	
	public List<Integer> findMinHeightTrees_Optimized(int n, int[][] edges) {
		
		   if( n < 2 ) {
			   List<Integer> ans = new ArrayList<>();
			   for ( int i=0;i<n;i++) {
		    	   ans.add(i);
		       }
			   return ans;
		   }
        
	       Map<Integer,Set<Integer>> map = new HashMap<>();
	       for ( int[] edge : edges){
	    	     map.computeIfAbsent(edge[0], x -> new HashSet<>() ).add(edge[1]);
	    	     map.computeIfAbsent(edge[1], x -> new HashSet<>() ).add(edge[0]);
	       }
	    
	       List<Integer> leaves = new ArrayList<>(); 
	       for ( int i=0;i<n;i++) {
	    	   if( map.get(i).size() == 1 ) {
	    		   leaves.add(i);
	    	   }
	       }
	       
	       int rem = n ;
	       
	       while( rem > 2 ) {
	    	   rem = rem - leaves.size();
	    	   List<Integer> newleaves = new ArrayList<>();
	    	   for( int leaf : leaves ) {
	    		   int neighbour = map.get(leaf).iterator().next();
	    		   map.get(neighbour).remove(leaf);
	    		   
	    		   if( map.get(neighbour).size() == 1 )
	    			   newleaves.add(neighbour);
	    	   } 
	    	   
	    	   leaves = newleaves;
	       }
	        
	       return leaves;
	        
	}
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
	       Map<Integer,List<Integer>> map = new HashMap<>();
	       for ( int[] edge : edges){
	    	     map.computeIfAbsent(edge[0], x -> new ArrayList<>() ).add(edge[1]);
	    	     map.computeIfAbsent(edge[1], x -> new ArrayList<>() ).add(edge[0]);
	       }
	    
	       TreeMap<Integer,List<Integer>> root = new TreeMap<>();
	       
	       
	       boolean[] visited = new boolean[n];
	       for( int i=0;i<n;i++ ) {
	            Arrays.fill(visited, false);
	            int height = height_bfs(i, map , visited );
	            root.computeIfAbsent(height, x -> new ArrayList<>() ).add(i);
	       }
	        
	       return root.get(root.keySet().iterator().next());
	        
	    }
	    
	    public int height_bfs ( int root , Map<Integer,List<Integer>> nodes , boolean[] visited ){
	        
	        Deque<Integer> q = new LinkedList<>();
	        q.add(root);
	        
	        int height = 0;
	        while( !q.isEmpty() ){
	            int size = q.size();
	            while( size-- > 0 ){
	                int node = q.remove();
	                visited[node] = true;
	                List<Integer> neighbour = nodes.getOrDefault(node,new ArrayList<>());
	                for ( int n : neighbour ){
	                    if( !visited[n] )
	                        q.add(n);
	                }
	            }
	            height++;
	        }
	        
	        return height;
	    }

}
