class Solution {
    public int subtractProductAndSum(int n) {
        int p_n=1,s_n=0,digit;
        while(n>0){
          digit = n%10;
          p_n = p_n*digit;
          s_n = s_n + digit;  
          n   = n/10;
        }
        
        return p_n - s_n;
            
    }
}
