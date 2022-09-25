package test.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MinimumHeightTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] edges = {{1,0},{1,2},{1,3}};
		
		System.out.println( new MinimumHeightTree().findMinHeightTrees(n, edges));
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
