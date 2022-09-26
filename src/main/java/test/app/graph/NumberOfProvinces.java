package test.app.graph;

public class NumberOfProvinces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findCircleNum(int[][] isConnected) {
        
		int provinces = 0;
		
		boolean[] visited = new boolean[isConnected.length];
		for ( int i=0;i<visited.length ; i++ ) {
			if( !visited[i] ) {
				provinces++;
				coverCities(i, isConnected, visited);
			}
		}
		
		return provinces;
    }
	
	
	public void coverCities(int city , int[][] isConnected , boolean[] visited ) {
	
		if( visited[city] )
			return ;
		
		visited[city] = true;
		
		int c = 0;
		for ( int neighbour : isConnected[city] ) {
			if( neighbour == 1 )
				coverCities( c , isConnected , visited );
			c++;
		}
	}

}
