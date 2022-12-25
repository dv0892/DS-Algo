package test.app.array;

import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class LongestSubsequenceWithLimitedSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {469781,45635,628818,324948,343772,452081};
		int[] queries = {816646};
		
		System.out.println( Arrays.toString( new LongestSubsequenceWithLimitedSum().answerQueriesOptimized(nums, queries)));
	}
	
	
	public int[] answerQueriesOptimized(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length];
        int sum=0;
        for( int i=0;i<nums.length ;i++) {
        	sum += nums[i];
        	prefixSum[i] = sum;
        }
        
        // for each query do a binary search on this prefix sum array;
        int i=0;
        for ( int q : queries ) {
        	res[i++] = binarySearch(prefixSum, q);
        	
        } 
        
        return res;
    }
	
	public int binarySearch( int[] arr , int t ) {
		
		int s=0,e=arr.length-1;
		while( s <= e ) {
			int m = s + (e-s)/2;
			if( arr[m] == t )
				return m;
			
			if( t > arr[m] )
				s = m+1;
			else
				e = m-1;
		}
		
		return s ;
	}
	
	public int[] answerQueries(int[] nums, int[] queries) {
        subSequence(nums, 0, 0, 0);

        System.out.println( map);
        
        int[] res = new int[queries.length];
        int i=0;
        for( int q : queries) {
        	NavigableMap<Integer, Integer> subMap = map.headMap(q,true);
        	
        	for( Map.Entry<Integer, Integer> es : subMap.entrySet()) {
        		res[i] = Math.max(res[i], es.getValue());
        	}
        	
        	i++;
        }
        
        return res;
        
    }
	
	TreeMap<Integer, Integer> map = new TreeMap<>();
	
	public void subSequence(int[] nums, int index ,int count , int sum ) {
		if( index == nums.length ) {
			map.merge(sum, count, (v1,v2) -> Math.max(v1, v2));
			return;
		}
		
		subSequence(nums, index+1, count+1, sum+nums[index]);
		subSequence(nums, index+1, count, sum);
    }
}
