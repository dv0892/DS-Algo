package test.app.array;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int[] intersection(int[] nums1, int[] nums2) {
	        
	        int[] hash = new int[1001];
	        Set<Integer> set = new HashSet<>();
	        
	        
	        for(int el : nums1){
	            hash[el]++;
	        }
	        
	        for(int el : nums2) {
	            if( hash[el] > 0 )
	                set.add(el);
	        }
	        
	        int[] arr = new int[set.size()];
	        int i = 0;
	        for(int el : set){
	            arr[i++] = el;
	        }
	        
	        return arr;
	}

}
