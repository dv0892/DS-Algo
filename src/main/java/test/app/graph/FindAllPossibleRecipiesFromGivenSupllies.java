package test.app.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllPossibleRecipiesFromGivenSupllies {

	public static void main(String[] args) {
		
		

	}
	
	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        Map<String,Integer> indegree = new HashMap<>();
        Map<String,List<String>> myDependents = new HashMap<>();
        Set<String> recipeSet = new HashSet<>();
        
        for( String supp : supplies ) {
        	indegree.put(supp, 0);
        }
        
        for( int r=0 ; r<recipes.length;r++ ) {
        	String recipe = recipes[r];
        	recipeSet.add(recipe);
        	indegree.put(recipe, ingredients.get(r).size() );
        	
        	for( int i=0;i< ingredients.get(r).size();i++ ) {
        		myDependents.computeIfAbsent(ingredients.get(r).get(i), x -> new ArrayList<>()).add(recipe);
        		indegree.putIfAbsent(ingredients.get(r).get(i), 0);
        	}
        }
        
        Deque<String> q = new LinkedList<>();
        for( String k : indegree.keySet() ) {
        	if( indegree.get(k).intValue() == 0 )
        		q.add(k);
        }
        
        while(!q.isEmpty()) {
        	String recipe = q.remove();
        	if(recipeSet.contains(recipe))
        		result.add(recipe);
        	
        	for( String neigh : myDependents.getOrDefault(recipe, new ArrayList<>())) {
        		indegree.computeIfPresent(neigh, (k,v) -> v-1 );
        		
        		if( indegree.get(neigh).intValue() <= 0 ) {
        			q.add(neigh);
        		}
        	}
        }
        
        return result;
    }

}
