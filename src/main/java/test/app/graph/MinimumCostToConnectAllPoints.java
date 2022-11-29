package test.app.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumCostToConnectAllPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public int minCostConnectPoints(int[][] points) {
	
		// Create a graph
		int n = points.length;
		Map<Integer,Map<Integer,Integer>> graph = new HashMap<>();
		for(int i=0;i<n;i++) {
			graph.put(i, new HashMap<>());
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
			if( i == j )
				continue;
			int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
			graph.get(i).put(j,dist);
			}
		}
		
		boolean[] visited = new boolean[n];
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2) -> Integer.compare(p1[1], p2[1]));
		pq.add(new int[] {0,0});
		
		int ans = 0 ;
		while( !pq.isEmpty() ) {
			int[] point = pq.remove();
			if( visited[point[0]] )
				continue;
			
			visited[point[0]] = true;
			ans += point[1];
			for( int ne : graph.get(point[0]).keySet()) {
			     if( !visited[ne] ) {
			    	 pq.add(new int[] {ne , graph.get(point[0]).get(ne)});
			     }
			}
			
		}
		
		return ans;
	}
}
