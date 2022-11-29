package test.app.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindPlayersWithZeroOrOneLoses {

	public static void main(String[] args) {
		int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
		
		System.out.println( new FindPlayersWithZeroOrOneLoses().findWinners(matches));
	}
	
	public List<List<Integer>> findWinners(int[][] matches) {
       
		Set<Integer> won = new HashSet<>();
        Set<Integer> onelost = new HashSet<>();
        Set<Integer> eliminated = new HashSet<>();
          
        for( int[] m : matches ){          
           // winning player
           if( !eliminated.contains(m[0]) ) {
               if( !onelost.contains(m[0]) )
                    won.add(m[0]);
           }

           // losing player
           if( !eliminated.contains(m[1]) ) {
               if( onelost.contains(m[1])  ) {
                   onelost.remove(m[1]);eliminated.add(m[1]);
               } else if( won.contains(m[1])  ) {
                   won.remove(m[1]);onelost.add(m[1]);
               } else {
            	   onelost.add(m[1]);
               }
           }
        }
       

        

        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> wonUsers = new ArrayList<>(won);
        Collections.sort(wonUsers);
        
        List<Integer> lostUsers = new ArrayList<>(onelost);
        Collections.sort(lostUsers);
        
        res.add( wonUsers );
        res.add( lostUsers );

        return res;

    }

}
