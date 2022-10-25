package test.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraAlgo {
	
	public static void main(String[] args) {
		
		int N = 6;
		
		List<List<GraphNode>> graph = new ArrayList<>();
		for( int i=0;i<N;i++) {
			graph.add( new ArrayList<>());
		}
		
		graph.get(0).add( new GraphNode(1, 1));
		graph.get(0).add( new GraphNode(2, 5));		
		
		graph.get(1).add( new GraphNode(2, 2));
		graph.get(1).add( new GraphNode(3, 2));		
		graph.get(1).add( new GraphNode(4, 1));
		
		graph.get(2).add( new GraphNode(4, 2));	
		
		graph.get(3).add( new GraphNode(5, 1));		
		graph.get(3).add( new GraphNode(4, 3));
		
		graph.get(4).add( new GraphNode(5, 2));
		
		System.out.print( Arrays.toString( new DijkstraAlgo().findShortestPathUsingDijkstra(0, graph, N)) );
	}
	
	public int[] findShortestPathUsingDijkstra( int source , List<List<GraphNode>> adj , int N ) {
		
		int[] distance = new int[N];
		int[] parent = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		 
		
		
		PriorityQueue<GraphNode> pq = new PriorityQueue<>();
		pq.add(new GraphNode(source, 0));
		distance[source] = 0;
		parent[source] = source;
		
		while( !pq.isEmpty() ) {
			GraphNode node = pq.remove();
			
			//Do Relaxation for All neighbours 
			for ( GraphNode neigh : adj.get(node.getId()) ) {
				if( distance[neigh.getId()] > ( distance[node.getId()] + neigh.getDistance() ) ) {
					distance[neigh.getId()] = ( distance[node.getId()] + neigh.getDistance() );
					pq.add( new GraphNode(neigh.getId(), distance[neigh.getId()]));
					parent[neigh.getId()] = node.getId();
				}
			}
		}
		
		System.out.print(  Arrays.toString(parent) );
		System.out.println();
		
		for ( int i=0;i<N;i++) {
			
			System.out.println( i + " : distance " + distance[i] + " path : "  );
			System.out.print(i + " -> ");
			path(parent,i);
		}
		
		return distance;
	}
	
	public void path ( int[] parent , int idx ) {
		if ( parent[idx] == idx ) {
			return ;
		}
		
		System.out.print( parent[idx]  + " -> ");
		path( parent , parent[idx] );
	}
}

class GraphNode implements Comparable<GraphNode> {
	
	private int id ;
	private int distance ;
	
	public GraphNode ( int id , int distance ) {
		this.id = id;
		this.distance = distance;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public void setDistance( int distance ) {
		this.distance = distance ;
	}
	

	@Override
	public int compareTo(GraphNode node) {
		return Integer.compare(this.distance, node.distance);
	}
}
