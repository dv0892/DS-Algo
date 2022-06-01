package test.app.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {53,8,12,80,99,6,39,15,64,31,17,12,98,79,6,69,99,67,93,30,76,9,3,77,45,77};
		
		System.out.println( new FindTargetIndicesAfterSortingArray().targetIndices(arr,99));
		
		
	}
	
	
	public List<Integer> targetIndices(int[] nums, int target) {
        
		Arrays.sort(nums);
        
		int st = binarySearcFirstIndex(nums, 0, nums.length-1, target);
		
		List<Integer> list = new ArrayList<>();
		if(st != -1) {
			while( st <= binarySearchLastIndex(nums, 0, nums.length-1, target))
				list.add(st++);
		}
		
		return list;
    }
	
	
	public int binarySearcFirstIndex (int[] nums, int st , int end , int target ) {
		
		if( st > end )
			return -1;
		
		int mid = st  + (end - st)/2;
	
		int ans = -1;
		if( target <= nums[mid])
			ans = binarySearcFirstIndex(nums, st, mid - 1, target);
		else
			ans = binarySearcFirstIndex(nums, mid + 1, end , target);
		
		
		return ans != -1 ? ans : ( (nums[mid] == target) ? mid : -1) ;
	}
	
	
	public int binarySearchLastIndex (int[] nums , int st , int end , int target ) {
		if( st > end )
			return -1;
		
		int mid = st  + (end - st)/2;
		
		int ans = -1;
		if( target < nums[mid])
			ans = binarySearchLastIndex(nums, st, mid - 1, target);
		else
			ans = binarySearchLastIndex(nums, mid + 1, end , target);
		
		
		return ans != -1 ? ans : ( (nums[mid] == target) ? mid : -1) ;
	}
	
public int binarySearcFirstIndexItr(int[] nums, int st , int end , int target ) {
		
		int ans = -1;
		while(st <= end) {
			int mid = st  + (end - st)/2;
			if(nums[mid] == target) 
				ans = mid;
			
			if( target <= nums[mid])
				end = mid - 1;
			else
				st = mid + 1;
		}
		
		return ans ;
	}
	
	public int binarySearchLastIndexItr(int[] nums , int st , int end , int target ) {
		int ans = -1;
		while(st <= end) {
			int mid = st  + (end - st)/2;
			if(nums[mid] == target) 
				ans = mid;
			
			if( target < nums[mid])
				end = mid - 1;
			else
				st = mid + 1;
		}
		
		return ans ;
	}
	
}
