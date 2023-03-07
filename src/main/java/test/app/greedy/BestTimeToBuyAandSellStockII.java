package test.app.greedy;

public class BestTimeToBuyAandSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  prices = {1,2,3,4,5};
		System.out.println( new BestTimeToBuyAandSellStockII().maxProfit(prices));
	}
	
	public int maxProfit(int[] prices) {
        int maxProfit=0, profit=0, buyPrice = prices[0],sellPrice = prices[0];
        
        for( int price : prices ){
            if( price > buyPrice ){
                if( price > sellPrice ) {
                	sellPrice = price;
                	profit = Math.max(profit , price-buyPrice);
                } else {
                	maxProfit += profit;
                    profit=0; buyPrice = sellPrice = price ;
                }
            } else {
            	 maxProfit += profit;
                 profit=0; buyPrice = sellPrice = price ;
            }
        }
        
        maxProfit += profit;
        return maxProfit;
    }
	
	
	// ADDED ON 25-02-2023
	public int maxProfitSimplified(int[] prices) {
	        int maxProfit=0, profit=0, buyPrice = prices[0],sellPrice = prices[0];
	        
	        for( int price : prices ){

	            if( price > sellPrice ){
	                sellPrice = price;
	                profit = sellPrice-buyPrice;
	            } else {
	                maxProfit += profit;
	                profit=0; buyPrice = sellPrice = price ;
	            }
	        }
	        
	        maxProfit += profit;
	        return maxProfit;
	}
	

}
