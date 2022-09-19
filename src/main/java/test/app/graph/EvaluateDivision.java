package test.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<String>> equations = new ArrayList<>();
		equations.add(Arrays.asList("x1","x2"));
		equations.add(Arrays.asList("x2","x3"));
		equations.add(Arrays.asList("x3","x4"));
		equations.add(Arrays.asList("x4","x5"));
		
		double[] vals = { 3.0d , 4.0d, 5.0d, 6.0d } ;
		
		List<List<String>> queries = new ArrayList<>();
		queries.add(Arrays.asList("x1","x5"));
		queries.add(Arrays.asList("x5","x2"));
		queries.add(Arrays.asList("x2","x4"));
		queries.add(Arrays.asList("x2","x2"));
		queries.add(Arrays.asList("x2","x9"));
		queries.add(Arrays.asList("x9","x9"));
		
		System.out.println( Arrays.toString( new EvaluateDivision().calcEquation(equations, vals, queries) ) );
	}

	    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
	        
	       Map<String,Map<String,Double>> graph = new HashMap<>();
	       double[] ans = new double[queries.size()];
	        
	        int i = 0;
	        for ( List<String> eq : equations ){
	            
	            String src = eq.get(0);
	            String dest = eq.get(1);
	            
	            graph.putIfAbsent(src, new HashMap<>());
	            graph.putIfAbsent(dest, new HashMap<>());
	            
	            graph.get(src).put(dest,values[i]);
	            graph.get(dest).put(src,(double)1/values[i]);
	            
	            i++;
	        }
	        
	        i=0;
	        for ( List<String> q : queries ){
	            
	            String src = q.get(0);
	            String dest = q.get(1);
	            
	            if( !graph.containsKey(src) || !graph.containsKey(dest) ) {
	                ans[i++] = -1.0d ;
	                continue;
	            } 
	            
	            ans[i++] = dfs ( src, dest , graph , new HashSet<>());
	        }
	        
	        return ans;
	    }
	    
	    public double dfs ( String src , String dest , Map<String,Map<String,Double>> graph , Set<String> visited ){
	        
	        if( src.equals(dest) )
	            return 1d;
	                
	        if( graph.get(src).containsKey(dest) ){
	            return graph.get(src).get(dest);
	        }
	        
	        visited.add(src);
	        Map<String,Double> neighbours = graph.get(src) ;
	        
	        for ( String neighbour : neighbours.keySet() ){
	            if ( !visited.contains(neighbour) ) {
	            	
	            	double ans =  dfs ( neighbour , dest , graph , visited);
	                if( ans != -1d ) {
	                	return ans * neighbours.get(neighbour);
	                }
	            }
	        }
	        
	        return -1d;
	        
	    }
	
	
	}


