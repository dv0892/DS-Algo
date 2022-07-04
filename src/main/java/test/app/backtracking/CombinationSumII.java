package test.app.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for( int c : candidates ){
            map.put( c , map.getOrDefault(c,0) + 1 );
        }
        
        return combinationSum2( new ArrayList<>(), map , 0 ,0 ,target);
    }
    
    
    public List<List<Integer>> combinationSum2(List<Integer> list, Map<Integer,Integer> map, int runningSum, int lastLevelsChoices, int target) {
        
        if ( runningSum == target ){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add( new ArrayList<>(list));
            
            return ans;
        }
        
        int max = target - runningSum;
        int min = Math.max(1,lastLevelsChoices);
        
        List<List<Integer>> ans = new ArrayList<>();
        for ( Integer candidate : map.keySet()){
            if ( candidate >= min && candidate <= max && map.get(candidate) > 0 ){
                
                list.add(candidate);
                map.put( candidate , map.get(candidate) - 1 );
                
                ans.addAll( combinationSum2 ( list , map , runningSum + candidate , candidate , target) );
            
                list.remove( list.size() - 1 );
                map.put( candidate , map.get(candidate) + 1 );
            }
        }
        
        return ans;
    }

}
