package test.app.stack;

public class FinalPricesWithaSpecialDiscount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int[] finalPrices(int[] prices) {
        
		// CAN BE OPTIMIZED FURTHER
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j] <= prices[i]){
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        
        return prices;
    }

}
