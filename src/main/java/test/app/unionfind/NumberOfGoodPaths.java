package test.app.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import test.app.utils.DisJointSet;

public class NumberOfGoodPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int numberOfGoodPathsOptmized(int[] vals, int[][] edges) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for( int[] edge : edges ){
            map.computeIfAbsent(edge[0],x->new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1],x->new HashSet<>()).add(edge[0]);
        } 
        
        int n = vals.length;
        Map<Integer,Set<Integer>> valueToNodes = new TreeMap<>();
        for( int i=0;i<n;i++) {
        	valueToNodes.computeIfAbsent(vals[i], x -> new HashSet<>()).add(i);
        }
        
        DisJointSet dsu = new DisJointSet(n);
        int goodPaths = 0 ;
        for( int val : valueToNodes.keySet()) {
        	
        	for ( int node : valueToNodes.get(val) ) {
        		for ( int neigh : map.getOrDefault(node, new HashSet<>()) ) {
            		
            		if( vals[neigh] <= vals[node] ) {
            			dsu.union(node, neigh);
            		}
            	}
        	}// components formed.
        	
        	Map<Integer,Integer> group = new HashMap<>();
        	for ( int node : valueToNodes.get(val) ) {
        		group.put( dsu.find(node), group.getOrDefault(dsu.find(node), 0) + 1);
        	}
        	
        	for ( int res :  group.values()) {
        		goodPaths += (res*(res+1))/2 ;
        	}
        	
        }

        return goodPaths;
    }
	
	
	public int numberOfGoodPaths(int[] vals, int[][] edges) {
		// This is giving TLE
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for( int[] edge : edges ){
            map.computeIfAbsent(edge[0],x->new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1],x->new HashSet<>()).add(edge[0]);
        } 

        boolean[] visited = new boolean[vals.length];
        int goodPaths = 0;
        for( int n=0;n<vals.length;n++){
            if( !visited[n] ){
                int res = countDFS( vals[n] , n, -1,map,vals,visited);
                goodPaths += (res*(res+1))/2 ;
            }
        }

        return goodPaths;
    }

    public int countDFS( int pivotValue , int currNode , int parent , Map<Integer,Set<Integer>> map , int[] vals , boolean[] visited){
        if( vals[currNode] > pivotValue )
            return 0;
        
        int count = 0 ;
        if(  vals[currNode] ==  pivotValue){
            count++;
            visited[currNode] = true; 
        }
        
        for( int ne : map.getOrDefault(currNode, new HashSet<>()) ) {
            if( ne != parent )
                count += ( countDFS( pivotValue ,ne,currNode,map,vals,visited) );
        }

        return count;
    }

}
