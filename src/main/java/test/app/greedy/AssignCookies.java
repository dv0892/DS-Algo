package test.app.greedy;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int count = 0, i = 0, j = 0;
        
        while( i < g.length  ) {
            while( j < s.length && g[i] > s[j] )
                j++;
            
            if( j == s.length )
                break;
          
            count++;
            i++;j++;
        }
        return count;
    }

}
