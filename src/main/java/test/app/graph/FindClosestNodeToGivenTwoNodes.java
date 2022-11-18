package test.app.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FindClosestNodeToGivenTwoNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	    public int closestMeetingNode(int[] edges, int node1, int node2) {
	        
	        int n = edges.length;
	        int[] d1 = new int[n];
	        bfs(edges,node1,d1);

	        int[] d2 = new int[n];
	        bfs(edges,node2,d2);

	        int res=Integer.MAX_VALUE;
	        int index=-1;
	        for( int i=0;i<n;i++){
	            if( d1[i]==-1 || d2[i]==-1 )
	                continue;

	            int max = Math.max(d1[i],d2[i]);
	            if( max < res ){
	                res = max;
	                index = i;
	            }
	        }

	        return index;
	    }

	    public void bfs ( int[] edges, int node ,int[] d ){
	        Arrays.fill(d,Integer.MAX_VALUE);
	        d[node] = 0;
	        int level = 0;

	        Deque<Integer> q = new LinkedList<>();
	        q.add(node);
	        while( !q.isEmpty() ){
	            int sz = q.size();
	            while( sz-- > 0 ) {
	                int n = q.remove();

	                int neighbour = edges[n];
	                if( neighbour != -1 && d[neighbour] > (level+1)){
	                    d[neighbour] = level+1;
	                    q.add(neighbour);
	                }
	            }
	            level++;
	        }
	    }
	
}
