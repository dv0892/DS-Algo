package test.app.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return  allPathsSourceTarget(new ArrayList<>(),graph,0); 
    }
    
    
    public List<List<Integer>> allPathsSourceTarget(List<Integer> list , int[][] graph ,int node) { 
       
        if( node == (graph.length - 1) ){
            List<List<Integer>> ans = new ArrayList<>();
            list.add(node);
            ans.add( new ArrayList<>(list) );
            list.remove(list.size()-1);
            return ans;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        int[] neighbours = graph[node];
        list.add(node);
        
        for ( int neighbour : neighbours ) {
            ans.addAll( allPathsSourceTarget(list,graph,neighbour) );
        } 
        
        list.remove(list.size()-1);
        
        return ans;
    }

}
