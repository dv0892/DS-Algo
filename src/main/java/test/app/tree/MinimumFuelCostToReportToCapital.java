package test.app.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumFuelCostToReportToCapital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

	    public long minimumFuelCost(int[][] roads, int seats) {
	       Map<Integer,Set<Integer>> graph = new HashMap<>();
	       for( int[] road : roads ){
	           int src  = road[0];
	           int dest = road[1];
	           graph.computeIfAbsent(src,x->new HashSet<>()).add(dest);
	           graph.computeIfAbsent(dest,x->new HashSet<>()).add(src);
	       }

	       count(graph,0,-1,seats);
	       return minFuel;

	    }
	    long minFuel = 0;
	    public int count ( Map<Integer,Set<Integer>> graph , int node , int parent,int seats ){

	        int count = 1;
	        for( int ne : graph.getOrDefault(node, new HashSet<>()) ){
	            if( ne == parent )
	                continue;
	            
	            count+=count(graph,ne,node,seats);
	        }

	        if( node != 0 ) {
	            minFuel += ( count/seats ); 
	            if( (count%seats) != 0)
	                minFuel++;
	        }

	        return count;
	    }
	
}
