package test.app.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ShortestPathWithAlternatingColos {

	public static void main(String[] args) {
		System.out.println( Arrays.toString( new ShortestPathWithAlternatingColos().shortestAlternatingPaths(
				5, new int[][] {{0,1},{1,2},{2,3},{3,4}}, new int[][] {{1,2},{2,3},{3,1}} )));

	}
	
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        Map<Integer,Map<Integer,Set<Integer>>> graph = new HashMap<>();
        for(int[] redEdge : redEdges ) {
			graph.putIfAbsent( redEdge[0] , new HashMap<>() );
            graph.get(redEdge[0]).computeIfAbsent(0 , x -> new HashSet<>()).add(redEdge[1]);
        }

        for(int[] blueEdge : blueEdges ) {
            graph.putIfAbsent(blueEdge[0] , new HashMap<>());
            graph.get(blueEdge[0]).computeIfAbsent(1 , x -> new HashSet<>()).add(blueEdge[1]);
        }
        
        boolean[][] processed = new boolean[n][2];
        
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        q.add(new int[]{0,1});
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while( size-- > 0 ) {
                int[] node = q.remove();
                
                if( ( node[1] == 1 && !processed[node[0]][node[1]] ) ) {
                	// process only red nodes
                	Set<Integer> redNeigh = graph.getOrDefault(node[0] , new HashMap<>()).getOrDefault(0,new HashSet<>());
                    for( int ne : redNeigh ){
                        if( node[1] == 0 )
                            continue;
                        
                        if( dist[ne] > level ){
                            dist[ne] = level;
                        }
                        
                        q.add( new int[]{ne,0});
                    }
                    processed[node[0]][node[1]] = true;
                }  
                
                if( ( node[1] == 0 && !processed[node[0]][node[1]] )) {
                	// process only black node
                	Set<Integer> blueNeigh = graph.getOrDefault(node[0] , new HashMap<>()).getOrDefault(1,new HashSet<>()); 
                	for( int ne : blueNeigh ){
                        if( node[1] == 1 )
                            continue;
                        
                        if( dist[ne] > level ){
                            dist[ne] = level;
                        }
                        
                        q.add( new int[]{ne,1});
                    }
                	processed[node[0]][node[1]] = true;
                }
                

                
            }
            level ++;
        }
        
        for( int i=0;i<n;i++) {
        	dist[i] = ( dist[i] == Integer.MAX_VALUE ) ? -1 : dist[i];
        }

        return dist;
    }
}
