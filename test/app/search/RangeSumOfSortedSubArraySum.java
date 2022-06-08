package test.app.search;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RangeSumOfSortedSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		
		System.out.println( new RangeSumOfSortedSubArraySum().rangeSum(nums, nums.length, 1, 5));
	}

	public int rangeSum(int[] nums, int n, int left, int right) {
        
		int[] subarray = new int[(n*(n+1))/2];
		int j=0;
		for(int i=0;i<nums.length;i++) {
			int sum = nums[i];
			subarray[j++] = sum;
			for(int k=i+1;k<nums.length;k++) {
                sum = (sum + nums[k]) % 1000000007;
				subarray[j++] = sum;
			}
		}
		
		Arrays.sort(subarray);
		
		int sum=0;
		--left; --right;
		for(  ; left <= right; )
			sum = (sum + subarray[left++]) % 1000000007;
		
		return sum;
	}
	
	public int rangeSumWithStreams(int[] nums, int n, int left, int right) {
        IntStream.range(1, nums.length)
            .forEach(i -> nums[i] += nums[i - 1]);
        return IntStream.range(0, nums.length)
            .boxed()
            .flatMap(i -> IntStream.range(i, nums.length)
                     .boxed()
                     .map(j -> (nums[j] - (i > 0 ? nums[i - 1] : 0))))
            .sorted()
            .skip(left - 1)
            .limit(right - left + 1)
            .reduce(0, (a, b) -> (a + b) % ((int)1E9+7));
    }
	
}
