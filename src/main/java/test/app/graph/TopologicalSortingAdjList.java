package test.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSortingAdjList {

	public static void main(String[] args) {
		int N = 7;
		Map<Integer,List<Integer>> graph = new HashMap<>();
		
		for( int i=0;i<N;i++) {
			graph.put(i, new ArrayList<>());
		}
		
		graph.get(0).add(1);
		graph.get(0).add(3);
		graph.get(0).add(5);
	
		graph.get(1).add(2);
		graph.get(1).add(3);
		
		graph.get(2).add(4);
		graph.get(2).add(3);
		
		graph.get(3).add(4);
		
		graph.get(5).add(4);
		
		System.out.println( ( new TopologicalSortingAdjList().topologicalSort(graph)));
		
	}
	
	public List<Integer> topologicalSort( Map<Integer,List<Integer>> graph ){
		
		List<Integer> order = new ArrayList<>(graph.size());
		boolean[] visited = new boolean[graph.size()]; 
		
		for ( int v = 0 ; v < graph.size() ; v++) {
			if( !visited[v] )
				visit( v , graph , visited, order );
		}
		
		
		return order;
		
	}
	
	public void visit ( int v , Map<Integer,List<Integer>> graph , boolean[] visited , List<Integer> order  ) {
		if( visited[v] )
			return ;
		
		 visited[v] = true;
		 
		 for ( int neighbour : graph.get(v) ) {
			 visit( neighbour , graph , visited ,  order );
		 }
		 
		 order.add(0 , v);
	}

}
