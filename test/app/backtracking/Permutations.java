package test.app.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] nums = { 1 , 2, 3 };
			//System.out.println( new Permutations().permute(nums));
			System.out.println( new Permutations().permuteDFSSolution( new LinkedList<>() , nums, 0));
	}
	
	public List<List<Integer>> permute(int[] nums) {
        
		/*
		 * Here we are trying to permute in a BFS way.
		 * First pick a character and place it all the possible places in already existing
		 * result.
		 */
		
		
		LinkedList<List<Integer>> result = new LinkedList<>();
		result.add( new LinkedList<>() );
		
		for ( int num : nums ) {
			int size = result.size();
			while ( size-- > 0 ) {
				List<Integer> t = result.remove();
				for( int i=0;i<=t.size();i++) {
					LinkedList<Integer> newResult = new LinkedList<>(t);
					newResult.add(i, num);
					
					result.add(newResult);
				}
			}
		}
		
		return result;
    }
	
	
	public List<List<Integer>> permuteDFSSolution( List<Integer> list , int[] nums , int i ) {
        
		/*
		 * Here we are trying to permute in a DFS way.
		 */
	
		if ( i == nums.length ) {
			List<List<Integer>> result = new LinkedList<>();
			result.add( list );
			
			return result;
		}
	     
		int num = nums[i]; 
		
		List<List<Integer>> answer = new ArrayList<>();
		for( int j=0;j<=list.size();j++) {
			LinkedList<Integer> newList = new LinkedList<>(list);
			newList.add(j, num);
			
			answer.addAll(permuteDFSSolution(newList, nums, i+1));
		}
		
		
	
		
		return answer;
    }

}
