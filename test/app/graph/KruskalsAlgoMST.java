package test.app.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import test.app.graph.NGraph.Edge;;

public class KruskalsAlgoMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		NGraph g = new NGraph(9);
		g.addEdge(0,1,4);
		g.addEdge(0,7,8);
		
		g.addEdge(1,2,8);
		g.addEdge(1,7,11);
		
		g.addEdge(2,3,7);
		g.addEdge(2,5,4);
		g.addEdge(2,8,2);
		
		g.addEdge(3,5,14);
		g.addEdge(3,4,9);
		
		g.addEdge(4,5,10);
		
		g.addEdge(5,6,2);
		
		g.addEdge(6,7,1);
		g.addEdge(6,8,6);
		
		g.addEdge(7,8,7);
		
		
		for(Edge e : g.allEdges ) {
			System.out.println(e);
		}
		
		System.out.println("MST....");
		
		for(Edge e : findMST_Kruskals(g) ) {
			System.out.println(e);
		}
		
		
	}
	
	public static List<Edge>  findMST_Kruskals(NGraph graph) {
		List<Edge> edges = graph.allEdges;
		
		List<Edge> outputEdges = new ArrayList<>();
		
		Collections.sort(edges, ( (e1,e2) ->  e1.weight - e2.weight ));
		
		
		UnionFind_Optimized  uf  = new UnionFind_Optimized(graph.vertices);
		
		int e=0,i=0;
		while(e < (graph.vertices) && i < (graph.allEdges.size())) {
			Edge edge = edges.get(i++);
			
			int sr = uf.root(edge.source);
			int dr = uf.root(edge.dest);
			
			if(sr != dr) {
				uf.union(sr, dr);
				outputEdges.add(edge);
				e++;
			}
		}
		
		return outputEdges;
	}

}
