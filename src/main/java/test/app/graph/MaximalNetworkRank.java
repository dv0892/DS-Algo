package test.app.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximalNetworkRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	public int maximalNetworkRank(int n, int[][] roads) {
		Map<Integer,Set<Integer>> graph = new HashMap<>(); 
        
        for(int i=0;i<n;i++)
            graph.put(i,new HashSet<>());
        
        int[] connectingRoads = new int[n];
        for( int[] road : roads ){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
            
            connectingRoads[road[0]]++;
            connectingRoads[road[1]]++;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if( graph.get(i).contains(j) ){
                    max = Math.max(max, connectingRoads[i] + connectingRoads[j] - 1); 
                } else{
                    max = Math.max(max, connectingRoads[i] + connectingRoads[j] );
                }
            }
        } 
            
        return max;
    }

}
