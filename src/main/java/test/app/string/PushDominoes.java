package test.app.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PushDominoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new PushDominoes().pushDominoes("RR.L"));
	}
	
	public String pushDominoes(String dominoes) {

		Map<Character,List<Integer>> map = new HashMap<>();
	    char[] dArr = dominoes.toCharArray();
	    int len = dArr.length;
	    
		while( true ) {
			map.clear();
			for ( int i=0;i<len;i++) {
				if( dArr[i] == '.' ) {
					
					if( i == 0 ) { //First one
						if( ((i+1)<len) && dArr[i+1] == 'L' )
							map.computeIfAbsent('L',x -> new ArrayList<>()).add(i);
							
					} else if ( i == (len-1) ){ //last one
						if( dArr[i-1] == 'R' )
							map.computeIfAbsent('R',x -> new ArrayList<>()).add(i);
				
					} else 	if( dArr[i+1] == 'L' && dArr[i-1] != 'R' ) { 
							map.computeIfAbsent('L',x -> new ArrayList<>()).add(i);
				    } else if( dArr[i-1] == 'R' && dArr[i+1] != 'L' ) {
							map.computeIfAbsent('R',x -> new ArrayList<>()).add(i);
				    }
					
				}
			}
			
			
			if( map.isEmpty() )
				break;
			
			for ( char key : map.keySet() ) {
				List<Integer> indexes  = map.get(key);
				
				for ( int dominoe : indexes )
					dArr[dominoe] = key;
			}
		}

		return new String(dArr);
    }

}
