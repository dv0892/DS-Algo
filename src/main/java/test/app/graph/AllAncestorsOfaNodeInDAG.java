package test.app.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AllAncestorsOfaNodeInDAG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}};
		System.out.println( new AllAncestorsOfaNodeInDAG().getAncestors(5, edges));
	}
	
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<Set<Integer>> res = new ArrayList<>();
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++) {
            graph.put(i,new ArrayList<>());
            res.add(new TreeSet<>());
        }

        for( int[]  edge : edges ){
            int src = edge[0];
            int dest = edge[1];

            graph.computeIfAbsent(src,x -> new ArrayList<>()).add(dest);
            indegree[dest]++;
        }

        Deque<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if( indegree[i] == 0 )
                q.add(i);
        }

        while( !q.isEmpty() ){
            int node = q.remove();
            for( int ne : graph.getOrDefault(node,new ArrayList<>()) ){
                res.get(ne).addAll(res.get(node));
                res.get(ne).add(node);
                indegree[ne]--;
                if( indegree[ne] <= 0 ){
                    q.add(ne);
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for( Set<Integer> set : res ) {
        	List<Integer> t = new ArrayList<>();
        	t.addAll(set);
        	ans.add(t);
        } 

        return ans;


    }

}
