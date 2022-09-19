package test.app.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
    public Node cloneGraph(Node node) {
        if( node == null )
            return node;
        
        return cloneGraph( node , new HashMap<>() );
        
    }
    
    public Node cloneGraph(Node node , Map<Integer,Node> map ) {
        
        ArrayList<Node> newNeighbors = new ArrayList<Node>();
        Node newNode = new Node(node.val,newNeighbors);
        
        map.put( node.val,newNode);
        
        for( Node neighbour : node.neighbors){
            if( map.containsKey(neighbour.val)  ) {
                newNeighbors.add( map.get(neighbour.val) );
            } else 
                newNeighbors.add( cloneGraph(neighbour , map) );
      
            }
        
        
        
        return newNode;
        
    }
}
