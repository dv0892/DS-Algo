package test.app.greedy;

public class MinCostToLightBulbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bulbs = {1,0,0,0,1};
        System.out.println( new MinCostToLightBulbs().minCost( bulbs) );
	}
	
	public int minCost( int[] bulbs ) {
		
		int cost = 0;
		for( int b : bulbs ) {
			if( cost%2 == 1)
				b = b == 0 ? 1 : 0;
			
			if( b == 0 )
				cost++;
		}
		
		return cost;
	}

}
