package test.app.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] edges = {{0,1},{1,2},{1,3},{2,3},{0,2}};
		double[] prob = {0.1,0.1,0.1,0.1,0.00000001};
		int s = 0;
		int e = 2;
		
		System.out.println( new PathWithMaximumProbability().maxProbability(n, edges, prob, s, e));
	}
	
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) { 
	   
		Map<Integer,Map<Integer,Double>> graph = new HashMap<>();
			for( int i=0;i<n;i++) {
				graph.put(i, new HashMap<>());
			}
	    
	    int i=0;
	    for( int[] edge : edges ){
	        graph.get(edge[0]).put(edge[1],succProb[i]);
	        graph.get(edge[1]).put(edge[0],succProb[i]);
	        i++;
	    }
	    
	    
	    
	    double[] prob = new double[n];
	    Arrays.fill(prob,Double.MIN_VALUE);
	    
	    prob[start] = 1.0d;
	    
	    PriorityQueue<GraphNode> pq = new PriorityQueue<>();
		pq.add(new GraphNode(start, prob[start]));
		
		
		while( !pq.isEmpty() ) {
			GraphNode node = pq.remove();
			
			if( node.getId() == end )
				return prob[end];
			
			//Do Relaxation for All neighbours 
			for ( Integer neighID : graph.get(node.getId()).keySet() ) {
				  
				if( prob[neighID] < ( prob[node.getId()] * graph.get(node.getId()).get(neighID) ) ) {
					prob[neighID] = ( prob[node.getId()] * graph.get(node.getId()).get(neighID) );
					pq.add( new GraphNode( neighID, prob[neighID] ));
					
				}
			}
		}
	    
	    
	    return 0.0d;
    
	}

	class GraphNode implements Comparable<GraphNode> {
	
		private int id ;
		double  prob ;
		
		public GraphNode ( int id , double distance ) {
			this.id = id;
			this.prob = distance;
		}
		
		public int getId() {
			return this.id;
		}
		
		public double getDistance() {
			return this.prob;
		}
		
		public void setDistance( double distance ) {
			this.prob = distance ;
		}
		
		
		@Override
		public int compareTo(GraphNode node) {
			return Double.compare(node.prob, this.prob);
		}
	}

}
