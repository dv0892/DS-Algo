package test.app.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindIfPathExistsInGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges =  { {1,0},{0,2},{2,3} };
		
		System.out.println( new FindIfPathExistsInGraph().validPath(4, edges, 0, 3));
	}

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        Map<Integer,Node> map = new HashMap<>();
        
        for(int[] edge : edges ){
            Node n1 =  map.get(edge[0]);
            Node n2 =  map.get(edge[1]);
            
            if ( n1 == null ){
                n1 = new Node(edge[0]);
                map.put( edge[0], n1 );
            }
            
            if ( n2 == null ){
                n2 = new Node(edge[1]);
                map.put( edge[1], n2 );
            }
            
            n1.addNeighbour(n2);
            n2.addNeighbour(n1);
            
        }
        
        return pathbfs( map.get(source), map.get(destination) );
        
    }
    
    public boolean pathdfs( Node source , Node dest ){
        
    	// TLE With DFS
    	
        if( source == dest )
            return true;
        
        source.visited = true;
        
        List<Node> neighbours = source.getNeighbours();
        for ( Node n : neighbours ){
            
            if( !n.visited && pathdfs( n, dest ) )
                return true;
            
        }
        source.visited = false;
        
        return false;
    }
    
    public boolean pathbfs( Node source , Node dest ){
        
        if( source == dest )
            return true;
        
        
        Deque<Node> q = new LinkedList<>();
        q.add(source);
       
        while( !q.isEmpty() ) {
        	int size = q.size();
        	while( size-- > 0 ) {
        		Node n = q.remove();
        		if( !n.visited ) {
        			if ( n == dest )
        				return true;

        			n.visited = true;
        			q.addAll( n.getNeighbours().stream()
        							 .filter( neigh -> !neigh.visited )
        							 .collect(Collectors.toList()) );
        			
        		}
        	}
        }
        
        
        
        return false;
    }
    
    static class Node{
        int n ;
        List<Node> neighbours;
        boolean visited = false;
        
        public Node ( int n ){
            this.n = n;
            neighbours = new ArrayList<>();
        }
        
        public void addNeighbour(Node node){
            neighbours.add(node);
        }
        
        public List<Node> getNeighbours(){
            return this.neighbours;
        }
    } 
}



