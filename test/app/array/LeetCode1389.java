package test.app.array;

public class LeetCode1389 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums  = {0,1,2,3,4};
		int[] index = {0,1,2,2,1};
		
		createTargetArray(nums,index);
		
	}
	
	
	public static int[] createTargetArray(int[] nums, int[] index) {
         int[] target = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            target[i] = -1;
        }
        
        int num_cnt=0;
        for(int i : index){
            if(target[i] !=  -1){
               int n = index.length;
               while( (n-2) >= i) {
                   target[n-1] = target[n-2];
                   n--;
               }
            }
            
            target[i] = nums[num_cnt++];
        }
        
        return target;
    }

}
