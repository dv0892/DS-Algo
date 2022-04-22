package test.app.array;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,1,5,3,6,4};
		System.out.println( new BestTimeToBuyAndSellStock().maxProfit(prices));
	}
	
public int maxProfit(int[] prices) {
     
	
	/*
	 * This solution is fine but has a time complexity O(n^2) .
	 * To improve upon this, :
	 * This problem is all about finding the max and min.
	 * With the constraint that 
	 *    min should always come before max
	 * or max should always come after min.
	 * 
	 * So In a linear scan, we will always check
	 * if we have found a min element and as soon as we found 
	 * a new min we will start caculating the profits again.
	 * In this way we can ensure max are always after min.
	 * 
	 * A more simplified version of this problem can seen @ LeetCode 2016
	 * 
	 */
	int maxProfit = 0;
    
    /*for(int i=0;i<prices.length;i++){
        maxProfit = Math.max(maxProfit, findMaxProfit(prices,i));
    }*/
	
	int minEl = Integer.MAX_VALUE;
	for(int i=0;i<prices.length;i++){
		minEl = Math.min(minEl,prices[i]);
		maxProfit = Math.max(maxProfit, prices[i] - minEl);
    }
	
	
        
    return maxProfit;
    }
    
    public int findMaxProfit(int[] prices,int i){
        
        int maxProfit = 0 ,buyingPrice = prices[i], maxProfit_i = i;
        
        i++;
        
        while(i < prices.length){
            if( (prices[i] - buyingPrice) > maxProfit ) {
                maxProfit   = prices[i] - buyingPrice;
                maxProfit_i = i ;
            }
                
            
            
            i++;
        }
        
        return maxProfit_i;
    }

}
