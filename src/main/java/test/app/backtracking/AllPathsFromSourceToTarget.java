package test.app.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	        List<Integer> list = new ArrayList<>();
	        list.add(0);
	        return  allPathsSourceTarget(list,graph,0); 
	    }
	    
	    
	    public List<List<Integer>> allPathsSourceTarget(List<Integer> list , int[][] graph ,int node) { 
	       
	        if( node == (graph.length - 1) ){
	            List<List<Integer>> ans = new ArrayList<>();
	            ans.add( new ArrayList<>(list) );
	            return ans;
	        }
	        
	        List<List<Integer>> ans = new ArrayList<>();
	        
	        for ( int neighbour : graph[node] ) {
	            list.add(neighbour);
	            ans.addAll( allPathsSourceTarget(list,graph,neighbour) );
	            list.remove(list.size()-1);
	        } 
	        
	        return ans;
	    }

}
