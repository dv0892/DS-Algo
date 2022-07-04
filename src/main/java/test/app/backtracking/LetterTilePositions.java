package test.app.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterTilePositions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new LetterTilePositions().numTilePossibilities("ACB"));
		
		System.out.println( new LetterTilePositions().allTilePossibilities("ACB"));
		
		System.out.println( new LetterTilePositions().nCombPossibilities("ACB",3));
	}
	
	 private List<String> nCombPossibilities(String tiles, int n) {
		 Map<Character, Integer> map = new HashMap<>();
	       
		 for( int i=0; i < tiles.length() ; i++ ) {
	            map.put( tiles.charAt(i) , map.getOrDefault(tiles.charAt(i),0) + 1);
	        }
		 
		return nCombPossibilities("", map, 2);
	}

	public int numTilePossibilities(String tiles) {
	        Map<Character, Integer> map = new HashMap<>();
	        for( int i=0; i < tiles.length() ; i++ ) {
	            map.put( tiles.charAt(i) , map.getOrDefault(tiles.charAt(i),0) + 1);
	        }
	        
	        return numTilePossibilities(  map ) - 1;
	        
	 }
	 
	 public List<String> allTilePossibilities(String tiles) {
	        Map<Character, Integer> map = new HashMap<>();
	        for( int i=0; i < tiles.length() ; i++ ) {
	            map.put( tiles.charAt(i) , map.getOrDefault(tiles.charAt(i),0) + 1);
	        }
	        
	        return allTilePossibilities( "", map ) ;
	        
	 }
	    
	    
	    public int numTilePossibilities( Map<Character, Integer> map ) {
	        
	        int count = 1;
	        
	        
	        for ( Character key : map.keySet() ){
	            if( map.get( key ) > 0){
	                map.put( key,map.get(key) - 1);
	                count += numTilePossibilities(  map  ) ;
	                map.put( key,map.get(key) + 1);
	            }
	        }
	        
	        return count;
	    }
	    
	    
	    public List<String> allTilePossibilities( String possibility, Map<Character, Integer> map ) {
	        
	    	List<String> result = new ArrayList<>();
	        if ( !possibility.isEmpty() ) {
	        	result.add(possibility);
	        }

	        
	        
	        for ( Character key : map.keySet() ){
	            if( map.get( key ) > 0){
	                map.put( key,map.get(key) - 1);
	                result.addAll( allTilePossibilities( new String (possibility + "" +key),  map  ) );
	                map.put( key,map.get(key) + 1);
	            }
	        }
	        
	        return result;
	    }
	    
	    
	    public List<String> nCombPossibilities( String possibility, Map<Character, Integer> map , int n) {
	        
	    	List<String> result = new ArrayList<>();
	        if ( n == possibility.length() ) {
	        	result.add(possibility);
	        }
	        
	        for ( Character key : map.keySet() ){
	            if( map.get( key ) > 0){
	                map.put( key,map.get(key) - 1);
	                result.addAll( nCombPossibilities( new String (possibility + "" +key),  map  ,n ) );
	                map.put( key,map.get(key) + 1);
	            }
	        }
	        
	        return result;
	    }

}
