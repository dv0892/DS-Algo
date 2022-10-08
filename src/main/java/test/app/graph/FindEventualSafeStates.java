package test.app.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindEventualSafeStates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer,Set<Integer>> inEdges = new HashMap<>();
        Map<Integer,Set<Integer>> outEdges = new HashMap<>();
        Deque<Integer> q = new LinkedList<>();
        
        for(int n=0;n<graph.length;n++){
            outEdges.put(n, new HashSet<>());
            
            for(int e=0;e<graph[n].length;e++){
                inEdges.computeIfAbsent( graph[n][e] , x -> new HashSet<>() ).add(n);
                outEdges.get(n).add(graph[n][e]);
            }
            
            if( graph[n].length == 0 )
                q.add(n);
        }
        
        List<Integer> ans = new ArrayList<>();
        while( !q.isEmpty() ){
            int terminalNode = q.remove();
            ans.add(terminalNode);
            
            for( int inNode : inEdges.getOrDefault( terminalNode,  new HashSet<>() ) ){
                outEdges.get(inNode).remove(terminalNode);
                if( outEdges.get(inNode).size()==0 )
                    q.add(inNode);
            }
        }
        
        Collections.sort(ans);
        return ans;
    }

}
