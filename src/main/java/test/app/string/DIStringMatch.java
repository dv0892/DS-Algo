package test.app.string;

import java.util.Arrays;

public class DIStringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(new DIStringMatch().diStringMatch("IDID")));
	}
	
	public int[] diStringMatch(String s) {
        int  l = 0 , r = s.length();
        int[] res = new int[r+1];
        
        for(int i = 0; i < res.length-1; i++){
            if(s.charAt(i) == 'I'){
                res[i] = l++;
            } else{
                res[i] = r--;
            }
        }
        
        res[res.length-1] = l;
        
        return res;
    }

}
