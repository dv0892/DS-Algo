package test.app.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class IsGraphBipartite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        
        for ( int i=0;i<color.length;i++)    {
            if( color[i] == -1 ){
            	
            	//DFS
            	color[i] = 1;
            	if( !isBipartiteDFS(graph, color, i) )
                    return false;
            	
            	//OR
            	
            	//BFS
            	if( !isBipartiteBFS(graph,color,i) )
                    return false;
            }
        }
        
        return true;
    }
	
	
	public boolean isBipartiteBFS(int[][] graph ,int[] color , int node ) {
		
		Deque<Integer> q = new LinkedList<>();
		q.add(node);
        color[node] = 1;
       
        while( !q.isEmpty() ){
            int sz = q.size();
            while( sz-- > 0 ) {
                int n = q.remove();
                for( int neigh : graph[n] ) {
                    if( color[neigh] == -1 ) {
                        color[neigh] = color[n] == 1 ? 2 : 1;
                        q.add(neigh);
                    } else if( color[neigh] == color[n] )
                        return false;
                    
                    
                }
            }
        }
		
		return true;
	
	}
	
	public boolean isBipartiteDFS(int[][] graph ,int[] color , int node ) {
		
		for ( int neigh : graph[node] ) {
			
			if( color[neigh] == -1 ) {
				color[neigh] = color[node] == 1 ? 2 : 1;
				if( !isBipartiteDFS(graph, color, neigh) )
					return false;
			} else if( color[neigh] == color[node] )
                return false;
		}
		
		return true;
	
	}

}
