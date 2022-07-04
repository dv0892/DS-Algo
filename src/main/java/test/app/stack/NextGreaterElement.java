package test.app.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10,7,6,4,5,8,9};
		NextGreaterElement nextGreaterElement = new NextGreaterElement();
		
		//System.out.println(Arrays.toString( nextGreaterElement.nextGreaterToRight(nums) )) ;
		
		System.out.println(Arrays.toString( nextGreaterElement.nextGreaterToLeft(nums) )) ;
	}
	
	public int[] nextGreaterToRight(int[] nums) {
		
		Deque<int[]> stack = new ArrayDeque<>(); 
		
		/* 
		 * This solution is just keeping replacing element with its the next Greater element.
		   and keep rest of it as it is.
		   
		   At the end the stack will be comprise of elements which couldn't be popped 
		   because their next greater is never found.
		   
		   MONOTONIC STACK IN DECREASING ORDER
		*/
		for(int i=0;i<nums.length;i++) {
			
			while(!stack.isEmpty() && nums[i] > stack.peek()[1]) {
				int[] rep = stack.pop();
				nums[rep[0]] = nums[i];
			}
			
			stack.push( new int[] {i,nums[i]});
			
		}
		
		while( !stack.isEmpty() ) {
			int[] rep = stack.pop();
			nums[rep[0]] = -1;
		}
		
		return nums;
		
		
	}
	
	
	public int[] nextGreaterToLeft(int[] nums) {
		
		Deque<int[]> stack = new ArrayDeque<>(); 
		
		/* 
		 * This solution is just keeping replacing element with its the next Greater element.
		   and keep rest of it as it is.
		   
		   At the end the stack will be comprise of elements which couldn't be popped 
		   because their next greater is never found.
		*/
		for(int i=nums.length-1;i>=0;i--) {
			
			while(!stack.isEmpty() && nums[i] > stack.peek()[1]) {
				int[] rep = stack.pop();
				nums[rep[0]] = nums[i];
			}
			
			stack.push( new int[] {i,nums[i]});
			
		}
		
		while( !stack.isEmpty() ) {
			int[] rep = stack.pop();
			nums[rep[0]] = -1;
		}
		
		return nums;
		
		
	}

}
