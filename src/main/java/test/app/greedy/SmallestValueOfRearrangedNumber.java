package test.app.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestValueOfRearrangedNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new SmallestValueOfRearrangedNumber().smallestNumber(310));
	}
	
	public long smallestNumber(long num) {
        if( num == 0 || (num/10 == 0) )
            return num;
        
        boolean isNeg = num < 0 ; num = Math.abs(num);
        List<Integer> list = new ArrayList<>();
        
        while( num != 0 ){
            list.add((int)(num%10));
            num /= 10;
        }
        
        list.sort(( c1 , c2 ) -> { return isNeg ? c2-c1 : c1-c2; });
     
        if( !isNeg ){
            int i = 0;
            while( list.get(i++) == 0 );
            int t = list.get(i-1);
            list.set(i-1, list.get(0));
            list.set(0, t);
        }
        
        
        while ( !list.isEmpty() ) {
        	num = num*10 + list.remove(0);
        }
        
        return isNeg ? -num  : num ;
    }
    

}
