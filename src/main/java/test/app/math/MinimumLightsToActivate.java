package test.app.math;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumLightsToActivate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,0,1,0,0,0));
		
		int res = new MinimumLightsToActivate().solve(list, 3);
		
		System.out.print(res);
	}
	
	public int solve(ArrayList<Integer> A, int B) {
		
		/*
		 * This section whether there are sufficient lights ( or are there any dark spots)
		 * to lighten up the corridor.
		 * int light = B;
		for (Integer i : A) {
			  if (i.intValue() == 0) {
				  if(light == 1)
					  return -1;
				  
				  light--;
			  } else {
				  light = B;
			  }		
		}*/
		
		int count = 0;
		for(int i=0; i<A.size();) {
			int r = Math.min(i + B - 1 , A.size() - 1); 
			int l = Math.max(i - B + 1   , 0);
			
			while( r >= l ) {
				
				if(A.get(r) == 1) {
					count++;
					break;
				}
				
				r--;
			}
			
			if( r == (l-1) ) 
				return -1;
			
			i = r + B ;
		}
		
		
		return count;
    }

}
