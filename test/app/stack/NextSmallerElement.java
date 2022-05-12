package test.app.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextSmallerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10,12,90,88,9};
		NextSmallerElement nextSmallerElement = new NextSmallerElement();
		
		//System.out.println( Arrays.toString( nextSmallerElement.nextSmallerToLeft(nums)) );
		
		System.out.println( Arrays.toString( nextSmallerElement.nextSmallerToRight(nums)) );
	}
	
	public int[] nextSmallerToLeft(int[] nums) {
		
		//MONOTONIC STACK IN INCREASING ORDER
		
		Deque<int[]> stack = new ArrayDeque<>();
		
		for(int i=0;i<nums.length;i++) {
			
			while(!stack.isEmpty() && nums[i] < stack.peek()[1])
			{
				int[] rep = stack.pop();
				nums[rep[0]] = nums[i];
			}
			
			stack.push(new int[] {i,nums[i]});
		}
		
		while(!stack.isEmpty() )
		{
			int[] rep = stack.pop();
			nums[rep[0]] = -1 ;
		}
		
		return nums;
	}
	
	
	public int[] nextSmallerToRight(int[] nums) {
		
		Deque<int[]> stack = new ArrayDeque<>();
		
		for(int i=nums.length-1; i>=0 ; i--) {
			
			while(!stack.isEmpty() && nums[i] < stack.peek()[1])
			{
				int[] rep = stack.pop();
				nums[rep[0]] = nums[i];
			}
			
			stack.push(new int[] {i,nums[i]});
		}
		
		while(!stack.isEmpty() )
		{
			int[] rep = stack.pop();
			nums[rep[0]] = -1 ;
		}
		
		return nums;
	}

}
