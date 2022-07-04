package test.app.backtracking;

class LeetCode1688 {
    public int numberOfMatches(int n) {
        if(n==2) return 1;
        if(n==1) return 0;
        
        if( n % 2 == 0 )
            return n/2 + numberOfMatches(n/2);
        
        return n/2 + numberOfMatches(((n-1)/2)+1);
    }
}
