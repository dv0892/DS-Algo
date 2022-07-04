package test.app.array;

public class LeetCode1365 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display(smallerNumbersThanCurrent(7,7,7,7));
	}
	
	public static int[] smallerNumbersThanCurrent(int... nums) {
		
		int max = nums[0];
        for(int el : nums) 
        	if( el > max ) max = el;
        
        
        int[] count = new int[max+1];
        for(int el : nums) //Initialize the Count Array
        	count[el] = count[el]+1;
        
        int[] sCount = new int[max+1];
        for(int i=1;i<sCount.length;i++) {
        	sCount[i] = count[i-1] + sCount[i-1];
        }
        
        for(int i=0;i<nums.length;i++) {
        	nums[i] = sCount[nums[i]];
        }
        
        return nums;
    }
	
	public static void  display(int[] arr) {
		for(int el : arr) {
			System.out.print(el+" ");
		}
	}

}
