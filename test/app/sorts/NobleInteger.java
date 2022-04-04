package test.app.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ArrayList<Integer>( Arrays.asList(-2,0,-4,-5) );
		System.out.print(new NobleInteger().solve(new ArrayList<Integer>( Arrays.asList(-2,0,-4,-5) )
				        ) );
	}
	
	public int solve(ArrayList<Integer> A) {
	      
        Collections.sort(A);

        if(A.get(A.size()-1) == 0)
            return 1;

        for(int i=0;i<A.size()-1;i++) {
            
            if(A.get(i) > (A.size()-1-i))
                break;

            if( A.get(i) != A.get(i+1) && A.get(i) == (A.size()-1-i)) {
                return 1;
            }
            
        }

        return -1;

    }

}
