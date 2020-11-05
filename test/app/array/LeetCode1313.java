class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        int outSize = 0;
        for(int p=0,index=0;index<nums.length;p++){
            outSize += nums[2*p]; 
            index = 2*p+2;
        }
        
        int[] outArr = new int[outSize];
        
         for(int p=0,index=0,out_i=0;index<nums.length;p++){
            int freq = nums[2*p]; 
            int val  = nums[2*p+1];
            index = 2*p+2;
            
            while(freq-- > 0){
               outArr[out_i++] = val;
            }
        }
            return outArr;
    }
}
