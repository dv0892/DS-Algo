package test.app.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> addToArrayForm(int[] num, int k) {

		List<Integer> ans = new ArrayList<>();
		int i = num.length-1, carry = 0;
		while( i > -1 && k > 0 ){
            int sum = num[i--] + k%10 + carry;
            ans.add(sum%10);
            carry = sum /10 ;
            k /= 10;
        }
		
		while( i > -1 ){
            int sum = num[i--] + carry;
            ans.add(sum%10);
            carry = sum /10 ;
            
        }
		
		while( k > 0 ){
            int sum = k%10 + carry;
            ans.add(sum%10);
            carry = sum /10 ;
            k /= 10;
        }

       if( carry > 0)
            ans.add(carry);

        Collections.reverse(ans);
      

        return ans;
    }

}
