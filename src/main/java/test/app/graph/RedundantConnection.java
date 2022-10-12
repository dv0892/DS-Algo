package test.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import test.app.utils.DisJointSet;

public class RedundantConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
		
		System.out.println(Arrays.toString( new RedundantConnection().findRedundantConnection(edges))); 
		
	}
	
	
	public int[] findRedundantConnectionDSU(int[][] edges) {
        int[] ans = new int[2];
        DisJointSet ds = new DisJointSet(1001);
		
        for( int[] edge : edges ){
            int src  = edge[0];
            int dest = edge[1];
            
            if( ds.find(src) == ds.find(dest) )
                return edge;
            
            ds.union(src,dest);
        }
        
        return ans;
    }
	
	HashSet<Integer> seen = new HashSet<>();
	
	public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] ans = new int[2];
        
        for( int[] edge : edges ){
            int src  = edge[0];
            int dest = edge[1];
            
            /*for( int n : map.getOrDefault(src,new ArrayList<>()) ){
                if( n != dest ){
                	seen.clear();
                	seen.add(src);
                    if( dfs(n , dest , map ) )
                        ans =  new int[]{src,dest};
                }
            }*/
            
            seen.clear();
            if( dfs(src , dest , map ) )
                ans =  new int[]{src,dest};
            
            map.computeIfAbsent(src , x -> new ArrayList<>() ).add(dest);
            map.computeIfAbsent(dest , x -> new ArrayList<>() ).add(src);
        }
        
        return ans;
    }
    
    
    public boolean dfs( int node , int target , Map<Integer,List<Integer>> map ) { 
        
        if ( node == target )
            return true;
        
        for ( int neighbour : map.getOrDefault(node,new ArrayList<>()) ){
            if( !seen.contains(neighbour) ) {
            	seen.add(node);
                if( dfs( neighbour, target, map) )
                    return true;
            }
        }
        
        return false;
    }

}
