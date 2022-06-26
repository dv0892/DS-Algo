package test.app.backtracking;

import java.util.HashMap;
import java.util.Map;

public class LetterTilePositions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int numTilePossibilities(String tiles) {
	        Map<Character, Integer> map = new HashMap<>();
	        for( int i=0; i < tiles.length() ; i++ ) {
	            map.put( tiles.charAt(i) , map.getOrDefault(tiles.charAt(i),0) + 1);
	        }
	        
	        return numTilePossibilities( "", map );
	        
	    }
	    
	    
	    public int numTilePossibilities(String answer, Map<Character, Integer> map ) {
	        
	        int count = 0;
	        
	        if( !answer.isEmpty() )
	            count++;
	        
	        for ( Character key : map.keySet() ){
	            if( map.get( key ) > 0){
	                map.put( key,map.get(key) - 1);
	                count += numTilePossibilities( answer + key, map  ) ;
	                map.put( key,map.get(key) + 1);
	            }
	        }
	        
	        return count;
	    }

}
