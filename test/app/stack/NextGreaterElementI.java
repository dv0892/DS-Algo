package test.app.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//All elements of nums2 must be unique because if a element occuring then it will replaced again
		//
		int[] nums1 = {4,2}, nums2 = {1,2,4,5};
		
		System.out.println( Arrays.toString( new NextGreaterElementI().nextGreaterElement(nums1, nums2)));
	}
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		
		//MONOTONIC STACK IN DECREASING ORDER
		
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums1.length;i++) {
			map.put(nums1[i], i);
		}
		
		Arrays.fill(nums1, -1);
		
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i=0;i<nums2.length;i++) {
			while(!stack.isEmpty() && nums2[i] > stack.peek()) {
				int el = stack.pop();
				
				if(map.containsKey(el)) {
					nums1[map.get(el)] = nums2[i];
				}
			}
			
			stack.push(nums2[i]);
		}
		
		return nums1;
        
    }

}
