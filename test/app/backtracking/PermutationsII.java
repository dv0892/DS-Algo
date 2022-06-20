package test.app.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermutationsII {

	public static void main(String[] args) {
		int[] nums = {1,2,1,2};
		
		//System.out.println( new PermutationsII().permuteUniqueUsingBFS(  nums ));
		
		Map<Integer,Integer> map = new HashMap<>();
		for( int n : nums ){
			map.put(n, map.getOrDefault(n,0)+1);
		}
		
		System.out.println( new PermutationsII().permuteUniqueUsingDFS( new ArrayList<>(), map, nums.length));
		
		//System.out.println( new PermutationsII().permuteUniqueUsingDFS( new ArrayList<>(), nums,0));
	}
	
	public List<List<Integer>> permuteUniqueUsingDFS(List<Integer> list , Map<Integer, Integer> map, int size) {
	
		if ( list.size() == size ) {
			List<List<Integer>> res = new ArrayList<>();
			res.add( new ArrayList<>(list));
			
			return res;
		}

		List<List<Integer>> ans = new ArrayList<>();
		Set<Integer> keySet = map.keySet();
		for ( Integer key : keySet ) {
			if ( map.get( key ) > 0 ) {
				list.add(key);
				map.put(key, map.get( key ) - 1);
				
				ans.addAll(permuteUniqueUsingDFS( list, map, size  ));
				
				list.remove(list.size()-1);
				map.put(key, map.get( key ) + 1);
			}
		}

		return ans;
    }
	
	public List<List<Integer>> permuteUniqueUsingBFS(int[] nums) {
        
		Arrays.sort(nums);
		
		LinkedList<List<Integer>> queue = new LinkedList<>();
		queue.add( new LinkedList<>() );
		
		for ( int n : nums ) {
			int size = queue.size();
			while( size-- > 0 ) {
				List<Integer> t = queue.remove();
				for (int i=0;i<=t.size();i++) {
					/*if( i>0 && n == t.get(i-1) )
						continue;*/
					
					List<Integer> newlist = new LinkedList<>(t);
					newlist.add(i, n);
					
					if ( queue.contains(newlist))
						continue; 
					
					queue.add(newlist);
				}
			}
		}

		return queue;
    }

}
