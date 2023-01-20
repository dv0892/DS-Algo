package test.app.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NonDecreasingSubSequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<List<Integer>> findSubsequences(int[] nums) {
        subSequence(0,nums,new ArrayList<>());
        List<List<Integer>> res = new ArrayList<>();
        for( Set<List<Integer>> temp : map.values() ){
            for(List<Integer> l : temp  )
            res.add(l);
        }
        
        System.out.println( map.values());
        return res;
    }

    Map<Integer, Set<List<Integer>> > map = new HashMap<>();

    public void subSequence( int i , int[] nums , List<Integer> sequence){
        if( i == nums.length ){
            if( sequence.size() >=2 ){
                map.computeIfAbsent(sequence.size(), x -> new HashSet<>() ).add(new ArrayList<>(sequence));
            }
            return;
        }

        if( sequence.size() == 0 || ( nums[i] >= sequence.get( sequence.size() - 1 )  )) {
            sequence.add(nums[i]);
            subSequence ( i + 1 , nums , sequence );
            sequence.remove( sequence.size() - 1 );
        }
    
        subSequence ( i + 1 , nums , sequence );
    }

   /* public boolean checkIfSequenceExists ( List<Integer> sequence ){  
        if( map.size() == 0 || map.get( sequence.size() ) == null )
            return false;
        List<List<Integer>> temp = map.get( sequence.size() );
        for( List<Integer> list : temp ){
            if( isSeqEqual(list,sequence) )
                return true;
        }
        return false;
    }

    public boolean isSeqEqual( List<Integer> l1 , List<Integer> l2 ){
        int i=0, len = l1.size();
        while( i < len ){
            if( Integer.compare(l1.get(i),l2.get(i)) != 0  )
                return false;
            i++;
        }

        return true;
    }*/

}
