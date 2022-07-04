package test.app.graph;

public class PrimsAlgoMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PGraph g = new PGraph(5);
		
		primsMST(g);
	}

	public static void primsMST(PGraph g) {
		VertexInfo[] vInfos = new VertexInfo[g.v];
		
		for( int i=0; i<g.v; i++) {
			vInfos[i] = new VertexInfo();
			vInfos[i].weight = Integer.MAX_VALUE;
		}
		
		vInfos[0].parent = -1;
		vInfos[0].weight = 0;
		
		for( int i=0; i<g.v; i++) {
			int minV =  findMinVertex(vInfos);
			vInfos[minV].visited = true;
			
			for( int j=0; j<g.v; j++) { 
				if(g.adj_mat[minV][j] != 0 && !vInfos[j].visited ) {
					if(g.adj_mat[minV][j] < vInfos[j].weight ) {
						vInfos[j].weight = g.adj_mat[minV][j];
						vInfos[j].parent =  minV;
					}
				}
			}
		}
		
		
		for(VertexInfo vInfo : vInfos) {
			if(vInfo.parent < 0) continue;
			System.out.println(vInfo.toString());
		}
	}
	
	private static int findMinVertex(VertexInfo[] vInfos) {
		// TODO Auto-generated method stub
		int minVertex = -1,i=0;
		
		for(VertexInfo vInfo : vInfos) {
			if(!vInfo.visited && (minVertex == -1 || vInfo.weight < vInfos[minVertex].weight) ) {
				minVertex = i;
			}
			i++;
		}
		
		return minVertex;
	}

	
}

class VertexInfo {
	int parent , weight;
	boolean visited;
	
	public String toString() {
		return parent + "-" + weight;
	}
}

class PGraph {
	int v;
	int[][] adj_mat ;
	
	PGraph(int nodes){
		this.v =  nodes;
		int[][] adj_mat1 = {
							{0,9,75,0,0},
							{9,0,95,19,42},
							{75,95,0,51,66},
							{0,19,51,0,31},
							{0,42,66,31,0}
						   };
		adj_mat = adj_mat1;
	}
}
