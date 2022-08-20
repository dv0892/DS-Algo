package test.app.greedy;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
public int canCompleteCircuit(int[] gas, int[] cost) {
        
	// Here is Brute Force
        int i=0, n = gas.length;
        while( i < n ){
            int tank = gas[i], j = i;
            while( tank >= cost[j] ) {
                tank -= cost[j];
                j = (j+1)%n;
                
                if( j == i )
                    return i;
                
                tank += gas[j];
            }
            
            i++;
        }
        
        return -1;
    }

public int canCompleteCircuit_Greedy(int[] gas, int[] cost) {
    
	/*
	 * We will store effective gas available in tank 
	 * Only i'th positions where were  ( gas[i] >= cost[i] ) are the candidates for answer.
		 * If( gas[i] < cost[i] ) , then we need to check if effective gas available has turned negative because in that case
		 * we need to reset ans = -1 , tank = 0 and store the negative turned gas quantity.
		 * 
		 * We are storing the negative turned gas quantity : 
		 * Because this will be later required when we need to calculate the effective gas available` for particular i position.
		 * 
		 * 
		 * else if  ( gas[i] >= cost[i] ) we just set the i if not set already.
		 * 
	 * 
	 * 	 */
	 
    int i=0, n = gas.length, tank = 0, ans = -1, tank1 = 0;
    while( i < n ){
        tank += gas[i];
        tank -= cost[i];
        if( gas[i] < cost[i] ){
           if ( tank < 0 ) {
                ans = -1; tank1 += tank ; tank = 0;
           }   
        } else {
            if( ans == -1 )
                ans = i;
       }
       i++;
    }
    
    return (tank+tank1) >= 0 ? ans : -1 ;
}

}
