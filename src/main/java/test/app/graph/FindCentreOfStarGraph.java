package test.app.graph;

public class FindCentreOfStarGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new FindCentreOfStarGraph().findCenter( 
				new int[][] {{1,2},{5,1},{1,3},{1,4}} ) );
	}
	
     public int findCenter(int[][] edges) {
        
        int n1 = edges[0][0];
        int n2 = edges[0][1];
        
        return (n1 == edges[1][1] || n1 == edges[1][0]) ? n1 : n2; 
    }

}
