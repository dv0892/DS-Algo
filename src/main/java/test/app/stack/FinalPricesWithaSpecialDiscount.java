package test.app.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FinalPricesWithaSpecialDiscount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( Arrays.toString(new FinalPricesWithaSpecialDiscount().finalPrices( new int[] {8,7,4,2,8,1,7,7,10,1})) );
	}
	
public int[] finalPrices(int[] prices) {
        
		// CAN BE OPTIMIZED FURTHER
	     /*For each prices[i] , what we actually want is a element to 
	     the right of it that is <= to it 
	     What we can do is for each prices[i], put it in stack.
	     Before we putting it in a stack we will also check
	     whether it lesser than of the elements lying in a stack if
	     yes then do the discounting and pop it from stack.
	     
	     Here the stack will always contain elements in increasing order
	     This is also known as Monotonic stack.
	     */
	     
        /*for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j] <= prices[i]){
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }*/
	
	    Deque<int[]> stack = new ArrayDeque<>();
	    
	    for(int i=0;i<prices.length;i++){
	    
	    	while( !stack.isEmpty() && prices[i] <= stack.peek()[1] ) {
	    		int[] dis = stack.pop();
	    		prices[dis[0]] = prices[dis[0]] - prices[i];
	    	}
	    	
	    	stack.push(new int[] {i,prices[i]});
	    }
	    
	
        
        return prices;
    }

}
