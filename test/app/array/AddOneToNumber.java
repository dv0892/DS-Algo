package test.app.array;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,0,9,9,9));
		System.out.println(new AddOneToNumber().plusOne(list));
	}
	
	/*public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        int carry = 0;


        for( int i = A.size()-1 ; i >= 0  ; i-- ){           
            int newS = carry + A.get(i) + ( i == (A.size()-1) ? 1 : 0);
            A.set(i, newS % 10);
            carry = ( newS > 9 ) ? 1 : 0 ;
        }

        if ( carry == 1 ) {
           A.add(0, 1);
           return A;
        } 

         ArrayList<Integer> t1 = new ArrayList<>();
         boolean nonZeroFound = false;

         for( int e : A){
             if(!nonZeroFound && e == 0)
                continue;
             else{
                nonZeroFound = true;
                t1.add(e);
             }
         }

        
        return t1;
        
        ||
        ||
        ||
        ||
        ||
        
        got cLEANED TO BELOW CODE
        
    }*/
	
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        int carry = 0;

        while (A.size() > 1 && A.get(0) == 0) {
            A.remove(0);
        }

        for( int i = A.size()-1 ; i >= 0  ; i-- ){           
            int newS = carry + A.get(i) + ( i == (A.size()-1) ? 1 : 0);
            A.set(i, newS % 10);
            carry = ( newS > 9 ) ? 1 : 0 ;
            if(carry == 0) 
            	break ;
        }

        if ( carry == 1 ) {
           A.add(0, 1);
           return A;
        } 
        
        return A;
    }

}
