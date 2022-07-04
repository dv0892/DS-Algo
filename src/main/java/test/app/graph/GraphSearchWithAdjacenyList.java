package test.app.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import test.app.graph.Graph.Vertex;

public class GraphSearchWithAdjacenyList {
	
	static Queue<Vertex> Q =  new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(5);
		graph.displayGraph();
		
		//breadthFirstSearch(graph.vs.get(0),graph);
		depthFirstSearch(graph.vs.get(0),graph);
	}
	
	public static void breadthFirstSearch(test.app.graph.Graph.Vertex v,Graph graph) {

			v.isVisited  = true;
			Q.add(v);
			
			while(Q.size() != 0) {
				Vertex nVertex = Q.remove();
				for(Vertex adjV : graph.adj.get(nVertex)) {
					if(adjV.isVisited == false) {
						System.out.println("Visiting ..."+ adjV.name);
						adjV.isVisited = true;
						Q.add(adjV);
					}
			   }
				
			}
			
	}
	
	public static void depthFirstSearch(test.app.graph.Graph.Vertex v,Graph graph) {

		v.isVisited  = true;
		
		for(Vertex adjV : graph.adj.get(v)) {
				if(adjV.isVisited == false) {
					System.out.println("Visiting ..."+ adjV.name);
					adjV.isVisited = true;
					depthFirstSearch(adjV,graph);
				}
		}
		
		
}
	
	
	
	
	
}

class Graph {
	
	List<Vertex> vs;
	
	Map<Vertex,List<Vertex>> adj;
	
	class Vertex {
		
		String name;
		
		boolean isVisited = false;
		
		public Vertex(String name) {
			this.name = name;
		}
		

		public boolean equals(Object v) {
			return this.name.equalsIgnoreCase(((Vertex)v).name);
		}
	}
	
	public Graph(int numOfVertices) {
		
		vs = new ArrayList<>();
		
		int i=1;
		while(numOfVertices-- > 0) {
			vs.add(new Vertex("N "+i++));
			
		}
		
		
		adj = new HashMap<>();

		
		List<Vertex> temp_List = new ArrayList<>();
		
		temp_List.add(vs.get(1));
		temp_List.add(vs.get(2));
		adj.put(vs.get(0), temp_List);
		
		temp_List = new ArrayList<>();
		temp_List.add(vs.get(3));
		temp_List.add(vs.get(4));
		adj.put(vs.get(1), temp_List);
		
		temp_List = new ArrayList<>();
		temp_List.add(vs.get(0));
		temp_List.add(vs.get(3));
		adj.put(vs.get(2), temp_List);
		
		temp_List = new ArrayList<>();
		temp_List.add(vs.get(1));
		temp_List.add(vs.get(2));
		adj.put(vs.get(3), temp_List);
		
		temp_List = new ArrayList<>();
		temp_List.add(vs.get(1));
		adj.put(vs.get(4), temp_List);
	}
	
	public void displayGraph() {
		for(Vertex v : vs) {
			System.out.print(v.name + "-->");
			for(Vertex adjV : adj.get(v)) {
				System.out.print(adjV.name + ",");
			}
			
			System.out.println();
		}
	}	
}
