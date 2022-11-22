package test.app.graph;

import test.app.utils.DisJointSet;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

	public static void main(String[] args) {
		
		

	}
	
	public long countPairs(int n, int[][] edges) {
        
        if( edges.length == 0 ){
            return ((long)n*((long)n-1))/2;
        }
		
		// Use Union Find to combine nodes and form components
		DisJointSet uf = new DisJointSet(n);
		for( int[] edge : edges ) {
			uf.union(edge[0], edge[1]);
		}
		
		long[] connected = new long[uf.sets()];
		for(int i=0,j=0;i<n;i++) {
			if( uf.find(i) == i ) {
				connected[j++] = uf.size(i);
			} 
		}
		
		long countPair=0;
		for(int i=0;i<connected.length;i++) {
			for(int j=i+1;j<connected.length;j++) {
				countPair+=(connected[i]*connected[j]);
			}
			
		}
		
		return countPair;
     }

}
