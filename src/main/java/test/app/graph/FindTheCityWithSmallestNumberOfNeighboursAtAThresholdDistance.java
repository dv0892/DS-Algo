package test.app.graph;

public class FindTheCityWithSmallestNumberOfNeighboursAtAThresholdDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public final int INF = 1000000000;
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] graph = new int[n][n];
        for(int i=0;i<n;i++ ){
            for( int j=0;j<n;j++ ){
                if( i != j )
                    graph[i][j] = INF;
            }
        }
        
        //initialize weights
        for( int[] edge : edges ){
            int f = edge[0], t = edge[1] , w = edge[2];
            graph[f][t] = graph[t][f] = w;
        }
        
        // Run Flyod Warshall 
        for( int k=0;k<n;k++){
          for(int i=0;i<n;i++ ){
            for( int j=0;j<n;j++ ){
                graph[i][j] = Math.min( graph[i][j] , graph[i][k] + graph[k][j] );
            }
          }  
        }
        
        // Now we have got Shotest paths. Apply Threashold on each city
        int city = -1, min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++ ) {
            
            //Count cities which are less than this threshold
            int count = 0;
            for( int j=0;j<n;j++ ){
                if( graph[i][j] <= distanceThreshold )
                    count++;
            }
            
            if( count < min ) {
                city = i;
                min = count;
            } else if( count == min ){
                city = Math.max(city,i);
            }
            
          }
        
        return city;
    }

}
