package test.app.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CompanyPlannigProjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] V  = { -3,5,7,2,3};
		int[] A =  { 3,1};  
		int[] B =  { 2,4}; 
		
		
		System.out.println( new CompanyPlannigProjects().solution(V, A, B));
	}
	
	public int solution(int[] V, int[] A, int[] B) {
        
		
        int nodes = V.length;

        Map<Integer,Set<Integer>> graph = new HashMap<>();
        List<Integer> indegree = new ArrayList<>(nodes);
        
        for ( int i=0;i<nodes; i++){
        	graph.put(i, new HashSet<>());
            indegree.add(0);
        }

        for ( int i=0;i<A.length; i++){
            int src = A[i];
            int dest = B[i];

            graph.get(src).add(dest);
            indegree.set( dest , indegree.get(dest) + 1 );
        }
        
        

        int maxProfit = Integer.MIN_VALUE;
            
        List<Integer> maxList = new ArrayList<>();
        
        for ( int i=0;i<indegree.size(); i++) {
            if( indegree.get(i).intValue() == 0 ) {
                
            	maxList.add(V[i]);
                
                for ( Integer dest : graph.get(i) ) {
	           		 if( indegree.get(dest) == 1 ){
	                        maxProfit = Math.max( maxProfit , V[i] + V[dest] );
	           		 }
                }
            }
        }
            

        Collections.sort(maxList);
        
        int max1  = maxList.get( maxList.size()-1 );
        int max2  = maxList.get( maxList.size()-2 );

        if( max1 < 0 ||  max2 < 0 ) {
            return Math.max( maxProfit , max1 );
        } else
            return Math.max( maxProfit , max1 + max2 );


       
    }

}
