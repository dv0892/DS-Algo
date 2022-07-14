package test.app.backtracking;

public class RodCutting {

	public RodCutting(int rodLen) {
		cache = new int[rodLen+1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rodLen = 4;
		System.out.println( new RodCutting(rodLen).findMaxRevenueImprovedByCaching(0, 0, rodLen));
	}
	
	int[] pricetable = { 0,1,5,8,9,10,17,17,20,24,30 };
	
	public int findMaxRevenue( int price , int lastChoice , int rodLength ) {
		if( rodLength == 0 )
			return price;
		
		int max=Integer.MIN_VALUE;
		if( rodLength >= lastChoice ) {
			int choice = Math.max(1, lastChoice);
			
			while( choice <= rodLength ) {
				
				price += pricetable[choice];
				
				max = Math.max(max, findMaxRevenue(price, choice, rodLength - choice));
				
				price -= pricetable[choice++];
			}
		}
		
		return max;
	}
	
	int[] cache ;
	
	public int findMaxRevenueImprovedByCaching( int price , int lastChoice , int rodLength ) {
		if( rodLength == 0 )
			return price;
		
		if( cache[rodLength] != 0 )
			return cache[rodLength];
		
		int max=Integer.MIN_VALUE;
		if( rodLength >= lastChoice ) {
			int choice = Math.max(1, lastChoice);
			
			while( choice <= rodLength ) {
				
				price += pricetable[choice];
				
				max = Math.max(max, findMaxRevenueImprovedByCaching(price, choice, rodLength - choice));
				
				price -= pricetable[choice++];
			}
		}
		
		return max;
	}

}
