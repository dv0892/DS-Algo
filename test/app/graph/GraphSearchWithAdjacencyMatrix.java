package test.app.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import test.app.graph.G.Vertex;

public class GraphSearchWithAdjacencyMatrix {
	
	static Queue<Vertex> Q =  new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G graph = new G(5);
		graph.displayGraph();
		
		//breadthFirstSearch(graph.vs.get(0),graph);
		depthFirstSearch(graph.vs.get(0),graph);;
	}
	
	
	public static void breadthFirstSearch(test.app.graph.G.Vertex v,G graph) {

		v.isVisited  = true;
		Q.add(v);
		
		while(Q.size() != 0) {
			Vertex nVertex = Q.remove();
			int i=0;
			for(int adjV : graph.adj[nVertex.name-1]) {
				Vertex newV = graph.vs.get(i++);
				if(newV.isVisited == false && adjV==1) {
					System.out.println("Visiting ..."+ newV.name);
					newV.isVisited = true;
					Q.add(newV);
				}
		   }
			
		}
		
}

public static void depthFirstSearch(test.app.graph.G.Vertex v,G graph) {

	v.isVisited  = true;
	
	int i=0;
	for(int adjV : graph.adj[v.name-1]) {
		Vertex newV = graph.vs.get(i++);
		if(newV.isVisited == false && adjV==1) {
			System.out.println("Visiting ..."+ newV.name);
			newV.isVisited = true;
			
			depthFirstSearch(newV,graph);
		}
   }
}

}


class G {
	
	List<Vertex> vs;
	
	int[][] adj = {
					   {0,1,1,0,0},
					   {1,0,0,1,1},
					   {1,0,0,1,0},
					   {0,1,1,0,0},
					   {0,1,0,0,0}
				  };
	

	class Vertex {
		
		int name;
		
		boolean isVisited = false;
		
		public Vertex(int name) {
			this.name = name;
		}
		

		public boolean equals(Object v) {
			return this.name == (((Vertex)v).name);
		}
	}
	
	public G(int numOfVertices) {
		this.vs = new ArrayList<>();;
		
		for(int i=0;i<numOfVertices;i++) {
			this.vs.add(new Vertex(i+1));
		}
	}
	
	
	public void displayGraph() {
		int row = 1;
		for(int[] v : adj) {
			System.out.print((row++)+ "-->");
			
			int col=1;
			for(int adj : v) {
				if(adj == 1)
				System.out.print(col + ",");
				
				col++;
			}
			
			System.out.println();
		}
	}	
}
