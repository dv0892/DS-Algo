package test.app.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoudAndRich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        Map<Integer,Set<Integer>> richMap = new HashMap<>();
       
        int[] ans = new int[quiet.length];
        for( int i=0;i<ans.length;i++){
            ans[i] = Integer.MAX_VALUE;
            richMap.put(i,new HashSet<>());
        }
        
        for( int[] edge : richer ){
            int rich = edge[0];
            int poor = edge[1];
            
            richMap.get(poor).add(rich);
        }
        
        for( int i=0;i<ans.length;i++){
            findQuieter(i,ans,richMap,quiet);
        }
        
        return ans;
    }
    
    public void findQuieter( int p , int[] ans , Map<Integer,Set<Integer>> richMap , int[] quiet ){
        
        if( ans[p] != Integer.MAX_VALUE )
            return ;
        
        ans[p] = p;
        
        for( int richNeighbour : richMap.get(p) ){
            findQuieter( richNeighbour , ans , richMap, quiet );
            ans[p] = quiet[ans[richNeighbour]] < quiet[ans[p]] ? ans[richNeighbour] : ans[p];
        }
    }

}
