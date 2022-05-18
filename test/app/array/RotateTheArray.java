package test.app.array;

import java.util.Arrays;

import test.app.utils.Utils;

public class RotateTheArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateTheArray rotateTheArray = new RotateTheArray();
		
		int[] nums = {1,2,3,4,5,6,7} ; int k=3;
		
		//nums = rotateTheArray.rotate(nums, k);
		//rotateTheArray.rotateWithSpaceOptimized(nums, k);
		rotateTheArray.rotateOptimized(nums, k);
		
		System.out.println( Arrays.toString(nums) );
	}
	
	public int[] rotate(int[] nums, int k) {
		/*
		 * e.g arr = {1,2,3,4,5,6,7}, k=3
		 * out -> {5,6,7,1,2,3,4}
		 * 
		 * it is quite evident that we need to place last (k) element at the beginning for the result.
		 * Brute force, pick last k elements and put it in new array and then copy the remaining elements.
		 * 
		 * But can we do it in O(1)  space;
		 */
		
		int n = nums.length;

		k = k % n;
		
		if(k == 0)
			return nums;
		
		int[] res = new int[n];
		
		int j = n - k ,i=0;
		while(j < n) {
			res[i++] = nums[j++];
		}
		
		for( j=0; j<(n-k) ; ) {
			res[i++] = nums[j++];
		}
		
		return res;
	}

	public void  rotateWithSpaceOptimized(int[] nums, int k) { 
		/*
		 * e.g arr = {1,2,3,4,5,6,7}, k=3
		 * 
		 * one   half -> {1,2,3,4}
		 * other half -> {5,6,7}
		 * 
		 * 1st iteration : {7,1,2,3,4,5,6}
		 * 2nd iteration : {6,7,1,2,3,4,5}
		 * 3rd iteration : {5,6,7,1,2,3,4}
		 * 
		 * desired out -> {5,6,7,1,2,3,4}
		 * 
		 * it is quite evident that we need to place last (k) element at the beginning for the result.
		 * The array can be seen as in two parts one that has got these last k elements and other half(which is to left of it).
		 * 
		 * Start picking last k elements one-by-one and put at the start of other half by right shifting all in it.
		 * 
		 * time Complexity O(n*k)
		 * 
		 * Can we do it in O(n) ?
		 */
		
		int n = nums.length;
		k = k % n;
		if(k == 0)
			return ;
		
		while( k > 0 ) {
			int temp = nums[n-1];
			
			int i=n-2;
			while(i >= 0) {
				nums[i+1] = nums[i];
				i--;
			}
			
			nums[i+1] = temp ;
			k--;
		}
		
	    		
	}
	
	public void  rotateOptimized(int[] nums, int k) { 
		/*
		 * e.g arr = {1,2,3,4,5,6,7}, k=3
		 * 
		 * first half -> {1,2,3,4}
		 * other half -> {5,6,7}
		 * 
		 * reverse first half : {4,3,2,1,5,6,7}
		 * reverse other half : {4,3,2,1,7,6,5}
		 * final revers : {5,6,7,1,2,3,4}
		 * 
		 * desired out -> {5,6,7,1,2,3,4}
		 * 
		 * If we see that we actually arrange these two halfs in some order.
		 * Other half is being placed just before first half. 
		 * 
		 * Suppose we reverse the array, then whole array be would eversed. 
		 * But to prevent it we will revere both of these halfs independenlty, so that the final reversal will make it appear
		 * in its original form.
		 * So double reversal will cause anything to appear in its original form. 
		 * 
		 */
		
		int n = nums.length;
		k = k % n;
		if(k == 0)
			return ;
		
		revese(nums,0,n-k-1);
		revese(nums,n-k,n-1);
		revese(nums,0,n-1);
		
	    		
	}

	private void revese(int[] nums, int st, int end) {
		

		while (st < end) {
			Utils.swap(nums, st++, end--);
		}
	}
}
