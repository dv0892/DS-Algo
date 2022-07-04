package test.app.array;

import java.util.ArrayList;
import java.util.Arrays;

public class BalanceArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(5,5,2,5,8));
		System.out.println(new BalanceArray().solve(A));
	}
	
	public int solve(ArrayList<Integer> A) {

        int[] evenSuffix = new int[A.size()];
        int[] oddSuffix  = new int[A.size()];

        for(int i=A.size()-2; i>=0 ; i--){
            if((i&1)==1) {
                evenSuffix[i] = evenSuffix[i+1] + A.get(i+1);
                oddSuffix[i]  = oddSuffix[i+1];
            } else {
                oddSuffix[i] = oddSuffix[i+1]   + A.get(i+1);
                evenSuffix[i] = evenSuffix[i+1];
            }
        }

        int oddSum,evenSum,count;
        oddSum=evenSum=count=0;

        for(int i=0; i<A.size() ; i++){
            if((oddSum + evenSuffix[i])==(evenSum + oddSuffix[i])) 
                count++;

            if((i&1)==1) {
                oddSum += A.get(i);
            } else {
                evenSum += A.get(i);
            }   
        }

        return count;
    }

}
