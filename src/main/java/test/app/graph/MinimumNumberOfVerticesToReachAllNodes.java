package test.app.graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        for( List<Integer> edge : edges ){
            int s = edge.get(0);
            int t = edge.get(1);
            
            parent[t] = s;
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if( parent[i] == i ) 
                res.add(i);
        }
        
        return res;
    }
}
