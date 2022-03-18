package test.app.array;

class LeetCode1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int sum=0;
        
        for(int st=0;st<arr.length; st++){
            for(int ed=st;ed<arr.length; ed++){
                if( ((ed-st+1)%2) != 0)
                for(int r=st;r<=ed;r++){
                    sum += arr[r];
                }
            }
        }
        
        return sum;
    }
   
}
