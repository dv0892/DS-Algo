package test.app.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReorderRoutesToMakeAllPathsLeadToCityZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int minReorder(int n, int[][] connections) {
        Map<Integer,List<Integer>> inedges = new HashMap<>();
        Map<Integer,List<Integer>> outedges = new HashMap<>();
        
        for(int i=0;i<n;i++){
            inedges.put(i,new ArrayList<>());
            outedges.put(i,new ArrayList<>());
        }
        
        for( int[] conn : connections ){
            int s = conn[0];
            int t = conn[1];
            outedges.get(s).add(t);
            inedges.get(t).add(s);
        }
        
        boolean[] visited = new boolean[n];
        
        Deque<Integer> q = new LinkedList<>();
        q.add(0);
        int count = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while( size-- > 0 ){
                int node = q.remove();
                
                for( int v : outedges.get(node) ){
                    if(!visited[v]){
                        count++;
                        q.add(v);
                    }
                }
                
                for( int v : inedges.get(node) ){
                    if(!visited[v]){
                        q.add(v);
                    }
                }
                
                visited[node] = true;
            }
        }
        
        return count;
    }

}
