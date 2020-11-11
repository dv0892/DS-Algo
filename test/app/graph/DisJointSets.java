package test.app.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DisJointSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NGraph graph = new NGraph(6);
		graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);

        
        System.out.println("Is Cycle ...."+ graph.isCycle_Optimized());
        //System.out.println("Is Cycle ...."+ graph.isCycle());
	}

}

class NGraph {
	
	int vertices;
	
	List<Integer> [] adjVertices;
	
	List<Edge> allEdges ;
	
	class Edge {
		int source;
		int dest;
		int weight;
		
	    public Edge(int source, int destination) {
            this.source = source;
            this.dest = destination;
        }
	    
	    public Edge(int source, int destination, int weight) {
            this.source = source;
            this.dest = destination;
            this.weight = weight;
        }
	    
	    public String toString() {
	    	return this.source + " : "+ this.dest +" : "+ this.weight;
	    }
	}
	
	NGraph(int vertices){
		this.vertices = vertices;
		
		adjVertices = new List[vertices];
		
		while(vertices > 0) {
			adjVertices[--vertices] = new ArrayList<>();
		}
		
		allEdges = new ArrayList<>(); 
	}
	
	void addEdge(int source,int dest) {
		
		adjVertices[source].add(dest);
		
		allEdges.add(new Edge(source,dest));
	}
	
	void addEdge(int source,int dest,int weight) {
		
		adjVertices[source].add(dest);
		
		allEdges.add(new Edge(source,dest,weight));
	}
	
	public boolean isCycle() {
		UnionFind uf = new UnionFind(this.vertices);
		
		for(Edge e : allEdges) {
			int rootA = uf.root(e.source);
			int rootB = uf.root(e.dest);
			
			if(rootA == rootB) {
				uf.display();
				return true;
			}
			
			uf.union(rootA, rootB);
		}
		
		return false;
	}
	
	public boolean isCycle_Optimized() {
		UnionFind_Optimized uf = new UnionFind_Optimized(this.vertices);
		
		for(Edge e : allEdges) {
			int rootA = uf.root(e.source);
			int rootB = uf.root(e.dest);
			
			if(rootA == rootB) {
				uf.display();
				return true;
			}
			
			uf.union(rootA, rootB);
		}
		
		return false;
	}
	
	
} 
//This class is optimized with Union By Rank and Path Compression Technique
class UnionFind_Optimized {
	
	class subset {
		int parent, rank;
	}
	
	subset[] arr ;
	
	UnionFind_Optimized(int setElements){
		arr = new subset[setElements];
		
		while(setElements > 0) {
			arr[--setElements] = new subset();
			arr[setElements].parent = setElements;
			arr[setElements].rank = 0;
		}
		
	}
	// X - will become the representative element of the Set
	public void union(int x, int y) {
		int p_x = root(x);
		int p_y = root(y);
		
		int r_x = arr[p_x].rank, r_y =  arr[p_y].rank;
		if( r_x > r_y ) {
			arr[p_y].parent = arr[p_x].parent;
		} else if( r_y > r_x ) {
			arr[p_x].parent = arr[p_y].parent;
		} else {
			arr[p_y].parent = arr[p_x].parent;
			arr[p_x].rank++;
		}
	}
	
	public int root(int el) {
		if(arr[el].parent == el) {
			return arr[el].parent;
		}
		
		return arr[el].parent = root(arr[el].parent);
	}
	
	public void display() {
		for(subset el : arr) {
			System.out.println(el.parent+"-");
		}
	}
}

class UnionFind {
	
	int[] arr ;
	
	UnionFind(int setElements){
		arr = new int[setElements];
		
		while(setElements > 0) {
			arr[--setElements] = setElements;
		}
		
	}
	
	public void union(int x, int y) {
		arr[root(y)] = root(x);
	}
	
	public boolean find(int el1, int el2) {
		
		if(root(el1) == root(el2))
			return true;
		
		return false;
		
	}
	
	public int root(int el) {
		if(arr[el] != el) {
			root(arr[el]);
		}
		
		return arr[el];
	}
	
	public void display() {
		for(int el : arr) {
			System.out.println(el+"-");
		}
	}
}
