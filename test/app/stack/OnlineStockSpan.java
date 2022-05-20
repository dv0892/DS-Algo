package test.app.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class OnlineStockSpan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OnlineStockSpan onlineStockSpan = new OnlineStockSpan();
		
		int[] arr = new int[] {100,80,60,70,60,75,85};
		onlineStockSpan.findSpan(arr );
		
		System.out.println( Arrays.toString(arr) );
		
		StockSpanner stockSpanner = new StockSpanner();
		System.out.println(stockSpanner.next(100)); // return 1
		System.out.println(stockSpanner.next(80));  // return 1
		System.out.println(stockSpanner.next(60));  // return 1
		System.out.println(stockSpanner.next(70));  // return 2
		System.out.println(stockSpanner.next(60)); // return 1
		System.out.println(stockSpanner.next(75)); // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
		System.out.println(stockSpanner.next(85));
	}
	
	public void findSpan(int[] arr) {
		
		/*
		 * This solution is perfrectly fine un
		 * 
		 * till we are given a
		 * scenario that data is flowing sequenctially in stream
		 * like arr[0] arriving first
		 * then arr[1] and so on.
		 * 
		 * The solution is in stock spanner
		 */
	
		Deque<int[]> stack = new ArrayDeque<>();
		for(int i=arr.length-1; i>=0; i--) {
			if(!stack.isEmpty() && arr[i] > stack.peek()[0]) {
				while(!stack.isEmpty() && arr[i] > stack.peek()[0]) {
					int[] temp = stack.pop();
					arr[temp[1]] = Math.abs(i-temp[1]);
				}
			}
			
			stack.push( new int[] {arr[i],i});
		}
		
		for(int[] el : stack) {
			arr[el[1]] = 1;
		}
	}

}


class StockSpanner {
	
	Deque<int[]> stack ;

    public StockSpanner() {
    	 stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
    	
    	int span = 1;
    	if(!stack.isEmpty() && price > stack.peek()[0]) {
			while(!stack.isEmpty() && price > stack.peek()[0]) {
				int[] temp = stack.pop();
				span += temp[1];
			}
		}
        
    	stack.push( new int[] { price,span } );
    	
    	return span;
    }
}
