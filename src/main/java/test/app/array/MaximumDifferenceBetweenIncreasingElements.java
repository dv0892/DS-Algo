package test.app.array;

public class MaximumDifferenceBetweenIncreasingElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,1,5,3,6,4};
		System.out.println( new MaximumDifferenceBetweenIncreasingElements().maximumDifference(prices));
	}
	
	public int maximumDifference(int[] prices) {
        int maxProfit = 0;
        int minEl = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            minEl = Math.min(minEl,prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minEl);
        }
        
        return maxProfit == 0 ? -1 : maxProfit;
    }

}
