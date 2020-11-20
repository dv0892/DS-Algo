class LeetCode1486 {
    public int xorOperation(int n, int start) {
        int no = start,i=1;
        n--;
        
        while(n-- > 0) {
            no = no^(start + 2*(i++));
        }
        
        return no;
    }
}
