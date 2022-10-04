package test.app.string;

public class MinimumTimeToMakeRopeColorful {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minCost(String colors, int[] neededTime) {
        int cost = 0;
       
       int count = 1, sum, max ;
       sum = max = neededTime[0] ;
       int prev  = colors.charAt(0) ;
       
       for( int i=1;i<colors.length();i++) {
       	if( prev == colors.charAt(i) ) {
       		count++;
       		max = Math.max(max, neededTime[i]);
       		sum += neededTime[i];
       	} else {
       		if(count > 1) {
       		   cost += ( sum - max );
       		} 
       		
       		count = 1;
       		sum = max = neededTime[i] ;
               prev  = colors.charAt(i) ;
       	}
       }
       return cost += ( sum - max )  ;
   }

}
