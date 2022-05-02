package test.app.sorts;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new MinimumCostOfBuyingCandiesWithDiscount().minimumCost(new int[] {7,9,6,2,5,2}));
	}
	
	public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        
        int n = cost.length,res=0;;
        for(int i = n-3; ; i-=3 )
        {
            if( i >= 0 || (i+1) >= 0){
                res += ( cost[i+1] + cost[i+2]);
            }  else {
                res += cost[i+2];
            }
            
            if(i <= 0) break;
        }        
        
        return res;
    }

}
