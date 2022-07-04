package test.app.string;


class LeetCode1446 {
    public int maxPower(String s) {
        char[] input = s.toCharArray();
        int max_cCh=1,cCh = 1;
        for(int i=0; i < (input.length-1); i++){
            if(input[i] == input[i+1])
                cCh++;
            else {
                if(max_cCh < cCh) max_cCh = cCh;
                
                cCh = 1;
            }
        }
        
        return (max_cCh < cCh) ? cCh : max_cCh;
    }
}
