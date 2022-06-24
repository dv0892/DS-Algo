package test.app.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSum {

	public static void main(String[] args) {
		
		Set<List<Integer>> set = new HashSet<>();
		set.add(Arrays.asList(1,2,3));
		set.add(Arrays.asList(1,2,3));
		
		//System.out.println( set );
		// TODO Auto-generated method stub
			int[]  candidates  = { 2, 3, 6, 7 };
			
			System.out.println( new CombinationSum().combinationSum(candidates, 7));
 	}
	
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
       // Arrays.stream(candidates).collect(Collectors.toSet()). Need to check and learn from this
        Set<Integer> setOfCandidates = Arrays.stream(candidates).boxed().collect(Collectors.toSet());
        return combinationSum(new ArrayList<>(), setOfCandidates, 0,0, target);
    }
	
	
	public List<List<Integer>> combinationSum(List<Integer> list ,Set<Integer> candidates, int runningSum, int lastlevelsChoice, int target) {
        if ( runningSum == target ) {
        	List<List<Integer>> ans = new ArrayList<>();
        	ans.add(new ArrayList<>(list));
        	return ans;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        int max = target - runningSum;
        int min = Math.max(1, lastlevelsChoice) ;
        
        
        for ( Integer candidate : candidates ) {
        	if( candidate >= min && candidate <= max) {
        		list.add(candidate);
         	    List<List<Integer>> temp = combinationSum(list, candidates, candidate + runningSum ,candidate,target) ;
         		
         		ans.addAll( temp );
         		
         		list.remove(list.size()-1);
        	}
        }
        
        
        // Below code is making lot of choices. This has been optimized to above code.
        /*int remainingSum = target - runningSum;
        int choice = Math.max(1, lastlevelsChoice) ;
        while ( choice <= remainingSum) {
        	if( candidates.contains(choice) ) {
        		
        	   list.add(choice);

        	   List<List<Integer>> temp = combinationSum(list, candidates, choice + runningSum ,choice,target) ;
        		
        		ans.addAll( temp );
        		
        		list.remove(list.size()-1);
        	}
        	
        	choice++;
        }*/
        
        return ans;
    }
	

}
