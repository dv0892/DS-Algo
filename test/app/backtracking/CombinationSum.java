package test.app.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[]  candidates  = { 2, 3, 6, 7 };
			
			System.out.println( new CombinationSum().combinationSum(candidates, 7));
 	}
	
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
       // Arrays.stream(candidates).collect(Collectors.toSet()). Need to check and learn from this
        Set<Integer> setOfCandidates = Arrays.stream(candidates).boxed().collect(Collectors.toSet());
        return combinationSum(new ArrayList<>(), setOfCandidates, 0, target);
    }
	
	
	public List<List<Integer>> combinationSum(List<Integer> list ,Set<Integer> candidates, int runningSum,  int target) {
        if ( runningSum == target ) {
        	List<List<Integer>> ans = new ArrayList<>();
        	ans.add(new ArrayList<>(list));
        	return ans;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        int leftOver = target - runningSum;
        while ( leftOver > 0) {
        	if( candidates.contains(leftOver) ) {
        		
        		list.add(leftOver);

        		ans.addAll( combinationSum(list, candidates, leftOver + runningSum , target) );
        		
        		list.remove(list.size()-1);
        	}
        	
        	leftOver--;
        }
        
        return ans;
    }
	

}
