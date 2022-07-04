package test.app.array;

import java.util.ArrayList;
import java.util.Arrays;

public class PickFromBothSides {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(5,-2,3,1,2));
		
		System.out.print(new PickFromBothSides().solve(A, 1));
		
	}
	
	public int solve(ArrayList<Integer> A, int B) {
	    
	   int end = A.size()-1;
	   int st  = end - B + 1;
	   
	   int max_sum = 0,i = st ,sum = 0;
	   
	   while(i <= end) {
		   sum += A.get(i++);
	   }
	   
	   B--; max_sum = sum;
	   
	   while(B-- >= 0) {
		   sum -= A.get(st) ;
		   
		   st  = (st  + 1)%A.size();
		   end = (end + 1)%A.size();
		   
		   sum += A.get(end);
		   
		   if(sum > max_sum)
			   max_sum = sum ;
	   }

	   return max_sum;
	}
}
